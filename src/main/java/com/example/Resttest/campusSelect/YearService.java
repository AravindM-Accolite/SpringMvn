package com.example.Resttest.campusSelect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.Workflow;

@Service
public class YearService {

    @Autowired
    private YearDAO yearDAO;

    public List<CSYear> getALLCSYears() {return yearDAO.getAllCSYears(); }

    public CSYear createCSYear(int fromYear) {
        // get all existing years
        List<CSYear> allYears = this.yearDAO.getAllCSYears();
        
        int lastYear=this.yearDAO.getLastYear();

        //allYears.sort((o1, o2) -> Integer.compare(o2.getYear(), o1.getYear()));

        // find the latest new year to create
        CSYear newYear = new CSYear();
        //newYear.setYear(allYears.get(0).getYear() + 1);
        
        newYear.setYear(lastYear + 1);

        // copy properties
        CSYear fromCopyYear = new CSYear();
        for (CSYear year : allYears) {
            if (year.getYear() == fromYear) {
                fromCopyYear = year;
            }
        }

        newYear.setCurr_workflow(fromCopyYear.getCurr_workflow());
        newYear.setSrc_workflow(fromCopyYear.getCurr_workflow());
        newYear.setCampusOwner(fromCopyYear.getCampusOwner());

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
        Workflow workflow = this.yearDAO.getWorkflowOfYear(year);
        if(workflow == null) {
            // year not found
            String error = "year not found; cannot get workflow";
            return error;
        }
        return workflow;
    }

    public Object updateYearWorkflow(int year, Workflow updatedWF) {
        CSYear updatedYear = this.yearDAO.updateWorkflow(year, updatedWF);
        if(updatedYear == null) {
            // year not found
            String error = "year not found; workflow not updated";
            return error;
        }
        return updatedYear;
    }

	public List<Integer> getCSYearList() {
		// TODO Auto-generated method stub
		return this.yearDAO.getYearList();
	}
}
