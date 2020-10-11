package Servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class TeacherViewReportServlet
 */
@WebServlet("/TeacherViewReportServlet")
public class TeacherViewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherViewReportServlet() {
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
 		tutorial.setQuestions(questions);
 			
 		ITutorialService iTutorialService = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService.getQuestionNumbersByTutorialId(tutorialID);	
		
		ITutorialService iTutorialService2 = new TutorialServiceImpl();

 		int studentCount = iTutorialService2.checkStudentCountForAforum(tutorial);
 		tutorial.setStudentCount(studentCount);
		
 		request.setAttribute("tutorial", tutorial);
 		
		request.setAttribute("tutorials", tutorials);
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_viewQuestionsReport.jsp");
		dispatcher.forward(request, response);			
					
	}

}
