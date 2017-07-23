package com.example.Resttest.campusSelect.model;

public enum Status {
    START  ("start"),
    END ("end"),
    OPEN   ("open"),
    UNREGISTERED ("unregistered"),
    REGISTERED ("registered"),
    READY ("ready"),
    ELIIGIBLE ("eligible"),
    ; // semicolon needed when fields / methods follow


    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getLevelCode() {
        return this.status;
    }
}