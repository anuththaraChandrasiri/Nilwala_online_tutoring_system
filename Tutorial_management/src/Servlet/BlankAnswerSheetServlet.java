package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AnswerSheet;

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

 		String teacherID = request.getParameter("teacherID");	
 		String subjectCode = request.getParameter("subjectCode");
 		
 		answerSheet.setTeacher_id(teacherID);
 		answerSheet.setSubject_code(subjectCode);
 				
		request.setAttribute("answerSheet", answerSheet);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_uploadAnswerSheet.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
