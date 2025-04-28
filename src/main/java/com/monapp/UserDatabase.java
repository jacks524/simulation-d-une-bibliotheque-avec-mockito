package com.monapp;

public interface UserDatabase {
    void save(User user);

    User findByName(String name);
}
