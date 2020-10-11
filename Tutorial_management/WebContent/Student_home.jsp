<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Anu_Student_styles.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Student home</title>
<style>
* {box-sizing: border-box}

/* Set height of body and the document to 100% */
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial;
}

/* Style tab links */
.tablink {
  background-color: #555;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 25%;
}

.tablink:hover {
  background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
  color: white;
  display: none;
  padding: 100px 20px;
  height: 100%;
}

#Home {background-color: #3366ff;}
#News {background-color: #ff6600;}
#Contact {background-color: #8c8c8c;}
#About {background-color: orange;}
</style>
</head>
<body>

<%@ include file="WEB-INF/Student_header.jsp" %> 

	<div>
		<ul class="breadcrumb"><!--   add your path example : Subject / Add Subject 1st li subject 2nd li Add Subject . change accordingly-->
		  <li><a href="Student_home.jsp"><b>Home</b></a></li>
		</ul>
	</div>
	<hr>
	
	
<button class="tablink" onclick="openPage('Home', this, '#3366ff')" id="defaultOpen">Classes</button>
<button class="tablink" onclick="openPage('News', this, '#ff6600')">News</button>
<button class="tablink" onclick="openPage('Contact', this,'#8c8c8c')">Contact</button>
<button class="tablink" onclick="openPage('About', this, 'orange')">About</button>

<div id="Home" class="tabcontent">
		<div class="jumbotron text-center"style="height: 100px; padding: 10px 20px 50px 20px; color: blue;">
	 		<h2><b>Classes</b></h2>
		</div>
		<div class = "column1" style="height: 500px; width: 65%; float:left;">
			<img src=".\images\image1.png"  class="responsives" style="height: 450px; width: 100%; float:left;">
		</div>
		<div class = "column2" style="height: 500px; width: 30%; float:right;">
			<p class="responsives" style="height: 450px; width: 100%; float:right; font-size: 20px;  color: black; ">
			Are you a student who is looking for online learning opportunities to complete you ordinary level or advanced level education? If so, 
			here is a great opportunity to complete what you missed because of the COVID-19 quarantine period!<br>
			In our system, we cover the areas in Ordinary level including Science, Mathematics, other main subjects and Biological Science, Physical Science, IT and other main streams 
			in advanced level. By using this system, you will be able to participate the online lectures, discussions and tutorial sessions including 
			the tutorial and answer sheet materials!</p>
		</div>
</div>

<div id="News" class="tabcontent">
	<div class="jumbotron text-center"style="height: 100px; padding: 10px 20px 50px 20px; color:#ff3300;">
	 		<h2><b>News</b></h2>
	</div>
	<div class = "column1" style="height: 500px; width: 65%; float:left;">
			<img src=".\images\image3.png"  class="responsives" style="height: 450px; width: 100%; float:left;">
		</div>
		<div class = "column2" style="height: 500px; width: 30%; float:right;">
			<p class="responsives" style="height: 450px; width: 100%; float:right; font-size: 20px;  color: black; ">
			We will be updating you with the latest news and special notices about the new classes and new teachers in this section.<br><br> 
			Dr. Dharshana Ukuwela will join us from the next month onwards. Advanced Level Physics classes will be available in our system soon.<br><br> 
			Mr. Gamini Premerathne will start his lecture delivery from this Sunday onwards. Ordinary Level Science classes will be available soon.</p>
		</div>
</div>

<div id="Contact" class="tabcontent">
	<div class="jumbotron text-center"style="height: 100px; padding: 10px 20px 50px 20px; color:#595959;">
	 		<h2><b>Contact</b></h2>
	</div>
	<div class = "column1" style="height: 500px; width: 65%; float:left;">
			<img src=".\images\image2.png"  class="responsives" style="height: 450px; width: 100%; float:left;">
		</div>
		<div class = "column2" style="height: 500px; width: 30%; float:right;">
			<p class="responsives" style="height: 450px; width: 100%; float:right; font-size: 20px;  color: black; ">
			Feel free to contact us regarding any kind of issues regarding the system and the classes. We will be there to help you.<br><br> 
			Nilwala institute, Kandy - 0814564567 <br> 
			Manager - 0774564563 <br>
			Assistant manager  0763454562<br>
			Email us - nilwala.kandy@gmail.com</p>
		</div>
</div>

<div id="About" class="tabcontent">
  	<div class="jumbotron text-center"style="height: 100px; padding: 10px 20px 50px 20px; color:#ff9900;">
	 		<h2><b>About</b></h2>
	</div>
	<div class = "column1" style="height: 500px; width: 65%; float:left;">
			<img src=".\images\image4.jpg"  class="responsives" style="height: 450px; width: 100%; float:left;">
		</div>
		<div class = "column2" style="height: 500px; width: 30%; float:right;">
			<p class="responsives" style="height: 450px; width: 100%; float:right; font-size: 20px;  color: black; ">
			We are proud to be listed as a leading and formidable awarding institute in Kandy, which helps hundreds and thousands of 
			children to continue their ordinary and advanced level studies. With the help of the talented and experienced teachers,
			we have helped many students to achieve their precious goals in education and, we consider helping them as one of our duties 
			and always it will be our priority.<br> Since our students experience many difficulties during this COVID-19 quarantine situation, 
			as an institute which focuses on students' well-being, we now provide our students the facility of online learning, through our 
			online tutoring system. We hope our students will get the maximum use of this facility. </p>
		</div>
</div>

<script>
function openPage(pageName,elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
   	 
</body>
</html>