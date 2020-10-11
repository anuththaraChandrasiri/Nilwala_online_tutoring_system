<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forum already submitted</title>
</head>
<body>

	<%
		Tutorial tutorial = (Tutorial) request.getAttribute("tutorial");
	
	%>
	
	<h1>Sorry! You have already submitted your response.</h1>
		<div class="col-50">
				<form class = "form1" method="POST" action="ListTutorialsServlet">
				    	  <input type="hidden" name="teacherId" id="teacherID" value="<%=tutorial.getTeacherId()%>"/>
				       	  <input type="hidden" name="subjectCode" id="subjectCode" value="<%=tutorial.getSubjectCode()%>"/>
				       	  <input type="hidden" name="teacherName" id="teacherName" value="<%=tutorial.getTeacherName()%>"/>
				       	  <input type="hidden" name="subjectName" value="<%=tutorial.getSubjectName()%>"/>
						  <input type="hidden" name="level" value="<%=tutorial.getLevel()%>"/>
						  <input type="hidden" name="medium" value="<%=tutorial.getMedium()%>"/>
				       	  <input type="hidden" name="teacher" value="false"/>
							     <button class="button" style="background-color:#42A5F6;">OK</button>
			    </form>
		</div>  
	
</body>
</html>