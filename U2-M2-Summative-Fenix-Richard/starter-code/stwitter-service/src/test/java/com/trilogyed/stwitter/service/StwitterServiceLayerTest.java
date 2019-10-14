package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.viewmodel.StwitterViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class StwitterServiceLayerTest {
    @InjectMocks
    StwitterServiceLayer stwitterServiceLayer;
    @Mock
    PostClient postClient;

    @Mock
    CommentClient commentClient;

    @Before
    public void setUp() throws Exception {
        setUpPostClientMock();
    }

    @Test
    public void saveFindStwitterViewModel() throws Exception{
        StwitterViewModel svm = new StwitterViewModel();
        svm.setPostDate(LocalDate.of(2019, 9, 15));
        svm.setPosterName("Richard");
        svm.setPost("Richard's first post.");

        svm = stwitterServiceLayer.saveStwitterViewModel(svm);

        StwitterViewModel fromService = stwitterServiceLayer.findStwitterViewModel(svm.getPostId());

        assertEquals(svm, fromService);
    }

    @Test
    public void findPostListByPosterName() throws Exception {
        List<StwitterViewModel> svmList = new ArrayList<>();

        StwitterViewModel svm = new StwitterViewModel();
        svm.setPostDate(LocalDate.of(2019, 9, 15));
        svm.setPostId(1);
        svm.setPosterName("Richard");
        svm.setPost("Richard's first post.");

        svmList.add(svm);

        StwitterViewModel svm1 = new StwitterViewModel();
        svm1.setPostId(2);
        svm1.setPostDate(LocalDate.of(2019, 9, 17));
        svm1.setPosterName("Richard");
        svm1.setPost("Richard's second post.");

        svmList.add(svm1);

        List<StwitterViewModel> fromService = stwitterServiceLayer.findAllPostsForPosterName("Richard");

        assertEquals(svmList, fromService);
    }


    // Helper method
    public void setUpPostClientMock(){
        Post post = new Post();
        post.setPostId(1);
        post.setPostDate(LocalDate.of(2019, 9, 15));
        post.setPosterName("Richard");
        post.setPost("Richard's first post.");

        Post post1 = new Post();
        post1.setPostId(2);
        post1.setPostDate(LocalDate.of(2019, 9, 17));
        post1.setPosterName("Richard");
        post1.setPost("Richard's second post.");

        // post2 does not have a postId as this will be the input into creating a new post.
        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2019, 9, 15));
        post2.setPosterName("Richard");
        post2.setPost("Richard's first post.");

        List<Post> pList = new ArrayList();
        pList.add(post);
        pList.add(post1);

        doReturn(post).when(postClient).createPost(post2);
        doReturn(post).when(postClient).findPost(1);
        doReturn(pList).when(postClient).findPostListByPosterName("Richard");
    }

    public void setUpCommentClientMock(){

        List <Comment> emptyCommentList = new ArrayList<>();

        doReturn(emptyCommentList).when(commentClient).findCommentsByPostId(1);
    }

}