package com.trilogyed.comment.dao;


import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {

    public Comment addComment(Comment comment);
    public Comment getComment(int id);
    public List<Comment> getAllComments();
    public void updateComment(Comment comment);
    public void deleteComment(int id);
    public List<Comment> getCommentsByPostId(int postId);

}
