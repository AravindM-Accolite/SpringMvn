package com.example.Resttest.campusSelect;

import com.example.Resttest.campusSelect.model.CSYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public YearDAO() {
        CSYear y1 = new CSYear();
        y1.setYear(2016);
        y1.setWorkflow("workflow1");

        CSYear y2 = new CSYear();
        y2.setYear(2017);
        y2.setWorkflow("workflow2");

        years.add(y1);
        years.add(y2);
    }

    public List<CSYear> getAllCSYears() {
        try {
            java.sql.Connection connection = getConnection(true);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(YearAPIQueries.GET_ALL_YEAR);
            while (rs.next()) {
                System.out.print("connected " + rs.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return years;
    }

    public void createCSYear(CSYear newYear) {
        // insert here
        this.years.add(newYear);
        System.out.print("created new year" + newYear);
    }

    public CSYear getCSYear(int year) {
        // query to get CSYeat with pk: year
        for (CSYear y: years) {
            if(year == y.getYear()) {
                return y;
            }
        }
        // return null when row count is zero
        return null;
    }

    public String getWorkflowOfYear(int year) {
        // query to get CSYeat with pk: year
        for (CSYear y: years) {
            if(year == y.getYear()) {
                return y.getWorkflow();
            }
        }
        // return null when row count is zero
        return null;
    }

    public CSYear updateWorkflow(int year, String updatedWF) {
        // query to get CSYeat with pk: year
        for (CSYear y: years) {
            if(year == y.getYear()) {
                y.setWorkflow(updatedWF);
                return y;
            }
        }
        // return null when row count is zero
        return null;
    }
}
