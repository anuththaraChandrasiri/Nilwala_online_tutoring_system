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
import Service.AnswerSheetServiceImpl;
import Service.IAnswerSheetService;
import Service.ITutorialService;
import Service.TutorialServiceImpl;

/**
 * Servlet implementation class GetAnswerSheetServlet
 */
@WebServlet("/GetAnswerSheetServlet")
public class GetAnswerSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAnswerSheetServlet() {
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
		
 		String answerSheetID = request.getParameter("answerSheetID");
 		String subjectCode = request.getParameter("subjectCode");
 		String teacherID = request.getParameter("teacherID") ;
 		
 		answerSheet.setSheet_id(answerSheetID);
 		answerSheet.setSubject_code(subjectCode);
 		answerSheet.setTeacher_id(teacherID);
 		
 		System.out.println(teacherID+"FIRST");
 		
 		request.setAttribute("answerSheet", answerSheet);
 		
 		Tutorial tutorial = new Tutorial() ;
 		
 		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
		
		tutorial.setSubjectName(subjectName);
 		tutorial.setLevel(level);
 		tutorial.setMedium(medium);
 		tutorial.setTeacherName(teacherName);
 		
 		System.out.println(tutorial.getTeacherName()+ "is teacher name in update as" + "subject code " + answerSheet.getSubject_code());
 		 		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		AnswerSheet answerSheet1 = iAnswerSheetService.getAnswerSheetById(answerSheetID);
		
		String tutorialId = answerSheet1.getTute_id();
		
		ITutorialService iTutorialService1 = new TutorialServiceImpl();
		Tutorial tutorial1 = iTutorialService1.getTutorialById(tutorialId);
		
		answerSheet1.setTute_title(tutorial1.getTutorialTitle());
 		
 		request.setAttribute("tutorial", tutorial);		
		
		System.out.println(teacherID+"sECOND"+ "tute tile ans : " + answerSheet1.getTute_title());
		
		ITutorialService iTutorialService2 = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService2.getTutorialsById(answerSheet.getTeacher_id());
		
		request.setAttribute("answerSheet1", answerSheet1);
		
		request.setAttribute("tutorials", tutorials);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_updateAnswerSheet.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
