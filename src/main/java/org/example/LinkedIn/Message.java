package org.example.LinkedIn;

public class Message {
    private String subject;
    private String messageContent;

    public Message(String subject, String messageContent) {
        this.subject = subject;
        this.messageContent = messageContent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
