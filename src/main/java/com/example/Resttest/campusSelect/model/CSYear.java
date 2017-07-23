package com.example.Resttest.campusSelect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CSYear {
    // add all the propertues and required dummy classes for year to work

    private int year; // example

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
