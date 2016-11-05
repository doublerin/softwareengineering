package com.example.softwareengineering;

import java.time.LocalDate;

public class WastedVolume {
    public String role;
    public String res;
    public LocalDate dateStart;
    public LocalDate dateEnd;
    public int volume;

    public WastedVolume(String role, String res, LocalDate dateStart, LocalDate dateEnd, int volume) {
        this.role = role;
        this.res = res;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.volume = volume;
    }
}
