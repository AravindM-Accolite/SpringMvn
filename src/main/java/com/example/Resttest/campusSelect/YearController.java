package com.example.Resttest.campusSelect;

import com.example.Resttest.campusSelect.model.CSYear;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // get list of CSYear
    @RequestMapping(value = "/years", method = RequestMethod.GET)
    public @ResponseBody List<CSYear> getCSYearList() {
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
    public CSYear createCSYear(@RequestParam("fromYear") int fromYear) {
        // get data from from year and populate in the new year and then store the year
        return this.yearService.createCSYear(fromYear);
    }

    @RequestMapping(value = "/workflow/{year}")
    // get workflow of the year
    public Object getWorkflowOfYear(@PathVariable("year") int year) {
        return this.yearService.getWorkflowOfYear(year);
    }

    @RequestMapping(value = "/workflow/{year}", method = RequestMethod.PUT)
    // update workflow of the year
    public Object updateYearWorkflow(@PathVariable("year") int year, @RequestBody String updatedWF) {
        return this.yearService.updateYearWorkflow(year, updatedWF);
    }

    // get/ update year HR
}
