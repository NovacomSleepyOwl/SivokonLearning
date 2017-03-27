package com.novacom.servlet;

import com.novacom.classes.Parse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by A.Sivakon on 24.01.2017.
 */
@WebServlet(name = "body", urlPatterns = "/body")
public class BodyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "";
        String age = "";

        BufferedReader reader = request.getReader();
        //String dataReq = "Data: ";
        ArrayList<String> dataReq = new ArrayList<String>();
        String s;
        while ((s = reader.readLine())!= null){
            dataReq.add(s + "// ");
        }

        Parse parse = new Parse();

        PrintWriter out = response.getWriter();
        out.println("Hello " + parse.FindName(dataReq) + ", you are " + parse.FindAge(dataReq) + " years old");

        System.out.println("wrpojpah");
        /*for( int i = 0; i < dataReq.size(); i++){
            out.println(dataReq.get(i));
        } */

        /*
        System.out.println("This message is made by System.out");

        //
        Logger log = Logger.getLogger(getServletInfo());
        log.info("This message is made by Logger");

        //
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
        dispatcher.forward(request, response); */

    }


}
