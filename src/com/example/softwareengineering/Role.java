package com.example.softwareengineering;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Role {
    private int id;
    private User user;
    Permission name;
    String resource;

    final Logger log = LogManager.getLogger(Role.class);

    Role(int id, User user, Permission name, String resource) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Permission getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

}