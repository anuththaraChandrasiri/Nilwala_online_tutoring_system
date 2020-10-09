<%@page import="Model.Tutorial"%>
<%@page import="Model.AnswerSheet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.TutorialServiceImpl"%>
<%@page import="Service.ITutorialService"%>
<%@page import="Service.AnswerSheetServiceImpl"%>
<%@page import="Service.IAnswerSheetService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="student_styles.css">
<meta charset="ISO-8859-1">
<title>Student main</title><meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
* {
  box-sizing: border-box;
}

/* Create two unequal columns that floats next to each other */
.column {
  float: left;
  padding: 20px;
  height: 100%;
}

.left {
  width: 55%;
  margin-left: 2.5%;
}

.right {
  width: 40%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<title>Teacher main</title>
</head>
<body>

<%@ include file="WEB-INF/Student_header.jsp" %> 

	     <%
		 	ArrayList<Tutorial> tutorialList = (ArrayList<Tutorial>) request.getAttribute("tutorials");
			ArrayList<AnswerSheet> answerSheetList = (ArrayList<AnswerSheet>) request.getAttribute("answerSheets");
			Tutorial tutorial1 = (Tutorial) request.getAttribute("tutorial");
								
	     %>  
		<div>
			<ul class="breadcrumb">
					<li><a href="Student_tutorial_home.jsp"><b><%=tutorial1.getLevel()%></b></a>
					<li><a href="Student_tutorial_home.jsp"><b><%=tutorial1.getMedium()%></b></a>
					<li><a href="Student_tutorial_subject.jsp"><b><%=tutorial1.getSubjectName()%></b></a>	
					<li><a href="Student_tutorial_subject.jsp"><b><%=tutorial1.getTeacherName()%></b></a>			
					</li>
			</ul>
		</div>
		
		<hr>
	
	<div class="column left" style="background-color: #b3d1ff;">
			 		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>Tutorials</h2>
			   		</div>
		   			 	
		   			 		   			 	
							<%
							
								for(Tutorial tutorial : tutorialList){
									
							%>
						    <div class="row">
				   				
				   				 		<div class="col-sm-6" style="background-color:#cce0ff;">
				   				 		<h2><a href=".\documents\Tutorial 1 - Views.pdf" target="_new">
				   				 		<b><%=tutorial.getTutorialTitle()%></b></a></h2><br>
				     					</div>
				     					<div class="col-sm-6" style="background-color:#cce0ff;">
				     						<form class = "form2" method="POST" action="GetTutorialServlet"><h2>
												<input type="hidden" name="tutorialID" value="<%=tutorial.getTutorialId()%>"/>
												<input type="submit" value= "Download" class="button2" /></h2>
											</form>				  
				     					</div>					     			 
				    		 </div> 
				    		  
					    	<%	
				 					  }
	         				%>  
	         				
	         				   <br><br><br><br>
				    		   <div class="row">
				   						 <div class="col-sm-6">
						   											   						
				     					 </div>
				    		    		 <div class="col-sm-6">
				    		    		 
				    		    		   <button class="button" onclick= "document.location='Student_tutorial_forum.jsp'" style="background-color: #1a75ff;">
						   						Questions?</button>
						   						  <br><br><br><br>
				    		    		 </div>
		   			         	</div>
				    	 </div>  
					    		    			    		    				
			  			<div class="column right" style="background-color:#b3d1ff; ">
			   				<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 		<h2>Answer sheets</h2>
			  			</div>
			  		
			  		<%
					        
								for(AnswerSheet answerSheet : answerSheetList){
					%>
			  		
		   			 		 <div class="row">
				   				 	<div class="col-sm-6" style="background-color: #cce0ff;">
				   				 		<h2><a href="Student_tutorial_pdf.jsp">
				   							 <b><%=answerSheet.getSheet_name()%></b></a></h2><br>
				     			    </div>
				    		     	<div class="col-sm-6" style="background-color:	#cce0ff;">
				    		     			<form class = "form2" method="POST" action="GetTutorialServlet"><h2>
												<input type="hidden" name="tutorialID" value="<%=tutorial1.getTutorialId()%>"/>
												<input type="submit" value= "Download" class="button2" /></h2>
											</form>	
				     				</div>	
				    		   </div>
		   			        
		   			        <%	
				 					  }
	         				%>  
		   			      </div>
		   			      	
			  					 <div class="row">
				   					 <div class="col-sm-6"><h3></h3><br><br>
				     			 	</div>
				    		    	<div class="col-sm-6"><h2></h2><br>
				    		     	</div>
		   	     				</div>	 
		
</body>
</html>