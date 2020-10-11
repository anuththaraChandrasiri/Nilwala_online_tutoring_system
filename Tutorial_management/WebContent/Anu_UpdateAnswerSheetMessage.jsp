<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
<%@page import="Model.AnswerSheet"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Anu_Teacher_styles.css">
<meta charset="ISO-8859-1">
<title>Update answer sheet message</title>
</head>
<body>

		<%
			Tutorial tutorial = (Tutorial) request.getAttribute("tutorial");
			AnswerSheet answerSheet = (AnswerSheet) request.getAttribute("answerSheet");
		
		%>		
		
			<div class="jumbotron text-center">
		 		 <h1>Successfully updated the selected answer sheet's details!</h1>
			</div>
			<div class="col-50">
				<form class = "form1" method="POST" action="ListTutorialsServlet">
						  <input type="hidden" name="teacherId" id="teacherID" value="<%=answerSheet.getTeacher_id()%>"/>
						  <input type="hidden" name="subjectCode" id="subjectCode" value="<%=answerSheet.getSubject_code()%>"/>
						  <input type="hidden" name="subjectName" value="<%=tutorial.getSubjectName()%>"/>
				    	  <input type="hidden" name="level" value="<%=tutorial.getLevel()%>"/>
				    	  <input type="hidden" name="medium" value="<%=tutorial.getMedium()%>"/>
						  <input type="hidden" name="teacherName" id="teacherName" value="<%=answerSheet.getTeacher_name()%>"/>
						  <input type="hidden" name="teacher" value="true"/>
							     <button class="button" style="background-color:  #70db70;">OK</button>
				</form>
			</div>  

</body>
</html>