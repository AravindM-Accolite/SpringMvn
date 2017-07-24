package com.example.Resttest.campusSelect.model;

public class CSYear {
    private Integer id;
    private Workflow workflow;
    private Employee campusOwner;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public Employee getCampusOwner() {
		return campusOwner;
	}
	public void setCampusOwner(Employee campusOwner) {
		this.campusOwner = campusOwner;
	}

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
