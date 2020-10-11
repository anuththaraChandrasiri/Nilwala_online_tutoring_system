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
import Model.Anu_Subject;
import Model.Tutorial;
import Service.AnswerSheetServiceImpl;
import Service.Anu_ISubjectService;
import Service.Anu_SubjectServiceImpl;
import Service.IAnswerSheetService;
import Service.ITutorialService;
import Service.TutorialServiceImpl;

/**
 * Servlet implementation class SearchTeacherServlet
 */
@WebServlet("/SearchTeacherServlet")
public class SearchTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeacherServlet() {
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
		
		String teacherName = request.getParameter("searchTeacher");
		
		ITutorialService iTutorialService = new TutorialServiceImpl();
		Tutorial tutorial = iTutorialService.getTeacherByName(teacherName);
		
		String subjectCode = tutorial.getSubjectCode();
		String teacherId = tutorial.getTeacherId();
		
		if(teacherId!=null && subjectCode!=null) {
		
				System.out.println("teacher id : " + teacherId + "subject code : " + subjectCode);
				
				Anu_ISubjectService iSubjectService = new Anu_SubjectServiceImpl();
				Anu_Subject subject = iSubjectService.getSubjectById(subjectCode);
				
				String subjectName = subject.getSubjectName();
				String level = subject.getLevel();
				String medium = subject.getMedium();
				
				System.out.println("subject name : " + subjectName);
				
				tutorial.setSubjectCode(subjectCode);
				tutorial.setTeacherId(teacherId);
				tutorial.setSubjectName(subjectName);
				tutorial.setLevel(level);
				tutorial.setMedium(medium);		
				
				ITutorialService iTutorialService1 = new TutorialServiceImpl();
				ArrayList<Tutorial> tutorials = iTutorialService1.getTutorialsById(teacherId);
				
				ITutorialService iTutorialService2 = new TutorialServiceImpl();
				Tutorial tutorial1 = iTutorialService2.getTheNewestTutorial(tutorial);
				
				String tutorialId =  tutorial1.getTutorialId();
				String tutorialName = tutorial1.getTutorialTitle();				

				tutorial.setTutorialId(tutorialId);
				tutorial.setTutorialTitle(tutorialName);
				
				System.out.println("Search newest tute id : " + tutorialId + "tute name :" + tutorialName);
				
				IAnswerSheetService iAnswerSheetService = new AnswerSheetServiceImpl();
				ArrayList<AnswerSheet> answerSheets = iAnswerSheetService.getAnswerSheetsById(teacherId);
				
				request.setAttribute("tutorial", tutorial);
				
				request.setAttribute("answerSheets", answerSheets);
				
				request.setAttribute("tutorials", tutorials);
				
				String teacherStatus = request.getParameter("teacher");
				System.out.println("Search teacher status : " + teacherStatus + "subject code " + tutorial.getSubjectCode());
				
				if(teacherStatus.contentEquals("true")) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacher_tutorial_main.jsp");
					dispatcher.forward(request, response);
					
				}
				
				else if (teacherStatus.contentEquals("false")) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Student_tutorial_main.jsp");
					dispatcher.forward(request, response);			
					
				}
				
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Anu_SearchedItemNotFound.jsp");
			dispatcher.forward(request, response);	
		}
			
	}

}
