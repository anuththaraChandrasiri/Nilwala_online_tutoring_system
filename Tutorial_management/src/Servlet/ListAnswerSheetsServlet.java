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
import Service.AnswerSheetServiceImpl;
import Service.IAnswerSheetService;

/**
 * Servlet implementation class ListAnswerSheetsServlet
 */
@WebServlet("/ListAnswerSheetsServlet")
public class ListAnswerSheetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAnswerSheetsServlet() {
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
		
		String teacherId = request.getParameter("teacherId");	
 		 		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService.getAnswerSheetsById(teacherId);
		
		request.setAttribute("answerSheets", answerSheets);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
		dispatcher.forward(request, response);
	
	}

}
