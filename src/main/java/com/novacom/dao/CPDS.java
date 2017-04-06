package com.novacom.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by A.Sivakon on 06.04.2017.
 */
public class CPDS {
    private final String HOST = "jdbc:postgresql://localhost:5432/testdb";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "root";
    private final String DRIVER_CLASS = "org.postgresql.Driver";
    Connection connection;

    ComboPooledDataSource cpds = new ComboPooledDataSource();


    public void GetComboPooledDataSource(){
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
}
