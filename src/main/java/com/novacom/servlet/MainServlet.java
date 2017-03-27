package com.novacom.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by A.Sivakon on 18.01.2017.
 */
@WebServlet(name = "url", urlPatterns = "/url")
public class MainServlet extends HttpServlet{

    private static final String NAME_PARAM = "txt_name";
    private static final String AGE_PARAM = "txt_age";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nameParam = req.getParameter(NAME_PARAM);
        String ageParam = req.getParameter(AGE_PARAM);
        req.setAttribute("name", nameParam);
        req.setAttribute("age", ageParam);

        PrintWriter out = resp.getWriter();
        //req.getRequestDispatcher("index.jsp").forward(req, resp);
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
        out.println("<h1>Hello " + nameParam + ", you are age of " + ageParam + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }


}
