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
 * Servlet implementation class UpdateTutorialServlet
 */
@WebServlet("/UpdateTutorialServlet")
public class UpdateTutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTutorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		Tutorial tutorial = new Tutorial() ;
		
		String tutorialID = request.getParameter("tutorialID");
				
		tutorial.setTutorialId(tutorialID);
		tutorial.setTutorialTitle(request.getParameter("tutorialName"));
		tutorial.setTeacherId(request.getParameter("teacherID"));
		tutorial.setSubjectCode(request.getParameter("subjectCode"));
		tutorial.setDateAdded(request.getParameter("uploadedDate"));
		tutorial.setMonth(request.getParameter("month"));
				
		if(request.getParameter("filename").equalsIgnoreCase("")) {
			tutorial.setMaterial(request.getParameter("filename1"));
			System.out.println(request.getParameter("filename1"));
		}
		else	
			tutorial.setMaterial(request.getParameter("filename"));
		
		System.out.println(tutorial.getMaterial());
		
		request.setAttribute("tutorial", tutorial);
	
		ITutorialService iTutorialService = new TutorialServiceImpl();
		iTutorialService.updateTutorial(tutorialID, tutorial);
		
		ITutorialService iTutorialService1 = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService1.getTutorialsById(tutorial.getTeacherId());
		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService.getAnswerSheetsById(tutorial.getTeacherId());
		
		request.setAttribute("answerSheets", answerSheets);
		
		request.setAttribute("tutorials", tutorials);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Anu_SuccessfullyUpdated.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
