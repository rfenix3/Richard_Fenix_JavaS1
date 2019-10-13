package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

/**
 *      Comment Table
 *     create table if not exists comment (
 *             comment_id int not null auto_increment primary key,
 *             post_id int not null,
 *             create_date date not null,
 *             commenter_name varchar(50) not null,
 *             comment varchar(255)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {
    // commentDao is the implementation interface that we want Spring to wire with the test class
    @Autowired
    //@Qualifier("This bean")
    protected CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Comment> mList = commentDao.getAllComments();
        mList.stream()
                .forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard on post ID 1.");

        // Creates comment object
        comment = commentDao.addComment(comment);

        Comment comment2 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, comment2);

        commentDao.deleteComment(comment.getCommentId());

        comment2 = commentDao.getComment(comment.getCommentId());

        assertNull(comment2);

    }

    @Test
    public void getAllComments() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard on post ID 1.");

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 9, 30));
        comment2.setCommenterName("Darlene");
        comment2.setComment("Second comment by Darlene on post ID 1.");

        // Creates comment object
        comment = commentDao.addComment(comment);

        // Creates comment2 object
        comment2 = commentDao.addComment(comment2);

        List<Comment> mList = commentDao.getAllComments();

        int mListSize = mList.size();

        assertEquals(2, mListSize);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();  // Create comment object.
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard on post ID 1.");

        comment = commentDao.addComment(comment);

        // Java object is now changed from hereon. DB data not yet changed.
        comment.setComment("Edited comment by Richard on post ID 1.");

        // Change Database data using update.
        commentDao.updateComment(comment);

        Comment comment2 = commentDao.getComment(comment.getCommentId());  // Create comment record or rows in the database.

        assertEquals(comment, comment2);

    }

    @Test
    public void getCommentsByPostId() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 30));
        comment.setCommenterName("Richard");
        comment.setComment("First comment by Richard on post ID 1.");

        // Creates comment object
        comment = commentDao.addComment(comment);

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 9, 30));
        comment2.setCommenterName("Darlene");
        comment2.setComment("Second comment by Darlene on post ID 1.");

        // Creates comment2 object
        comment2 = commentDao.addComment(comment2);

        Comment comment3 = new Comment();
        comment3.setPostId(2);
        comment3.setCreateDate(LocalDate.of(2019, 10, 01));
        comment3.setCommenterName("Richard");
        comment3.setComment("First comment by Richard on post ID 2.");

        // Creates comment3 object
        comment3 = commentDao.addComment(comment3);

        List<Comment> mList = commentDao.getCommentsByPostId(1);

        int mListSize = mList.size();

        assertEquals(2, mListSize);
    }

}