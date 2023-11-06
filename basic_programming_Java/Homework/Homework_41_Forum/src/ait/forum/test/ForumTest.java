package ait.forum.test;

import ait.forum.dao.Forum;
import ait.forum.dao.ForumImpl;
import ait.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {
    Forum forum;
    Post[] posts;

    Comparator<Post> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getPostId(), p2.getPostId());
        return res = res >= 0 ? res : p1.addLike() - p2.addLike();
    };

    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[7];
        posts[0] = new Post(1001, "title1", "author1", "content1");
        posts[1] = new Post(1002, "title2", "author2", "content2");
        posts[2] = new Post(1003, "title3", "author1", "content3");
        posts[3] = new Post(1004, "title4", "author3", "content4");
        posts[4] = new Post(1005, "title5", "author2", "content5");
        posts[5] = new Post(1006, "title6", "author4", "content6");
        posts[6] = new Post(1007, "title7", "author5", "content7");
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[2]));
        Post post = new Post(1008, "title8", "author3", "content8");
        assertTrue(forum.addPost(post));
        assertEquals(8, forum.size());
    }

    @Test
    void removePost() {
        assertFalse(forum.removePost(1010));
        assertTrue(forum.removePost(1004));
        assertEquals(6, forum.size());
        assertFalse(forum.removePost(1004));
    }

    @Test
    void updatePost() {
        assertTrue(forum.updatePost(1002, "content10"));
        assertEquals("content10", forum.getPostById(1002));
    }

    @Test
    void getPostById() {
        assertEquals(posts[4], forum.getPostById(1005));
        assertNull(forum.getPostById(1010));
    }

    @Test
    void getPostsByAuthor() {
        Post[] actual = forum.getPostsByAuthor("author2");
        Post[] expected = {posts[1], posts[4]};
        Arrays.sort(actual, comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetPostsByAuthor() {
        LocalDate ld = LocalDate.now();
        Post[] actual = forum.getPostsByAuthor("author1", ld.minusDays(6), ld.minusDays(3));
        Post[] expected = {posts[0], posts[2]};
        Arrays.sort(actual, comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(7, forum.size());
    }
}