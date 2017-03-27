package com.novacom.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by A.Sivakon on 20.01.2017.
 */
@WebServlet(name = "header", urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {

    private static final String HEADER = "HEAD";

    @Override
     protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getHeader("X-Name");
        String age = request.getHeader("X-Age");
        Enumeration<String> headers = request.getHeaderNames();
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Hello Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Hello Page</h1>");
        out.println("</center>");
        out.println("<h1> Hello " + name + ", you are " +age+ " years old</h1>");
        String SHeaders = "Headers: ";
        for(; headers.hasMoreElements();){
            SHeaders += headers.nextElement() + ", ";
        }
        out.println(SHeaders);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
        dispatcher.include(request, response);

        //
        /*System.out.println("This message is made by System.out");

        //
        Logger log = Logger.getLogger(getServletInfo());
        log.info("This message is made by Logger");


        */

    }
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello");
        dispatcher.forward(req, resp);
    } */
}
