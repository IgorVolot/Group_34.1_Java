package ait.forum.model;

import java.time.LocalDateTime;

public class Post {
    private int postId;
    private String title;
    private String author;
    private String content;
    private LocalDateTime date;
    private int likes;

    public Post(int postId, String title, String author, String content) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.content = content;
        date = LocalDateTime.now();
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int addLike() {
        return ++likes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", date=").append(date);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Post post = (Post) object;

        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return postId;
    }
}
