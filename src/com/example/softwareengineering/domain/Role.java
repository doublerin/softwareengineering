package com.example.softwareengineering.domain;


public class Role {
    private int id; //id
    private int userId;
    private User user; //пользователь у которого данная роль
    private Permission permission; //наименование роли
    private String resource; //ресурс

    public Role(int id, int userId, User user, Permission permission, String resource) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.permission = permission;
        this.resource = resource;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}