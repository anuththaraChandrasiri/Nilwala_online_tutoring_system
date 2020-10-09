<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.AnswerSheet"%>
<%@page import="Model.Tutorial"%>
<%@page import="Service.TutorialServiceImpl"%>
<%@page import="Service.ITutorialService"%>
<%@page import="java.util.ArrayList"%>
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
<title>Update answer sheet</title>
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
		AnswerSheet answerSheet = (AnswerSheet) request.getAttribute("answerSheet1");
		AnswerSheet answerSheet1 = (AnswerSheet) request.getAttribute("answerSheet");
		Tutorial tutorial1 = (Tutorial) request.getAttribute("tutorial");
		ArrayList<Tutorial> tutorialList = (ArrayList<Tutorial>) request.getAttribute("tutorials");
	%>

		<div>
			<ul class="breadcrumb">
			    <li><a href="Teacher_tutorial_home.jsp"><b><%=tutorial1.getLevel()%></b></a>
				<li><a href="Teacher_tutorial_home.jsp"><b><%=tutorial1.getMedium()%></b></a>
				<li><a href="Teacher_tutorial_subject.jsp"><b><%=tutorial1.getSubjectName()%></b></a>	
				<li><a href="Teacher_tutorial_subject.jsp"><b><%=tutorial1.getTeacherName()%></b></a>	
			  </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style="height: 150px;">
	 		 <p style= font-size:50px;><%=answerSheet.getSheet_name()%></p>
		</div>
				
		<div class="jumbotron text-center">
			  <div class="row">
			   		<div class="container-fluid">	
				   		<div class="container">
							  <form  method="POST" action="UpdateAnswerSheetServlet">
							    <div class="row">
							      <div class="col-25">
							        <label for="answerSheet">Answer sheet name</label>
							      </div>
							      <div class="col-75">
							        <input type="text" id="sheetName" name="sheetName"  value="<%=answerSheet.getSheet_name()%>">
							      </div>
							    </div>
							    
							    
							      <div class="row">
							      <div class="col-25">
							        <label for="SheetId" style="display: none;">Sheet ID</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="sheetId" name="sheetID" value="<%=answerSheet.getSheet_id()%>" style="display: none;">
								      </div>
							    </div>
							    
							      <div class="row">
							      <div class="col-25">
							        <label for="TeacherId" style="display: none;" >Teacher ID</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="tId" name="teacherID" value="<%=answerSheet.getTeacher_id()%>" style="display: none;" >
								      </div>
							    </div>
							     <div class="row">
							      <div class="col-25">
							        <label for="TutorialId">Tutorial name</label>
							      </div>
							     								      
								       <div class="col-75">								         
								        		<select id="tuteId" name="tuteID" required>
								        		
								        			 <option value="<%=answerSheet.getTute_id()%>" style=" color: brown;"><%=answerSheet.getTute_id()%></option>
								        			<%
					           								
															for(Tutorial tutorial : tutorialList){
													%>
								        		
								        		
								        			 <option value="<%=tutorial.getTutorialId()%>"><%=tutorial.getTutorialTitle()%></option>
								       			
								       				<%	
				 					  						}
	         										%>         				
								       			
								       			</select>								       			
							           </div>								      
								      
							    </div>
							    
							     <div class="row">
							      <div class="col-25">
							        <label for="SubjectCode" style="display: none;" >Subject code</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="sCode" name="subjectCode" value="<%=answerSheet.getSubject_code()%>" readonly="readonly" style="display: none;" >
								      </div>
							    </div>
							    
							    <div class="row">
							      <div class="col-25">
							        <label for="answerSheetLabel">Answer sheet</label>
							      </div>
							      <div class="col-75">
							      	 <input type="text" id = "myFile1" name="filename1" value="<%=answerSheet.getMaterial()%>" readonly="readonly"/>
							        <input type="file" id = "myFile" name="filename" value="<%=answerSheet.getMaterial()%>"/>
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="fname">Uploaded date</label>
							      </div>
							      <div class="col-75">
							        <input type="text" id="uploadedDate" name="uploadedDate" value="<%=answerSheet.getDate_added()%>" readonly="readonly">
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
							    	</div>
							    
							    <div class="row">							    
								      <div class="col-50">							        
								      	<form class = "form1" method="POST" action="DeleteAnswerSheetServlet">
												<input type="hidden" name="sheetID" id="sheetID" value="<%=answerSheet.getSheet_id()%>"/> 
												<input type="hidden" name="teacherID" value="<%=answerSheet.getTeacher_id()%>"/>
												<input type="hidden" name="subjectCode" value="<%=answerSheet.getSubject_code()%>"/> 
												<button class="button" role="button">Delete</button>
										</form>
								      </div><br>
							      
							       	  <div class="col-50">
							       	  <form class = "form1" method="POST" action="ListTutorialsServlet">
							       	  <input type="hidden" name="teacherId" id="teacherID" value="<%=answerSheet.getTeacher_id()%>"/>
							       	  <input type="hidden" name="subjectCode" id="subjectCode" value="<%=answerSheet.getSubject_code()%>"/>
							       	  <input type="hidden" name="teacherName" id="teacherName" value="<%=answerSheet.getTeacher_name()%>"/>
							     <button class="button" style="background-color:  #70db70;">
							       Cancel</button>
							       </form>
							     	 </div>  			
							       							     						
							    </div>			
				   	</div>				   
	 		</div>
	 		</div>

</body>
</html>