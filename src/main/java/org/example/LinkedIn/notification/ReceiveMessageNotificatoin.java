package org.example.LinkedIn.notification;

import org.example.LinkedIn.Message;
import org.example.LinkedIn.NotificationService;
import org.example.LinkedIn.User;

import java.time.LocalDateTime;

public class ReceiveMessageNotificatoin implements NotificationService {
    private String id;
    private User user;
    private Message message;
    private LocalDateTime timestamp;

    public ReceiveMessageNotificatoin(String id, User user, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.message=message;
        this.timestamp = timestamp;
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void notification(User user1, User user2) {
        System.out.println(user1.getUsername()+"has received a message from "+user2.getUsername());
    }
}
