package org.example.LinkedIn;

import java.time.LocalDateTime;

public class Comments {
    private String content;
    private LocalDateTime time;

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
