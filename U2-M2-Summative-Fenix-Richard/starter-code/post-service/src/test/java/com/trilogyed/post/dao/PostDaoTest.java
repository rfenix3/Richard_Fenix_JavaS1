package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 *     create table if not exists post (
 *             post_id int not null auto_increment primary key,
 *             post_date date not null,
 *             poster_name varchar(50) not null,
 *     post varchar(255));
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {
    // postDao is the implementation interface that we want Spring to wire with the test class
    @Autowired
    //@Qualifier("This bean")
    protected PostDao postDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Post> mList = postDao.getAllPosts();
        mList.stream()
                .forEach(post -> postDao.deletePost(post.getPostId()));
    }


    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 9, 30));
        post.setPosterName("Neil");
        post.setPost("First post by Neil.");

        // Creates post object
        post = postDao.addPost(post);

        Post post2 = postDao.getPost(post.getPostId());

        assertEquals(post, post2);

        postDao.deletePost(post.getPostId());

        post2 = postDao.getPost(post.getPostId());

        assertNull(post2);
        
    }
    
    @Test
    public void getAllPosts() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 9, 30));
        post.setPosterName("Neil");
        post.setPost("First post by Neil.");

        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2019, 10, 02));
        post2.setPosterName("Neil");
        post2.setPost("Second post by Neil.");

        // Creates post object
        post = postDao.addPost(post);

        // Creates post2 object
        post2 = postDao.addPost(post2);

        List<Post> mList = postDao.getAllPosts();

        int mListSize = mList.size();

        assertEquals(2, mListSize);
    }

    @Test
    public void updatePost() {
        Post post = new Post();  // Create post object.
        post.setPostDate(LocalDate.of(2019, 9, 30));
        post.setPosterName("Neil");
        post.setPost("First post by Neil.");

        post = postDao.addPost(post);

        // Java object is now changed from hereon. DB data not yet changed.
        post.setPost("Edited post by Neil.");

        // Change Database data using update.
        postDao.updatePost(post);

        Post post2 = postDao.getPost(post.getPostId());  // Create post record or rows in the database.

        assertEquals(post, post2);
    }
    
    @Test
    public void getPostsByPosterName() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 9, 30));
        post.setPosterName("Neil");
        post.setPost("First post by Neil.");

        // Creates post object
        post = postDao.addPost(post);

        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2019, 10, 02));
        post2.setPosterName("Neil");
        post2.setPost("Second post by Neil.");

        // Creates post2 object
        post2 = postDao.addPost(post2);

        Post post3 = new Post();
        post3.setPostDate(LocalDate.of(2019, 10, 02));
        post3.setPosterName("Richard");
        post3.setPost("First post by Richard.");

        // Creates post3 object
        post3 = postDao.addPost(post3);

        List<Post> mList = postDao.getPostsByPosterName("Neil");

        int mListSize = mList.size();

        assertEquals(2, mListSize);

    }
}