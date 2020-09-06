package Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import Model.Tutorial;

public interface ITutorialService {
	
	public static final Logger Log = Logger.getLogger(ITutorialService.class.getName()) ;
	
	public void addTutorial(Tutorial tutorial) ;
	
	public Tutorial getTutorialById(String tutorialId) ;
	
	public ArrayList<Tutorial> getTutorials() ;
	
	public Tutorial updateTutorial(String tutorialId, Tutorial tutorial) ;
	
	public void deleteTutorial(String tutorialId) ;

}
