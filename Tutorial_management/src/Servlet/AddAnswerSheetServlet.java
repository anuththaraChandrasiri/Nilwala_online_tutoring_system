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
 * Servlet implementation class AddAnswerSheetServlet
 */
@WebServlet("/AddAnswerSheetServlet")
public class AddAnswerSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnswerSheetServlet() {
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
				
		answerSheet.setSheet_name(request.getParameter("sheetName"));
		answerSheet.setMaterial(request.getParameter("filename"));
		answerSheet.setDate_added(request.getParameter("uploadingDate"));
		answerSheet.setTeacher_id(request.getParameter("teacherID"));
		answerSheet.setTute_id(request.getParameter("tuteID"));
		answerSheet.setSubject_code(request.getParameter("subjectCode"));
		
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
		
		IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
		iAnswerSheetService.addAnswerSheet(answerSheet);
		
		request.setAttribute("answerSheet", answerSheet);
		
		ITutorialService iTutorialService1 = new TutorialServiceImpl();
		ArrayList<Tutorial> tutorials = iTutorialService1.getTutorialsById(answerSheet.getTeacher_id());
		
		IAnswerSheetService iAnswerSheetService1 = new AnswerSheetServiceImpl();
		ArrayList<AnswerSheet> answerSheets = iAnswerSheetService1.getAnswerSheetsById(answerSheet.getTeacher_id());
		
		request.setAttribute("answerSheets", answerSheets);
		
		request.setAttribute("tutorials", tutorials);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Anu_AddAnswerSheetMessage.jsp");
		dispatcher.forward(request, response);
	
	}

}
