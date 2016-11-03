package com.example.softwareengineering;

class Userdata {
    private String uLogin;
    private String uPassword;
    private String uResource;
    private String uRole;
    private String uDate_start;
    private String uDate_end;
    private String uVolume;

    Userdata() {
        this.uLogin = null;
        this.uPassword = null;
        this.uResource = null;
        this.uRole = null;
        this.uDate_start = null;
        this.uDate_end = null;
        this.uVolume = null;
    }

    boolean isEmpty() {
        return((uLogin==null)&&(uPassword==null)&&(uRole==null)&&(uResource==null)&&(uDate_start==null)
                &&(uDate_end==null)&&(uVolume==null));
    }

    boolean isAuthentication() {
        return ((uLogin != null) && (uPassword != null));
    }

    boolean isAuthorization() {
        return (isAuthentication() && (uRole != null) && (uResource != null));
    }

    boolean isAccounting() {
        return (isAuthorization() && (uDate_start != null) && (uDate_end != null) && (uVolume != null));
    }

    Permission getPermission() {
        return Permission.valueOf(uRole);
    }

    void setLogin(String login) {
        this.uLogin = login;
    }

    void setPassword(String password) {
        this.uPassword = password;
    }

    void setResource(String resource) {
        this.uResource = resource;
    }

    void setRole(String role) {
        this.uRole = role;
    }

    String getLogin() {
        return uLogin;
    }

    String getPassword() {
        return uPassword;
    }

    String getResource() {
        return uResource;
    }

    String getRole() {
        return uRole;
    }

    String getuDate_start() {
        return uDate_start;
    }

    void setuDate_start(String uDate_start) {
        this.uDate_start = uDate_start;
    }

    String getuDate_end() {
        return uDate_end;
    }

    void setuDate_end(String uDate_end) {
        this.uDate_end = uDate_end;
    }

    String getuVolume() {
        return uVolume;
    }

    void setuVolume(String uVolume) {
        this.uVolume = uVolume;
    }
}
