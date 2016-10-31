package com.example.software_engineering;

public class Userdata {
    private String uLogin;
    private String uPassword;
    private String uResource;
    private String uRole;
    private String uDate_start;
    private String uDate_end;
    private String uVolume;

    public Userdata() {
        this.uLogin = null;
        this.uPassword = null;
        this.uResource = null;
        this.uRole = null;
        this.uDate_start = null;
        this.uDate_end = null;
        this.uVolume = null;
    }

    public boolean isAuthentication() {
        return ((uLogin != null) && (uPassword != null));
    }

    public boolean isAuthorization() {
        return (isAuthentication() && (uRole != null) && (uResource != null));
    }

    public boolean isAccounting() {
        return (isAuthorization() && (uDate_start != null) && (uDate_end != null) && (uVolume != null));
    }

    public void setLogin(String login) {
        this.uLogin = login;
    }

    public void setPassword(String password) {
        this.uPassword = password;
    }

    public void setResource(String resource) {
        this.uResource = resource;
    }

    public void setRole(String role) {
        this.uRole = role;
    }

    public String getLogin() {
        return uLogin;
    }

    public String getPassword() {
        return uPassword;
    }

    public String getResource() {
        return uResource;
    }

    public String getRole() {
        return uRole;
    }

    public String getuDate_start() {
        return uDate_start;
    }

    public void setuDate_start(String uDate_start) {
        this.uDate_start = uDate_start;
    }

    public String getuDate_end() {
        return uDate_end;
    }

    public void setuDate_end(String uDate_end) {
        this.uDate_end = uDate_end;
    }

    public String getuVolume() {
        return uVolume;
    }

    public void setuVolume(String uVolume) {
        this.uVolume = uVolume;
    }
}
