package org.example.LinkedIn.notification;

import org.example.LinkedIn.NotificationService;
import org.example.LinkedIn.User;

import java.time.LocalDateTime;

public class ConnectionRequestNotification implements NotificationService {
    private String id;
    private User user;
    private  String content;
    private LocalDateTime timestamp;

    public ConnectionRequestNotification(String id, User user, String content, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public void notification(User user1,User user2) {
        System.out.println("User "+user1.getUsername()+" has sent a connection!");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
