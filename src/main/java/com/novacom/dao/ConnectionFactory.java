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
        cpds = new ComboPooledDataSource();
        getComboPooledDataSource();
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();

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
    private Connection connection;
    private ComboPooledDataSource cpds;



    //Block c3p0----------------------------------------------------------------------

    private void getComboPooledDataSource(){
        try {
            cpds.setDriverClass(DRIVER_CLASS);
            cpds.setJdbcUrl    (HOST);
            cpds.setUser       (USERNAME);
            cpds.setPassword   (PASSWORD);

            Properties properties = new Properties();
            properties.setProperty ("user"             , USERNAME   );
            properties.setProperty ("password"         , PASSWORD);
            properties.setProperty ("useUnicode"       , "true"      );
            properties.setProperty ("characterEncoding", "UTF8"      );
            cpds.setProperties(properties);

            // set options
            cpds.setMaxStatements             (10);
            cpds.setMaxStatementsPerConnection(3);
            cpds.setMinPoolSize               (3);
            cpds.setAcquireIncrement          ( 10);
            cpds.setMaxPoolSize               ( 10);
            cpds.setMaxIdleTime               ( 30);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------------------------------

    public Connection getConnection() {
        try{
            connection = cpds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}
