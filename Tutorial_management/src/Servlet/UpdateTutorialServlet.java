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
		tutorial.setDateAdded(request.getParameter("uploadingDate"));
		tutorial.setMonth(request.getParameter("month"));
		tutorial.setMaterial(request.getParameter("filename"));
	
		ITutorialService iTutorialService = new TutorialServiceImpl();
		iTutorialService.updateTutorial(tutorialID, tutorial);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
