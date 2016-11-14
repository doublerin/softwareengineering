package com.example.softwareengineering.domain;

import java.time.LocalDate;

public class Accounting {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int volume;
    private int id;
    private Role role;

    public Accounting(Role role, LocalDate dateStart, LocalDate dateEnd, int volume) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.volume = volume;
        this.role = role;
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

    public Role getRole() {
        return role;
    }
}
