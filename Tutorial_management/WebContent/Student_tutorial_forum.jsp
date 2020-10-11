<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="student_styles.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Tutorial forum</title>
<style> 
        input.largerCheckbox { 
            width: 25px; 
            height: 25px; 
        } 
    </style>
</head>
<body>
<%@ include file="WEB-INF/Student_header.jsp" %> 

		
	     <%
	     
			Tutorial tutorial1 = (Tutorial) request.getAttribute("tutorial");
								
	     %>  
		<div>
			<ul class="breadcrumb">
					<li><a href="Student_tutorial_home.jsp"><b><%=tutorial1.getLevel()%> - </b></a>
						<a href="Student_tutorial_home.jsp"><b><%=tutorial1.getMedium()%> medium - </b></a>
					 	<b><%=tutorial1.getSubjectName()%> - </b>
					 	<b><%=tutorial1.getTeacherName()%></b>			
					</li>
			</ul>
		</div>
		<hr>
		       	
		<div class="jumbotron text-center">
	 		 <h1>Questions - <%=tutorial1.getTutorialTitle()%> </h1>
		</div>
		
		<div class="jumbotron text-center">
			  <div class="row">
			  	 <form method="POST" action="StudentSubmitForumServlet">
			   		 <div class="col-sm-6" style="background-color:#ccd9ff;">
				   		 <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 1</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="questions" value="1">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 2</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="questions" value="2">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 3</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="questions" value="3">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 4</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="questions" value="4">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 5</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="questions" value="5">     
			   			 </div>
			   		</div>
			     	<div class="col-sm-6" style="background-color:#ccd9ff;">
				   		 <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 6</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="questions" value="6">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 7</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="questions" value="7">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 8</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="questions" value="8">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 9</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="questions" value="9">       
		   				 </div>
		   				 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 10</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="questions" value="10">       
		   				 </div>		  			     				 
			     	</div>	
			     		  <div class="col-sm-6" style="background-color:  #f2f2f2;"><br><br>  		         
		 	  			  </div>
		 	  			  <div class="col-sm-6" style="background-color:  #f2f2f2;"><br><br>  		         
		 	  			  </div>
		 	 			 
		 	 			 <div class="row">							    
							        <div class="col-50">
							        			<input type="hidden" name="tutorialID" value="<%=tutorial1.getTutorialId()%>"/>
												<input type="hidden" name="studentID" value="<%=tutorial1.getStudentId()%>"/>
												<input type="hidden" name="tutorialName" value="<%=tutorial1.getTutorialTitle()%>"/>
									            <input type="hidden" name="subjectName" value="<%=tutorial1.getSubjectName()%>"/>
									            <input type="hidden" name="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>
												<input type="hidden" name="level" value="<%=tutorial1.getLevel()%>"/>
												<input type="hidden" name="medium" value="<%=tutorial1.getMedium()%>"/>
												<input type="hidden" name="teacherId" value="<%=tutorial1.getTeacherId()%>"/>
												<input type="hidden" name="teacherName"  value="<%=tutorial1.getTeacherName()%>"/>	
							     		           <button class="button" role="button"><b>Submit</b></button><br>
							      	</div>
						</div><br>
			     		    	
			     </form>
			     		 <div class="row">
							       <div class="col-50">
							  		      <form class = "form1" method="POST" action="ListTutorialsServlet">
							       	  			 <input type="hidden" name="subjectName" value="<%=tutorial1.getSubjectName()%>"/>
												 <input type="hidden" name="level" value="<%=tutorial1.getLevel()%>"/>
												 <input type="hidden" name="medium" value="<%=tutorial1.getMedium()%>"/>
												 <input type="hidden" name="teacherId" value="<%=tutorial1.getTeacherId()%>"/>
												  <input type="hidden" name="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>
												 <input type="hidden" name="teacherName"  value="<%=tutorial1.getTeacherName()%>"/>	
												 <input type="hidden" name="teacher" value="false"/>						       	  			
							     					<button class="button"><b>Cancel</b></button>
							       		  </form>	
							      	</div><br>
							        <div class="col-50">
									</div>
					    </div><br>
	 		</div> 
	</div>
</body>
</html>