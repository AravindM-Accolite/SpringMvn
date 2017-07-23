package com.example.Resttest.campusSelect;

public interface YearAPIQueries {
    String GET_ALL_YEAR = "select * from year"; // example
    String GET_YEARS="select * from cs.year as year ,cs.workflow as workflow,cs.employe as employe where year.workflow_id=workflow.id and year.campusowner=employe.id";
}
