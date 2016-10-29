package com.example.softwareengineering;


public class Role {
    public int      Id;
    public int      User_id;
    public String      Name;
    public String   Resource;

    public Role(int id, int user_id, String name, String resource) {
        Id       = id;
        User_id  = user_id;
        Name     = name;
        Resource = resource;
    }

    public int getId() {
        return Id;
    }

    public int getUser_id() {
        return User_id;
    }

    public String getName() {
        return Name;
    }

    public String getResource() {
        return Resource;
    }
}