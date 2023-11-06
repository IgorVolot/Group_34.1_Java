package ait.forum.test;

import ait.forum.dao.Forum;
import ait.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {
    Forum forum;
    Post[] posts;

    @BeforeEach
    void setUp() {
        posts = new Post[7];
        posts[0] = new Post(1001, "title1", "auhtor1", "content1");
        posts[1] = new Post(1002, "title2", "auhtor2", "content2");
        posts[2] = new Post(1003, "title3", "auhtor1", "content3");
        posts[3] = new Post(1004, "title4", "auhtor3", "content4");
        posts[4] = new Post(1005, "title5", "auhtor2", "content5");
        posts[5] = new Post(1006, "title6", "auhtor4", "content6");
        posts[6] = new Post(1007, "title7", "auhtor5", "content7");
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
    }

    @Test
    void removePost() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void getPostById() {
    }

    @Test
    void getPostsByAuthor() {
    }

    @Test
    void testGetPostsByAuthor() {
    }

    @Test
    void size() {
    }
}