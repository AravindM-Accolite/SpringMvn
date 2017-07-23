package com.example.Resttest.campusSelect.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Workflow {
	
	private Integer id;
    private List<Array> stages;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Array> getStages() {
		return stages;
	}
	public void setStages(List<Array> list) {
		this.stages = list;
	}

	
    
}
