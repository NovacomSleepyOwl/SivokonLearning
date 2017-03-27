package com.novacom.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by A.Sivakon on 27.01.2017.
 */
@WebFilter(urlPatterns = "/*")
public class CountFilter implements Filter {

    int a = 0;
    int headerCount = 0;
    int mainCount = 0;
    int bodyCount = 0;

    FilterConfig filterConfig = null;

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String servletPath = "";

        HttpServletRequest request = (HttpServletRequest) req;
        servletPath = request.getServletPath();

        if(servletPath.equals("/body")){
            bodyCount++;
            System.out.println ("You entered a body servlet for a " + bodyCount + " time");
        }
        if(servletPath.equals("/header")){
            headerCount++;
            System.out.println ("You entered a header servlet for a " + headerCount + " time");
        }
        if(servletPath.equals("/main")){
            mainCount++;
            System.out.println ("You entered a main servlet for a " + mainCount + " time");
        }
        if(servletPath.equals("/index.jsp") ){
            mainCount++;
            a = mainCount;
            System.out.println ("You entered a main servlet for a " + mainCount + " time");
        }
        chain.doFilter(req, resp);

    }

    public void destroy() {
        this.filterConfig = null;
    }

}
