package com.sergi.C4_TA22_PT1.utils;

import com.sergi.C4_TA22_PT1.model.DbConnection;

public class PopulateDatabase {
	
	//the first time it creates the database and fill it with sample data
	public static void populateDatabaseIfNotExists() {
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		
		//opens connection to mysql database
		connection.openConnection();
		
		//connection.dropDatabase();
		
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
		}
		//it closes the connection
		connection.closeConnection();	
	}
}
