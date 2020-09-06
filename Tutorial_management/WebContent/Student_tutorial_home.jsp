<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="student_styles.css">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="ISO-8859-1">
<!-- For the table -->
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Student tutorial home</title>
</head>
<body>
<%@ include file="WEB-INF/Student_header.jsp" %> 

	<div>
		<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
		  <li><a href="Student_tutorial_home.jsp"><b>Tutorials</b></a></li>
		</ul>
	</div>
	<hr>
	
	<div class="container-fluid">
	     
		  <div class="row">
		   		 <div class="col-sm-6" style="background-color:#ccd9ff;"><h1>Ordinary level</h1>
		     		 <div class="col-sm-6" style="background-color:#99b3ff;"><h1>Sinhala medium</h1>	         
		        	 </div>
		         	 <div class="col-sm-6" style="background-color:#668cff;"><h1>English medium</h1>    
		   			 </div>
		    	</div>
		    	<div class="col-sm-6" style="background-color:#ccd9ff;"><h1>Advanced level</h1>
		    		 <div class="col-sm-6" style="background-color:#99b3ff;"><h1>Sinhala medium</h1>
		           	 </div>
		       		 <div class="col-sm-6" style="background-color:#668cff;"><h1>English medium</h1>
		         	 </div>
		       </div>
		       
		       <div class="col-sm-6" style="background-color:#ccd9ff;"><br><br>
		    		 <div class="col-sm-6" style="background-color:white;"><br>
		    		 <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">English</button><br><br>
		             </div>
		             <div class="col-sm-6" style="background-color:white;"><br>
		            <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">English literature</button><br><br>
		         	 </div>	         
		 	   </div>
				<div class="col-sm-6" style="background-color:#ccd9ff;"><br><br>
			    	 <div class="col-sm-6" style="background-color:white;"><br>
			    	 <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">Biology</button><br><br>
			         </div>
			          <div class="col-sm-6" style="background-color:white;"><br>
			          <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">Biology</button><br><br>
			         </div>	         
		  	   </div>
		  	     <div class="col-sm-6" style="background-color:#ccd9ff;"><br>
		    		 <div class="col-sm-6" style="background-color:white;"><br>
		    		 <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">Mathematics</button><br><br>
		             </div>
		           <div class="col-sm-6" style="background-color:white;"><br>
		    		 <button class="button" onclick= "document.location='Student_tutorial_subject.jsp'" role="button">Mathematics</button><br><br>
		             </div>
		 	   </div>
				<div class="col-sm-6" style="background-color:#ccd9ff;"><br>
			    	 <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Com. Mathematics</button><br><br>
			         </div>
			          <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Com. Mathematics</button><br><br>
			         </div>	         
		  	   </div>
		  	   <div class="col-sm-6" style="background-color:#ccd9ff;"><br>
		    		 <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Science</button><br><br>
		             </div>
		             <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Science</button><br><br>
		         	 </div>	         
		 	   </div>
				<div class="col-sm-6" style="background-color:#ccd9ff;"><br>
			    	 <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Physics</button><br><br>
			         </div>
			          <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Physics</button><br><br>
			         </div>     
		  	   </div>
		  	    <div class="col-sm-6" style="background-color:#ccd9ff;"><br>
		    		 <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Sinhala</button><br><br>
		             </div>
		             <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Commerce</button><br><br>
		         	 </div>	         
		 	   </div>
				<div class="col-sm-6" style="background-color:#ccd9ff;"><br>
			    	 <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Chemistry</button><br><br>
			         </div>
			          <div class="col-sm-6" style="background-color:white;"><br><button class="button" role="button">Chemistry</button><br><br>
			         </div>     
		  	   </div>
		  	    <div class="col-sm-6" style="background-color:#ccd9ff;"><br><br>  		         
		 	   </div>
			   <div class="col-sm-6" style="background-color:#ccd9ff;"><br><br>
		       </div>
		    </div>
	</div><br><br>
</body>
</html>