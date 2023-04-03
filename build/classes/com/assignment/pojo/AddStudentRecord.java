//package com.webdev.service;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

public class AddStudentRecord implements Servlet{
 public  void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException{
	 
	 System.out.println("Servlet Initialized");
 }

  public  javax.servlet.ServletConfig getServletConfig(){
	 System.out.println("Servlet Config Method");
	 return null;
	  
  }
  public  void service(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response) throws javax.servlet.ServletException, java.io.IOException{
	   response.getWriter().write("<h1> Record Recorded Successfully...!</h1><table border=1>");
	  	 System.out.println("Servlet Service Mode");
		 String fname = request.getParameter("fname");
		 String lname = request.getParameter("lname");
		 String email = request.getParameter("email");
		 String pwd =  request.getParameter("pwd");
		 for(int i=0; i<10;i++){
		 response.getWriter().write("<tr><td style='padding:10'>"+fname+"</td><td style='padding:10'>"+lname+"</td><td style='padding:10'>"+email+"</td></tr>");
		 }
		 response.getWriter().write("</table>");
  }
  public  java.lang.String getServletInfo(){
	  return "I am AddStudentRecord-Servlet";
  }
  public  void destroy(){
	  
	  	 System.out.println("Servlet is out of Service or Dead");

  }

}