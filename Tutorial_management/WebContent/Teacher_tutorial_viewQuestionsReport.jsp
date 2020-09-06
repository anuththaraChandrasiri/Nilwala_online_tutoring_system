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

		<div>
			<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
			  <li><a href="Teacher_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Teacher_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="Teacher_tutorial_main.jsp"><b> - Kapila Gunarathne</b></a>
			 </li>
			</ul>
		</div>
		<hr>
		<div class="jumbotron text-center" style=" height: 30px; text-align:center; padding: 10px 20px 70px 20px;">
	  		<h2>View most asked questions - Tutorial 01 </h2>
		</div>
		<div class="row">
  			<div class="column" style="background-color: #00ff55; margin-left:35px; text-align:center; ">
   				 <h1>Question number</h1>
   				 
   				  <div class="row"><br><br>
		   		 <div class="col-sm-11" style="background-color: #b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 05</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color: #b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 07</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 03</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 04</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 02</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 08</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 09</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 01</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 10</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>Question 06</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><br><br>
		     		
		    	</div>
		     </div>	 
   				 
           </div>
  		   <div class="column" style="background-color: #00ff55; text-align:center;">
    			<h1>Number of students</h1><br><br>
    			
    			 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>25</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>22</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>21</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>20</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>16</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>14</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>13</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>5</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>2</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><h3>0</h3>
		     		
		    	</div>
		    	 <div class="col-sm-11" style="background-color:#b3ffcc;  text-align:center; margin-left:30px;"><br><br>
		     		
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
				 	    <button class="button" onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:#00b33c;">Print</button>
				</div>
				 <div class="col-sm-2">
				 	    <button class="button" onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:#00b33c;">Download</button>
				 </div>
				 <div class="col-sm-2">
				     <button class="button" onclick= "document.location='Teacher_tutorial_main.jsp'" style="background-color:#00b33c;">Cancel</button>
				 </div>
		 </div><br><br>  
</body>
</html>