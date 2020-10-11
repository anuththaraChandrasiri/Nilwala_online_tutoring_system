package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AnswerSheet;
import Model.Tutorial;
import Service.ITutorialService;
import Service.TutorialServiceImpl;

/**
 * Servlet implementation class BlankAnswerSheetServlet
 */
@WebServlet("/BlankAnswerSheetServlet")
public class BlankAnswerSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlankAnswerSheetServlet() {
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
		
		AnswerSheet answerSheet = new AnswerSheet() ;
		Tutorial tutorial = new Tutorial() ;

 		String teacherID = request.getParameter("teacherID");	
 		String subjectCode = request.getParameter("subjectCode");
 		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
 		
 		answerSheet.setTeacher_id(teacherID);
 		answerSheet.setSubject_code(subjectCode);
 		
 		tutorial.setTeacherId(teacherID);
 		tutorial.setSubjectCode(subjectCode);
 		tutorial.setSubjectName(subjectName);
 		tutorial.setLevel(level);
 		tutorial.setMedium(medium);
 		tutorial.setTeacherName(teacherName);
 				
		request.setAttribute("answerSheet", answerSheet);
		
		request.setAttribute("tutorial", tutorial);
			 		
		ITutorialService iTutorialService = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService.getTutorialsById(teacherID);
		
		request.setAttribute("tutorials", tutorials);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_uploadAnswerSheet.jsp");
		dispatcher.forward(request, response);
		
	}

}
