<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Anu_Subject"%>
<%@page import="Service.Anu_SubjectServiceImpl"%>
<%@page import="Service.Anu_ISubjectService"%>
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
<title>Teacher tutorial home</title>
</head>
<body>
<%@ include file="WEB-INF/Teacher_header.jsp" %> 

	<div>
		<ul class="breadcrumb">
		  <li><a href="Teacher_tutorial_home.jsp"><b>Tutorials</b></a>  
		 	 <div style= "margin-left: 520px;">				
				  	 <form method="POST" action="SearchTeacherServlet">
		                <input type="text" placeholder="Search by the teacher's name..." name="searchTeacher" style= "font-size: 24px; width: 420px">
		                	 <input type="hidden" name="teacher" value="true"/>
		                       <button type="submit">
		                      		 <i class="fa fa-search"></i>
		                       </button>
		          	</form>	 				
			</div>
		  </li>
		</ul>
	</div>
	<hr>
	
	<div class="container-fluid" style=" width: 96%;">	     
		  <div class="row">
		   		 <div class="col-sm-6"><h1>Ordinary level</h1>
		     		 <div class="col-sm-6" style="background-color:#f0f0f5;"><h1>Sinhala medium</h1>	         
		        	 </div>
		         	 <div class="col-sm-6" style="background-color:#f0f0f5;"><h1>English medium</h1>    
		   			 </div>
		    	</div>
		    	<div class="col-sm-6"><h1>Advanced level</h1>
		    		 <div class="col-sm-6" style="background-color:#f0f0f5;"><h1>Sinhala medium</h1>
		           	 </div>
		       		 <div class="col-sm-6" style="background-color:#f0f0f5;"><h1>English medium</h1>
		         	 </div>
		       </div>
		  </div>     
		 
		  <div class="col-sm-6"><br><br>
		  	<div class="col-sm-6"><br>
		       <%
					            Anu_ISubjectService iSubjectService = new Anu_SubjectServiceImpl();
								ArrayList<Anu_Subject> arrayList = iSubjectService.OLSinhalaSubjects();
								
								for(Anu_Subject anu_Subject : arrayList){
			   %>
		       
		       	  		<div class="row"> 
		    		 		<form class = "form2" method="POST" action="Anu_ListTeachersServlet"><h2>
			    		 		 <input type="hidden" name="subjectCode" value="<%=anu_Subject.getSubjectCode()%>"/>
			    		 		 <input type="hidden" name="subjectName" value="<%=anu_Subject.getSubjectName()%>"/>
			    		 		 <input type="hidden" name="level" value="<%=anu_Subject.getLevel()%>"/>
			    		 		 <input type="hidden" name="medium" value="<%=anu_Subject.getMedium()%>"/>
			    		 		 <input type="hidden" name="teacher" value="true"/>
			    		 		 <button class="button" role="button"><%=anu_Subject.getSubjectName()%></button><br><br>
							</h2>
							</form>
		            	</div>
		        		 	   
		 	   <%	
				 					  }
	           %> 
	          </div>
	          <div class="col-sm-6"><br> 
	            <%
					            Anu_ISubjectService iSubjectService1 = new Anu_SubjectServiceImpl();
								ArrayList<Anu_Subject> arrayList1 = iSubjectService.OLEnglishSubjects();
								
								for(Anu_Subject anu_Subject : arrayList1){
			   %>
		       
		      			 <div class="row">
		       				 <form class = "form2" method="POST" action="Anu_ListTeachersServlet"><h2>
			    		 		 <input type="hidden" name="subjectCode" value="<%=anu_Subject.getSubjectCode()%>"/>
			    		 		 <input type="hidden" name="subjectName" value="<%=anu_Subject.getSubjectName()%>"/>
			    		 		 <input type="hidden" name="level" value="<%=anu_Subject.getLevel()%>"/>
			    		 		 <input type="hidden" name="medium" value="<%=anu_Subject.getMedium()%>"/>
			    		 		 <button class="button" role="button"><%=anu_Subject.getSubjectName()%></button><br><br>
							</h2>
							</form>
		            	</div>
		        
		 	   <%	
				 					  }
	           %> 
				
			   </div> <br>    
		  </div>
		  <div class="col-sm-6"><br><br>
		  	<div class="col-sm-6"><br>
		       <%
					            Anu_ISubjectService iSubjectService2 = new Anu_SubjectServiceImpl();
								ArrayList<Anu_Subject> arrayList2 = iSubjectService.ALSinhalaSubjects();
								
								for(Anu_Subject anu_Subject : arrayList2){
			   %>
		       
		       	  		<div class="row"> 
		    		 	<form class = "form2" method="POST" action="Anu_ListTeachersServlet"><h2>
			    		 		 <input type="hidden" name="subjectCode" value="<%=anu_Subject.getSubjectCode()%>"/>
			    		 		 <input type="hidden" name="subjectName" value="<%=anu_Subject.getSubjectName()%>"/>
			    		 		 <input type="hidden" name="level" value="<%=anu_Subject.getLevel()%>"/>
			    		 		 <input type="hidden" name="medium" value="<%=anu_Subject.getMedium()%>"/>
			    		 		 <button class="button" role="button"><%=anu_Subject.getSubjectName()%></button><br><br>
							</h2>
						</form>
		            	</div>
		        		 	   
		 	   <%	
				 					  }
	           %> 
	          </div>
	          <div class="col-sm-6"><br> 
	            <%
					            Anu_ISubjectService iSubjectService3 = new Anu_SubjectServiceImpl();
								ArrayList<Anu_Subject> arrayList3 = iSubjectService.ALEnglishSubjects();
								
								for(Anu_Subject anu_Subject : arrayList3){
			   %>
		       
		      			 <div class="row">		       				    		 	
		    		 		<form class = "form2" method="POST" action="Anu_ListTeachersServlet"><h2>
			    		 		 <input type="hidden" name="subjectCode" value="<%=anu_Subject.getSubjectCode()%>"/>
			    		 		 <input type="hidden" name="subjectName" value="<%=anu_Subject.getSubjectName()%>"/>
			    		 		 <input type="hidden" name="level" value="<%=anu_Subject.getLevel()%>"/>
			    		 		 <input type="hidden" name="medium" value="<%=anu_Subject.getMedium()%>"/>
			    		 		 <button class="button" role="button"><%=anu_Subject.getSubjectName()%></button><br><br>
							</h2>
							</form>
		            	</div>
		        
		 	   <%	
				 					  }
	           %> 
				
			   </div>     
		  </div>
				
		  	    <div class="col-sm-6"><br><br>  		         
		 	   </div>
			   <div class="col-sm-6"><br><br>
		       </div>
		    </div>
</body>
</html>