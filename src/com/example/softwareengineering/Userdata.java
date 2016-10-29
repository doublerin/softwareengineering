package com.example.softwareengineering;

public class Userdata {
    private String uLogin;
    private String arrpassword;
    private String arrresource;
    private String arrrole;
    private String uDate_start;
    private String uDate_end;
    private String uVolume;

    public Userdata(String uLogin, String arrpassword, String arrresource, String arrrole,
                    String uDate_start, String uDate_end, String uVolume) {
        this.uLogin = uLogin;
        this.arrpassword = arrpassword;
        this.arrresource = arrresource;
        this.arrrole = arrrole;
        this.uDate_start = uDate_start;
        this.uDate_end = uDate_end;
        this.uVolume = uVolume;
    }

    public Userdata() {
        this.uLogin = null;
        this.arrpassword = null;
        this.arrresource = null;
        this.arrrole = null;
        this.uDate_start = null;
        this.uDate_end = null;
        this.uVolume = null;
    }

    public boolean isEmpty() {
        return ((uLogin == null) && (arrrole == null) && (arrpassword == null) && (arrresource == null));
    }

    public boolean authentication() {
        return ((uLogin != null) && (arrpassword != null));
    }

    public boolean authorization() {
        return (authentication() && (arrrole != null) && (arrresource != null));
    }

    public boolean accounting() {
        return (authorization() && (uDate_start != null) && (uDate_end != null));
    }


    public void setLogin(String login) {
        this.uLogin = login;
    }

    public void setPassword(String password) {
        this.arrpassword = password;
    }

    public void setResource(String resource) {
        this.arrresource = resource;
    }

    public void setRole(String role) {
        this.arrrole = role;
    }

    public String getLogin() {
        return uLogin;
    }

    public String getPassword() {
        return arrpassword;
    }

    public String getResource() {
        return arrresource;
    }

    public String getRole() {
        return arrrole;
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
