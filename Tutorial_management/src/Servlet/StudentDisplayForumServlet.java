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
 * Servlet implementation class StudentDisplayForumServlet
 */
@WebServlet("/StudentDisplayForumServlet")
public class StudentDisplayForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDisplayForumServlet() {
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
		
		String teacherId = request.getParameter("teacherID");
		String subjectCode = request.getParameter("subjectCode");
		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
		String tutorialID =  request.getParameter("tutorialID");
		String studentID =  request.getParameter("studentID");
		String tutorialTitle =  request.getParameter("tutorialName");
		
 		System.out.println(teacherId + subjectName + teacherName + tutorialTitle + studentID + " servlet");
 		
 		tutorial.setTeacherId(teacherId);
 		tutorial.setSubjectCode(subjectCode);
 		tutorial.setSubjectName(subjectName);
 		tutorial.setLevel(level);
 		tutorial.setMedium(medium);
 		tutorial.setTeacherName(teacherName);
 		tutorial.setTutorialId(tutorialID);
 		tutorial.setTutorialTitle(tutorialTitle);
 		tutorial.setStudentId(studentID);
 		
 		System.out.println(tutorial.getTeacherId()+ "is tid" + tutorial.getTeacherName() + "teacher name");
 		
 		request.setAttribute("tutorial", tutorial);
 		 		 
 		ITutorialService iTutorialService = new TutorialServiceImpl();
 		 		
		boolean checkStatus = iTutorialService.checkStudentIdInQforum(tutorial);
		
		if(!checkStatus) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Student_tutorial_ForumAlreadySubmitted.jsp");
			dispatcher.forward(request, response);	
			
		}
		else {			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Student_tutorial_forum.jsp");
			dispatcher.forward(request, response);			
						
		}
			
		//doGet(request, response);
	}

}
