package Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import Model.AnswerSheet;


public interface IAnswerSheetService {
	
public static final Logger Log = Logger.getLogger(IAnswerSheetService.class.getName()) ;
	
	public void addAnswerSheet(AnswerSheet answerSheet) ;
	
	public AnswerSheet getAnswerSheetById(String answerSheetId) ;
	
	public ArrayList<AnswerSheet> getAnswerSheets() ;
	
	public AnswerSheet updateAnswerSheet(String answerSheetId, AnswerSheet answerSheet) ;
	
	public void deleteAnswerSheet(String answerSheetId) ;

}
