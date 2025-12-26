package com.example.demo.servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(200);
        res.setContentType("text/plain");
        res.getWriter().write("HelloMessage");
     
    }
}
// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// public class HelloServlet extends HttpServlet {

//     @Override
//     public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setContentType("text/plain");
//         resp.getWriter().write("HelloMessage");
//     }
// }
