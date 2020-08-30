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
<title>Upload a new answer sheet</title>
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
</head>
<body>
<%@ include file="WEB-INF/Teacher_header.jsp" %>  

		<div>
			<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
			  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			  	  <a href="#"><b> - Upload a new answer sheet</b></a>
			  </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style="height: 150px;">
	 		 <p style= font-size:50px;>Upload a new answer sheet</p>
		</div>
				
		<div class="jumbotron text-center">
			  <div class="row">
			   		<div class="container-fluid">	
				   		<div class="container">
							  <form action="/action_page.php">
							    <div class="row">
							      <div class="col-25">
							        <label for="fname">Answer sheet name</label>
							      </div>
							      <div class="col-75">
							        <input type="text" id="fname" name="firstname" placeholder="Name of the answer sheet">
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="lname">Answer sheet </label>
							      </div>
							      <div class="col-75">
							        <input type="file"  />
							      </div>
							    </div>
							    <div class="row">
							      <div class="col-25">
							        <label for="subject">Uploading date</label>
							      </div>
							      <div class="col-75">
									   <input type="date" class="date" id="birthday" name="birthday " width="100" height="48">
								  </div>
							    </div>
							    <div class="row">
							    
							      <div class="col-25">
							        
							      </div>
							       <div class="col-25">
							        
							      </div>
							       <div class="col-25"><br><br><br>
							         <button class="button" role="button">Upload</button>
							      </div><br><br><br>
							      <div class="col-25">
							      
							      	 <button class="button" role="button" style="background-color:  #70db70;">Cancel</button>
							      </div>
							      							     							     						
							    </div>
							  </form>
							</div>
				   	</div>				   
	 		</div> 
	</div>
</body>
</html>