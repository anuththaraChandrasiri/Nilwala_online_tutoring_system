<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Anu_Teacher_styles.css">
<meta charset="ISO-8859-1">
<title>Update tutorial message</title>
</head>
<body>

		<%
			Tutorial tutorial = (Tutorial) request.getAttribute("tutorial");
		
		%>		
	
			<div class="jumbotron text-center">
		 		 <h1>Successfully updated the selected tutorial's details!</h1>
			</div>
			<div class="col-50">
				<form class = "form1" method="POST" action="ListTutorialsServlet">
						<input type="hidden" name="teacherId" id="teacherId" value="<%=tutorial.getTeacherId()%>"/>
						<input type="hidden" name="subjectCode" id="subjectCode" value="<%=tutorial.getSubjectCode()%>"/>
						<input type="hidden" name="teacherName" id="teacherName" value="<%=tutorial.getTeacherName()%>"/>
						<input type="hidden" name="subjectName" value="<%=tutorial.getSubjectName()%>"/>
					    <input type="hidden" name="level" value="<%=tutorial.getLevel()%>"/>
					    <input type="hidden" name="medium" value="<%=tutorial.getMedium()%>"/>
						<input type="hidden" name="teacher" value="true"/>
								     <button class="button" style="background-color:  #70db70;">OK</button>
				</form>
	    	 </div>  
							     	 
</body>
</html>