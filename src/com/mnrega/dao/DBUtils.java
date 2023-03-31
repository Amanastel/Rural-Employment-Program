package com.mnrega.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
    public static Connection getConnectionToDatabase() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResourceBundle rb = ResourceBundle.getBundle("db");
        return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
    }


    static void closeConnection(Connection conn) throws SQLException{
        if(conn !=null){
            conn.close();
        }
    }

    static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
        if(!rs.isBeforeFirst() && rs.getRow() ==0)
            return true;
        return false;
    }
}