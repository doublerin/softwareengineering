package com.example.softwareengineering.domain;


public class Role {
    private int id;
    private User user;
    Permission permission;
    String resource;

    public  Role(int id, User user, Permission name, String resource) {
        this.id = id;
        this.user = user;
        this.permission = name;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Permission getPermission() {
        return permission;
    }

    public String getResource() {
        return resource;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}