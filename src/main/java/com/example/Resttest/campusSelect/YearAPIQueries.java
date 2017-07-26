package com.example.Resttest.campusSelect;

public interface YearAPIQueries {
    String GET_ALL_YEAR = "select * from campus_year"; // example
    String GET_YEARS="select campus_year, curr_workflow_id,employe.name from campus_year  ,workflow, employe where campus_year.curr_workflow_id=workflow.workflow_id and campus_year.campusowner=employe.employe_id";
   
}
