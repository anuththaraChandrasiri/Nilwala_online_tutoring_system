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
<title>Upload a new tutorial</title>
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

		<div>
			<ul class="breadcrumb">
			  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			  	  <a href="#"><b> - Upload a new tutorial</b></a>
			  </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style="height: 100px; padding: 10px 20px 10px 20px;">
	 		 <p style= font-size:50px;>Upload a new tutorial</p>
		</div>
				
		<div class="jumbotron text-center">
			  <div class="row">
			   		<div class="container-fluid">	
				   		<div class="container">
							  <form method="POST" action="AddTutorialServlet">	  
							  
							    <div class="row">
							      <div class="col-25">
							        <label for="fname">Tutorial name</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="tname" name="tutorialName" placeholder="Name of the tutorial" required>
								      </div>
							    </div>
							    
							    <div class="row">
							      <div class="col-25">
							        <label for="fname" style="display: none;" >Teacher ID</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="tid" name="teacherID" placeholder="1201" readonly="readonly" style="display: none;">
								      </div>
							    </div>
							    
							    <div class="row">
							      <div class="col-25">
							        <label for="fname" style="display: none;" >Subject code</label>
							      </div>
								      <div class="col-75">
								        <input type="text" id="sCode" name="subjectCode" placeholder="21" readonly="readonly" style="display: none;">
								      </div>
							    </div>						    
							    
							    <div class="row">
							      <div class="col-25">
							        <label for="lname">Tutorial</label>
							      </div>
								      <div class="col-75">
								        <input type="file" id="myFile" name="filename" required>
								        <label for="fileupload" style = "font-size:12px;"> Select a file to upload</label>
								      </div><br>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="month">Month</label>
							      </div>
							      <div class="col-75">
							        <select id="month" name="month" required>
							          <option value="January">January</option>
							          <option value="February">February</option>
							          <option value="March">March</option>
							          <option value="April">April</option>
							          <option value="May">May</option>
							          <option value="June">June</option>
							          <option value="July">July</option>
							          <option value="August">August</option>
							          <option value="September">September</option>
							          <option value="October">October</option>
							          <option value="November">November</option>
							          <option value="December">December</option>
							        </select>
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="subject">Uploading date</label>
							      </div>
							      <div class="col-75">
									   <input type="date" class="date" id="uDate" name="uploadingDate" width="100" height="60">
								  </div>
							    </div>
							    <div class="row">							    
							      
							       <div class="col-50">
							         <button class="button" role="button"><b>Upload</b></button><br>
							      </div><br>
							      <div class="col-50">
							      	<button class="button" type="reset" role="button"><b>Reset</b></button>
							      	
							      </div>
							     				     		     							     						
							    </div><br>
							  </form>
							  
							   <div class="row">
							    
							      <div class="col-50">
							       <button class="button"  onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:  #70db70;">
							      	 <b> Cancel</b></button>	
							      </div><br>
							       <div class="col-50">
							        
							      </div>
							     				     		     							     						
							    </div><br>
							    	
							</div> 
							  
				   	</div>				   
	 		</div> 
	</div>

</body>
</html>