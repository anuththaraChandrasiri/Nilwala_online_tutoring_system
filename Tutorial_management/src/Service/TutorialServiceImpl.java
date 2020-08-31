package Service;

import java.util.ArrayList;

import Model.Tutorial;

public class TutorialServiceImpl implements ITutorialService {
	

	@Override
	public void addTutorial(Tutorial tutorial) {
		
		
	}

	@Override
	public Tutorial getTutorialById(String tutorialId) {
		return null;		
		
	}

	@Override
	public ArrayList<Tutorial> getTutorials() {
		return null;
		
		
	}

	@Override
	public Tutorial updateTutorial(String tutorialId, Tutorial tutorial) {
		return tutorial;

		
	}

	@Override
	public void deleteTutorial(String tutorialId) {
		// Before deleting check whether employee ID is available
				
	}

}
