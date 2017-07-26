package com.example.Resttest.campusSelect.model;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

public class YearMapper implements RowMapper<CSYear>
{
	   
		@Override
		public CSYear mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			CSYear years=new CSYear();
			try {
				while (rs.next()) {

					CSYear yr = new CSYear();
					Workflow wf = new Workflow();
					Employee emp = new Employee();
					try {

						wf.setWorkflow_id(rs.getInt("curr_workflow_id"));

						ArrayList<Integer> inStages = new ArrayList<>();
	                    Array stagesArray = rs.getArray("rid");
//	                    Integer[] stages = (Integer[]) stagesArray.getArray();
//	                    inStages.addAll(Arrays.asList(stages));
//	                    wf.setStages(inStages);

	                    yr.setYear(rs.getInt("year"));
						yr.setCurr_workflow(wf);

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
			return years;
			
		}

}
