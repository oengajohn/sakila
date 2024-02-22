package io.github.oengajohn.sakilaapp.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String authenticationFailedMessage) {
        super(authenticationFailedMessage);
    }
}
