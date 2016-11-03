package com.example.softwareengineering;

class User {
    public int id;
    public String login;
    public String password;
    public String name;
    public String salt;

    public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.salt = Secure.generateSalt();
        this.password = Secure.md5(Secure.md5(password) + salt);
        this.name = name;

    }
}
