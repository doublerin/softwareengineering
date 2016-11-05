package com.example.softwareengineering;

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

    Permission getPermission() {
        return Permission.valueOf(role);
    }

    void setLogin(String login) {
        this.login = login;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setResource(String resource) {
        this.resource = resource;
    }

    void setRole(String role) {
        this.role = role;
    }

    String getLogin() {
        return login;
    }

    String getPassword() {
        return password;
    }

    String getResource() {
        return resource;
    }

    String getRole() {
        return role;
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

    String getVolume() {
        return volume;
    }

    void setVolume(String volume) {
        this.volume = volume;
    }
}
