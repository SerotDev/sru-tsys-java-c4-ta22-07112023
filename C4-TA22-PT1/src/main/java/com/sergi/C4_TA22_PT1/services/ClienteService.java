package com.sergi.C4_TA22_PT1.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sergi.C4_TA22_PT1.model.Cliente;
import com.sergi.C4_TA22_PT1.model.DbConnection;

public class ClienteService {

	/**
	* Create new client
	* 
	* @param nombre the name of the client to add
	* @param apellidos the surname of the client to add
	* @param direccion the address of the client to add
	* @param dni the personal identifiction card number of the client to add
	* @param fecha the born date of the client to add
	*/
	public void createCliente(String nombre, String apellidos, String direccion, String dni, String fecha){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//it adds the new client to the database
		connection.insertData("clientes",""
				+ "(\"" + nombre + "\","
				+ "\"" + apellidos + "\","
				+ "\"" + direccion + "\","
				+ "\"" + dni + "\","
				+ "\"" + fecha + "\")"); //condition
		//it closes the connection
		connection.closeConnection();
	}
	
	/**
	 * it returns all clients in the clientes table
	 * @return list of all clients
	 */
	public static ArrayList<Cliente> readTableClientes () {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrClientes = connection.getTableContent("clientes");
		for (String row[]: listaStrClientes) { 
			Cliente client = new Cliente();
			client.setId(Integer.parseInt(row[0]));
			client.setNombre(row[1]);
			client.setApellidos(row[2]);
			client.setDireccion(row[3]);
			client.setDni(row[4]);
			client.setFecha(row[5]);
			listaClientes.add(client);
		}
		System.out.println("Clients collected from table clientes.");
		//it closes the conection
		connection.closeConnection();
		return listaClientes;
	}
	
	
	/**
	 * it returns clients whith a condition
	 * @return list of clients that fulfill a condition
	 */
	public static ArrayList<Cliente> getClientesWithCondition (String condition) {
		System.out.println(condition);
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrClientes = connection.getTableContent("clientes", condition);
		for (String row[]: listaStrClientes) { 
			Cliente client = new Cliente();
			client.setId(Integer.parseInt(row[0]));
			client.setNombre(row[1]);
			client.setApellidos(row[2]);
			client.setDireccion(row[3]);
			client.setDni(row[4]);
			client.setFecha(row[5]);
			listaClientes.add(client);
		}
		System.out.println("Clients collected from table clientes.");
		//it closes the conection
		connection.closeConnection();
		return listaClientes;
	}

	/**
	 * update specified client by id
	 * @param client client to be updated
	 */
	public void updateCliente(Cliente client){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//updates the client by id
		connection.updateData("clientes",""
				+ "nombre=\"" + client.getNombre() + "\","
				+ "apellido=\"" + client.getApellidos() + "\","
				+ "direccion=\"" + client.getDireccion() + "\","
				+ "dni=\"" + client.getDni() + "\","
				+ "fecha=\"" + client.getFecha() + "\""
				, "id=" + client.getId()); //condition
    	//it closes the connection
		connection.closeConnection();
	}

	/**
	 * delete the client by its id
	 * @param id of the client to delete
	 */
	public void deleteCliente(int idCliente){
		//instanciate the class and open connection
	   	DbConnection connection2 = new DbConnection();
	   	//it opens the connection
	   	connection2.openConnection();
	   	//deletes the client by id
	   	connection2.deleteData("clientes", "id=" + idCliente);
	   	//it closes the connection
	   	connection2.closeConnection();
	}
}
