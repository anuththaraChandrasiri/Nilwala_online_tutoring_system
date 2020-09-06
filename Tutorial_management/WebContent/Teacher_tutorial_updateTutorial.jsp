<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Tutorial"%>
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
<title>Update tutorial</title>
<style>
* {
  box-sizing: border-box;
}

input[type=text], select{
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
  float: left;
  margin-left:100px;
  font-size: 18px;
  
}

.container {
  border-radius: 5px;
  background-color: #d6f5d6;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>   
<script type="text/javascript">   
$(document).ready(function() {   
$('#types').change(function(){   
if($('#types').val() === 'Other')   
   {   
   $('#other').show();    
   }   
else 
   {   
   $('#other').hide();      
   }   
});   
});   
</script> 
</head>
<body>
<%@ include file="WEB-INF/Teacher_header.jsp" %>  

	<%
		Tutorial tutorial = (Tutorial) request.getAttribute("tutorial");
	%>
		<div>
			<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
			  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			  	  <a href="#"><b> - Update a tutorial</b></a>
			  </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style="height: 90px; padding: 10px 20px 10px 20px;">
	 		 <p style= font-size:40px;><%=tutorial.getTutorialTitle()%></p>
		</div>
				
		<div class="jumbotron text-center">
			  <div class="row">
			   		<div class="container-fluid">	
				   		<div class="container">
							  <form  method="POST" action="UpdateTutorialServlet">
							    <div class="row">
							      <div class="col-25">
							         <label for="TutorialName">Tutorial name</label>
							      </div>
							      
							      <div class="col-75">
							        <input type="text" id="tname" name="tutorialName" value="<%=tutorial.getTutorialTitle()%>" required>
							      </div>
							    </div>
							    
							      <div class="row">
							      <div class="col-25">
							        <label for="TutorialId" style="display: none;">Tutorial ID</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="tuteId" name="tutorialID" value="<%=tutorial.getTutorialId()%>" readonly="readonly" style="display: none;">
								      </div>
							    </div>
							    
							      <div class="row">
							      <div class="col-25">
							        <label for="TeacherId" style="display: none;" >Teacher ID</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="tId" name="teacherID" value="1201" readonly="readonly" style="display: none;" >
								      </div>
							    </div>
							    
							     <div class="row">
							      <div class="col-25">
							        <label for="SubjectCode" style="display: none;" >Subject code</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="sCode" name="subjectCode" value="21" readonly="readonly" style="display: none;" >
								      </div>
							    </div>
							    
							    
							    <div class="row">
							      <div class="col-25">
							        <label for="Tutorial">Tutorial</label>
							      </div>
							      <div class="col-75">
							        <input type="file" id = "myFile" name="filename" value="<%=tutorial.getMaterial()%>"/>
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="Month">Month</label>
							      </div>
							      <div class="col-75">
							        <input type="text" id="month" name="month"  value="<%=tutorial.getMonth()%>" required>
							      </div>
							    </div>
							     <div class="row">
							      <div class="col-25">
							        <label for="Uploaded date">Uploaded date</label>
							      </div>
							      <div class="col-75">
							        <input type="text" id="uploadedDate" name="uploadedDate"  value="<%=tutorial.getDateAdded()%>">
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="updatingDate">Updating date</label>
							      </div>
							      <div class="col-75">
							      		<input type="date" class="date" id="uDate" name="uploadingDate" width="100" height="48">
								  </div>
							    </div>
							    <div class="row">
							    
							      <div class="col-50">
							        
							      </div>
							      
							       <div class="col-50"> 
							          <button class="button" role="button">Update</button>
							      </div>
							       							     						
							    </div>
							  </form><br>
							  
							    <div class="row">							    
								      <div class="col-50">							        
								      	<form class = "form1" method="POST" action="DeleteTutorialServlet">
												<input type="hidden" name="tutorialID" value="<%=tutorial.getTutorialId()%>"/> 
												<button class="button" role="button">Delete</button>
										</form>
								      </div><br>
							      
							       	  <div class="col-50">
							     <button class="button"  onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:  #70db70;">
							       Cancel</button>
							     	 </div>  			
							       							     						
							    </div>							  			  
						</div>
				   	</div>				   
	 		</div> 
	</div>

</body>
</html>