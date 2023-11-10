package com.sergi.C4_TA22_PT3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sergi.C4_TA22_PT3.model.Proyecto;
import com.sergi.C4_TA22_PT3.services.ProyectoService;
import com.sergi.C4_TA22_PT3.view.AddAsignadoView;
import com.sergi.C4_TA22_PT3.view.AddCientificoView;
import com.sergi.C4_TA22_PT3.view.AddProyectoView;
import com.sergi.C4_TA22_PT3.view.AsignadoView;
import com.sergi.C4_TA22_PT3.view.CientificoView;
import com.sergi.C4_TA22_PT3.view.ProyectoView;
import com.sergi.C4_TA22_PT3.view.EditAsignadoView;
import com.sergi.C4_TA22_PT3.view.EditCientificoView;
import com.sergi.C4_TA22_PT3.view.EditProyectoView;

public class ProyectoController {
	private String idProyectoToEdit;
	private ProyectoView proyectoView;
	private AddProyectoView addProyectoView;
	private EditProyectoView editProyectoView;
	
	public ProyectoController(ProyectoView proyectoView, AddProyectoView addProyectoView, EditProyectoView editProyectoView) {
		this.proyectoView = proyectoView;
		this.addProyectoView = addProyectoView;
		this.editProyectoView = editProyectoView;
	}

	public void initializeView() {
		printAllProyectos();
		proyectoView.setTitle("Lista de Proyectos");
		proyectoView.setVisible(true);
		proyectoView.btnAddProyecto.addActionListener(addProyectoBtn);
		proyectoView.btnEditProyecto.addActionListener(editProyectoBtn);
		proyectoView.btnDeleteProyecto.addActionListener(deleteProyectoBtn);
		proyectoView.btnViewCientificos.addActionListener(viewCientificosBtn);
		proyectoView.btnViewAsignados.addActionListener(viewAsignadosBtn);
		//add action listener to add client view
		addProyectoView.btnAddProyecto.addActionListener(addProyecto);
		//add action listener to edit client view
		editProyectoView.btnEditProyecto.addActionListener(editProyecto);
		
	}
	
	public void updateProyectos() {
		proyectoView.clearProyectos();
		printAllProyectos();
	}
	
	public void printAllProyectos() {
		ArrayList<Proyecto> proyectos = ProyectoService.readTableProyecto();
		proyectoView.printProyectos(proyectos);
	}
	
	ActionListener addProyectoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set window visible
			addProyectoView.setVisible(true);
		}
	};
	
	ActionListener addProyecto = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//inserts the data of the new proyecto
				ProyectoService proyectoService = new ProyectoService();
				if (Proyecto.isChar(addProyectoView.getTfId(), 4)) {
					proyectoService.createProyecto(
							addProyectoView.getTfId(),
							addProyectoView.getTfNombre(),
							Integer.parseInt(addProyectoView.getTfHoras())); 
					//shows a message of the insert confirmation
					JOptionPane.showConfirmDialog(null, "El proyecto ha sido insertado correctamente.","Proyecto Añadido",JOptionPane.CLOSED_OPTION);
				}
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido insertar el nuevo proyecto","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in ProyectoView
			updateProyectos();
			//hidden the AddClienteView
			addProyectoView.setVisible(false);
		}
	};
	
	ActionListener editProyectoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				idProyectoToEdit = JOptionPane.showInputDialog(null,"Introduce el ID del proyecto a ediar:","ID de Proyecto a Editar", JOptionPane.INFORMATION_MESSAGE);
				//gets and prints proyecto from database to EditClienteView
				ProyectoService proyectoService = new ProyectoService();
				Proyecto proyectoAEditar = proyectoService.getProyectosWithCondition("WHERE id=\"" + idProyectoToEdit + "\"").get(0);
				editProyectoView.setTfId(proyectoAEditar.getId());
				editProyectoView.setTfNombre(proyectoAEditar.getNombre());
				editProyectoView.setTfHoras("" + proyectoAEditar.getHoras());
				//we set window visible
				editProyectoView.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el proyecto, si deseas editar el proyecto inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
		}
	};
	
	ActionListener editProyecto = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if (Proyecto.isChar(editProyectoView.getTfId(), 4)) {
					//updates the client with the new data
					ProyectoService proyectoService = new ProyectoService();
					Proyecto proyectoToUpdate = new Proyecto();
					proyectoToUpdate.setId(editProyectoView.getTfId());
					proyectoToUpdate.setNombre(editProyectoView.getTfNombre());
					proyectoToUpdate.setHoras(Integer.parseInt(editProyectoView.getTfHoras()));
					//try to updates the proyecto
					proyectoService.updateProyecto(proyectoToUpdate, idProyectoToEdit);
					//shows a message of the insert confirmation
					JOptionPane.showConfirmDialog(null, "El proyecto con ID " + idProyectoToEdit + " ha sido actualizado correctamente.",
							"Proyecto Actualizado",JOptionPane.CLOSED_OPTION);
				}
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el proyecto","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in ClienteView
			updateProyectos();
			//hidden the AddClienteView
			editProyectoView.setVisible(false);
		}
	};
	
	ActionListener deleteProyectoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String idProyectoToDelete = JOptionPane.showInputDialog(null,"Introduce la ID del proyecto a eliminar:","Eliminar Proyecto", JOptionPane.INFORMATION_MESSAGE);
				if (Proyecto.isChar(idProyectoToDelete, 4)) {
					int returnValue = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el proyecto con ID " + idProyectoToDelete + "?", 
							"Quieres eliminar el proyecto?",
							JOptionPane.YES_NO_OPTION);
					if (returnValue == JOptionPane.YES_OPTION) {
						ProyectoService proyectoService = new ProyectoService();
						proyectoService.deleteProyecto(idProyectoToDelete);
						JOptionPane.showConfirmDialog(null, "El proyecto " + idProyectoToDelete + " ha sido eliminado correctamente.","Proyecto Eliminado",JOptionPane.CLOSED_OPTION);
						updateProyectos();
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el proyecto, si deseas eliminar el proyecto inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			
		}
	};
	
	ActionListener viewCientificosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set proyectos window hidden
			proyectoView.setVisible(false);
			//it initialize the Video Views using VideoController
			CientificoView cientificoView = new CientificoView();
			AddCientificoView addCientificoView = new AddCientificoView();
			EditCientificoView editCientificoView = new EditCientificoView();
			CientificoController cientificoController = new CientificoController (cientificoView, addCientificoView, editCientificoView); 
			cientificoController.initializeView();
		}
	};
	
	ActionListener viewAsignadosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set proyectos window hidden
			proyectoView.setVisible(false);
			//it initialize the Video Views using VideoController
			AsignadoView asignadoView = new AsignadoView();
			AddAsignadoView addAsignadoView = new AddAsignadoView();
			EditAsignadoView editAsignadoView = new EditAsignadoView();
			AsignadoController asignadoController = new AsignadoController (asignadoView, addAsignadoView, editAsignadoView); 
			asignadoController.initializeView();
		}
	};
}
