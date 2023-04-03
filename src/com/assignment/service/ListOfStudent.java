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
 * Servlet implementation class ListOfStudent
 */
@WebServlet("/listStudent")
public class ListOfStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListOfStudent() {
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
		StringBuffer returnData = new StringBuffer();
		ArrayList<Student> listOfStudent = (ArrayList<Student>) session.getAttribute("listOfStudent");
		if (listOfStudent == null) {
			response.getWriter().write("<h1> There are No Records for Student</h1>");
		} else {

			for (Student s : listOfStudent) {
				String rowData = new String(
						"<div class='row'><div class='col-sm-3'></div><div class='col-sm-3'><ul class='list-group list-group-horizontal'><li class='list-group-item'>"
								+ s.getfName()
								+ "</li><li class='list-group-item'>"+s.getlName()+"</li><li class='list-group-item'>"+s.getGradeID()+"</li><li class='list-group-item'>SUBJECT LIST</li><a href='editStudent?studentID="+s.getRollNumber()+"' class='list-group-item list-group-item-action'>Edit</a><a href='deleteStudent?studentID="+s.getRollNumber()+"' class='list-group-item list-group-item-action'>Delete</a></ul></div><div class='col-sm-3'></div></div>");
			returnData.append(rowData);
			}

		}
		response.getWriter().write(returnData.toString());
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
