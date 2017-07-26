package com.example.Resttest.campusSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.Employee;
import com.example.Resttest.campusSelect.model.Stage;
import com.example.Resttest.campusSelect.model.Workflow;

public class Util 
{

	//get info of all years
	static ArrayList<CSYear> yearResultMapper(ResultSet rs) {
		ArrayList<CSYear> years = new ArrayList<>();
		
		YearDAO yd=new YearDAO();
		try {
			while (rs.next()) {

				CSYear yr = new CSYear();
				Workflow wf = new Workflow();
				Employee emp = new Employee();
				try {

					wf.setWorkflow_id(rs.getInt("curr_workflow_id"));
					wf.setWorkflow_name(rs.getString("workflow_name"));
					wf.setWorkflow_decription(rs.getString("description"));
					

                    yr.setYear(rs.getInt("campus_year"));
					yr.setCurr_workflow(wf);
					yr.setSrc_workflow(wf);
					
					emp.setContant(rs.getString("contact_number"));
					emp.setEmail(rs.getString("email"));
					emp.setId(rs.getInt("employe_id"));
					emp.setName(rs.getString("name"));
					emp.setRole(rs.getString("role"));
                    yr.setCampusOwner(emp);
                    
                    
                    CSYear yr2=new CSYear();
					yr2=addRoundsToYear(yd.getstage(yr.getYear()), yr);
					yr=yr2;

					

				} catch (SQLException e) {
					e.printStackTrace();
				}
				years.add(yr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return years;
	}
	
	
	//get info of particular year
	static CSYear yrResultMapper(ResultSet rs) {
	
		CSYear yr = new CSYear();
		try {
			while (rs.next()) {

				
				
				Workflow wf = new Workflow();
				Employee emp = new Employee();
				try {

					wf.setWorkflow_id(rs.getInt("curr_workflow_id"));
					wf.setWorkflow_name(rs.getString("workflow_name"));
					wf.setWorkflow_decription(rs.getString("description"));

                    yr.setYear(rs.getInt("campus_year"));
					yr.setCurr_workflow(wf);
					yr.setSrc_workflow(wf);
					
					emp.setContant(rs.getString("contact_number"));
					emp.setEmail(rs.getString("email"));
					emp.setId(rs.getInt("employe_id"));
					emp.setName(rs.getString("name"));
					emp.setRole(rs.getString("role"));
                    yr.setCampusOwner(emp);
                    
                    

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return yr;
	}


//get list of years
	public static List<Integer> yrList(ResultSet rs) 
	{
		// TODO Auto-generated method stub
		List<Integer>yrList=new ArrayList<>();
		try {
			while(rs.next())
			{
				yrList.add(rs.getInt("campus_year"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return yrList;
	}
	
	
	
	//function to add rounds to the year object
	public static CSYear  addRoundsToYear(ResultSet rs,CSYear yr)
	{
		  
		try {
			
			while(rs.next())
			{
				Stage s=new Stage();
				s.setDescription(rs.getString("description"));
				s.setId(rs.getInt("round_id"));
				s.setName(rs.getString("round_type"));
				
				yr.getCurr_workflow().addStages(s);

			}
				 
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yr;
	}
	
	
	
	
	
}
