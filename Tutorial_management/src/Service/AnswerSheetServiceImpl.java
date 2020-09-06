package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import Model.AnswerSheet;
import Util.DBConnectionUtil;

public class AnswerSheetServiceImpl implements IAnswerSheetService {
	
	private static Connection connection;
	
	private PreparedStatement preparedStatement;
	
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = "200" + next;
		if (arrayList.contains(id)) {
			next++;
			id = "200" + next;
		}
		return id;
	}	

	@Override
	public void addAnswerSheet(AnswerSheet answerSheet) {
		
		String answerSheetID = generateIDs(getAnswerSheetIDs());
		String query = "insert into answer_sheet (teacher_id, subject_code, tute_id,  sheet_id, date_added,  sheet_name, material) values (?, ?, ?, ?, ?, ?, ?)" ;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			System.out.println("Before the insertion");
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			System.out.println("Did you insert?");
			
			//Generate Answer sheet IDs
			answerSheet.setSheet_id(answerSheetID);
			preparedStatement.setString(1, answerSheet.getTeacher_id());
			preparedStatement.setString(2, answerSheet.getSubject_code());
			preparedStatement.setString(3, answerSheet.getTute_id());
			preparedStatement.setString(4, answerSheet.getSheet_id());
			preparedStatement.setString(5, answerSheet.getDate_added());
			preparedStatement.setString(6, answerSheet.getSheet_name());
			preparedStatement.setString(7, answerSheet.getMaterial());
			System.out.println("Inserted!");
			System.out.println(answerSheet.getTeacher_id() + " " + answerSheet.getSubject_code() + " " +  answerSheet.getTute_id()  );
			
			// Add answer sheet
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
	public AnswerSheet getAnswerSheetById(String answerSheetId) {
	
		return actionOnAnswerSheet(answerSheetId).get(0);	
	}

	@Override
	public ArrayList<AnswerSheet> getAnswerSheets() {
		
		return actionOnAnswerSheet(null);
	}

	@Override
	public AnswerSheet updateAnswerSheet(String answerSheetId, AnswerSheet answerSheet) {
		
		System.out.println(answerSheetId);
		String query = "update answer_sheet as a set a.teacher_id = ?, a.subject_code = ?, a.tute_id = ?, a.date_added = ?, a.sheet_name = ?, a.material = ? where a.sheet_id = ?";
		
			/*
			 * Before fetching answer sheet it checks whether answerSheetID is available
			 */
			if (answerSheetId!= null && !answerSheetId.isEmpty()) {
				
				try {				
													
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(query);
					
					preparedStatement.setString(1, answerSheet.getTeacher_id());
					preparedStatement.setString(2, answerSheet.getSubject_code());
					preparedStatement.setString(3, answerSheet.getTute_id());
					preparedStatement.setString(4, answerSheet.getDate_added());
					preparedStatement.setString(5, answerSheet.getSheet_name());
					preparedStatement.setString(6, answerSheet.getMaterial());
					preparedStatement.setString(7, answerSheetId);
					
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
			// Get the updated answer sheet
			return getAnswerSheetById(answerSheetId);	
	}

	@Override
	public void deleteAnswerSheet(String answerSheetId) {
		
    String query = "delete from answer_sheet where answer_sheet.sheet_Id = ?" ;
		
		// Before deleting check whether the answerSheetID is available
		if (answerSheetId!= null && !answerSheetId.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(query);
				preparedStatement.setString(1, answerSheetId);
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
	
	private ArrayList<String> getAnswerSheetIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		String query = "select a.sheet_Id from answer_sheet as a" ;
		
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

		
	private ArrayList<AnswerSheet> actionOnAnswerSheet(String answerSheetID) {
			
			String query1 = "select * from answer_sheet where answer_sheet.sheet_id = ?" ;
			String query2 = "select * from answer_sheet order by answer_sheet.sheet_id " ;

			ArrayList<AnswerSheet> answerSheetList = new ArrayList<AnswerSheet>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				/*
				 * Before fetching tutorial it checks whether answerSheetID is
				 * available
				 */
				if (answerSheetID!= null && !answerSheetID.isEmpty()) {
					
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, answerSheetID);
				}
				/*
				 * If answerSheetID is not provided it displays all answer sheets
				 */
				else {
					preparedStatement = connection.prepareStatement(query2);
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					AnswerSheet answerSheet = new AnswerSheet();
					answerSheet.setTeacher_id(resultSet.getString(1));
					answerSheet.setSubject_code(resultSet.getString(2));
					answerSheet.setTute_id(resultSet.getString(3));
					answerSheet.setSheet_id(resultSet.getString(4));
					answerSheet.setDate_added(resultSet.getString(5));
					answerSheet.setSheet_name(resultSet.getString(6));
					answerSheet.setMaterial(resultSet.getString(7));
										
					answerSheetList.add(answerSheet);
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
			return  answerSheetList;
		}
}


