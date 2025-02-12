package org.example.LinkedIn;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private String content;
    private LocalDateTime time;
    private List<Comments> commentsList;
    private List<Reactions> reactionsList;

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Reactions> getReactionsList() {
        return reactionsList;
    }

    public void setReactionsList(List<Reactions> reactionsList) {
        this.reactionsList = reactionsList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
