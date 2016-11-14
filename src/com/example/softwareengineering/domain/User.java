package com.example.softwareengineering.domain;

import com.example.softwareengineering.Secure;

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String salt;

    public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.salt = Secure.generateSalt();
        this.password = Secure.md5(Secure.md5(password) + salt);
        this.name = name;

    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSalt() {
        return salt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
