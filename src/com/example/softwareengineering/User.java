package com.example.softwareengineering;

class User {
    public int id;
    public String Login;
    public String Password;
    public String Name;
    public String salt;

    public User(int id, String login, String password, String name) {
        this.id = id;
        this.Login = login;
        this.salt = Secure.generateSalt();
        this.Password = Secure.MD5(Secure.MD5(password) + salt);
        this.Name = name;

    }

    public String getSalt() {
        return salt;
    }
}
