package com.example.softwareengineering;

class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String salt;

    User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.salt = Secure.generateSalt();
        this.password = Secure.md5(Secure.md5(password) + salt);
        this.name = name;

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
}
