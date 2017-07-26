package com.example.Resttest.campusSelect.model;

public class Candidates {

    private Integer id;
    private String name;
    private College college;
    private String email;
    private String contact;
    private boolean isRegistered;
    private String cgpa;
    private String branch;
    
    public void setId(Integer id) {
		this.id = id;
	}
    public Integer getId(){
    	return id;
    }
    
    public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setCollege(College college) {
		this.college = college;
	}
	public College getCollege() {
		return college;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public boolean getIsRegistered() {
		return isRegistered;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact() {
		return contact;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getCgpa() {
		return cgpa;
	}
	

	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranch() {
		return branch;
	}
	
	@Override
	public String toString() {
        return String.valueOf(id);
    }
}
