package com.example.Resttest.campusSelect;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.Drive;
import com.example.Resttest.campusSelect.model.Employee;
import com.example.Resttest.campusSelect.model.Workflow;

public class Util {
	static ArrayList<CSYear> yearResultMapper(ResultSet rs) {
		ArrayList<CSYear> years = new ArrayList<>();
		try {
			while (rs.next()) {

				CSYear yr = new CSYear();
				Workflow wf = new Workflow();
				Employee emp = new Employee();
				try {

					wf.setId(rs.getInt("workflow_id"));

					ArrayList<Integer> inStages = new ArrayList<>();
                    Array stagesArray = rs.getArray("rid");
                    Integer[] stages = (Integer[]) stagesArray.getArray();
                    inStages.addAll(Arrays.asList(stages));
                    wf.setStages(inStages);

                    yr.setId(rs.getInt("year"));
					yr.setWorkflow(wf);

					emp.setContant(rs.getString("contact_number"));
					emp.setEmail(rs.getString("email"));
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setRole(rs.getString("role"));

					yr.setCampusOwner(emp);

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
	
	static ArrayList<Drive> AllDriveList(ResultSet rs){
		
		ArrayList<Drive> drives = new ArrayList<Drive>();
		try{
			while(rs.next()){
				Drive dr = new Drive();
			
				
				dr.setDrive_id(rs.getInt("drive_id"));
				dr.setYear(rs.getInt("campus_year"));
				dr.setWorkflow(rs.getInt("workflow_id"));
				dr.setStatus(rs.getInt("drive_status"));
				dr.setStartDate(rs.getString("start_date"));
				dr.setEndDate(rs.getString("end_date"));
				dr.setHr(rs.getInt("hr_id"));
				
				drives.add(dr);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return drives;
	}

	static ArrayList<Drive> YearDriveList(ResultSet rs){
		
		ArrayList<Drive> drives = new ArrayList<Drive>();
		try{
			while(rs.next()){
				Drive dr = new Drive();
			
				
				dr.setDrive_id(rs.getInt("drive_id"));
				dr.setYear(rs.getInt("campus_year"));
				dr.setWorkflow(rs.getInt("workflow_id"));
				dr.setStatus(rs.getInt("drive_status"));
				dr.setStartDate(rs.getString("start_date"));
				dr.setEndDate(rs.getString("end_date"));
				dr.setHr(rs.getInt("hr_id"));
				
				drives.add(dr);
			}
		}

		catch(SQLException e){
			e.printStackTrace();
		}
		return drives;
	}
}
