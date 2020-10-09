package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Anu_Teacher;
import Service.Anu_ITeacherService;
import Service.Anu_TeacherServiceImpl;

/**
 * Servlet implementation class Anu_ListTeachersServlet
 */
@WebServlet("/Anu_ListTeachersServlet")
public class Anu_ListTeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anu_ListTeachersServlet() {
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
		
		Anu_Teacher teacher = new Anu_Teacher() ;

 		String subjectCode = request.getParameter("subjectCode");	
 		String subjectName = request.getParameter("subjectName");
 		String level = request.getParameter("level");
 		String medium = request.getParameter("medium");
 		System.out.println(subjectCode + "servlet");
 		
 		teacher.setSubjectCode(subjectCode);
 		teacher.setSubjectName(subjectName);
 		teacher.setLevel(level);
 		teacher.setMedium(medium);
 				
		request.setAttribute("teacher", teacher);
 		
		Anu_ITeacherService iTeacherService = new Anu_TeacherServiceImpl();
		ArrayList<Anu_Teacher> teachers = iTeacherService.getTeacherById(subjectCode);
		
		request.setAttribute("teachers", teachers);
		
		String teacherStatus = request.getParameter("teacher");
		System.out.println("teacher status : " + teacherStatus);
		
		if(teacherStatus.contentEquals("true")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_subject.jsp");
			dispatcher.forward(request, response);
			
		}
		
		else if (teacherStatus.contentEquals("false")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Student_tutorial_subject.jsp");
			dispatcher.forward(request, response);			
			
		}
		
		//doGet(request, response);
	}

}
