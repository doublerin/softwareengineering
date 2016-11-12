package com.example.softwareengineering;

class Role {
    private int id;
    private User user;
    Permission name;
    String resource;

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