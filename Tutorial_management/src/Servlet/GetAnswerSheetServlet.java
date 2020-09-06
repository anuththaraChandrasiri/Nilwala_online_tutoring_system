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

 		String answerSheetID = request.getParameter("answerSheetID");	
 		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		AnswerSheet answerSheet = iAnswerSheetService.getAnswerSheetById(answerSheetID);
		
		request.setAttribute("answerSheet", answerSheet);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_updateAnswerSheet.jsp");
		dispatcher.forward(request, response);
		
		//doGet(request, response);
	}

}
