package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import Model.Anu_Teacher;
import Util.DBConnectionUtil;

public class Anu_TeacherServiceImpl implements Anu_ITeacherService {
	
	private static Connection connection;
	
	private PreparedStatement preparedStatement;
		

	@Override
	public ArrayList<Anu_Teacher> getTeacherById(String subjectCode) {
		
		return actionOnTeacher(subjectCode);	
	}

	@Override
	public ArrayList<Anu_Teacher> getTeachers() {
	
		return actionOnTeacher(null);
	}
	
	private ArrayList<Anu_Teacher> actionOnTeacher(String subjectCode) {
		
		String code = subjectCode ;
		System.out.println(code);
		
		String query1 = "select * from teacher_subject ts where ts.subject_code = ? ";
		//String query1 = "select ts.teacher_id, u.first_name+u.last_name from teacher t,user u,teacher_subject ts where t.teacher_id = ts.teacher_id and ts.teacher_id = u.user_id and ts.subject_code = ?" ;
		String query2 = "select * from teacher_subject ts order by ts.teacher_id " ;

		ArrayList<Anu_Teacher> teacherList = new ArrayList<Anu_Teacher>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching subject it checks whether subject code is
			 * available
			 */
			if (subjectCode!= null && !subjectCode.isEmpty()) {
				
				preparedStatement = connection.prepareStatement(query1);
				System.out.println(subjectCode+" before assign inside action");
				preparedStatement.setString(1, code);
				System.out.println(subjectCode+" before assign inside action");
			}
			/*
			 * If subject code is not provided it displays all subjects
			 */
			else {
				preparedStatement = connection.prepareStatement(query2);
				System.out.println("damn");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Teacher teacher = new Anu_Teacher();
				teacher.setTeacherID(resultSet.getString(1));
				teacher.setSubjectCode(resultSet.getString(2));
				teacher.setGrade(resultSet.getString(3));
				teacher.setTeacherName(resultSet.getString(4));
												
				teacherList.add(teacher);
			}

		} catch (SQLException | ClassNotFoundException e) {
			Log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
		return teacherList;
	}
}
