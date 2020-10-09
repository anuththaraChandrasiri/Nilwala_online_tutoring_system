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
		String query = "insert into tutorials (teacher_id, subject_code, tute_id,  title, date_added,  month, material) values (?, ?, ?, ?, ?, ?, ?)" ;
		System.out.println(tutorial.getDateAdded()+"date");
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			
			System.out.println(tutorial.getSubjectCode()+"code" +tutorial.getTeacherId()+" tid ");
						
			//Generate tutorial IDs
			tutorial.setTutorialId(tutorialID);
			preparedStatement.setString(1, tutorial.getTeacherId());
			preparedStatement.setString(2, tutorial.getSubjectCode());
			preparedStatement.setString(3, tutorial.getTutorialId());
			preparedStatement.setString(4, tutorial.getTutorialTitle());
			preparedStatement.setString(5, tutorial.getDateAdded());
			preparedStatement.setString(6, tutorial.getMonth());
			preparedStatement.setString(7, tutorial.getMaterial());
						
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
		
	String query = "update tutorials as t set t.teacher_id = ?, t.subject_code = ?, t.title = ?, t.date_added = ?, t.month = ?, t.material = ? where t.tute_id = ?";
	
		/*
		 * Before fetching tutorial it checks whether tutorialID is available
		 */
		if (tutorialId != null && !tutorialId.isEmpty()) {
			
			try {				
												
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(query);
				
				System.out.println(tutorial.getMaterial());
				System.out.println(tutorial.getDateAdded());
				
				preparedStatement.setString(1, tutorial.getTeacherId());
				preparedStatement.setString(2, tutorial.getSubjectCode());
				preparedStatement.setString(3, tutorial.getTutorialTitle());
				preparedStatement.setString(4, tutorial.getDateAdded());
				preparedStatement.setString(5, tutorial.getMonth());
				preparedStatement.setString(6, tutorial.getMaterial());
				preparedStatement.setString(7, tutorialId);
				
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
		System.out.println(tutorialId+" tuteId ");
		
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
					System.out.println("Correct");
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
					tutorial.setMonth(resultSet.getString(6));
					tutorial.setMaterial(resultSet.getString(7));
					
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
					tutorial.setMonth(resultSet.getString(6));
					tutorial.setMaterial(resultSet.getString(7));
										
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
						System.out.println(question_no + " question number");
						
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
				/*
				 * Before fetching tutorial it checks whether tutorial ID is
				 * available
				 */
				if (tutorialId!= null && !tutorialId.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, tutorialId);
					System.out.println("Correct");
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
					tutorial.setQuestionNo(Integer.parseInt(resultSet.getString(1)));
					tutorial.setCount(Integer.parseInt(resultSet.getString(2)));
										
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
