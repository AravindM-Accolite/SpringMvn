package com.example.Resttest.campusSelect.model;

import java.util.ArrayList;

public class Workflow {
	
	private Integer id;
    private ArrayList<Integer> stages;
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Integer> getStages() {
		return stages;
	}

	public void setStages(ArrayList<Integer> stages) {
		this.stages = stages;
	}
}