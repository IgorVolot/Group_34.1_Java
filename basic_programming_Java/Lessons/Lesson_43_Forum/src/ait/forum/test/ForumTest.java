package ait.forum.test;

import ait.forum.dao.Forum;
import ait.forum.dao.ForumImpl;
import ait.forum.model.Post;
import org.junit.jupiter.api.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {
    Post[] posts;
    Forum forum;

    Comparator<Post> comparator = (p1, p2) -> Integer.compare(p1.getPostId(), p2.getPostId());

    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[6];
        posts[0] = new Post(0, "title1", "author1", "content");
        posts[1] = new Post(1, "title2", "author2", "content");
        posts[2] = new Post(2, "title3", "author2", "content");
        posts[3] = new Post(3, "title4", "author1", "content");
        posts[4] = new Post(4, "title1", "author3", "content");
        posts[5] = new Post(5, "title2", "author1", "content");
        for (int i = 0; i < posts.length - 1; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertTrue(forum.addPost(posts[5]));
        assertEquals(6, forum.size());
        assertFalse(forum.addPost(posts[5]));
        assertEquals(6, forum.size());
    }

    @Test
    void removePost() {
        assertTrue(forum.removePost(2));
        assertEquals(4, forum.size());
        assertFalse(forum.removePost(2));
        assertEquals(4, forum.size());
    }

    @Test
    void updatePost() {
        assertTrue(forum.updatePost(4, "new content"));
        assertEquals("new content", forum.getPostById(4).getContent());
    }

    @Test
    void getPostById() {
        assertEquals(posts[4], forum.getPostById(4));
        assertNull(forum.getPostById(7));
    }

    @Test
    void getPostByAuthor() {
        Post[] actual = forum.getPostByAuthor("author1");
        Arrays.sort(actual, comparator);
        Post[] expected = {posts[0], posts[3]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getPostByAuthorAndDate() {
        posts[0].setDate(LocalDateTime.now().minusDays(4));
        posts[1].setDate(LocalDateTime.now().minusDays(9));
        posts[2].setDate(LocalDateTime.now().minusDays(5));
        posts[3].setDate(LocalDateTime.now().minusDays(7));
        posts[4].setDate(LocalDateTime.now().minusDays(10));
        posts[5].setDate(LocalDateTime.now().minusDays(8));
        forum = new ForumImpl();
        for (Post post : posts) {
            forum.addPost(post);
        }
        Post[] actual = forum.getPostByAuthor("author1", LocalDate.now().minusDays(10), LocalDate.now().minusDays(6));
        Arrays.sort(actual, comparator);
        Post[] expected = {posts[3], posts[5]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(5, forum.size());
    }
}