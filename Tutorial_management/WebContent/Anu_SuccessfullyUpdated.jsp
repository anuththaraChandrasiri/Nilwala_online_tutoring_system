<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.AnswerSheet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>

<h1>Successfully updated!</h1>

<%
		AnswerSheet answerSheet = (AnswerSheet) request.getAttribute("answerSheet1");
		AnswerSheet answerSheet1 = (AnswerSheet) request.getAttribute("answerSheet");
	%>

<div class="col-50">
							       	  <form class = "form1" method="POST" action="ListTutorialsServlet">
							       	  <input type="hidden" name="teacherId" id="teacherID" value="<%=answerSheet.getTeacher_id()%>"/>
							       	  <input type="hidden" name="subjectCode" id="subjectCode" value="<%=answerSheet.getSubject_code()%>"/>
							       	  <input type="hidden" name="teacherName" id="teacherName" value="<%=answerSheet.getTeacher_name()%>"/>
							     <button class="button" style="background-color:  #70db70;">
							       OK</button>
							       </form>
							     	 </div>  		


</body>
</html>