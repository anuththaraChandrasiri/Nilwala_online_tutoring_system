package Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import Model.Anu_Subject;

public interface Anu_ISubjectService {
	
	public static final Logger Log = Logger.getLogger(Anu_ISubjectService.class.getName()) ;
	
	public Anu_Subject getSubjectById(String subjectCode) ;
	
	public ArrayList<Anu_Subject> getSubjects() ;
	
	public ArrayList<Anu_Subject> OLSinhalaSubjects() ;
	
	public ArrayList<Anu_Subject> OLEnglishSubjects() ;
	
	public ArrayList<Anu_Subject> ALSinhalaSubjects() ;
	
	public ArrayList<Anu_Subject> ALEnglishSubjects() ;

}
