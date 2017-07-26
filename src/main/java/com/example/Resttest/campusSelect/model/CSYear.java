package com.example.Resttest.campusSelect.model;

public class CSYear{
    private Integer year;
	private Workflow curr_workflow;
	private Workflow src_workflow;
    private Employee campusOwner;
    
    
    
    
    
    
	
    
    public Workflow getCurr_workflow() {
		return this.curr_workflow;
	}

	public void setCurr_workflow(Workflow curr_workflow) {
		this.curr_workflow = curr_workflow;
	}

	public Workflow getSrc_workflow() {
		return src_workflow;
	}

	public void setSrc_workflow(Workflow src_workflow) {
		this.src_workflow = src_workflow;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	
	
	public Employee getCampusOwner() {
		return campusOwner;
	}
	public void setCampusOwner(Employee campusOwner) {
		this.campusOwner = campusOwner;
	}

    @Override
    public String toString() {
        return String.valueOf(year);
    }

    
 
}
