package com.sergi.C4_TA22_PT3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sergi.C4_TA22_PT3.model.Asignado;
import com.sergi.C4_TA22_PT3.model.Cientifico;
import com.sergi.C4_TA22_PT3.model.Proyecto;
import com.sergi.C4_TA22_PT3.services.AsignadoService;
import com.sergi.C4_TA22_PT3.view.AddAsignadoView;
import com.sergi.C4_TA22_PT3.view.AddCientificoView;
import com.sergi.C4_TA22_PT3.view.AddProyectoView;
import com.sergi.C4_TA22_PT3.view.AsignadoView;
import com.sergi.C4_TA22_PT3.view.CientificoView;
import com.sergi.C4_TA22_PT3.view.ProyectoView;
import com.sergi.C4_TA22_PT3.view.EditAsignadoView;
import com.sergi.C4_TA22_PT3.view.EditCientificoView;
import com.sergi.C4_TA22_PT3.view.EditProyectoView;

public class AsignadoController {
	private AsignadoView asignadoView;
	private AddAsignadoView addAsignadoView;
	private EditAsignadoView editAsignadoView;
	int idAsignadoToEdit;
	
	public AsignadoController(AsignadoView asignadoView, AddAsignadoView addAsignadoView, EditAsignadoView editAsignadoView) {
		this.asignadoView = asignadoView;
		this.addAsignadoView = addAsignadoView;
		this.editAsignadoView = editAsignadoView;
	}

	public void initializeView() {
		printAllAsignados();
		asignadoView.setTitle("Lista de Asignados");
		asignadoView.setVisible(true);
		asignadoView.btnAddAsignado.addActionListener(addAsignadoBtn);
		asignadoView.btnEditAsignado.addActionListener(editAsignadoBtn);
		asignadoView.btnDeleteAsignado.addActionListener(deleteAsignadoBtn);
		asignadoView.btnViewProyectos.addActionListener(viewProyectosBtn);
		asignadoView.btnViewCientificos.addActionListener(viewCientificosBtn);
		//add action listener to add client view
		addAsignadoView.btnAddAsignado.addActionListener(addAsignado);
		//add action listener to edit client view
		editAsignadoView.btnEditAsignado.addActionListener(editAsignado);
		
	}
	
	public void updateAsignados() {
		asignadoView.clearAsignados();
		printAllAsignados();
	}
	
	public void printAllAsignados() {
		ArrayList<Asignado> asignados = AsignadoService.readTableAsignado();
		asignadoView.printAsignados(asignados);
	}
	
	ActionListener addAsignadoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set window visible
			addAsignadoView.setVisible(true);
		}
	};
	
	ActionListener addAsignado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if (Cientifico.isDni(addAsignadoView.getTfDniCientifico()) && Proyecto.isChar(addAsignadoView.getTfIdProyecto(), 4)) {
					//inserts the data of the new asignado
					AsignadoService asignadoService = new AsignadoService();
					asignadoService.createAsignado(
						addAsignadoView.getTfDniCientifico(),
						addAsignadoView.getTfIdProyecto()); 
					//shows a message of the insert confirmation
					JOptionPane.showConfirmDialog(null, "La asignación ha sido insertada correctamente.","Asignación Añadida",JOptionPane.CLOSED_OPTION);
				}
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido insertar la nueva asignacion","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in AsignadoView
			updateAsignados();
			//hidden the AddClienteView
			addAsignadoView.setVisible(false);
		}
	};
	
	ActionListener editAsignadoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				idAsignadoToEdit = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el ID de la asignación a ediar:","ID de Asignacion a Editar", JOptionPane.INFORMATION_MESSAGE));
				//gets and prints asignados from database to EditClienteView
				AsignadoService asignadoService = new AsignadoService();
				Asignado asignadoAEditar = asignadoService.getAsignadosWithCondition("WHERE id=" + idAsignadoToEdit).get(0);
				editAsignadoView.setTfId(String.valueOf(asignadoAEditar.getId()));
				editAsignadoView.setTfDniCientifico(asignadoAEditar.getDniCientifico());
				editAsignadoView.setTfIdProyecto("" + asignadoAEditar.getIdProyecto());
				//we set window visible
				editAsignadoView.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar la asignación, si deseas editar alguna asignación inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
		}
	};
	
	ActionListener editAsignado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//updates the client with the new data
				AsignadoService asignadoService = new AsignadoService();
				Asignado asignadoToUpdate = new Asignado();
				asignadoToUpdate.setId(Integer.parseInt(editAsignadoView.getTfId()));
				asignadoToUpdate.setDniCientifico(editAsignadoView.getTfDniCientifico());
				asignadoToUpdate.setIdProyecto(editAsignadoView.getTfIdProyecto());
				//try to updates the asignado
				asignadoService.updateAsignado(asignadoToUpdate, idAsignadoToEdit);
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "La asignación con ID " + editAsignadoView.getTfId() + " ha sido actualizada correctamente.",
						"Asignacion Actualizada",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar la asignación.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in ClienteView
			updateAsignados();
			//hidden the AddClienteView
			editAsignadoView.setVisible(false);
		}
	};
	
	ActionListener deleteAsignadoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int idAsignadoToDelete = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la ID de la asignación a eliminar:","Eliminar Asignacion", JOptionPane.INFORMATION_MESSAGE));
				int returnValue = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar la asignación con ID " + idAsignadoToDelete + "?", 
						"Quieres eliminar la asignacion?",
						JOptionPane.YES_NO_OPTION);
				if (returnValue == JOptionPane.YES_OPTION) {
					AsignadoService asignadoService = new AsignadoService();
					asignadoService.deleteAsignado(idAsignadoToDelete);
					JOptionPane.showConfirmDialog(null, "La asignación " + idAsignadoToDelete + " ha sido eliminada correctamente.","Asignacion Eliminada",JOptionPane.CLOSED_OPTION);
					updateAsignados();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar la asignación, si deseas eliminar la asignación inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			
		}
	};
	
	ActionListener viewCientificosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set asignados window hidden
			asignadoView.setVisible(false);
			//it initialize the Video Views using VideoController
			CientificoView cientificoView = new CientificoView();
			AddCientificoView addCientificoView = new AddCientificoView();
			EditCientificoView editCientificoView = new EditCientificoView();
			CientificoController cientificoController = new CientificoController (cientificoView, addCientificoView, editCientificoView); 
			cientificoController.initializeView();
		}
	};
	
	ActionListener viewProyectosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set asignados window hidden
			asignadoView.setVisible(false);
			//it initialize the Video Views using VideoController
			ProyectoView proyectoView = new ProyectoView();
			AddProyectoView addProyectoView = new AddProyectoView();
			EditProyectoView editProyectoView = new EditProyectoView();
			ProyectoController proyectoController = new ProyectoController (proyectoView, addProyectoView, editProyectoView); 
			proyectoController.initializeView();
		}
	};
}
