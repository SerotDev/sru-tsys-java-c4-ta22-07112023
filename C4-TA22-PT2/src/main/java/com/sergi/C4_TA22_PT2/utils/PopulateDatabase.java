package com.sergi.C4_TA22_PT2.utils;

import com.sergi.C4_TA22_PT2.model.DbConnection;

public class PopulateDatabase {
	//the first time it creates the database and fill it with sample data
	public static void populateDatabaseIfNotExists() {
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		
		//opens connection to mysql database
		connection.openConnection();
		
		//connection.dropDatabase(); //it deletes the database to create a new one and fill it later
		
		//if database not exists
		if (!connection.databaseExists()) {
			
			//it create the database
			connection.createDatabase();
			
			//create table clientes
			connection.createTable("clientes",""
					+ "id INT(11) AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(250) DEFAULT NULL,"
					+ "apellido VARCHAR(250) DEFAULT NULL,"
					+ "direccion VARCHAR(250) DEFAULT NULL,"
					+ "dni VARCHAR(9) DEFAULT NULL,"
					+ "fecha DATE DEFAULT NULL");
			
			//it fills the table clientes with data
			connection.insertData("clientes",""
					+ "(\"Carla\", \"Filipendrios Martinez\", \"C/ Pepesonia 333\", \"45178254X\", \"1998-12-02\"),"
					+ "(\"Josep\", \"Ramirez Perez\", \"C/ Joselito 129\", \"23597823X\", \"1997-09-22\"),"
					+ "(\"Felipe\", \"Clavos Pinos\", \"C/ Sin nombre 7\", \"32809158C\", \"2000-07-12\"),"
					+ "(\"Antonia\", \"Fumar Mata\", \"C/ Alegria 55\", \"38074332N\", \"1991-04-09\"),"
					+ "(\"Alberto\", \"Lopez Serrano\", \"C/ Disgustos 1A\", \"59863256P\", \"1999-05-10\"),"
					+ "(\"Sergi\", \"Rodriguez Utge\", \"C/ MySql de Miamol 1\", \"13256898V\", \"1995-02-11\"),"
					+ "(\"Joan\", \"Puig Feliu\", \"C/ Calle 15\", \"76957689V\", \"2002-06-20\")");
			
			//create table videos
			connection.createTable("videos",""
					+ "id INT(11) AUTO_INCREMENT PRIMARY KEY,"
					+ "title VARCHAR(250) DEFAULT NULL,"
					+ "director VARCHAR(250) DEFAULT NULL,"
					+ "cli_id INT(11) DEFAULT NULL,"
					+ "FOREIGN KEY (cli_id) REFERENCES clientes (id) ON DELETE CASCADE ON UPDATE SET NULL");
			
			//inserts of videos data
			connection.insertData("videos", ""
			        + "(1, \"Título del Video 1\", \"Director 1\", 1),"
			        + "(2, \"Título del Video 2\", \"Director 2\", 2),"
			        + "(3, \"Título del Video 3\", \"Director 3\", 3),"
			        + "(4, \"Título del Video 4\", \"Director 4\", 4),"
			        + "(5, \"Título del Video 5\", \"Director 5\", 5),"
			        + "(6, \"Título del Video 6\", \"Director 6\", 6),"
			        + "(7, \"Título del Video 7\", \"Director 7\", 7)");
		}
		//it closes the connection
		connection.closeConnection();	
	}
}
