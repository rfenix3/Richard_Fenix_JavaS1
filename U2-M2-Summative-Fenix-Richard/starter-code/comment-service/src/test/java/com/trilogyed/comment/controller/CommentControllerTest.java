package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
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
@WebMvcTest(CommentController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)

public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Autowired
    private CommentDao commentDao;

    Comment comment, comment2, comment3;

    @Before
    public void setUp() throws Exception {
        comment = new Comment();
        comment2 = new Comment();  // comment2 is the input to a create object.
        comment3 = new Comment();

        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard.");

        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 9, 30));
        comment2.setCommenterName("Richard");
        comment2.setComment("First comment by Richard.");

        comment3.setPostId(2);
        comment3.setCommentId(2);
        comment3.setCreateDate(LocalDate.of(2019, 10, 12));
        comment3.setCommenterName("Dee");
        comment3.setComment("First comment by Dee.");
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
    public void createComment() throws Exception{
        when(commentDao.addComment(comment2)).thenReturn(comment);

        String input = asJsonString(comment2);
        String result = asJsonString(comment);

        mockMvc.perform(post("/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(comment2))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                //use the objectmapper output with the json method
                .andExpect(content().json(asJsonString(comment)));
    }

    @Test
    public void changeComment() {
    }

    @Test
    public void findComment() throws Exception {
        when(commentDao.getComment(1)).thenReturn(comment);

        mockMvc.perform(get("/comments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(comment)));
    }

    @Test
    public void deleteComment() {
    }

    @Test
    public void findCommentList()throws Exception{
        List<Comment> allComments = new ArrayList<>();
        allComments.add(comment);
        allComments.add(comment3);

        when(commentDao.getAllComments()).thenReturn(allComments);

        mockMvc.perform(get("/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(allComments)));
    }
}