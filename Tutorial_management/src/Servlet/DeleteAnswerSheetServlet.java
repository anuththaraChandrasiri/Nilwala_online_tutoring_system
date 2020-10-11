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
 * Servlet implementation class DeleteAnswerSheetServlet
 */
@WebServlet("/DeleteAnswerSheetServlet")
public class DeleteAnswerSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnswerSheetServlet() {
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
		String teacherID = request.getParameter("teacherID");
		String subjectCode = request.getParameter("subjectCode");
		
		answerSheet.setSheet_id(answerSheetID);
		answerSheet.setTeacher_id(teacherID);
		answerSheet.setSubject_code(subjectCode);
		
		Tutorial tutorial1 = new Tutorial() ;
		
		String subjectName = request.getParameter("subjectName");
		String level = request.getParameter("level");
		String medium = request.getParameter("medium");
		String teacherName = request.getParameter("teacherName");
		
		tutorial1.setSubjectName(subjectName);
 		tutorial1.setLevel(level);
 		tutorial1.setMedium(medium);
 		tutorial1.setTeacherName(teacherName);
 		
 		request.setAttribute("tutorial", tutorial1);
		
		request.setAttribute("answerSheet", answerSheet);
		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		iAnswerSheetService.deleteAnswerSheet(answerSheetID);
		
		ITutorialService iTutorialService1 = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService1.getTutorialsById(answerSheet.getTeacher_id());
		
		IAnswerSheetService iAnswerSheetService1 = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService1.getAnswerSheetsById(answerSheet.getTeacher_id());
		
		request.setAttribute("answerSheets", answerSheets);
		
		request.setAttribute("tutorials", tutorials);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Anu_DeleteAnswerSheetMessage.jsp");
		dispatcher.forward(request, response);
	
	}

}
