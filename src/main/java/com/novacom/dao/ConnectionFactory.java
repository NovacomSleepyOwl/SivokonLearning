package com.novacom.dao;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class ConnectionFactory {

    //Block singleton-------------------------------------------
    private static ConnectionFactory uniqueInstance = new ConnectionFactory();

    private ConnectionFactory(){

        try {
            Class.forName(DRIVER_CLASS);
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
    private final String DRIVER_CLASS = "org.postgresql.Driver";
    Connection connection;


    public Connection getConnection() {
        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }


    /*Block c3p0----------------------------------------------------------------------


    public Connection getC3P0Connection(){
        try {
            connection = cpds.getConnection();
            System.out.println ("closeConnection : idleConnections = " + cpds.getNumIdleConnections() +
                    ", busyConnections = " + cpds.getNumBusyConnections());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //-------------------------------------------------------------------------------- */

}
