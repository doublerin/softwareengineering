package com.example.softwareengineering;

import java.time.LocalDate;

public class WastedVolume {
    public String wRole;
    public String wRes;
    public LocalDate wDS;
    public LocalDate wDE;
    public int wVol;

    public WastedVolume(String wRole, String wRes, LocalDate wDS, LocalDate wDE, int wVol) {
        this.wRole = wRole;
        this.wRes = wRes;
        this.wDS = wDS;
        this.wDE = wDE;
        this.wVol = wVol;
    }
    public WastedVolume() {
        this.wRole = null;
        this.wRes = null;
        this.wDS = null;
        this.wDE = null;
        this.wVol = 0;
    }
}
