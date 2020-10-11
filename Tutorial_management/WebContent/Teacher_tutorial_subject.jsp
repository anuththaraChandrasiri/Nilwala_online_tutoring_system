<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Anu_Teacher"%>
<%@page import="Model.Anu_Subject"%>
<%@page import="Service.Anu_TeacherServiceImpl"%>
<%@page import="Service.Anu_ITeacherService"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Anu_Teacher_styles.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Tutorial subject</title>
</head>
<body>

	<%
	
		ArrayList<Anu_Teacher> teacherList = (ArrayList<Anu_Teacher>) request.getAttribute("teachers");
		ArrayList<Anu_Subject> subjectList = (ArrayList<Anu_Subject>) request.getAttribute("subjects");

	%>


<%@ include file="WEB-INF/Teacher_header.jsp" %>  

	  <%
					            Anu_Teacher teacher = (Anu_Teacher) request.getAttribute("teacher");
								
	     %>  

		<div>
			<ul class="breadcrumb">
				<li><a href="Teacher_tutorial_home.jsp"><b><%=teacher.getLevel()%> - </b></a>
					<a href="Teacher_tutorial_home.jsp"><b><%=teacher.getMedium()%> medium</b></a>
				</li>
			</ul>
		</div>
	<hr>
	
	
	<div class="jumbotron text-center">
  <h1><%=teacher.getSubjectName()%></h1>
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-12" style = "text-align: center;">
    
      <%								
						for(Anu_Teacher anu_Teacher : teacherList){
	  %>
    
	    	<form class = "form2" method="POST" action="ListTutorialsServlet"><h2>
					 <input type="hidden" name="teacherId" value="<%=anu_Teacher.getTeacherID()%>"/>
					 <input type="hidden" name="subjectCode" value="<%=anu_Teacher.getSubjectCode()%>"/>
					 <input type="hidden" name="subjectName" value="<%=teacher.getSubjectName()%>"/>
					 <input type="hidden" name="level" value="<%=teacher.getLevel()%>"/>
					 <input type="hidden" name="medium" value="<%=teacher.getMedium()%>"/>
					 <input type="hidden" name="teacherName"  value="<%=anu_Teacher.getTeacherName()%>"/>
					 <input type="hidden" name="teacher" value="true"/>
	     				 <button class="button1" role="button"><%=anu_Teacher.getTeacherName()%></button><br><br>
	         		 </h2>
			</form>		 	   
	  <%	
	 					 }
	  %> 
    </div>
   </div>
</div>

</body>
</html>