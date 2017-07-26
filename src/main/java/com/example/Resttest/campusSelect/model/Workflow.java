package com.example.Resttest.campusSelect.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Workflow {
	

    
    
    private Integer workflow_id;
    private String workflow_name;
    private String workflow_decription;
    private ArrayList<Stage> stages;
    private static ArrayList<Workflow> src_worflow;
    private static HashMap<Integer,Workflow> src_wf_map;
    
    
    public Workflow() {
    	stages = new ArrayList<>();
    }

    
    public  Workflow get_src_workflow(int year)
    {
    	if(src_wf_map.get(year) != null)
    	{
    		
    		return src_wf_map.get(year);
    	}
    	else
    	{
    	src_wf_map.put(year,this);
		return this;
    	}
    }
    

	public Integer getWorkflow_id() {
		return workflow_id;
	}

	public void setWorkflow_id(Integer workflow_id) {
		this.workflow_id = workflow_id;
	}

	public String getWorkflow_name() {
		return workflow_name;
	}

	public void setWorkflow_name(String workflow_name) {
		this.workflow_name = workflow_name;
	}

	public String getWorkflow_decription() {
		return workflow_decription;
	}

	public void setWorkflow_decription(String workflow_decription) {
		this.workflow_decription = workflow_decription;
	}

	public ArrayList<Stage> getStages() {
		return stages;
	}

	public void addStages(Stage stage) {
	
		this.stages.add(stage);
	}
}