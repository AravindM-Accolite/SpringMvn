package com.example.Resttest.campusSelect;

import com.example.Resttest.campusSelect.model.CSYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class YearService {

    @Autowired
    private YearDAO yearDAO;

    public List<CSYear> getALLCSYears() {return yearDAO.getAllCSYears(); }

    public CSYear createCSYear(int fromYear) {
        // get all existing years
        List<CSYear> allYears = this.yearDAO.getAllCSYears();

        allYears.sort((o1, o2) -> Integer.compare(o2.getYear(), o1.getYear()));

        // find the latest new year to create
        CSYear newYear = new CSYear();
        newYear.setYear(allYears.get(0).getYear() + 1);

        // copy properties
        CSYear fromCopyYear = new CSYear();
        for (CSYear year : allYears) {
            if (year.getYear() == fromYear) {
                fromCopyYear = year;
            }
        }

        newYear.setWorkflow(fromCopyYear.getWorkflow());

        // save in newYear DB
        this.yearDAO.createCSYear(newYear);

        return newYear;
    }

    public Object getCSYear(int year) {
        CSYear createdYear = this.yearDAO.getCSYear(year);
        if(createdYear == null) {
            // year not found
            String error = "year not found";
            return error;
        }
        return createdYear;
    }

    public Object getWorkflowOfYear(int year) {
        String workflow = this.yearDAO.getWorkflowOfYear(year);
        if(workflow == null) {
            // year not found
            String error = "year not found; cannot get workflow";
            return error;
        }
        return workflow;
    }

    public Object updateYearWorkflow(int year, String updatedWF) {
        CSYear updatedYear = this.yearDAO.updateWorkflow(year, updatedWF);
        if(updatedYear == null) {
            // year not found
            String error = "year not found; workflow not updated";
            return error;
        }
        return updatedYear;
    }
}
