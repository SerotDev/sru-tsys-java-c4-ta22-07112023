package com.sergi.C4_TA22_PT1.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.sergi.C4_TA22_PT1.model.Cliente;
import com.sergi.C4_TA22_PT1.services.ClienteService;
import com.sergi.C4_TA22_PT1.view.AddClienteView;
import com.sergi.C4_TA22_PT1.view.ClienteView;
import com.sergi.C4_TA22_PT1.view.EditClienteView;

public class ClienteController{
	private ClienteView clienteView;
	private AddClienteView addClienteView;
	private EditClienteView editClienteView;
	
	public ClienteController(ClienteView clienteView, AddClienteView addClienteView, EditClienteView editClienteView) {
		this.clienteView = clienteView;
		this.addClienteView = addClienteView;
		this.editClienteView = editClienteView;
	}

	public void initializeView() {
		printAllClientes();
		clienteView.setTitle("Lista de Clientes");
		clienteView.setVisible(true);
		clienteView.btnAddNewCliente.addActionListener(addClienteBtn);
		clienteView.btnEditCliente.addActionListener(editClienteBtn);
		clienteView.btnDeleteCliente.addActionListener(deleteClienteBtn);
		//add action listener to add client view
		addClienteView.btnAddCliente.addActionListener(addCliente);
		//add action listener to edit client view
		editClienteView.btnEditCliente.addActionListener(editCliente);
		
	}
	
	public void updateClientes() {
		clienteView.clearClientes();
		printAllClientes();
	}
	
	public void printAllClientes() {
		ArrayList<Cliente> clientes = ClienteService.readTableClientes();
		clienteView.printClientes(clientes);
	}
	
	ActionListener addClienteBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set window visible
			addClienteView.setVisible(true);
		}
	};
	
	ActionListener addCliente = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//inserts the data of the new client
				ClienteService clienteService = new ClienteService();
				clienteService.createCliente(
						addClienteView.getTfNombre(), 
						addClienteView.getTfApellidos(), 
						addClienteView.getTfDireccion(), 
						addClienteView.getTfDni(),
						addClienteView.getTfFecha());
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "El cliente ha sido insertado correctamente.","Cliente Añadido",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido insertar el nuevo cliente","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println(e2);
			}
			//update the client values in ClienteView
			updateClientes();
			//hidden the AddClienteView
			addClienteView.setVisible(false);
		}
	};
	
	ActionListener editClienteBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int idClientToEdit = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la ID del cliente a ediar:","ID de Cliente a Editar", JOptionPane.INFORMATION_MESSAGE));
				//gets and prints cliente from database to EditClienteView
				ClienteService clienteService = new ClienteService();
				Cliente clienteAEditar = clienteService.getClientesWithCondition("WHERE id=" + idClientToEdit).get(0);
				editClienteView.setTfId(String.valueOf(clienteAEditar.getId()));
				editClienteView.setTfNombre(clienteAEditar.getNombre());
				editClienteView.setTfApellidos(clienteAEditar.getApellidos());
				editClienteView.setTfDireccion(clienteAEditar.getDireccion());
				editClienteView.setTfDni(clienteAEditar.getDni());
				editClienteView.setTfFecha(clienteAEditar.getFecha());
				//we set window visible
				editClienteView.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el cliente, si deseas editar el usuario inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println(e2);
			}
		}
	};
	
	ActionListener editCliente = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//updates the client with the new data
				ClienteService clienteService = new ClienteService();
				Cliente clienteToUpdate = new Cliente();
				clienteToUpdate.setId(Integer.parseInt(editClienteView.getTfId()));
				clienteToUpdate.setNombre(editClienteView.getTfNombre());
				clienteToUpdate.setApellidos(editClienteView.getTfApellidos());
				clienteToUpdate.setDireccion(editClienteView.getTfDireccion());
				clienteToUpdate.setDni(editClienteView.getTfDni());
				clienteToUpdate.setFecha(editClienteView.getTfFecha());
				//try to updates the client
				clienteService.updateCliente(clienteToUpdate);
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "El cliente con id " + editClienteView.getTfId() + " ha sido actualizado correctamente.",
						"Cliente Actualizado",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cliente","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println(e2);
			}
			//update the client values in ClienteView
			updateClientes();
			//hidden the AddClienteView
			editClienteView.setVisible(false);
		}
	};
	
	ActionListener deleteClienteBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int idClientToDelete = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la ID del cliente a eliminar:","Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE));
				int returnValue = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el usuario con id " + idClientToDelete + "?", 
						"Quieres eliminar el cliente?",
						JOptionPane.YES_NO_OPTION);
				if (returnValue == JOptionPane.YES_OPTION) {
					ClienteService clienteService = new ClienteService();
					clienteService.deleteCliente(idClientToDelete);
					JOptionPane.showConfirmDialog(null, "El cliente " + idClientToDelete + " ha sido eliminado correctamente.","Cliente Eliminado",JOptionPane.CLOSED_OPTION);
					updateClientes();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cliente, si deseas eliminar el usuario inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println(e2);
			}
			
		}
	};

}
