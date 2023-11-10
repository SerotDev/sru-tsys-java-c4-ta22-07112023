package com.sergi.C4_TA22_PT3.services;

import java.util.ArrayList;

import com.sergi.C4_TA22_PT3.model.Asignado;
import com.sergi.C4_TA22_PT3.model.DbConnection;

public class AsignadoService {
	/**
	* Create new asignado
	* 
	* @param dniCientifico the id of the cientifico varchar(9)
	* @param idProyecto the name of the proyecto char(4)
	*/
	public void createAsignado(String dniCientifico, String idProyecto){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//it adds the new asignado to the database
		connection.insertData("asignado_a",""
				+ "(\"" + dniCientifico + "\","
				+ "\"" + idProyecto + "\")");
		//it closes the connection
		connection.closeConnection();
	}
	
	/**
	 * it returns all asignados in the asignado_a table
	 * @return list of all asignados
	 */
	public static ArrayList<Asignado> readTableAsignado () {
		ArrayList<Asignado> listaAsignado = new ArrayList<Asignado>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaAsignados = connection.getTableContent("asignado_a");
		for (String row[]: listaAsignados) { 
			Asignado asignado = new Asignado();
			asignado.setId(Integer.parseInt(row[0]));
			asignado.setDniCientifico(row[1]);
			asignado.setIdProyecto(row[2]);
			listaAsignado.add(asignado);
		}
		System.out.println("Asignados collected from table asignado_a.");
		//it closes the conection
		connection.closeConnection();
		return listaAsignado;
	}
	
	
	/**
	 * it returns asignados whith a condition
	 * @param condition condition to get asignados. Example: WHERE dni_cientifico=\"83294935Z\"
	 * @return list of asignados that fulfill a condition
	 */
	public static ArrayList<Asignado> getAsignadosWithCondition (String condition) {
		ArrayList<Asignado> listaAsignado = new ArrayList<Asignado>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrAsignados = connection.getTableContent("asignado_a", condition);
		for (String row[]: listaStrAsignados) { 
			Asignado asignado = new Asignado();
			asignado.setId(Integer.parseInt(row[0]));
			asignado.setDniCientifico(row[1]);
			asignado.setIdProyecto(row[2]);
			listaAsignado.add(asignado);
		}
		System.out.println("Proyectos collected from table asignado_a.");
		//it closes the conection
		connection.closeConnection();
		return listaAsignado;
	}

	/**
	 * update specified asignado by id
	 * @param asignado asignado to be updated
	 */
	public void updateAsignado(Asignado asignado, int idAsignadoToEdit){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//updates the asignado by id
		connection.updateData("asignado_a",""
				+ "id=\"" + asignado.getId() + "\","
				+ "dni_cientifico=\"" + asignado.getDniCientifico() + "\","
				+ "id_proyecto=\"" + asignado.getIdProyecto() + "\"" 
				, "id=" + idAsignadoToEdit); //condition
    	//it closes the connection
		connection.closeConnection();
	}

	/**
	 * delete the asignado_a by its id
	 * @param idAsignado id of the asignado to delete
	 */
	public void deleteAsignado(int idAsignado){
		//instanciate the class and open connection
	   	DbConnection connection = new DbConnection();
	   	//it opens the connection
	   	connection.openConnection();
	   	//deletes the asignado by id
	   	connection.deleteData("asignado_a", "id=" + idAsignado);
	   	//it closes the connection
	   	connection.closeConnection();
	}
}
