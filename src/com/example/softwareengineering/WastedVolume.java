package com.example.softwareengineering;

import java.time.LocalDate;

class WastedVolume {
    public String getRole() {
        return role;
    }

    public String getRes() {
        return res;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public int getVolume() {
        return volume;
    }

    private String role;
    private String res;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int volume;

    WastedVolume(String role, String res, LocalDate dateStart, LocalDate dateEnd, int volume) {
        this.role = role;
        this.res = res;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.volume = volume;
    }
}
