package com.example.Resttest.campusSelect;

import com.example.Resttest.campusSelect.model.CSYearTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearService {

    @Autowired
    private YearDAO yearDAO;

    public List<CSYearTest> getALLCSYears() {return yearDAO.getAllCSYears(); }

    public CSYearTest createCSYear(int fromYear) {
        // get all existing years
        List<CSYearTest> allYears = this.yearDAO.getAllCSYears();

        allYears.sort((o1, o2) -> Integer.compare(o2.getYear(), o1.getYear()));

        // find the latest new year to create
        CSYearTest newYear = new CSYearTest();
        newYear.setYear(allYears.get(0).getYear() + 1);

        // copy properties
        CSYearTest fromCopyYear = new CSYearTest();
        for (CSYearTest year : allYears) {
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
        CSYearTest createdYear = this.yearDAO.getCSYear(year);
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
        CSYearTest updatedYear = this.yearDAO.updateWorkflow(year, updatedWF);
        if(updatedYear == null) {
            // year not found
            String error = "year not found; workflow not updated";
            return error;
        }
        return updatedYear;
    }
}
