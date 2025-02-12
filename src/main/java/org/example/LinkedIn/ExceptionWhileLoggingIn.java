package org.example.LinkedIn;

public class ExceptionWhileLoggingIn extends Throwable {
    public ExceptionWhileLoggingIn(String excpeitonInLogin) {
        super(excpeitonInLogin);
    }
}
