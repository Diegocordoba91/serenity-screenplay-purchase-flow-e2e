package com.serenety.models;

public record User(String username, String password) {

    public static User of(String username, String password) {
        return new User(username, password);
    }
}
