package Service;

import java.util.ArrayList;
import java.util.logging.Logger;
import Model.Anu_Teacher;

public interface Anu_ITeacherService {
	
	public static final Logger Log = Logger.getLogger(Anu_ITeacherService.class.getName()) ;

	public ArrayList<Anu_Teacher> getTeacherById(String teacherID) ;
	
	public ArrayList<Anu_Teacher> getTeachers() ;

}
