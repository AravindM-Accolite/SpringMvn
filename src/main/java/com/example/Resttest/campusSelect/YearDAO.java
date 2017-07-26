package com.example.Resttest.campusSelect;

import com.example.Resttest.campusSelect.model.CSYear;
import com.example.Resttest.campusSelect.model.CSYearTest;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class YearDAO {

    ArrayList<CSYearTest> years = new ArrayList<>();

    public java.sql.Connection getConnection(boolean autoCommit) throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        java.sql.Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AU","postgres", "postgres");
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    public YearDAO() {
        CSYearTest y1 = new CSYearTest();
        y1.setYear(2016);
        y1.setWorkflow("workflow1");

        CSYearTest y2 = new CSYearTest();
        y2.setYear(2017);
        y2.setWorkflow("workflow2");

        years.add(y1);
        years.add(y2);
    }

    public ArrayList<CSYear> getAllCSYears() {
        try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_YEARS);
            return Util.yearResultMapper(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return new ArrayList<>();
    }
    
    
    public ArrayList<CSYearTest> getAllCSYearsTest() {
        try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_ALL_YEAR);
            return new ArrayList<>();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return new ArrayList<>();
    }

    public void createCSYear(CSYearTest newYear) {
        // insert here
        this.years.add(newYear);
        System.out.print("created new year" + newYear);
    }

    public CSYearTest getCSYear(int year) {
        // query to get CSYeat with pk: year
        for (CSYearTest y: years) {
            if(year == y.getYear()) {
                return y;
            }
        }
        // return null when row count is zero
        return null;
    }

    public String getWorkflowOfYear(int year) {
        // query to get CSYeat with pk: year
        for (CSYearTest y: years) {
            if(year == y.getYear()) {
                return y.getWorkflow();
            }
        }
        // return null when row count is zero
        return null;
    }

    public CSYearTest updateWorkflow(int year, String updatedWF) {
        // query to get CSYeat with pk: year
        for (CSYearTest y: years) {
            if(year == y.getYear()) {
                y.setWorkflow(updatedWF);
                return y;
            }
        }
        // return null when row count is zero
        return null;
    }
}
