package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class CommentController {
    @Autowired
    CommentDao commentDao;

    public CommentController(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    @CachePut(key = "#result.getCommentId()")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment) throws Exception {
        return commentDao.addComment(comment);
    }

    @CacheEvict(key = "#comment.getCommentId()")
    @RequestMapping(value = "/comments", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void changeComment(@RequestBody @Valid Comment comment) {
        commentDao.updateComment(comment);
    }

    @Cacheable
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment findComment(@PathVariable int id) throws Exception {
        Comment comment = commentDao.getComment(id);
        if (comment == null) {
            throw new Exception("Comment not found.");
        }
        return comment;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findCommentList() {

        return commentDao.getAllComments();
    }

    @CacheEvict
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {

        commentDao.deleteComment(id);
    }

    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findCommentList(@PathVariable int postId) {

        return commentDao.getCommentsByPostId(postId);
    }
}
