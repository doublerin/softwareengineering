package com.example.softwareengineering;

class Role {
    private int rId;
    private int rUser_id;
    Permission rName;
    String   rResource;

    Role(int id, int user_id, Permission name, String resource) {
        rId       = id;
        rUser_id  = user_id;
        rName     = name;
        rResource = resource;
    }
}