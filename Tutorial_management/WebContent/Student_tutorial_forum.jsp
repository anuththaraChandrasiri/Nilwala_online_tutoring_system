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
<title>Tutorial forum</title>
<style> 
        input.largerCheckbox { 
            width: 25px; 
            height: 25px; 
        } 
    </style>
</head>
<body>
<%@ include file="WEB-INF/Student_header.jsp" %> 
	
		<div class="jumbotron text-center">
	 		 <h1>Questions</h1>
		</div>
		
		<div class="jumbotron text-center">
			  <div class="row">
			  	 <form action="/action_page.php">
			   		 <div class="col-sm-6" style="background-color:#ccd9ff;">
				   		 <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 1</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="question1">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 2</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="question2">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 3</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="question3">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 4</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="question4">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 5</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="question5">     
			   			 </div>
			   		</div>
			     	<div class="col-sm-6" style="background-color:#ccd9ff;">
				   		 <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 6</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="question6">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 7</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="question7">       
		   				 </div>
		   				  <div class="checkbox">
			     			 <label style = "font-size:25px;">Question 8</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     			 <input type="checkbox" class="largerCheckbox" name="question8">     
			   			 </div>
			   			 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 9</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="question9">       
		   				 </div>
		   				 <div class="checkbox">
		     				 <label style = "font-size:25px;">Question 10</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     				 <input type="checkbox" class="largerCheckbox" name="question10">       
		   				 </div>		  			     				 
			     	</div>	
			     		  <div class="col-sm-6" style="background-color:  #f2f2f2;"><br><br>  		         
		 	  			  </div>
		 	  			  <div class="col-sm-6" style="background-color:  #f2f2f2;"><br><br>  		         
		 	  			  </div>
		 	  			  
					    <!-- <button class="button" onclick= "document.location='Student_tutorial_main.jsp'">Submit</button><br><br> Until i create the servlet -->
			     		    	
			     </form>
			     		<button class="button" onclick= "document.location='Student_tutorial_main.jsp'">Submit</button><br><br> 
			     		<button class="button" onclick= "document.location='Student_tutorial_main.jsp'">Cancel</button>
	 		</div> 
	</div>
</body>
</html>