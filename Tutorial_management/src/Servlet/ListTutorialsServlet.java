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
 * Servlet implementation class ListTutorialsServlet
 */
@WebServlet("/ListTutorialsServlet")
public class ListTutorialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTutorialsServlet() {
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
 		System.out.println(teacherId + subjectName + teacherName + "servlet");
 		
 		tutorial.setTeacherId(teacherId);
 		tutorial.setSubjectCode(subjectCode);
 		tutorial.setSubjectName(subjectName);
 		tutorial.setLevel(level);
 		tutorial.setMedium(medium);
 		tutorial.setTeacherName(teacherName);
 		
 		request.setAttribute("tutorial", tutorial);
 		
		ITutorialService iTutorialService = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService.getTutorialsById(teacherId);
		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService.getAnswerSheetsById(teacherId);
		
		request.setAttribute("answerSheets", answerSheets);
		
		request.setAttribute("tutorials", tutorials);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
