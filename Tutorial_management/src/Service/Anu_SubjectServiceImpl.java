package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import Model.Anu_Subject;
import Util.DBConnectionUtil;

public class Anu_SubjectServiceImpl implements Anu_ISubjectService {
	
	private static Connection connection;
	
	private PreparedStatement preparedStatement;
		

	@Override
	public Anu_Subject getSubjectById(String subjectCode) {
		
		return actionOnSubject(subjectCode).get(0);	
	}

	@Override
	public ArrayList<Anu_Subject> getSubjects() {
	
		return actionOnSubject(null);
	}
	
	private ArrayList<Anu_Subject> actionOnSubject(String subjectCode) {
		
		String query1 = "select * from subject where subject.subject_code = ?" ;
		String query2 = "select * from subject order by subject_code" ;

		ArrayList<Anu_Subject> subjectList = new ArrayList<Anu_Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching subject it checks whether subject code is
			 * available
			 */
			if (subjectCode!= null && !subjectCode.isEmpty()) {
				
				preparedStatement = connection.prepareStatement(query1);
				preparedStatement.setString(1, subjectCode);
			}
			/*
			 * If subject code is not provided it displays all subjects
			 */
			else {
				preparedStatement = connection.prepareStatement(query2);
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Subject subject = new Anu_Subject();
				subject.setSubjectCode(resultSet.getString(1));
				subject.setSubjectName(resultSet.getString(2));
				subject.setLevel(resultSet.getString(3));
				subject.setMedium(resultSet.getString(4));
								
				subjectList.add(subject);
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
		return subjectList;
	}

	public ArrayList<Anu_Subject> OLSinhalaSubjects() {
		
		String query1 = "select * from subject where level ='OL' and medium = 'Sinhala' " ;

		ArrayList<Anu_Subject> subjectList = new ArrayList<Anu_Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query1);
		
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Subject subject = new Anu_Subject();
				subject.setSubjectCode(resultSet.getString(1));
				subject.setSubjectName(resultSet.getString(2));
				subject.setLevel(resultSet.getString(3));
				subject.setMedium(resultSet.getString(4));
								
				subjectList.add(subject);
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
		return subjectList;
	}

	public ArrayList<Anu_Subject> OLEnglishSubjects() {
		
		String query1 = "select * from subject where level ='OL' and medium = 'English' " ;

		ArrayList<Anu_Subject> subjectList = new ArrayList<Anu_Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query1);
		
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Subject subject = new Anu_Subject();
				subject.setSubjectCode(resultSet.getString(1));
				subject.setSubjectName(resultSet.getString(2));
				subject.setLevel(resultSet.getString(3));
				subject.setMedium(resultSet.getString(4));
								
				subjectList.add(subject);
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
		return subjectList;
	}
	
	public ArrayList<Anu_Subject> ALSinhalaSubjects() {
		
		String query1 = "select * from subject where level ='AL' and medium = 'Sinhala' " ;

		ArrayList<Anu_Subject> subjectList = new ArrayList<Anu_Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query1);
		
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Subject subject = new Anu_Subject();
				subject.setSubjectCode(resultSet.getString(1));
				subject.setSubjectName(resultSet.getString(2));
				subject.setLevel(resultSet.getString(3));
				subject.setMedium(resultSet.getString(4));
								
				subjectList.add(subject);
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
		return subjectList;
	}
	
	public ArrayList<Anu_Subject> ALEnglishSubjects() {
		
		String query1 = "select * from subject where level ='AL' and medium = 'English' " ;

		ArrayList<Anu_Subject> subjectList = new ArrayList<Anu_Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(query1);
		
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Anu_Subject subject = new Anu_Subject();
				subject.setSubjectCode(resultSet.getString(1));
				subject.setSubjectName(resultSet.getString(2));
				subject.setLevel(resultSet.getString(3));
				subject.setMedium(resultSet.getString(4));
								
				subjectList.add(subject);
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
		return subjectList;
	}



}
