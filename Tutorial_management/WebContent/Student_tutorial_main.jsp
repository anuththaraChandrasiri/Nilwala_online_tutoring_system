<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="student_styles.css">
<meta charset="ISO-8859-1">
<title>Tutorial main</title><meta name="viewport" content="width=device-width, initial-scale=1">
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
  height: 1000px;
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

<%@ include file="WEB-INF/Student_header.jsp" %> 

	<div>
		<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
		   	  <li><a href="Student_tutorial_home.jsp"><b>Ordinary level - Sinhala medium</b></a>
			  	  <a href="Student_tutorial_subject.jsp"><b> - Mathematics</b></a>
			  	  <a href="#"><b> - Kapila Gunarathne</b></a>
			 </li>
		</ul>
	</div>
	<hr>
	
	<div class="column left" style="background-color: #3385ff;">
			 		<div class="jumbotron text-center" style="height:30px; text-align:left;">
			   			 <h2>January</h2>
			   		</div>
		   			 	<div class="inside">
		   			 		 <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 01 - Lesson 01</b></a></h2><br>
				     			 </div>
				    		     
		   			         </div>	 
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 02 - Lesson 01</b></a></h2><br>
				     			 </div>
				    		    
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 03 - Lesson 02</b></a></h2><br>
				     			 </div>
				    		    
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 04 - Lesson 03</b></a></h2><br>
				     			 </div>
				    		    
		   			         </div>	<br>
		   			         <div class="jumbotron text-center" style="height:30px; text-align:left; text-align:left;">
				   				 <h2>February</h2>
				   			</div>  	
				   			 <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 05 - Lesson 04</b></a></h2><br>
				     			 </div>
				    		    
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color: #cce0ff; width:99.5%; text-align:left;"><h2><a href="#"><b>Tute 06 - Lesson 04</b></a></h2><br>
				     			 </div>
				    		     
		   			         </div>	<br>
		   			         		<br><br><br><br>
		   			         		<div class="row">
				   						 <div class="col-sm-6">
				   						 
				   						  <br><br><br><br><br>
				     					 </div>
				    		    		 <div class="col-sm-6">
				    		    		 <button class="button" role="button" style="background-color: #0052cc;">Questions?</button>
				    		    		 <br><br><br><br><br>
				    		    		 </div>
		   			         		</div>
	   			       </div>  		
				</div>
				
				
			  	<div class="column right" style="background-color: #0052cc; ">
			   		<div class="jumbotron text-center"  style="height:30px;">
			   			 <h2>Answer sheets</h2>
			  		</div>
			  		<div class="inside">
		   			 		 <div class="row">
				   				 <div class="col-sm-6" style="background-color: #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 01 answers</b></a></h3><br>
				     			 </div>
				    		     
		   			         </div>
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	 #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 02 answers</b></a></h3><br>
				     			 </div>
				    		    
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	  #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 03 answers</b></a></h3><br>
				     			 </div>
				    		    
		   			         </div>	  
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	 #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 04 answers</b></a></h3><br>
				     			 </div>
				    		    
		   			         </div>	 	
				   			<div class="row">
				   				 <div class="col-sm-6" style="background-color:	  #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 05 answers</b></a></h3><br>
				     			 </div>
				    		    
		   			         </div>
		   			         <div class="row">
				   				 <div class="col-sm-6" style="background-color:	  #ccd9ff; width:99.5%;"><h3><a href="#"><b>Tute 06 answers</b></a></h3><br><br><br>
				     			 </div>
				    		     
		   			         </div>
	   			       </div>  		
			  	</div>
</body>
</html>