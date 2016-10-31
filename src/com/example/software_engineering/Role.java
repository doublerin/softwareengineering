package com.example.software_engineering;

public class Role {
    public int      rId;
    public int      rUser_id;
    public String   rName;
    public String   rResource;

    public Role(int id, int user_id, String name, String resource) {
        rId       = id;
        rUser_id  = user_id;
        rName     = name;
        rResource = resource;
    }
}