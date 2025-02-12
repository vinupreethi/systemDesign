package org.example.LinkedIn;

public class UserNotAvailableException extends Throwable {
    public UserNotAvailableException(String msg) {
        super(msg);
    }
}
