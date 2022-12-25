package com.pirogsoft.taxiservice.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String login) {
        super("User with login" + login + "is already exists");
    }
}
