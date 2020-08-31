<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  width: 50%;
  padding: 10px;
  height: 500px; /* Should be removed. Only for demonstration */
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

		<div>
			<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
			  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			 </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center">
	  		<h1>View most asked questions - Tute 06</h1>
		</div>
		<div class="row">
  			<div class="column" style="background-color:#aaa;">
   				 <h2>Column 1</h2>
           </div>
  		   <div class="column" style="background-color:#bbb;">
    			<h2>Column 2</h2>
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
				 	 <button class="button" role="button;">Print</button>
				 </div>
				 <div class="col-sm-2">
				 	 <button class="button" role="button;">Download</button>
				 </div>
				 <div class="col-sm-2">
				     <button class="button" role="button" style="background-color:  #70db70;">Cancel</button>
				 </div>
		 </div><br><br>  
</body>
</html>