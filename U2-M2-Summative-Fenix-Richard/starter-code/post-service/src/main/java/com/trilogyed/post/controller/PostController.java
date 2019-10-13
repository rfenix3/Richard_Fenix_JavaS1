package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {
    @Autowired
    PostDao postDao;

    public PostController(PostDao postDao){
        this.postDao = postDao;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody @Valid Post post) {
        return postDao.addPost(post);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void changePost(@RequestBody @Valid Post post) {
        postDao.updatePost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Post findPost(@PathVariable int id) throws Exception {
        Post post = postDao.getPost(id);
        if (post == null) {
            throw new Exception("Post not found.");
        }
        return post;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> findPostList() {

        return postDao.getAllPosts();
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {

        postDao.deletePost(id);
    }

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> findPostListByPosterName(@PathVariable String posterName) {

        return postDao.getPostsByPosterName(posterName);
    }

}
