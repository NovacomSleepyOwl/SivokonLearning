package com.novacom.dao;

import java.sql.*;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class ConnectionFactory {

    //Block singleton-------------------------------------------
    private static ConnectionFactory uniqueInstance = new ConnectionFactory();

    private ConnectionFactory(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
    }

    public static ConnectionFactory getUniqueInstance() {
        return uniqueInstance;
    }
    //----------------------------------------------------------

    private final String HOST = "jdbc:postgresql://localhost:5432/testdb";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "root";
    Connection connection;


    public Connection getConnection() {
        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
