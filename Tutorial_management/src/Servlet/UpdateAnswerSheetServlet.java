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
 * Servlet implementation class UpdateAnswerSheetServlet
 */
@WebServlet("/UpdateAnswerSheetServlet")
public class UpdateAnswerSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnswerSheetServlet() {
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
		
		String answerSheetID = request.getParameter("sheetID");
		
		answerSheet.setSheet_name(request.getParameter("sheetName"));
		answerSheet.setDate_added(request.getParameter("uploadedDate"));
		answerSheet.setTeacher_id(request.getParameter("teacherID"));
		answerSheet.setTute_id(request.getParameter("tuteID"));
		answerSheet.setSubject_code(request.getParameter("subjectCode"));
		
		if(request.getParameter("filename").equalsIgnoreCase("")) {
			answerSheet.setMaterial(request.getParameter("filename1"));
			System.out.println(request.getParameter("filename1"));
		}
		else	
			answerSheet.setMaterial(request.getParameter("filename"));
		
		System.out.println(answerSheet.getMaterial());
			
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		iAnswerSheetService.updateAnswerSheet(answerSheetID, answerSheet);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
