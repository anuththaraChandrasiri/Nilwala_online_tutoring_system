<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.TutorialServiceImpl"%>
<%@page import="Service.ITutorialService"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="teacher_styles.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="ISO-8859-1">
<title>View questions report</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 48%;
  padding: 10px;
  height: 100%; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
  }
}
</style>
</head>
<body>
<%@ include file="WEB-INF/Teacher_header.jsp" %>  

		 <%
		 	ArrayList<Tutorial> tutorialList = (ArrayList<Tutorial>) request.getAttribute("tutorials");
			Tutorial tutorial1 = (Tutorial) request.getAttribute("tutorial");
								
	     %>  
		<div>
			<ul class="breadcrumb">
				<li><a href="Teacher_tutorial_home.jsp"><b><%=tutorial1.getLevel()%> - </b></a>
					<a href="Teacher_tutorial_home.jsp"><b><%=tutorial1.getMedium()%> medium - </b></a>
					<b><%=tutorial1.getSubjectName()%> - </b>	
					<b><%=tutorial1.getTeacherName()%></b>			
				</li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style=" height: 30px; text-align:center; padding: 10px 20px 70px 20px;">
	  		<h2>View most asked questions - <%=tutorial1.getTutorialTitle()%></h2>
		</div>
		
	  		<h3 style="margin-left:20px; color: #009900;"><b>Total number of students who submitted their responses - <%=tutorial1.getStudentCount()%></b></h3><br>
		
		<div class="row">
  			<div class="column" style="background-color:  #ccffcc; margin-left:35px; text-align:center; ">
   				 <h1>Question number</h1>
   				 
   				 <div class="row"><br><br>
   				 
   				 			<%
					           								
								for(Tutorial tutorial : tutorialList){
							%>
   				 
   				 
			   		 <div class="col-sm-11" style="background-color: white;  text-align:center; margin-left:40px;"><h3>Question <%=tutorial.getQuestionNo()%></h3>
			     		
			    	</div>
			    	
			    			<%	
				 					  }
	         				%> 
			    	
			    	 <div class="col-sm-11" style="background-color:white;  text-align:center; margin-left:40px;"><br><br>
			     		
			    	</div>
			    	 <div class="col-sm-11" style="background-color:  #ccffcc;  text-align:center; margin-left:40px;"><br><br>
			     		
			    	</div>
		     </div>	 
   				 
           </div>
  		   <div class="column" style="background-color:  #ccffcc; text-align:center;">
    			<h1>Number of students</h1><br><br>
    			
		    				<%
							           								
								for(Tutorial tutorial : tutorialList){
							%>
    			
	    			 <div class="col-sm-11" style="background-color:white;  text-align:center; margin-left:30px;"><h3><%=tutorial.getCount()%></h3>
			     		
			    	</div>
			    	
			    	
					    	<%	
						 					  }
			         		%> 
	    			
	    			 <div class="col-sm-11" style="background-color:white;  text-align:center; margin-left:30px;"><br><br>
			     		
			    	</div>
			    	 <div class="col-sm-11" style="background-color:#ccffcc;  text-align:center; margin-left:30px;"><br><br>
			     		
			    	</div>
	    			
           </div>
		</div>
		<br>
		<div class="row">
				 <div class="col-sm-1"><br>
				 </div>
				 <div class="col-sm-1"><br>
				 </div>
				 <div class="col-sm-1"><br>
				 </div>
				 <div class="col-sm-2">
				 	    <button class="button" onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:#00b33c;">Download</button>
				 </div>
				 <div class="col-sm-2">
				 	   
				 </div>
				 <div class="col-sm-2">
				       <form class = "form1" method="POST" action="ListTutorialsServlet">
							       	  			 <input type="hidden" name="subjectName" value="<%=tutorial1.getSubjectName()%>"/>
												 <input type="hidden" name="level" value="<%=tutorial1.getLevel()%>"/>
												 <input type="hidden" name="medium" value="<%=tutorial1.getMedium()%>"/>
												 <input type="hidden" name="teacherId" value="<%=tutorial1.getTeacherId()%>"/>
												 <input type="hidden" name="subjectCode" id="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>
												 <input type="hidden" name="teacherName"  value="<%=tutorial1.getTeacherName()%>"/>	
												 <input type="hidden" name="teacher" value="true"/>						       	  			
							     					<button class="button"><b>Cancel</b></button>
					  </form>	
				 </div>
		 </div><br><br>  
</body>
</html>