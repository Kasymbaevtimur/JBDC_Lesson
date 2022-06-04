package org.peaksoft.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static final String  url="jdbc:postgresql://localhost:5432/jdbc_home_work";
    private static final String userName="postgres";
    private static final String posword="timurlan0797";

    public static Connection connection(){
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url,userName,posword);
            System.out.println("Sucsesfully connected to Daaatabase !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
