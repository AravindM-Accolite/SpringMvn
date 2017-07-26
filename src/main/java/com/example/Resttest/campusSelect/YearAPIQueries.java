package com.example.Resttest.campusSelect;

public interface YearAPIQueries {
    String GET_ALL_YEAR = "select * from year"; // example
    
    String GET_YEARS="select * from cs.campus_year as year ,cs.workflow as workflow,cs.employe as employe where year.curr_workflow_id=workflow.workflow_id and year.campusowner=employe.employe_id;";
    String GET_ROUNDS="select campus_year,curr_workflow_id,rounds.round_id,round_type,description  from cs.campus_year as cYr,cs.workflow_round as wf_r,cs.rounds as rounds where cYr.curr_workflow_id=wf_r.workflow_id and wf_r.round_id=rounds.round_id AND CAMPUS_YEAR=";
    //String GET_YEARS="select * from cs.year as year ,cs.workflow as workflow,cs.employe as employe where year.curr_workflow_id=workflow.workflow_id and year.campusowner=employe.employe_id;";
String GET_YEAR="select * from cs.campus_year as year ,cs.workflow as workflow,cs.employe as employe where year.curr_workflow_id=workflow.workflow_id and year.campusowner=employe.employe_id and year.campus_year=";

String GET_YEAR_LIST = "select campus_year from cs.campus_year";

String GET_LastYear = "select campus_year from cs.campus_year order by campus_year desc limit 1";

    




}
