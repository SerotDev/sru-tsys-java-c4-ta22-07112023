package com.sergi.C4_TA22_PT3.services;

import java.util.ArrayList;

import com.sergi.C4_TA22_PT3.model.Cientifico;
import com.sergi.C4_TA22_PT3.model.DbConnection;

public class CientificoService {
	/**
	* Create new cientifico
	* 
	* @param dni the dni of the cientifico
	* @param nomApels the name of the cientifico
	*/
	public void createCientifico(String dni, String nomApels){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//it adds the new cientifico to the database
		connection.insertData("cientificos",""
				+ "(\"" + dni + "\","
				+ "\"" + nomApels + "\")");
		//it closes the connection
		connection.closeConnection();
	}
	
	/**
	 * it returns all clients in the cientificos table
	 * @return list of all cientificos
	 */
	public static ArrayList<Cientifico> readTableCientifico () {
		ArrayList<Cientifico> listaCientificos = new ArrayList<Cientifico>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrCientificos = connection.getTableContent("cientificos");
		for (String row[]: listaStrCientificos) { 
			Cientifico cientifico = new Cientifico();
			cientifico.setDni(row[0]);
			cientifico.setNomApels(row[1]);
			listaCientificos.add(cientifico);
		}
		System.out.println("Cientificos collected from table cientificos.");
		//it closes the conection
		connection.closeConnection();
		return listaCientificos;
	}
	
	
	/**
	 * it returns cientificos whith a condition
	 * @param condition condition to get cientificos. Example: WHERE dni=\"83294935Z\"
	 * @return list of cientificos that fulfill a condition
	 */
	public static ArrayList<Cientifico> getCientificosWithCondition (String condition) {
		ArrayList<Cientifico> listaCientificos = new ArrayList<Cientifico>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrCientificos = connection.getTableContent("cientificos", condition);
		for (String row[]: listaStrCientificos) { 
			Cientifico cientifico = new Cientifico();
			cientifico.setDni(row[0]);
			cientifico.setNomApels(row[1]);
			listaCientificos.add(cientifico);
		}
		System.out.println("Cientificos collected from table cientificos.");
		//it closes the conection
		connection.closeConnection();
		return listaCientificos;
	}

	/**
	 * update specified cientifico by dni
	 * @param cientifico cientifico to be updated
	 * @param dniCientificoToEdit is the dni of the cientifico to edit
	 */
	public void updateCientifico(Cientifico cientifico, String dniCientificoToEdit){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//updates the cientifico my dni
		connection.updateData("cientificos",""
				+ "dni=\"" + cientifico.getDni() + "\","
				+ "nom_apels=\"" + cientifico.getNomApels() + "\""
				, "dni=\"" + dniCientificoToEdit + "\""); //condition
    	//it closes the connection
		connection.closeConnection();
	}

	/**
	 * delete the cientifico by its id
	 * @param dniCientifico dni of the cientifico to delete
	 */
	public void deleteCientifico(String dniCientifico){
		//instanciate the class and open connection
	   	DbConnection connection = new DbConnection();
	   	//it opens the connection
	   	connection.openConnection();
	   	//deletes the cientifico by dni
	   	connection.deleteData("cientificos", "dni=\"" + dniCientifico + "\"");
	   	//it closes the connection
	   	connection.closeConnection();
	}
}
