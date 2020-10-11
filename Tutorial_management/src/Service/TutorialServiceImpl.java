package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import Model.Tutorial;
import Util.DBConnectionUtil;

public class TutorialServiceImpl implements ITutorialService {
	
	private static Connection connection;
	
	private PreparedStatement preparedStatement;
		
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = "100" + next;
		if (arrayList.contains(id)) {
			next++;
			id = "100" + next;
		}
		return id;
	}	
	
	public static String generateForumIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = "1" + next;
		if (arrayList.contains(id)) {
			next++;
			id = "1" + next;
		}
		return id;
	}	
	
	@Override
	public void addTutorial(Tutorial tutorial) {
		
		String tutorialID = generateIDs(getTutorialIDs());
		String query = "insert into tutorials (teacher_id, subject_code, tute_id,  title, date_added, material) values (?, ?, ?, ?, ?, ?)" ;
				
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
		
			//Generate tutorial IDs
			tutorial.setTutorialId(tutorialID);
			preparedStatement.setString(1, tutorial.getTeacherId());
			preparedStatement.setString(2, tutorial.getSubjectCode());
			preparedStatement.setString(3, tutorial.getTutorialId());
			preparedStatement.setString(4, tutorial.getTutorialTitle());
			preparedStatement.setString(5, tutorial.getDateAdded());
			preparedStatement.setString(6, tutorial.getMaterial());
						
			// Add tutorial
			preparedStatement.execute();
			connection.commit();

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
	}

	@Override
	public Tutorial getTutorialById(String tutorialId) {
		
		return actionOnTutorial(tutorialId).get(0);	
		
	}
	
	@Override
	public ArrayList<Tutorial> getTutorialsById(String teacherId) {
		
		return TutorialsByTeacherId(teacherId);	
		
	}

	@Override
	public ArrayList<Tutorial> getTutorials() {
		
		return actionOnTutorial(null);
				
	}

	@Override
	public Tutorial updateTutorial(String tutorialId, Tutorial tutorial) {
		
	String query = "update tutorials as t set t.teacher_id = ?, t.subject_code = ?, t.title = ?, t.date_added = ?, t.material = ? where t.tute_id = ?";
	
		/*
		 * Before fetching tutorial it checks whether tutorialID is available
		 */
		if (tutorialId != null && !tutorialId.isEmpty()) {
			
			try {				
												
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(query);
							
				preparedStatement.setString(1, tutorial.getTeacherId());
				preparedStatement.setString(2, tutorial.getSubjectCode());
				preparedStatement.setString(3, tutorial.getTutorialTitle());
				preparedStatement.setString(4, tutorial.getDateAdded());
				preparedStatement.setString(5, tutorial.getMaterial());
				preparedStatement.setString(6, tutorialId);
				
				preparedStatement.executeUpdate();
								
			} catch (SQLException | ClassNotFoundException e) {
				Log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
		}
		// Get the updated tutorial
		return getTutorialById(tutorialId);		
	}

	@Override
	public void deleteTutorial(String tutorialId) {
		
		String query = "delete from tutorials where tutorials.tute_Id = ?" ;
		
		// Before deleting check whether the tutorial ID is available
		if (tutorialId!= null && !tutorialId.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(query);
				preparedStatement.setString(1, tutorialId);
				preparedStatement.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
				Log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
		}	
	}
	
		private ArrayList<String> getTutorialIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		String query = "select t.tute_Id from tutorials as t" ;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(query);
			
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
				arrayList.add(resultSet.getString(1));
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
			return arrayList;
		}
		
		private ArrayList<String> getForumIDs(){
			
			ArrayList<String> arrayList = new ArrayList<String>();
			String query = "select t.tute_Id from tutorials as t" ;
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(query);
				
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
					arrayList.add(resultSet.getString(1));
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
				return arrayList;
			}
		
		private ArrayList<Tutorial> TutorialsByTeacherId(String teacherID) {
			
			String query1 = "select * from tutorials where tutorials.teacher_id = ?" ;
			String query2 = "select * from tutorials order by tutorials.tute_id " ;

			ArrayList<Tutorial> tutorialList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				/*
				 * Before fetching tutorial it checks whether tutorial ID is
				 * available
				 */
				if (teacherID!= null && !teacherID.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, teacherID);
			
				}
				/*
				 * If tutorial ID is not provided it displays all tutorials
				 */
				else {
					preparedStatement = connection.prepareStatement(query2);
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					Tutorial tutorial = new Tutorial();
					tutorial.setTeacherId(resultSet.getString(1));
					tutorial.setSubjectCode(resultSet.getString(2));
					tutorial.setTutorialId(resultSet.getString(3));
					tutorial.setTutorialTitle(resultSet.getString(4));
					tutorial.setDateAdded(resultSet.getString(5));
					tutorial.setMaterial(resultSet.getString(6));
					
					tutorialList.add(tutorial);
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
			return tutorialList;
		}
		
		private ArrayList<Tutorial> actionOnTutorial(String tutorialID) {
			
			String query1 = "select * from tutorials where tutorials.tute_id = ?" ;
			String query2 = "select * from tutorials order by tutorials.tute_id " ;

			ArrayList<Tutorial> tutorialList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				/*
				 * Before fetching tutorial it checks whether tutorial ID is
				 * available
				 */
				if (tutorialID!= null && !tutorialID.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, tutorialID);
				}
				/*
				 * If tutorial ID is not provided it displays all tutorials
				 */
				else {
					preparedStatement = connection.prepareStatement(query2);
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					Tutorial tutorial = new Tutorial();
					tutorial.setTeacherId(resultSet.getString(1));
					tutorial.setSubjectCode(resultSet.getString(2));
					tutorial.setTutorialId(resultSet.getString(3));
					tutorial.setTutorialTitle(resultSet.getString(4));
					tutorial.setDateAdded(resultSet.getString(5));
					tutorial.setMaterial(resultSet.getString(6));
										
					tutorialList.add(tutorial);
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
			return tutorialList;
		}

		@Override
		public void addQuestions(Tutorial tutorial) {
			
			String questions[] = tutorial.getQuestions();
			String forumID = generateForumIDs(getForumIDs());	
			tutorial.setForumId(forumID);
			String question_no;
			String query = "insert into qforum (forum_id, student_id, tute_id, teacher_id, subject_code, question_no) values (?, ?, ?, ?, ?, ?)" ;
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(query);
				connection.setAutoCommit(false);
				
				for(int i = 0 ; i < questions.length ; i ++) {
					
					if(questions[i]!=null) {
						
						question_no = questions[i];	
												
						preparedStatement.setString(1, tutorial.getForumId());
						preparedStatement.setString(2, tutorial.getStudentId());
						preparedStatement.setString(3, tutorial.getTutorialId());
						preparedStatement.setString(4, tutorial.getTeacherId());
						preparedStatement.setString(5, tutorial.getSubjectCode());
						preparedStatement.setString(6, question_no);						
						
						preparedStatement.execute();					
						
					}					
						
				}			

				connection.commit();	
				
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
		}

		@Override
		public ArrayList<Tutorial> getQuestionNumbersByTutorialId(String tutorialId) {
			
			String query1 = "select question_no, count(student_id) as qcount from qforum where qforum.tute_id = ? group by question_no order by qcount DESC" ;
			String query2 = "select * from qforum order by qforum.forum_id " ;

			ArrayList<Tutorial> questionList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (tutorialId!= null && !tutorialId.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, tutorialId);
					System.out.println("Correct");
				}
				
				else {
					preparedStatement = connection.prepareStatement(query2);
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					Tutorial tutorial = new Tutorial();
					tutorial.setQuestionNo(Integer.parseInt(resultSet.getString(1)));
					tutorial.setCount(Integer.parseInt(resultSet.getString(2)));
										
					questionList.add(tutorial);
				}

			} catch (SQLException | ClassNotFoundException e) {
				Log.log(Level.SEVERE, e.getMessage());
			} finally {
				
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
			return questionList;
		}

		@Override
		public Tutorial getTeacherByName(String teacherName) {
			
			return actionOnTeacherSubject(teacherName).get(0);
		}
		
		private ArrayList<Tutorial> actionOnTeacherSubject(String teacherName) {
			
			String query1 = "select * from teacher_subject where teacher_subject.teacher_name like '%"+teacherName+"%' " ;
			String query2 = "select * from teacher_subject order by teacher_subject.teacher_id " ;
			
			ArrayList<Tutorial> teacherDetailsList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (teacherName!= null && !teacherName.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
				
				}
				
				else {
					preparedStatement = connection.prepareStatement(query2);
				}
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
						
						Tutorial tutorial = new Tutorial();
						tutorial.setTeacherId(resultSet.getString(1));
						tutorial.setSubjectCode(resultSet.getString(2));
						tutorial.setGrade(Integer.parseInt(resultSet.getString(3)));
						tutorial.setTeacherName(resultSet.getString(4));
																
						teacherDetailsList.add(tutorial);
				}
				
				if(!resultSet.next()) {
				
						Tutorial tutorial = new Tutorial();
						tutorial.setTeacherId(null);
						tutorial.setSubjectCode(null);
						tutorial.setGrade(0);
						tutorial.setTeacherName(null);
																
						teacherDetailsList.add(tutorial);
					
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
			return teacherDetailsList;
		}

		@Override
		public Tutorial getTheNewestTutorial(Tutorial tutorial) {
			
			return getTheNewestTuteDetails(tutorial).get(0);
		}
		
		private ArrayList<Tutorial> getTheNewestTuteDetails(Tutorial tutorial1) {
			
			String teacherId = tutorial1.getTeacherId() ;
			String subjectCode = tutorial1.getSubjectCode() ;	
						
			String query1 = "select teacher_id, subject_code, MAX(tute_id), title, date_added, material from tutorials where tutorials.teacher_id = "+teacherId+" and tutorials.subject_code = "+subjectCode+"";
					
			ArrayList<Tutorial> tutorialList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (teacherId!= null && !teacherId.isEmpty() && subjectCode!= null && !subjectCode.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
		
				}
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					Tutorial tutorial = new Tutorial();
										
					tutorial.setTeacherId(resultSet.getString(1));
					tutorial.setSubjectCode(resultSet.getString(2));
					tutorial.setTutorialId(resultSet.getString(3));
					tutorial.setTutorialTitle(resultSet.getString(4));
					tutorial.setDateAdded(resultSet.getString(5));
					tutorial.setMaterial(resultSet.getString(6));
										
					tutorialList.add(tutorial);
									
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
			return tutorialList;
		}
		
		@Override
		public int checkStudentCountForAforum(Tutorial tutorial) {
			
			Tutorial tutorial1 = actionOnQForum(tutorial).get(0); 
			int studentCount = tutorial1.getStudentCount();
			
			return studentCount;
		}

		@Override
		public boolean checkStudentIdInQforum(Tutorial tutorial) {
			
			Tutorial tutorial1 = actionOnQForum(tutorial).get(0); 
			String studentId = tutorial1.getStudentId();
			String tutorialId = tutorial1.getTutorialId();
			
			if(studentId!=null && !studentId.isEmpty() && tutorialId!=null && !tutorialId.isEmpty())		
				return true;
			
			else
				return false;
			
		}
		
		private ArrayList<Tutorial> actionOnQForum(Tutorial tutorial1) {
			
			String studentId = tutorial1.getStudentId();
			String tutorialId = tutorial1.getTutorialId();
			String teacherId = tutorial1.getTeacherId();
			
			String query1 = "select qforum.student_id, qforum.tute_id, count(question_no) as qcount from qforum where qforum.student_id = "+studentId+" and qforum.tute_id = "+tutorialId+" group by student_id" ;
			String query2 = "select qforum.student_id, qforum.tute_id, count( DISTINCT student_id) as scount from qforum where qforum.teacher_id = "+teacherId+" and qforum.tute_id = "+tutorialId+" group by forum_id" ;
			
			ArrayList<Tutorial> questionList = new ArrayList<Tutorial>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (studentId!= null && !studentId.isEmpty() && tutorialId!= null && !tutorialId.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
				
				}
				
				else if (studentId== null && tutorialId!= null && !tutorialId.isEmpty() && teacherId!=null && !teacherId.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query2);
				
				}
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
						
						System.out.println("Found student..");
						Tutorial tutorial = new Tutorial();
						
						tutorial.setStudentId(resultSet.getString(1));
						tutorial.setTutorialId(resultSet.getString(2));
						tutorial.setStudentCount(Integer.parseInt(resultSet.getString(3)));
											
						questionList.add(tutorial);
						
				}
				
				if(!resultSet.next()) {
					
						Tutorial tutorial = new Tutorial();
						tutorial.setStudentId(null);
						tutorial.setTutorialId(null);
						tutorial.setCount(0);
											
						questionList.add(tutorial);
					
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
			return questionList;
		}
		
}
