package com.trilogyed.stwitter.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StwitterViewModel {
    private int postId;
    @Size(max = 255, message = "Post maximum is 255 characters in length.")
    private String post;
    //@NotEmpty(message = "You must supply a value for Post Date.")
    private LocalDate postDate;
    @NotEmpty(message = "You must supply a value for posterName.")
    @Size(max = 50, message = "Poster Name maximum is 50 characters in length.")
    private String posterName;
    @Size(max = 255, message = "Post maximum is 255 characters in length.")
    private List<String> comments;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StwitterViewModel that = (StwitterViewModel) o;
        return getPostId() == that.getPostId() &&
                getPost().equals(that.getPost()) &&
                getPostDate().equals(that.getPostDate()) &&
                getPosterName().equals(that.getPosterName()) &&
                Objects.equals(getComments(), that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPost(), getPostDate(), getPosterName(), getComments());
    }

    @Override
    public String toString() {
        return "StwitterViewModel{" +
                "postId=" + postId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", comments=" + comments +
                '}';
    }
}
