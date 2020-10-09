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
 * Servlet implementation class GetTutorialServlet
 */
@WebServlet("/GetTutorialServlet")
public class GetTutorialServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTutorialServlet() {
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
		
		Tutorial tutorial1 = new Tutorial() ;

 		String tutorialID = request.getParameter("tutorialID");
 		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
		
		tutorial1.setSubjectName(subjectName);
 		tutorial1.setLevel(level);
 		tutorial1.setMedium(medium);
 		tutorial1.setTeacherName(teacherName);
 		
 		request.setAttribute("tutorial1", tutorial1);
 		
		ITutorialService iTutorialService = new TutorialServiceImpl();
		Tutorial tutorial = iTutorialService.getTutorialById(tutorialID);
		
		request.setAttribute("tutorial", tutorial);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_updateTutorial.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
