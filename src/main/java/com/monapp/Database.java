package com.monapp;

public interface Database {
    void save(User user);

    User findByName(String name);
}
