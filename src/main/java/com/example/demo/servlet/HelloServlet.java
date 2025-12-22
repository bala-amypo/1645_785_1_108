package com.example.demo.servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello-servlet")
public class sampleget extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(200);
        res.setContentType("text/plain");
        for(user u:samplepost.users){
           res.getWriter().write(u.name+" "+u.email+" "+u.pwd+" "+u.phone+" "+u.age);
        }
     
    }