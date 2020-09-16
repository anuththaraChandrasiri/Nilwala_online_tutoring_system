<%@page import="Model.Tutorial"%>
<%@page import="Model.AnswerSheet"%>
<%@page import="Model.Anu_Subject"%>
<%@page import="Model.Anu_Teacher"%>
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
<link rel="stylesheet" href="teacher_styles.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<%@ include file="WEB-INF/Teacher_header.jsp" %>

		 <%
		 	ArrayList<Tutorial> tutorialList = (ArrayList<Tutorial>) request.getAttribute("tutorials");
			ArrayList<AnswerSheet> answerSheetList = (ArrayList<AnswerSheet>) request.getAttribute("answerSheets");
			Tutorial tutorial1 = (Tutorial) request.getAttribute("tutorial");
								
	     %>  
		<div>
			<ul class="breadcrumb">
			<li><a href="Teacher_tutorial_home.jsp"><b> "ol" </b></a>
			<a href="Teacher_tutorial_home.jsp"><b> "sinhala"</b></a>
			  	  <a href="Teacher_tutorial_subject.jsp"><b> ""</b></a>
			  	  <a href="Teacher_tutorial_main.jsp"><b>""</b></a>
			 </li>
			</ul>
		</div>
		
		<hr>
			 	<div class="column left" style="background-color: #b8b894;">
			 		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>Tutorials</h2>
			   		</div>
		   			 			   			 	
							<%
					           								
								for(Tutorial tutorial : tutorialList){
							%>
						   			 	
		   			 		 <div class="row">				   				
				   				 
				   				 		<div class="col-sm-6" style="background-color: #ccccb3;">
				   				 		<h2><a href="Teacher_tutorial_pdf.jsp">
				   				 		<b><%=tutorial.getTutorialTitle()%></b></a></h2><br>
				   				 		<!--<a href="C:\Users\ASUS\Desktop\MADD\Tutes\Tutorial 1 - Views.pdf" target="_new">  -->
				     					</div>
				     					<div class="col-sm-6" style="background-color:#ccccb3;">
					   				 		<form class = "form2" method="POST" action="GetTutorialServlet"><h2>
												<input type="hidden" name="tutorialID" value="<%=tutorial.getTutorialId()%>"/>
												<input type="submit" value= "Edit" class="button2" /></h2>
											</form>
				     					</div>				   				 
				     			 
				    		 </div> 
				    		 
					    	<%	
				 					  }
	         				%>  
	         				
	         				   <br><br><br><br>
		   			         		<div class="row">
				   						 <div class="col-sm-6">
						   						<form class = "form2" method="POST" action="BlankTutorialServlet"><h2>	
		   			         				<input type="hidden" name="teacherID" value="<%=tutorial1.getTeacherId()%>"/>	
		   			         				<input type="hidden" name="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>		   			         		
		   			         		 		<button class="button" style = "background: #4d9900;  margin-left:25%;">
		   			         		 		Upload a new tutorial</button>
									</h2>
									</form>
						   						  <br><br>
				     					 </div>
				    		    		 <div class="col-sm-6">
				    		    		 
				    		    		   <button class="button" onclick= "document.location='Teacher_tutorial_viewQuestionsReport.jsp'" style="background-color: #009900;">
						   						View most asked questions</button>
						   						  <br><br>
				    		    		 </div>
		   			         		</div>
				    	 </div>  
					    	    				
			  	<div class="column right" style="background-color: #b8b894; ">
			   		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>Answer sheets</h2>
			  		</div>
			  		
			  		<%
					          								
								for(AnswerSheet answerSheet : answerSheetList){
					%>
			  		
		   			 		 <div class="row">
				   				 <div class="col-sm-6" style="background-color:#ccccb3;">
				   				 <h2><a href="Teacher_tutorial_pdf.jsp">
				   				 <b><%=answerSheet.getSheet_name()%></b></a></h2><br>
				     			 </div>
				    		     <div class="col-sm-6" style="background-color:	 #ccccb3;">
				    		     <form class = "form2" method="POST" action="GetAnswerSheetServlet"><h2>
											 <input type="hidden" name="answerSheetID" value="<%=answerSheet.getSheet_id()%>"/>
											 <input type="hidden" name="teacherID" value="<%=tutorial1.getTeacherId()%>"/>	
		   			         				<input type="hidden" name="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>	
											<button class="button2" role="button" style="background-color: #4d9900;" >Edit</button></h2>
										</form>
				    		     </div>
		   			         </div>
		   			        <%	
				 					  }
	         				%>  
		   			     
		   			         		<br><br><br><br>
		   			         		
		   			        	
		   			         		<div class="row">
		   			         		<form class = "form2" method="POST" action="BlankAnswerSheetServlet"><h2>	
		   			         				<input type="hidden" name="teacherID" value="<%=tutorial1.getTeacherId()%>"/>	
		   			         				<input type="hidden" name="subjectCode" value="<%=tutorial1.getSubjectCode()%>"/>		   			         		
		   			         		 		<button class="button" style = "background: #4d9900;  margin-left:25%;">
		   			         		 		Upload a new answer sheet</button>
									</h2>
									</form>
						   			        <br><br>		   					
				   					</div>
	   			       </div><br>		
			  				
			  					 <div class="row">
				   					 <div class="col-sm-6"><h3></h3><br><br>
				     			 	</div>
				    		    	<div class="col-sm-6"><h2></h2><br>
				    		     	</div>
		   	     				</div>	 
		
</body>
</html>