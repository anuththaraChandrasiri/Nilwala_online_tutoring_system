package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AnswerSheet;
import Service.AnswerSheetServiceImpl;
import Service.IAnswerSheetService;

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
 		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		AnswerSheet answerSheet1 = iAnswerSheetService.getAnswerSheetById(answerSheetID);
		
		System.out.println(teacherID+"sECOND");
		
		request.setAttribute("answerSheet1", answerSheet1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_updateAnswerSheet.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
