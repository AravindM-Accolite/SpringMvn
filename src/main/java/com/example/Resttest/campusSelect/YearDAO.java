package com.example.Resttest.campusSelect;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.Workflow;

@Component
public class YearDAO {

    ArrayList<CSYear> years = new ArrayList<>();

    public java.sql.Connection getConnection(boolean autoCommit) throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        java.sql.Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AU","postgres", "postgres");
        connection.setAutoCommit(autoCommit);
        return connection;
    }

//    @Autowired
//    JdbcTemplate JDtemplate ;
    
    
    public YearDAO() {
//        CSYear y1 = new CSYear();
//        y1.setYear(2016);
//        y1.setWorkflow("workflow1");
//
//        CSYear y2 = new CSYear();
//        y2.setYear(2017);
//        y2.setWorkflow("workflow2");
//
//        years.add(y1);
//        years.add(y2);
    }
    
    
//    public CSYear getYear()
//    {
// 	   return (CSYear) (JDtemplate.query(YearAPIQueries.GET_YEARS,new YearMapper()));
//
//    }
//    
    
   

    public ArrayList<CSYear> getAllCSYears() {
        try {
        	
        	
   	         java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_YEARS);
            return Util.yearResultMapper(rs);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
          return new ArrayList<>();
    }
//    
//    public ArrayList<CSYear> getAllCSYear() {
//        try {
//            java.sql.Connection connection = getConnection(true);
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_ALL_YEAR);
//            return new ArrayList<>();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//          return new ArrayList<>();
//    }

    public void createCSYear(CSYear newYear)
    {
        // insert here
        this.years.add(newYear);
        String createYearmsg="failed to create new year";
        try {
            java.sql.Connection connection = getConnection(true);
            
            
            PreparedStatement ps=connection.prepareStatement("INSERT INTO cs.campus_year(campus_year, curr_workflow_id,source_workflow_id, campusowner) VALUES (?,?,?,?)");
            ps.setInt(1,newYear.getYear());
            ps.setInt(2,newYear.getCurr_workflow().getWorkflow_id());
            ps.setInt(3, newYear.getSrc_workflow().getWorkflow_id());
            ps.setInt(4,newYear.getCampusOwner().getId());
            
            int rs = ps.executeUpdate();
            createYearmsg="new year created";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        System.out.print(createYearmsg + newYear);
    }

    public CSYear getCSYear(int year) {
        // query to get CSYear with pk: year
    	
    	
    	try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_YEAR+year+";");
            return Util.yrResultMapper(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return new CSYear() ;
    }


	public List<Integer> getYearList() 
	{
		// TODO Auto-generated method stub
		
	      List<Integer> i=new ArrayList<>();
		
		try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_YEAR_LIST);
            return Util.yrList(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return i;
	}
    
    
    public Workflow getWorkflowOfYear(int year) {
        // query to get CSYeat with pk: year
        for (CSYear y: years) {
            if(year == y.getYear()) {
                return y.getCurr_workflow();
            }
        }
        // return null when row count is zero
        return null;
    }

    public CSYear updateWorkflow(int year, Workflow updatedWF) {
        // query to get CSYeat with pk: year
        for (CSYear y: years) {
            if(year == y.getYear()) {
                y.setCurr_workflow(updatedWF);
                return y;
            }
        }
        // return null when row count is zero
        return null;
    }
    
    
    
    
    
    public ResultSet getstage(int yr)
    {
    	
    	try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_ROUNDS+yr+";");
               return rs;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return null;
    	
    	
    }

	public int getLastYear() 
	{
		// TODO Auto-generated method stub

    	try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_LastYear);
            rs.next();
               return rs.getInt("campus_year");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          
		return 0;
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
