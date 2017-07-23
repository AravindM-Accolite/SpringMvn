package com.example.Resttest.campusSelect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/campuses")
public class YearController {

    @Autowired
    private YearService yearService;

    public void setYearService(YearService yearService) {
        this.yearService = yearService;
    }


}
