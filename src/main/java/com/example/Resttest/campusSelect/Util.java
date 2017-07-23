package com.example.Resttest.campusSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.Resttest.campusSelect.model.CSYear;
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

					wf.setStages(Arrays.asList(rs.getArray("rid")));

					yr.setWorkflow(wf);

					emp.setContant(rs.getString("contact_number"));
					emp.setEmail(rs.getString("email"));
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setRole(rs.getString("role"));

					yr.setCampusOwner(emp);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				years.add(yr);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return years;

	}
}
