package com.novacom.dao;

import java.sql.*;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class Dao {
    private ConnectionFactory connection;

    //Block singleton-------------------------------------------
    private final static Dao uniqueInstance = new Dao();

    private Dao(){
        connection = ConnectionFactory.getUniqueInstance();
    }

    public static Dao getUniqueInstance() {
        return uniqueInstance;
    }
    //----------------------------------------------------------


    //Custom query (return first client from database)
    public void exCustomQuery(){

        String query = "SELECT c_name FROM clients WHERE c_id = 1";
        try(Connection c = connection.getConnection()){
            Statement statement = c.createStatement();
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
