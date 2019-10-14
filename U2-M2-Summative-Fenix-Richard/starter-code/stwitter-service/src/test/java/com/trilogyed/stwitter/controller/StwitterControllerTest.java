package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.StwitterServiceLayer;
import com.trilogyed.stwitter.viewmodel.StwitterViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
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
@WebMvcTest(StwitterController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StwitterServiceLayer service;

    StwitterViewModel svm, svm2, svm3;

    @Before
    public void setUp() throws Exception {
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();

        svm = new StwitterViewModel();
        svm2 = new StwitterViewModel();  // svm2 is the input to a create object.
        svm3 = new StwitterViewModel();

        svm.setPostId(1);
        svm.setPost("First svm post by Richard.");
        svm.setPostDate(LocalDate.of(2019, 9, 25));
        svm.setPosterName("Richard");
        svm.setCommentList(commentList);

        svm2.setPost("First svm post by Richard.");
        svm2.setPostDate(LocalDate.of(2019, 9, 25));
        svm2.setPosterName("Richard");
        svm2.setCommentList(commentList);

        svm3.setPostId(2);
        svm3.setPost("First svm post by Dee.");
        svm3.setPostDate(LocalDate.of(2019, 9, 28));
        svm3.setPosterName("Richard");

        // Add sample comment for postId = 2;
        comment.setCommentId(1);
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard.");
        commentList.add(comment);

        svm3.setCommentList(commentList);
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
    public void createPost() throws Exception {
        when(service.saveStwitterViewModel(svm2)).thenReturn(svm);

        String input = asJsonString(svm2);
        String result = asJsonString(svm);

        mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(svm2))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                //use the objectmapper output with the json method
                .andExpect(content().json(asJsonString(svm)));
    }

    @Test
    public void findPost() throws Exception {
        when(service.findStwitterViewModel(1)).thenReturn(svm);

        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(svm)));
    }

    @Test
    public void findPostListByPosterName() throws Exception {
        List<StwitterViewModel> pvmList = new ArrayList<>();

        pvmList.add(svm);
        pvmList.add(svm3);
        when(service.findAllPostsForPosterName("Richard")).thenReturn(pvmList);

        String result = asJsonString(pvmList);

        mockMvc.perform(get("/posts/user/Richard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(pvmList)));
    }
}