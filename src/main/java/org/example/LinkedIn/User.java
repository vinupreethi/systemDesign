package org.example.LinkedIn;

import java.util.List;

public class User {
    private String username;
    private String emailId;
    private String password;
    private Profile profile;
    private List<Connection> connectionList;
    private List<Message> inboxMessage;
    private List<Message> sentMessage;
    private List<Post> posts;
    private List<Reactions> reactions;
    private List<Comments> comments;
    private List<Connection> sentConnection;
    private List<Connection> receivedConnection;

    public List<Reactions> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reactions> reactions) {
        this.reactions = reactions;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Connection> getSentConnection() {
        return sentConnection;
    }

    public void setSentConnection(List<Connection> sentConnection) {
        this.sentConnection = sentConnection;
    }

    public List<Connection> getReceivedConnection() {
        return receivedConnection;
    }

    public void setReceivedConnection(List<Connection> receivedConnection) {
        this.receivedConnection = receivedConnection;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User(String username, String emailId, String password, Profile profile, List<Connection> connectionList, List<Message> inboxMessage, List<Message> sentMessage) {
        this.emailId=emailId;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.connectionList = connectionList;
        this.inboxMessage = inboxMessage;
        this.sentMessage = sentMessage;

    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Message> getInboxMessage() {
        return inboxMessage;
    }

    public void setInboxMessage(List<Message> inboxMessage) {
        this.inboxMessage = inboxMessage;
    }

    public List<Message> getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(List<Message> sentMessage) {
        this.sentMessage = sentMessage;
    }




}
