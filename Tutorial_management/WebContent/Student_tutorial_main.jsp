<%@page import="Model.Tutorial"%>
<%@page import="Model.AnswerSheet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.TutorialServiceImpl"%>
<%@page import="Service.ITutorialService"%>
<%@page import="Service.AnswerSheetServiceImpl"%>
<%@page import="Service.IAnswerSheetService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="student_styles.css">
<meta charset="ISO-8859-1">
<title>Student main</title><meta name="viewport" content="width=device-width, initial-scale=1">
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
  height: 100%;
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
			  	  <a href="Student_tutorial_main.jsp"><b> - Kapila Gunarathne</b></a>
			 </li>
		</ul>
	</div>
	<hr>
	
	<div class="column left" style="background-color: #b3d1ff;">
			 		<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 <h2>January</h2>
			   		</div>
		   			 	
		   			 		   			 	
							<%
					            ITutorialService iTutorialService = new TutorialServiceImpl();
								ArrayList<Tutorial> arrayList = iTutorialService.getTutorials();
								
								for(Tutorial tutorial : arrayList){
							%>
						    <div class="row">
				   				
				   				 <br>
				   				 		<div class="col-sm-6" style="background-color:#cce0ff;">
				   				 		<h2><a href="Student_tutorial_pdf.jsp">
				   				 		<b><%=tutorial.getTutorialTitle()%></b><br><br></a></h2>
				     					</div>
				     					<div class="col-sm-6" style="background-color:#cce0ff;"><br>
				   				 		<button class="button" onclick= "document.location='Student_tutorial_pdf.jsp'"
				   				 			style = "background: #80b3ff;  margin-left:25%;">Download</button><br><br>
				     					</div>					     			 
				    		 </div> 
				    		  
					    	<%	
				 					  }
	         				%>  
	         				
	         				   <br><br><br>
				    		   <div class="row">
				   						 <div class="col-sm-6">
						   											   						
				     					 </div>
				    		    		 <div class="col-sm-6">
				    		    		 
				    		    		   <button class="button" onclick= "document.location='Student_tutorial_forum.jsp'" style="background-color: #1a75ff;">
						   						Questions?</button>
						   						  <br><br><br><br>
				    		    		 </div>
		   			         	</div>
				    	 </div>  
					    		    			    		    				
			  			<div class="column right" style="background-color: #cce0ff; ">
			   				<div class="jumbotron text-center" style=" height: 30px; text-align:left; padding: 10px 20px 70px 20px;">
			   			 		<h2>Answer sheets</h2>
			  			</div>
			  		
			  		<%
					            IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
								ArrayList<AnswerSheet> arrayList2 = iAnswerSheetService.getAnswerSheets();
								
								for(AnswerSheet answerSheet : arrayList2){
					%>
			  		
		   			 		 <div class="row"><br>
				   				 	<div class="col-sm-6" style="background-color:	 #cce0ff;">
				   				 		<h3><a href="Student_tutorial_pdf.jsp">
				   							 <b><%=answerSheet.getSheet_name()%></b></a></h3><br>
				     			    </div>
				    		     	<div class="col-sm-6" style="background-color:	#cce0ff;"><br>
				    		     			<button class="button4" onclick= "document.location='Student_tutorial_pdf.jsp'"
				   				 			style = "background: #80b3ff;">Download</button><br><br>
				     				</div>	
				    		   </div>
		   			        
		   			        <%	
				 					  }
	         				%>  
		   			      </div>
		   			      	
			  					 <div class="row">
				   					 <div class="col-sm-6"><h3></h3><br><br>
				     			 	</div>
				    		    	<div class="col-sm-6"><h2></h2><br>
				    		     	</div>
		   	     				</div>	 
		
</body>
</html>