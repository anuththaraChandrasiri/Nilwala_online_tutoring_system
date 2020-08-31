package Service;

import java.util.ArrayList;
import com.sun.istack.internal.logging.Logger;
import Model.Tutorial;

public interface ITutorialService {
	
	public static final Logger Log = Logger.getLogger(ITutorialService.class.getName(), null) ;
	
	public void addTutorial(Tutorial tutorial) ;
	
	public Tutorial getTutorialById(String tutorialId) ;
	
	public ArrayList<Tutorial> getTutorials() ;//Will it be useful?
	
	public Tutorial updateTutorial(String tutorialId, Tutorial tutorial) ;
	
	public void deleteTutorial(String tutorialId) ;	

}
