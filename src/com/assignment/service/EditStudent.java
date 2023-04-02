package com.assignment.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.pojo.Student;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("Session ID: "+session.getId());
		int rollNumber = Integer.parseInt( request.getParameter("studentID"));
		
		ArrayList<Student> listOfStudent = (ArrayList<Student>)session.getAttribute("listOfStudent");
		
		for(Student s: listOfStudent) {
			if(s.getRollNumber()==rollNumber) {
			request.setAttribute("editStudent", s);
			}
		}
		session.setAttribute("listOfStudent", listOfStudent);
		request.getRequestDispatcher("./EditFunctionality.jsp").forward(request, response);
//		response.getWriter().write("<h1>Student is Edited Now "+request.getParameter("studentID")+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
