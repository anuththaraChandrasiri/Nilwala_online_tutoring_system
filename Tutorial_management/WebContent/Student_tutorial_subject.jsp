<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Tutorial subject</title>
</head>
<body>

<%@ include file="WEB-INF/Student_header.jsp" %> 

	<div>
		<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
		  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a></li>
		</ul>
	</div>
	<hr>
	
	<div class="jumbotron text-center">
  <h1>Mathematics</h1>
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-12" style = "text-align: center;">
      <button class="button1" onclick= "document.location='Student_tutorial_main.jsp'" role="button">Mr. Athula Perera</button><br><br>
      <button class="button1" onclick= "document.location='Student_tutorial_main.jsp'" role="button">Mr. Kapila Gunarathne</button><br><br>
      <button class="button1" onclick= "document.location='Student_tutorial_main.jsp'" role="button">Ms. Samanthi Gamage</button><br><br>
      <button class="button1" onclick= "document.location='Student_tutorial_main.jsp'" role="button">Mr. Kamal De Silva</button><br><br><br><br>
    </div>
   </div>
</div>
	 
</body>
</html>