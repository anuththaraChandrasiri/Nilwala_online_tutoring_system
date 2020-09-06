<%@page import="Model.Tutorial"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.TutorialServiceImpl"%>
<%@page import="Service.ITutorialService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="teacher_styles.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
  width: 65%;
  margin-left: 2.5%;
}

.right {
  width: 30%;
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

		<div>
			<ul class="breadcrumb">
			  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			 </li>
			</ul>
		</div>
		<hr>
			 	<div class="column left" style="background-color:green;">
			 		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>January</h2>
			   		</div>
		   			 			   			 	
							<%
					            ITutorialService iTutorialService = new TutorialServiceImpl();
								ArrayList<Tutorial> arrayList = iTutorialService.getTutorials();
								
								for(Tutorial tutorial : arrayList){
							%>
						   			 	
		   			 		 <div class="row">
				   				
				   				 
				   				 		<div class="col-sm-6" style="background-color:#99ff99;">
				   				 		<h2><a href="#"><b><%=tutorial.getTutorialTitle()%></b></a></h2><br>
				     					</div>
				     					<div class="col-sm-6" style="background-color:#99ff99;">
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
						   						 <button class="button" onclick= "document.location='Teacher_tutorial_uploadTutorial.jsp'">Upload a new tutorial</button>
						   						  <br><br>
				     					 </div>
				    		    		 <div class="col-sm-6">
				    		    		 <button class="button" role="button" style="background-color:  #70db70;">View most asked questions</button>
				    		    		 <br><br>
				    		    		 </div>
		   			         		</div>
				    	 </div>  
					    
				    		    
				    		    				
			  	<div class="column right" style="background-color: #4d9900; ">
			   		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>Answer sheets</h2>
			  		</div>
			  		<div class="inside">
		   			 		 <div class="row">
				   				 <div class="col-sm-6" style="background-color:	 #99ff33;"><h3><a href="#"><b>Tute 01 answers</b></a></h3><br>
				     			 </div>
				    		     <div class="col-sm-6" style="background-color:	 #99ff33;"><h2><button class="button3" role="button">Edit</button></h2>
				    		     </div>
		   			         </div>
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	 #99ff33;"><h3><a href="#"><b>Tute 02 answers</b></a></h3><br>
				     			 </div>
				    		    <div class="col-sm-6" style="background-color:	 #99ff33;"><h2><button class="button3" role="button">Edit</button></h2>
				    		     </div>
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	 #99ff33;"><h3><a href="#"><b>Tute 03 answers</b></a></h3><br><br>
				     			 </div>
				    		    <div class="col-sm-6" style="background-color:	 #99ff33;"><h2><button class="button3" role="button">Edit</button></h2><br>
				    		     </div>
		   			         </div>	  
		   			        	
				   			
		   			         		<br><br><br><br>
		   			         		<div class="row">				   					
				   						  <button class="button" role="button" style = "background:#264d00;  margin-left:25%;">
				   						  Upload a new answer sheet</button>
				   						
		   			         		</div>
	   			       </div><br>		
			  	</div>
			  	 <div class="row">
				   				 <div class="col-sm-6"><h3></h3><br><br>
				     			 </div>
				    		    <div class="col-sm-6"><h2></h2><br>
				    		     </div>
		   	     </div>	 
		
</body>
</html>