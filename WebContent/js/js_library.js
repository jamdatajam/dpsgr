/**
 * Index Page- Form Script
 */

function getDataLoaded(actionName) {
	//alert(actionName);
	if (actionName == 'addStudent') {
		document.getElementById("myForm").style = "display:inline;";
		document.getElementById('recordsStudent').style = "display:none";
		/**
		 * disabling other ADD Forms
		 */
		document.getElementById("teacherAddForm").style = "display:none;";
	} else if (actionName = "addTeacher") {
		document.getElementById("teacherAddForm").style = "display:inline;";
		/**
		 * disabling other ADD forms
		 */
		document.getElementById("myForm").style = "display:none;";
	}
}// End of getDataLoaded()

function addStudent() {
	let fname = document.getElementById("fname").value;
	let lname = document.getElementById("lname").value;
	let grade = document.getElementById("grade").value;
	var urlData = "addStudent?fname=" + fname + "&lname=" + lname + "&grade="
			+ grade;

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			//document.getElementById(listName).innerHTML = this.responseText;
			alert("Student Data Added Successfuly! \n\t"+ this.responseText+" Roll Number Created!");
		}
	};
	xhttp.open("POST", urlData, true);
	xhttp.send();

}

/**
 * This is Listing page Script
 * 
 */
//showListData('listStudent', 'recordsStudent')
function showListData(actionName, listName) {

	/** Calling the backend to provide data with List Action */
//	alert("In showListData()");
	 var xhttp = new XMLHttpRequest(); 
	 xhttp.onreadystatechange = function() {
		 
	  if (this.readyState == 4 && this.status == 200) {
	  document.getElementById(listName).innerHTML = this.responseText;
	  /** Rendering the UI with Data* */

		if (actionName == "listStudent") {
			document.getElementById('recordsStudent').style = "display:inline";
			document.getElementById("myForm").style = "display:none;";
			document.getElementById('recordsTeacher').style = "display:none";
			document.getElementById('recordsSubject').style = "display:none";
			document.getElementById('recordsGrade').style = "display:none";
		} else if (actionName == "listTeacher") {
			document.getElementById('recordsStudent').style = "display:none";
			document.getElementById('recordsTeacher').style = "display:inline";
			document.getElementById('recordsSubject').style = "display:none";
			document.getElementById('recordsGrade').style = "display:none";
		} else if (actionName == "listGrade") {
			document.getElementById('recordsStudent').style = "display:none";
			document.getElementById('recordsTeacher').style = "display:none";
			document.getElementById('recordsSubject').style = "display:none";
			document.getElementById('recordsGrade').style = "display:inline";
		} else if (actionName == "listSubject") {
			document.getElementById('recordsStudent').style = "display:none";
			document.getElementById('recordsTeacher').style = "display:none";
			document.getElementById('recordsSubject').style = "display:inline";
			document.getElementById('recordsGrade').style = "display:none";
		}
	  } 
	  };
	  xhttp.open("POST", actionName, true); 
	  xhttp.send();
}
