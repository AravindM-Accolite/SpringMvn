package com.example.Resttest.campusSelect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.Workflow;

@RestController
@RequestMapping(value = "api/campuses")
public class YearController {

    @Autowired
    private YearService yearService;

    public void setYearService(YearService yearService) {
        this.yearService = yearService;
    }

    @RequestMapping(value = "/test")
    public String getHello(){
        return "hello";
    }

    // get list of CSYearTest
   
    @RequestMapping(value = "/years", method = RequestMethod.GET)
        public @ResponseBody  List<CSYear> getCSYearList() {
       // System.out.print("result ärraylist " + this.yearService.getALLCSYears());
    	 
           return this.yearService.getALLCSYears();
    	
    }

    // get year by {ID}
        // show all the drives(later according to the user)
    @RequestMapping(value = "/{year}", method = RequestMethod.GET)
    public @ResponseBody Object getCSYear(@PathVariable("year") int year) {
        return this.yearService.getCSYear(year);
    }

    @RequestMapping(value = "/create/year", method = RequestMethod.POST)
    // post a new year params: from year
    public CSYear createCSYear(@RequestParam("fromYear") int fromYear)
    {
        // get data from from year and populate in the new year and then store the year
    		
        return this.yearService.createCSYear(fromYear);
        
        
      }
    
    @RequestMapping(value = "/yearList", method = RequestMethod.GET)
    public @ResponseBody Object getCSYear() {
        return this.yearService.getCSYearList();
    }

    
    
 
    @RequestMapping(value = "/workflow/{year}")
    // get workflow of the year
    public Object getWorkflowOfYear(@PathVariable("year") int year) {
        return this.yearService.getWorkflowOfYear(year);
    }

    @RequestMapping(value = "/workflow/{year}", method = RequestMethod.PUT)
    // update workflow of the year
    public Object updateYearWorkflow(@PathVariable("year") int year, @RequestBody Workflow updatedWF) {
        return this.yearService.updateYearWorkflow(year, updatedWF);
    }

    // get/ update year HR
}
