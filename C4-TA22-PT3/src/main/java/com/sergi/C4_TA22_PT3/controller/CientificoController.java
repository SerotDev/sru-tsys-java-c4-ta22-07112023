package com.sergi.C4_TA22_PT3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sergi.C4_TA22_PT3.model.Cientifico;
import com.sergi.C4_TA22_PT3.services.CientificoService;
import com.sergi.C4_TA22_PT3.view.CientificoView;
import com.sergi.C4_TA22_PT3.view.EditAsignadoView;
import com.sergi.C4_TA22_PT3.view.AddAsignadoView;
import com.sergi.C4_TA22_PT3.view.AddCientificoView;
import com.sergi.C4_TA22_PT3.view.AddProyectoView;
import com.sergi.C4_TA22_PT3.view.AsignadoView;
import com.sergi.C4_TA22_PT3.view.EditCientificoView;
import com.sergi.C4_TA22_PT3.view.EditProyectoView;
import com.sergi.C4_TA22_PT3.view.ProyectoView;

public class CientificoController {
	private CientificoView cientificoView;
	private AddCientificoView addCientificoView;
	private EditCientificoView editCientificoView;
	private String dniCientificoToEdit;
	
	public CientificoController(CientificoView cientificoView, AddCientificoView addCientificoView, EditCientificoView editCientificoView) {
		this.cientificoView = cientificoView;
		this.addCientificoView = addCientificoView;
		this.editCientificoView = editCientificoView;
	}

	public void initializeView() {
		printAllCientificos();
		cientificoView.setTitle("Lista de Cientificos");
		cientificoView.setVisible(true);
		cientificoView.btnAddCientifico.addActionListener(addCientificoBtn);
		cientificoView.btnEditCientifico.addActionListener(editCientificoBtn);
		cientificoView.btnDeleteCientifico.addActionListener(deleteCientificoBtn);
		cientificoView.btnViewProyectos.addActionListener(viewProyectosBtn);
		cientificoView.btnViewAsignados.addActionListener(viewAsignadosBtn);
		//add action listener to add client view
		addCientificoView.btnAddCientifico.addActionListener(addCientifico);
		//add action listener to edit client view
		editCientificoView.btnEditCientifico.addActionListener(editCientifico);
		
	}
	
	public void updateCientificos() {
		cientificoView.clearCientificos();
		printAllCientificos();
	}
	
	public void printAllCientificos() {
		ArrayList<Cientifico> cientificos = CientificoService.readTableCientifico();
		cientificoView.printCientificos(cientificos);
	}
	
	ActionListener addCientificoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set window visible
			addCientificoView.setVisible(true);
		}
	};
	
	ActionListener addCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//inserts the data of the new cientifico
				CientificoService cientificoService = new CientificoService();
				if (Cientifico.isDni(addCientificoView.getTfDni())) {
					cientificoService.createCientifico(
							addCientificoView.getTfDni(), 
							addCientificoView.getTfNomApels()); 
					//shows a message of the insert confirmation
					JOptionPane.showConfirmDialog(null, "El cientifico ha sido insertado correctamente.","Cientifico Añadido",JOptionPane.CLOSED_OPTION);
				}
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido insertar el nuevo cientifico","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in CientificoView
			updateCientificos();
			//hidden the AddClienteView
			addCientificoView.setVisible(false);
		}
	};
	
	ActionListener editCientificoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				dniCientificoToEdit = JOptionPane.showInputDialog(null,"Introduce el DNI del científico a ediar:","DNI de Cliente a Editar", JOptionPane.INFORMATION_MESSAGE);
				//gets and prints cientifico from database to EditClienteView
				CientificoService cientificoService = new CientificoService();
				Cientifico cientificoAEditar = cientificoService.getCientificosWithCondition("WHERE dni=\"" + dniCientificoToEdit + "\"").get(0);
				editCientificoView.setTfDni(String.valueOf(cientificoAEditar.getDni()));
				editCientificoView.setTfNomApels(cientificoAEditar.getNomApels());
				//we set window visible
				editCientificoView.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el cientifico, si deseas editar el cientifico inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
		}
	};
	
	ActionListener editCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//updates the client with the new data
				CientificoService cientificoService = new CientificoService();
				Cientifico cientificoToUpdate = new Cientifico();
				cientificoToUpdate.setDni(editCientificoView.getTfDni());
				cientificoToUpdate.setNomApels(editCientificoView.getTfNomApels());
				//try to updates the cientifico
				cientificoService.updateCientifico(cientificoToUpdate, dniCientificoToEdit);
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "El cientifico con DNI " + dniCientificoToEdit + " ha sido actualizado correctamente.",
						"Cientifico Actualizado",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cientifico","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in ClienteView
			updateCientificos();
			//hidden the AddClienteView
			editCientificoView.setVisible(false);
		}
	};
	
	ActionListener deleteCientificoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String idCientificoToDelete = JOptionPane.showInputDialog(null,"Introduce el DNI del cientifico a eliminar:","Eliminar Cientifico", JOptionPane.INFORMATION_MESSAGE);
				if (Cientifico.isDni(idCientificoToDelete)) {
					int returnValue = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el cientifico con DNI " + idCientificoToDelete + "?", 
							"Quieres eliminar el cientifico?",
							JOptionPane.YES_NO_OPTION);
					if (returnValue == JOptionPane.YES_OPTION) {
						CientificoService cientificoService = new CientificoService();
						cientificoService.deleteCientifico(idCientificoToDelete);
						JOptionPane.showConfirmDialog(null, "El cietifico " + idCientificoToDelete + " ha sido eliminado correctamente.","Cientifico Eliminado",JOptionPane.CLOSED_OPTION);
						updateCientificos();
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cientifico, si deseas eliminar el cientifico inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			
		}
	};
	
	ActionListener viewProyectosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set cientificos window hidden
			cientificoView.setVisible(false);
			//it initialize the Video Views using VideoController
			ProyectoView proyectoView = new ProyectoView();
			AddProyectoView addProyectoView = new AddProyectoView();
			EditProyectoView editProyectoView = new EditProyectoView();
			ProyectoController proyectoController = new ProyectoController (proyectoView, addProyectoView, editProyectoView); 
			proyectoController.initializeView();
		}
	};
	
	ActionListener viewAsignadosBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set cientificos window hidden
			cientificoView.setVisible(false);
			//it initialize the Video Views using VideoController
			AsignadoView asignadoView = new AsignadoView();
			AddAsignadoView addAsignadoView = new AddAsignadoView();
			EditAsignadoView editAsignadoView = new EditAsignadoView();
			AsignadoController asignadoController = new AsignadoController (asignadoView, addAsignadoView, editAsignadoView); 
			asignadoController.initializeView();
		}
	};
}
