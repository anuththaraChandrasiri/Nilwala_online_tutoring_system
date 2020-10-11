package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Tutorial;
import Service.ITutorialService;
import Service.TutorialServiceImpl;

/**
 * Servlet implementation class StudentSubmitForumServlet
 */
@WebServlet("/StudentSubmitForumServlet")
public class StudentSubmitForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSubmitForumServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Tutorial tutorial = new Tutorial() ;
		
		String teacherId = request.getParameter("teacherId");
		String subjectCode = request.getParameter("subjectCode");
		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
		String tutorialID =  request.getParameter("tutorialID");
		String studentID =  request.getParameter("studentID");
		String tutorialTitle =  request.getParameter("tutorialName");
		String questions[] = request.getParameterValues("questions");
		 		
 		tutorial.setTeacherId(teacherId);
 		tutorial.setSubjectCode(subjectCode);
 		tutorial.setSubjectName(subjectName);
 		tutorial.setLevel(level);
 		tutorial.setMedium(medium);
 		tutorial.setTeacherName(teacherName);
 		tutorial.setTutorialId(tutorialID);
 		tutorial.setTutorialTitle(tutorialTitle);
 		tutorial.setStudentId(studentID);
 		tutorial.setQuestions(questions);
 		 		
 		request.setAttribute("tutorial", tutorial);
 		
 		for(int i = 0 ; i < questions.length; i++) {
 			
 			if(questions[i]!=null) 			
 				System.out.println("Selected questions are : " + questions[i] + "\t"); 
 			
 			else if(questions[i]==null) 
 				System.out.println("Not selected questions are : " + questions[i] + "\t");
 			
 		} 		 
 		
 		ITutorialService iTutorialService = new TutorialServiceImpl();
		iTutorialService.addQuestions(tutorial);
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Student_tutorial_ForumSuccessfullySubmitted.jsp");
		dispatcher.forward(request, response);			
					
	}

}
