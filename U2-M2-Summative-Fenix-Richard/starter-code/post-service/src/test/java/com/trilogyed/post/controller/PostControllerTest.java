package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Autowired
    private PostDao postDao;

    Post post, post2, post3;

    @Before
    public void setUp() throws Exception {
        post = new Post();
        post2 = new Post();  // post2 is the input to a create object.
        post3 = new Post();

        post.setPostId(1);
        post.setPostDate(LocalDate.of(2019, 9, 30));
        post.setPosterName("Neil");
        post.setPost("First post by Neil.");

        post2.setPostDate(LocalDate.of(2019, 9, 30));
        post2.setPosterName("Neil");
        post2.setPost("First post by Neil.");

        post3.setPostId(2);
        post3.setPostDate(LocalDate.of(2019, 9, 28));
        post3.setPosterName("Richard");
        post3.setPost("First post by Richard.");

    }

    /**
     * This method converts any object into a json format.
     * @param object
     * @return JSON format of the object that handles the LocalDate to be YYYY-MM-dd
     * @throws Exception
     */
    private String asJsonString(final Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(object);
    }

    @Test
    public void testCreatePost() throws Exception{
        when(postDao.addPost(post2)).thenReturn(post);

        String input = asJsonString(post2);
        String result = asJsonString(post);

        mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(post2))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                //use the objectmapper output with the json method
                .andExpect(content().json(asJsonString(post)));
    }

    @Test
    public void testChangePost() throws Exception {
    }

    @Test
    public void testFindPost() throws Exception{
        when(postDao.getPost(1)).thenReturn(post);

        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(post)));
    }

    @Test
    public void testFindPostList() throws Exception{
        List<Post> allPosts = new ArrayList<>();
        allPosts.add(post);
        allPosts.add(post3);

        when(postDao.getAllPosts()).thenReturn(allPosts);

        mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(allPosts)));
    }

    @Test
    public void testDeletePost() {
    }

    @Test
    public void testFindPostListByPosterName() throws Exception {
        List<Post> posterPosts = new ArrayList<>();

        posterPosts.add(post);
        when(postDao.getPostsByPosterName("Neil")).thenReturn(posterPosts);

        String result = asJsonString(posterPosts);

        mockMvc.perform(get("/posts/user/Neil"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(posterPosts)));

    }
}