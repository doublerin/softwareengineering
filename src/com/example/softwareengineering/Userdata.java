package com.example.softwareengineering;

import com.example.softwareengineering.domain.Permission;

class Userdata {
    private String login;
    private String password;
    private String resource;
    private String role;
    private String dateStart;
    private String dateEnd;
    private String volume;


    boolean isEmpty() {
        return((login ==null)&&(password ==null)&&(role ==null)&&(resource ==null)&&(dateStart ==null)
                &&(dateEnd ==null)&&(volume ==null));
    }

    boolean isAuthentication() {
        return ((login != null) && (password != null));
    }

    boolean isAuthorization() {
        return (isAuthentication() && (role != null) && (resource != null));
    }

    boolean isAccounting() {
        return (isAuthorization() && (dateStart != null) && (dateEnd != null) && (volume != null));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getResource() {
        return resource;
    }

    void setResource(String resource) {
        this.resource = resource;
    }

    public Permission getRole() {
        return Permission.valueOf(role);
    }

    public void setRole(String role) {
        this.role = role;
    }

    String getDateStart() {
        return dateStart;
    }

    void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    String getDateEnd() {
        return dateEnd;
    }

    void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
