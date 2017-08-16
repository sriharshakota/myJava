/**
 * Created by sriharshakota on 8/16/17.
 */
package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;


public class SecondServlet extends HttpServlet  {
    @Override
    public void service (ServletRequest req, ServletResponse res) throws ServletException, IOException{
        res.getWriter().write("Hello this is my second servlet");
    }
}
