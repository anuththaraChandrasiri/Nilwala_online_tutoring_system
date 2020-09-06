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
	
	@Override
	public void addTutorial(Tutorial tutorial) {
		
		String tutorialID = generateIDs(getTutorialIDs());
		String query = "insert into tutorials (teacher_id, subject_code, tute_id,  title, date_added,  month, material) values (?, ?, ?, ?, ?, ?, ?)" ;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			System.out.println("Before the insertion");
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			System.out.println("Did you insert?");
			
			//Generate tutorial IDs
			tutorial.setTutorialId(tutorialID);
			preparedStatement.setString(1, tutorial.getTeacherId());
			preparedStatement.setString(2, tutorial.getSubjectCode());
			preparedStatement.setString(3, tutorial.getTutorialId());
			preparedStatement.setString(4, tutorial.getTutorialTitle());
			preparedStatement.setString(5, tutorial.getDateAdded());
			preparedStatement.setString(6, tutorial.getMonth());
			preparedStatement.setString(7, tutorial.getMaterial());
			System.out.println("Inserted!");
			System.out.println(tutorial.getTeacherId() + " " + tutorial.getSubjectCode() + " " +  tutorial.getTutorialId()  );
			
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
				
				preparedStatement.setString(1, tutorial.getTeacherId());
				preparedStatement.setString(2, tutorial.getSubjectCode());
				preparedStatement.setString(3, tutorial.getTutorialTitle());
				preparedStatement.setString(4, tutorial.getDateAdded());
				preparedStatement.setString(5, tutorial.getMonth());
				preparedStatement.setString(6, tutorial.getMaterial());
				preparedStatement.setString(7, tutorialId);
				
				preparedStatement.executeUpdate();
				System.out.println("Done!");
				
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
			System.out.println("Got the id");
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
					tutorial.setMaterial(resultSet.getString(1));
					tutorial.setMonth(resultSet.getString(2));
					tutorial.setDateAdded(resultSet.getString(3));
					tutorial.setTutorialTitle(resultSet.getString(4));
					tutorial.setTutorialId(resultSet.getString(5));
					tutorial.setSubjectCode(resultSet.getString(6));
					tutorial.setTeacherId(resultSet.getString(7));
					
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
}
