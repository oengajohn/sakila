package io.github.oengajohn.sakilaapp.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userNotFoundMessage) {
        super(userNotFoundMessage);
    }
}
