package com.sergi.C4_TA22_PT1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
	private Connection connection;
	
	//constants with connection params
	private final String HOST_DOT_ENV = "127.0.0.1";
	private final String PORT_DOT_ENV = "33060";
	private final String USER_DOT_ENV = "root";
	private final String PASSWORD_DOT_ENV = "password";
	private final String DATABASE_NAME = "Ejercicio1";
	
	/**
	 * Establish the connection to the MySQL server.
	 * 
	 * @throws ClassNotFoundException If class is not found
	 * @throws SQLException if it can't establish connection to MySQL.
	 */
	public void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://" + HOST_DOT_ENV + ":" + PORT_DOT_ENV + " ", USER_DOT_ENV, PASSWORD_DOT_ENV);
			System.out.println("\nConnected to MySQL server at " +  HOST_DOT_ENV + ":" + PORT_DOT_ENV);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("ERROR: Cant connect to MySQL server.\n" + e);
		}
	}
	
	/**
	 * It close the connection to the MySQL server.
	 * @throws SQLException if it can't close connection to MySQL.
	 */
	public void closeConnection() {
		try {
			this.connection.close();
			System.out.println("MySQL server conection at " + HOST_DOT_ENV + ":" + PORT_DOT_ENV + " closed.");
		} catch (SQLException e) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Cant close the connection to MySQL server.\n", e);
		}
	}
	
	/**
	 * This method creates a the database if not exists.
	 * 
	 */
	public void createDatabase() {
		try {
			Statement stdb = this.connection.createStatement();
			String query = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME + ";";
			stdb.executeUpdate(query);
			System.out.println("Database " + DATABASE_NAME + " created.");
		} catch (SQLException e) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Cant create the database " + DATABASE_NAME + "\n", e);
		}
	}
	
	/**
	 * This method deletes the database if exists.
	 * 
	 */
	public void dropDatabase() {
		try {
			Statement stdb = this.connection.createStatement();
			String query = "DROP DATABASE IF EXISTS " + DATABASE_NAME + ";";
			stdb.executeUpdate(query);
			System.out.println("Database " + DATABASE_NAME + " deleted in case of exists.");
		} catch (SQLException e) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Cant delete the database " + DATABASE_NAME + "\n", e);
		}
	}
	
	/**
	 * It tries to use the database. 
	 * 
	 * @param databaseName Name of the database to connect
	 */
	public void useDatabase() {
		try {
			String query = "USE " + DATABASE_NAME + ";";
			this.connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "ERROR: Cant use the database " + DATABASE_NAME + "\n", e);
		}
	}
	
	/**
	 * Checks if database is usable or not
	 * 
	 * @return boolean true if database exists or false if not exists (tries to use the database)
	 */
	public boolean databaseExists() {
		boolean dbExists = false;
		//we try to use the database, if we can use it is because it exists
		try {
			String query = "USE " + DATABASE_NAME + ";";
			this.connection.createStatement().executeUpdate(query);
			dbExists = true;
		} catch (Exception e) {
			dbExists = false;
		}
		return dbExists;
	}
	
	/**
	 * This method creates a specified table if not exists
	 * 
	 * @param tableName Name of the table to create
	 * @param tableConent Content of the table (columns)
	 */
	public void createTable(String tableName, String tableConent) {
		useDatabase();
		try {
			String query = "CREATE TABLE IF NOT EXISTS " + tableName + "(" + tableConent + ");";
			this.connection.createStatement().executeUpdate(query);
			System.out.println("Table " + tableName + " created.");
		} catch (SQLException e) {
			System.out.println("ERROR: Cant create the table " + tableName + "\n" + e);
		}
	}
	
	/**
	 * This method deletes a specified table if exists
	 * 
	 * @param tableName Name of the table to delete
	 */
	public void dropTable(String tableName) {
		useDatabase();
		try {
			String query = "DROP TABLE IF EXISTS" + tableName + ";";
			Statement sttb = this.connection.createStatement();
			sttb.executeUpdate(query);
			System.out.println("Table " + tableName + " deleted.");
		} catch (SQLException e) {
			System.out.println("ERROR: Cant delete the table " + tableName + "\n" + e);
		}
	}
	
	/**
	 * Inserts the data into a specified table
	 * 
	 * @param tableName Table name in the database to insert values
	 * @param values The values that will be inserted.
	 */
	public void insertData(String tableName, String values) {
		useDatabase();
		try {
			String query = "INSERT INTO " + tableName + " (" + getColumnsFromTable(tableName) + ") VALUES " + values + ";";
			this.connection.createStatement().executeUpdate(query);
			System.out.println("Data succesfuly inserted into table " + tableName);
		} catch (SQLException e) {
			System.out.println("ERROR: Cant insert data into table " + tableName + "\n" + e);
		}
	}
	
	/**
	 * It will update the specified values into a specified table.
	 * 
	 * @param tableName Table name in the database to update values
	 * @param valuesToSet The values that will be set. ex: columName = "value", columName2 = "value2" )
	 * @param condition The condition where the values will update (after WHERE).
	 */
	public void updateData(String tableName, String valuesToSet, String condition) {
		useDatabase();
		try {
			String query = "UPDATE " + tableName + " SET " + valuesToSet + " WHERE " + condition + ";";
			this.connection.createStatement().executeUpdate(query);
			System.out.println("Data succesfuly updated to " + valuesToSet + " from table " + tableName + " where " + condition);
		} catch (SQLException e) {
			System.out.println("ERROR: Cant update data from table " + tableName + "\n" + e);
		}
	}
	
	/**
	 * Delete values from table where condition
	 * 
	 * @param tableName Table name in the database to delete values
	 * @param condition The condition to delete values (after WHERE).
	 */
	public void deleteData(String tableName, String condition) {
		useDatabase();
		try {
			String query = "DELETE FROM " + tableName + " WHERE " + condition + ";";
			this.connection.createStatement().executeUpdate(query);
			System.out.println("Data succesfuly deleted from table " + tableName + " where " + condition);
		} catch (SQLException e) {
			System.out.println("ERROR: Cant delete data into table " + tableName + "\n" + e);
		}
	}

	/**
	 * This method gets the column names of a specified table without the auto-incrementals 
	 * 
	 * @param tableName Table name in the database to extract column names
	 * @return return a String of a table names separated with commas,
	 */
	public String getColumnsFromTable(String tableName) {
		useDatabase();
		String columns = "";
		try {
			String query = "SELECT * FROM " + tableName + " LIMIT 0"; // The LIMIT can be used when you want a specified number of rows from a result rather than the entire rows. 
			Statement st = this.connection.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			ResultSetMetaData tableContent = resultSet.getMetaData(); // Provides information about the obtained ResultSet object like, the number of columns, names of the columns, datatypes...
			for (int i = 1; i <= tableContent.getColumnCount(); i++) {
				if (!tableContent.isAutoIncrement(i)) {
					if (i != tableContent.getColumnCount()) {
						columns += tableContent.getColumnName(i) + "," ;
					} else {
						columns += tableContent.getColumnName(i);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: Can not get meta data column name fom table " + tableName);
		}

		return columns;
	}
	
	/**
	 * This method gets the content of an specified table dinamically. The values of the rows are arrays of String values
	 * and inserted into the ArrayList
	 * 
	 * @param tableName Name of the table to print the content
	 */
	public ArrayList<String[]> getTableContent(String tableName) {
		useDatabase();
		ArrayList<String[]> result = new ArrayList<String[]>();
		try {
			String query = "SELECT * FROM " + tableName;
			java.sql.ResultSet resultSet;
			resultSet = this.connection.createStatement().executeQuery(query);
			java.sql.ResultSetMetaData tableContent = resultSet.getMetaData();
			int numColumnas = tableContent.getColumnCount();
			while (resultSet.next()) {
				String row[] = new String[numColumnas];
				for (int i = 1; i <= numColumnas; i++) {
					row[i-1] = resultSet.getString(tableContent.getColumnName(i));
				}
				result.add(row);
			}
		} catch (SQLException e) {
			System.out.println("ERROR: Unable get the content from table " + tableName + "\n" + e);
		}
		return result;
	}
	
	/**
	 * This method gets the conditioned content of an specified table dinamically. The values of the rows are arrays of String values
	 * and inserted into the ArrayList
	 * 
	 * @param tableName Name of the table to print the content
	 * @param condition Condition in sql to get the filtred data
	 */
	public ArrayList<String[]> getTableContent(String tableName, String condition) {
		useDatabase();
		ArrayList<String[]> result = new ArrayList<String[]>();
		try {
			String query = "SELECT * FROM " + tableName + " " + condition;
			java.sql.ResultSet resultSet;
			resultSet = this.connection.createStatement().executeQuery(query);
			java.sql.ResultSetMetaData tableContent = resultSet.getMetaData();
			int numColumnas = tableContent.getColumnCount();
			while (resultSet.next()) {
				String row[] = new String[numColumnas];
				for (int i = 1; i <= numColumnas; i++) {
					row[i-1] = resultSet.getString(tableContent.getColumnName(i));
				}
				result.add(row);
			}
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to get the content from table " + tableName + "\n" + e);
		}
		return result;
	}
	
}
