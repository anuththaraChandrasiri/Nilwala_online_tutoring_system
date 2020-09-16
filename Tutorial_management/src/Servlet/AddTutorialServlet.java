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
 * Servlet implementation class AddTutorialServlet
 */
@WebServlet("/AddTutorialServlet")
public class AddTutorialServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTutorialServlet() {
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
				
		tutorial.setTutorialTitle(request.getParameter("tutorialName"));
		tutorial.setTeacherId(request.getParameter("teacherID"));
		tutorial.setSubjectCode(request.getParameter("subjectCode"));
		tutorial.setDateAdded(request.getParameter("uploadingDate"));
		tutorial.setMonth(request.getParameter("month"));
		tutorial.setMaterial(request.getParameter("filename"));
		
		System.out.println(request.getParameter("uploadingDate"));
		
		ITutorialService iTutorialService = new TutorialServiceImpl();
		iTutorialService.addTutorial(tutorial);
		
		request.setAttribute("tutorial", tutorial);
		
		ITutorialService iTutorialService1 = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService1.getTutorialsById(tutorial.getTeacherId());
		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService.getAnswerSheetsById(tutorial.getTeacherId());
		
		request.setAttribute("answerSheets", answerSheets);
		
		request.setAttribute("tutorials", tutorials);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
