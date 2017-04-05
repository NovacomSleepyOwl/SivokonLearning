package com.novacom.dao;

import java.sql.*;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class Dao {
    ConnectionFactory connection;

    //Block singleton-------------------------------------------
    private static Dao uniqueInstance = new Dao();

    private Dao(){
        connection = new ConnectionFactory();
    }

    public static Dao getUniqueInstance() {
        return uniqueInstance;
    }
    //----------------------------------------------------------

    //Factory method------------------------------------------
    private ConnectionFactory getConnectionFactory(){
        return connection;
    }
    //----------------------------------------------------------




    //Custom query (return first client from database)
    public void ExQuery(){

        String query = "SELECT c_name FROM clients WHERE c_id = 1";

        try(Statement statement = connection.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String cname = resultSet.getString(1);
                System.out.println("Cname = :" + cname);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }



}
