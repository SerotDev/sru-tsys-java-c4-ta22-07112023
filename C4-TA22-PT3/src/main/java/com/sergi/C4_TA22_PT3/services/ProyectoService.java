package com.sergi.C4_TA22_PT3.services;

import java.util.ArrayList;

import com.sergi.C4_TA22_PT3.model.DbConnection;
import com.sergi.C4_TA22_PT3.model.Proyecto;

public class ProyectoService {
	/**
	* Create new proyecto
	* 
	* @param id the id of the proyecto char(4)
	* @param nombre the name of the proyecto
	* @param horas the name of the proyecto
	*/
	public void createProyecto(String id, String nombre, int horas){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//it adds the new proyecto to the database
		connection.insertData("proyectos",""
				+ "(\"" + id + "\","
				+ "\"" + nombre + "\","
				+  horas + ")");
		//it closes the connection
		connection.closeConnection();
	}
	
	/**
	 * it returns all proyectos in the proyectos table
	 * @return list of all proyectos
	 */
	public static ArrayList<Proyecto> readTableProyecto () {
		ArrayList<Proyecto> listaProyecto = new ArrayList<Proyecto>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrProyectos = connection.getTableContent("proyectos");
		for (String row[]: listaStrProyectos) { 
			Proyecto proyecto = new Proyecto();
			proyecto.setId(row[0]);
			proyecto.setNombre(row[1]);
			proyecto.setHoras(Integer.parseInt(row[2]));
			listaProyecto.add(proyecto);
		}
		System.out.println("Proyectos collected from table proyectos.");
		//it closes the conection
		connection.closeConnection();
		return listaProyecto;
	}
	
	
	/**
	 * it returns proyectos whith a condition
	 * @param condition condition to get proyectos. Example: WHERE id=\"P001\"
	 * @return list of proyectos that fulfill a condition
	 */
	public static ArrayList<Proyecto> getProyectosWithCondition (String condition) {
		ArrayList<Proyecto> listaProyecto = new ArrayList<Proyecto>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrProyectos = connection.getTableContent("proyectos", condition);
		for (String row[]: listaStrProyectos) { 
			Proyecto proyecto = new Proyecto();
			proyecto.setId(row[0]);
			proyecto.setNombre(row[1]);
			proyecto.setHoras(Integer.parseInt(row[2]));
			listaProyecto.add(proyecto);
		}
		System.out.println("Proyectos collected from table proyectos.");
		//it closes the conection
		connection.closeConnection();
		return listaProyecto;
	}

	/**
	 * update specified proyecto by id
	 * @param proyecto proyecto to be updated
	 */
	public void updateProyecto(Proyecto proyecto, String idProyectoToEdit){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//updates the proyecto by id
		connection.updateData("proyectos",""
				+ "id=\"" + proyecto.getId() + "\","
				+ "nombre=\"" + proyecto.getNombre() + "\","
				+ "horas=" + proyecto.getHoras() 
				, "id=\"" + idProyectoToEdit + "\"" ); //condition
    	//it closes the connection
		connection.closeConnection();
	}

	/**
	 * delete the proyecto by its id
	 * @param idProyecto id of the proyecto to delete
	 */
	public void deleteProyecto(String idProyecto){
		//instanciate the class and open connection
	   	DbConnection connection = new DbConnection();
	   	//it opens the connection
	   	connection.openConnection();
	   	//deletes the proyecto by id
	   	connection.deleteData("proyectos", "id=\"" + idProyecto + "\"" );
	   	//it closes the connection
	   	connection.closeConnection();
	}
}
