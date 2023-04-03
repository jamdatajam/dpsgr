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
import com.assignment.utility.GenerateID;

/**
 * Servlet implementation class AddStudentData
 */
@WebServlet("/addStudent")
public class AddStudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("Session ID: "+session.getId());
		ArrayList<Student> listStudent = (ArrayList<Student>) session.getAttribute("listOfStudent");
		if(listStudent== null) {
			listStudent = new ArrayList<Student>();
		}
		//Retrieve Data From Request and store it in Student Object and then add to ListOfStudent
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String grade = request.getParameter("grade");
		Student newStudent = new Student();
		newStudent.setRollNumber(GenerateID.getNewRollNumber());
		newStudent.setfName(fName);
		newStudent.setlName(lName);
		newStudent.setGradeID(grade);
		listStudent.add(newStudent);
		session.setAttribute("listOfStudent", listStudent);
		response.getWriter().append(String.valueOf(newStudent.getRollNumber()));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}