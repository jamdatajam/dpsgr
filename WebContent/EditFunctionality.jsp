<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.assignment.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.2/js/bootstrap.bundle.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- CUSTOME JavaScript Files -->
<script src="./js/js_library.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav class="navbar navbar-expand-sm bg-dark">
					<ul class="navbar-nav">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> Student</a>
							<div class="dropdown-menu bg-light">
								<a class="dropdown-item" href="#"
									onclick="getDataLoaded('addStudent')">Add Student</a> <a
									class="dropdown-item" href="#"
									onclick="showListData('listStudent', 'recordsStudent')">List
									Student</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> Teacher </a>
							<div class="dropdown-menu bg-light">
								<a class="dropdown-item" href="#"
									onclick="getDataLoaded('addTeacher')">Add Teacher</a> <a
									class="dropdown-item" href="#"
									onclick="getDataLoaded('listTeacher')">List Teacher</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> Grade </a>
							<div class="dropdown-menu bg-light">
								<a class="dropdown-item" href="#"
									onclick="getDataLoaded('addGrade')">Add Grade</a> <a
									class="dropdown-item" href="#"
									onclick="getDataLoaded('listGrade')">List Grade</a>

							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> Subject </a>
							<div class="dropdown-menu bg-light">
								<a class="dropdown-item" href="#"
									onclick="getDataLoaded('addSubject')">Add Subject</a> <a
									class="dropdown-item" href="#"
									onclick="getDataLoaded('listSubject')">List Subject</a>

							</div></li>

					</ul>
				</nav>
			</div>
		</div>
		<%
			if (request.getAttribute("editStudent") != null) {
				Student s = (Student) request.getAttribute("editStudent");
		%>
		<div id="editStudent" style="display: inline;">
			<div class="row">
				<div class="col-sm-2 col-lg-4"></div>
				<!-- 1 Col from 2 Row Closed-->
				<div class="col-sm-8 col-lg-4" id="myForm">
					<form name="studentForm">
						<div>
							<h3>Edit Student</h3>
						</div>
						<div class="form-group">
							<label for="fname">First Name:</label> <input type="text"
								class="form-control" disabled value=<%=s.getfName()%>
								id="fname" />
						</div>
						<div class="form-group">
							<label for="lname">Last Name:</label> <input type="text"
								class="form-control" value="<%=s.getlName()%>" id="lname" />
						</div>
						<div class="form-group">
							<label for="grade">Grade:</label> <select name="grade"
								class="form-control" id="grade">Select Grade
								
								<option value="g1" >Grade 1</option>
								<option value="g2">Grade 2</option>
								<option value="g3">Grade 3</option>
								<option value="g4">Grade 4</option>
								<option value="g5">Grade 5</option>
								<option value="g6">Grade 6</option>
							</select>
						</div>
						<div width="100%" align="right">
							<button type="button" class="btn btn-primary"
								onclick="addStudent()">Edit</button>
						</div>
					</form>
				</div>
				<!-- 2 Col from 2 Row Closed-->

				<div class="col-sm-2 col-lg-4"></div>
				<!-- 3 Col from 2 Row Closed-->

			</div>
		</div>
		<%}else {%>
		<div class="row">
			<h1>There is no record to Edit...!</h1>
		</div>
		<% }%>
	</div>
</body>
</html>