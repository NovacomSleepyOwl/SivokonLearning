package com.novacom.dao;

import com.novacom.dao.beans.ClientBean;

import java.sql.*;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class Dao {

    public void ExQuery(){
        Connector connector = new Connector();
        String query = "SELECT c_name FROM clients WHERE c_id = 1";

        try{
            Statement statement = connector.getConnection().createStatement();
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
