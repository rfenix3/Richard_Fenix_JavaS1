package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.viewmodel.StwitterViewModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class StwitterServiceLayer {
    @Autowired
    private PostClient postClient;
    private CommentClient commentClient;

    // This is a constructor. These values below gets included when ServiceLayer is instantiated (like in each controller).
    public StwitterServiceLayer(PostClient postClient, CommentClient commentClient) {
        this.postClient = postClient;
        this.commentClient = commentClient;
    }

    @Transactional
    public StwitterViewModel saveStwitterViewModel(@RequestBody @Valid StwitterViewModel viewModel) throws Exception {

        // Persist Post
        Post post = new Post();
        post.setPostDate(viewModel.getPostDate());
        post.setPosterName(viewModel.getPosterName());
        post.setPost(viewModel.getPost());

        post = postClient.createPost(post);

        viewModel.setPostId(post.getPostId());

        return buildStwitterViewModel(post);
    }

    public StwitterViewModel findStwitterViewModel(int id) {

        Post post= postClient.findPost(id);

        return buildStwitterViewModel(post);
    }

    public List<StwitterViewModel> findAllPostsForPosterName(String posterName){
        List<Post> postList = postClient.findPostListByPosterName(posterName);
        List<StwitterViewModel> svmList = new ArrayList<>();
        for (Post post: postList){
            StwitterViewModel svm = buildStwitterViewModel(post);
            svmList.add(svm);
        }
        return svmList;
    }

    // Post Service API
    //

    public Post savePost(Post post) {

        return postClient.createPost(post);
    }

    public Post findPost(int id) {

        return postClient.findPost(id);
    }

    public List<Post> findPostListByPosterName(String posterName) {

        return postClient.findPostListByPosterName(posterName);
    }

    // Comment Service API
    //

    public List<Comment> findCommentsByPostId(int posterId) {

        return commentClient.findCommentsByPostId(posterId);
    }


    // Helper Methods
    private StwitterViewModel buildStwitterViewModel(Post post) {

        // Assemble the StwitterViewModel
        StwitterViewModel svm = new StwitterViewModel();

        svm.setPostId(post.getPostId());
        svm.setPostDate(post.getPostDate());
        svm.setPosterName(post.getPosterName());
        svm.setPost(post.getPost());

        List<Comment> commentList = commentClient.findCommentsByPostId(post.getPostId());

        // Get only the comments from the Comment Object and put in a String arraylist.
//        List<String> postComments = new ArrayList<>();
//        for (Comment comment: commentList) {
//            postComments.add(comment.getComment());
//        }

        svm.setCommentList(commentList);

        // Return the StwitterViewModel
        return svm;

    }

}
