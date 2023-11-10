package com.sergi.C4_TA22_PT3.utils;

import com.sergi.C4_TA22_PT3.model.DbConnection;

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
			
			//create table cientificos
			connection.createTable("cientificos",""
					+ "dni VARCHAR(9) PRIMARY KEY,"
					+ "nom_apels VARCHAR(255) NOT NULL");
			
			//it fills the table cientificos with data
			connection.insertData("cientificos",""
					+ "(\"12345678A\", \"Carla Filipendrios Martinez\"),"
					+ "(\"23456789B\", \"Josep Ramirez Perez\"),"
					+ "(\"34567890C\", \"Felipe Clavos Pinos\"),"
					+ "(\"45678901D\", \"Antonia Fumar Mata\"),"
					+ "(\"56789012E\", \"Alberto Lopez Serrano\"),"
					+ "(\"67890123F\", \"Sergi Rodriguez Utge\"),"
					+ "(\"78901234G\", \"Nerea Prados Mata\"),"
					+ "(\"89012345H\", \"Joan Puig Feliu\")");
			
			//create table proyectos
			connection.createTable("proyectos",""
					+ "id CHAR(4) PRIMARY KEY,"
					+ "nombre VARCHAR(255) NOT NULL,"
					+ "horas INT DEFAULT 0");
			
			//it fills the table proyectos with data
			connection.insertData("proyectos", 
				    "(\"P001\", \"Proyecto 1\", 10)," + 
				    "(\"P002\", \"Proyecto 2\", 20)," + 
				    "(\"P003\", \"Proyecto 3\", 30)," + 
				    "(\"P004\", \"Proyecto 4\", 40)," + 
				    "(\"P005\", \"Proyecto 5\", 50)," + 
				    "(\"P006\", \"Proyecto 6\", 60)," + 
				    "(\"P007\", \"Proyecto 7\", 70)," + 
				    "(\"P008\", \"Proyecto 8\", 80)");
			
			//create table videos
			connection.createTable("asignado_a",""
					+ "id INT(11) AUTO_INCREMENT PRIMARY KEY,"
					+ "dni_cientifico VARCHAR(9),"
					+ "id_proyecto CHAR(4),"
					+ "FOREIGN KEY (dni_cientifico) REFERENCES cientificos (dni) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (id_proyecto) REFERENCES proyectos (id) ON DELETE CASCADE ON UPDATE CASCADE");
			
			//it fills the table asignado_a with data
			connection.insertData("asignado_a", 
				    "(\"12345678A\", \"P001\")," + 
				    "(\"23456789B\", \"P002\")," + 
				    "(\"34567890C\", \"P003\")," + 
				    "(\"45678901D\", \"P004\")," + 
				    "(\"56789012E\", \"P005\")," + 
				    "(\"67890123F\", \"P006\")," + 
				    "(\"78901234G\", \"P007\")," + 
				    "(\"89012345H\", \"P008\")");
			
		}
		//it closes the connection
		connection.closeConnection();	
	}
}
