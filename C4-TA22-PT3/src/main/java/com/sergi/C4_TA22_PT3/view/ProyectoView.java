package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.sergi.C4_TA22_PT3.model.Proyecto;

public class ProyectoView {
	private JFrame frmProyectos;
	private JPanel mainPanel;
	public JButton btnViewCientificos;
	public JButton btnViewAsignados;
	private JTable table;
	private DefaultTableModel model_table;
	private JScrollPane scroll_table;
	public JButton btnDeleteProyecto;
	public JButton btnAddProyecto;
	public JButton btnEditProyecto;

	/**
	 * Create the application.
	 */
	public ProyectoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmProyectos = new JFrame();
		frmProyectos.setBounds(100, 100, 650, 521);
		frmProyectos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectos.setLocationRelativeTo(null);
		frmProyectos.setResizable(false);
		frmProyectos.getContentPane().setLayout(null);
        
		mainPanel = new JPanel(null);
		mainPanel.setLocation(10, 0);
		mainPanel.setSize(616, 474);
		
	    btnViewCientificos = new JButton("Ver Lista de Cientificos");
	    btnViewCientificos.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewCientificos.setBounds(10, 10, 293, 40);
	    mainPanel.add(btnViewCientificos);
	    
	    btnViewAsignados = new JButton("Ver Lista de Asignados");
	    btnViewAsignados.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewAsignados.setBounds(313, 10, 293, 40);
	    mainPanel.add(btnViewAsignados);
		
		JLabel lblTitle = new JLabel("Lista de Proyectos", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 72, 596, 32);
	    mainPanel.add(lblTitle);

	    table = new JTable();
	    table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    table.setRowHeight(24);
	    model_table = new DefaultTableModel();
	    table.setModel(model_table);
	    
	    // Create a custom renderer for the table header
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 14)); // Set font for column names
        model_table = new DefaultTableModel();
        table.setModel(model_table);
	    
	    // add table to scroll panel
	    scroll_table = new JScrollPane(table);
	    scroll_table.setBounds(10, 111, 596, 303);
	    scroll_table.setVisible(true);
	    //add column names
	    model_table.addColumn("ID");
	    model_table.addColumn("Nombre");
	    model_table.addColumn("Horas");
	    mainPanel.add(scroll_table);

	    frmProyectos.getContentPane().add(mainPanel);
	    
	    btnEditProyecto = new JButton("Editar Proyecto");
	    btnEditProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnEditProyecto.setBounds(210, 424, 196, 40);
	    mainPanel.add(btnEditProyecto);
	    
	    btnDeleteProyecto = new JButton("Eliminar Proyecto");
	    btnDeleteProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnDeleteProyecto.setBounds(10, 424, 190, 40);
	    mainPanel.add(btnDeleteProyecto);
	    
	    btnAddProyecto = new JButton("Añadir Proyecto");
	    btnAddProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnAddProyecto.setBounds(416, 424, 190, 40);
	    mainPanel.add(btnAddProyecto);
	}

	public void setTitle(String title) {
		frmProyectos.setTitle(title);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmProyectos.setVisible(true);
		} else {
			frmProyectos.setVisible(false);
		}

	}
	
	public void clearProyectos() {
		//delete all rows
		int rows = model_table.getRowCount();
		for (int i = rows-1; i >= 0; i--) {
			model_table.removeRow(i);
		}
	}

	public void printProyectos(ArrayList<Proyecto> proyectos) {
	    
	    //add client values
		for (Proyecto proyecto : proyectos) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(proyecto.getId());
			rowData.add(proyecto.getNombre());
			rowData.add(proyecto.getHoras());
			model_table.addRow(rowData);
		}
	}
}
