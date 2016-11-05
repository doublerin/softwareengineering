package com.example.softwareengineering;

class Role {
    private int id;
    private int userId;
    Permission name;
    String resource;

    Role(int id, int userId, Permission name, String resource) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.resource = resource;
    }
}