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

import com.sergi.C4_TA22_PT3.model.Asignado;

public class AsignadoView {
	private JFrame frmAsignados;
	private JPanel mainPanel;
	public JButton btnViewCientificos;
	public JButton btnViewProyectos;
	private JTable table;
	private DefaultTableModel model_table;
	private JScrollPane scroll_table;
	public JButton btnDeleteAsignado;
	public JButton btnAddAsignado;
	public JButton btnEditAsignado;

	/**
	 * Create the application.
	 */
	public AsignadoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAsignados = new JFrame();
		frmAsignados.setTitle("Lista de Asignados");
		frmAsignados.setBounds(100, 100, 650, 521);
		frmAsignados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsignados.setLocationRelativeTo(null);
		frmAsignados.setResizable(false);
		frmAsignados.getContentPane().setLayout(null);
        
		mainPanel = new JPanel(null);
		mainPanel.setLocation(10, 0);
		mainPanel.setSize(616, 474);
		
	    btnViewCientificos = new JButton("Ver Lista de Cientificos");
	    btnViewCientificos.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewCientificos.setBounds(313, 10, 293, 40);
	    mainPanel.add(btnViewCientificos);
	    
	    btnViewProyectos = new JButton("Ver Lista de Proyectos");
	    btnViewProyectos.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewProyectos.setBounds(10, 10, 293, 40);
	    mainPanel.add(btnViewProyectos);
		
		JLabel lblTitle = new JLabel("Lista de Asignados", SwingConstants.CENTER);
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
	    model_table.addColumn("DNI de Científico");
	    model_table.addColumn("ID de Proyecto");
	    mainPanel.add(scroll_table);

	    frmAsignados.getContentPane().add(mainPanel);
	    
	    btnEditAsignado = new JButton("Editar Asignado");
	    btnEditAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnEditAsignado.setBounds(210, 424, 196, 40);
	    mainPanel.add(btnEditAsignado);
	    
	    btnDeleteAsignado = new JButton("Eliminar Asignado");
	    btnDeleteAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnDeleteAsignado.setBounds(10, 424, 190, 40);
	    mainPanel.add(btnDeleteAsignado);
	    
	    btnAddAsignado = new JButton("Añadir Asignado");
	    btnAddAsignado.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnAddAsignado.setBounds(416, 424, 190, 40);
	    mainPanel.add(btnAddAsignado);
	}

	public void setTitle(String title) {
		frmAsignados.setTitle(title);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmAsignados.setVisible(true);
		} else {
			frmAsignados.setVisible(false);
		}

	}
	
	public void clearAsignados() {
		//delete all rows
		int rows = model_table.getRowCount();
		for (int i = rows-1; i >= 0; i--) {
			model_table.removeRow(i);
		}
	}

	public void printAsignados(ArrayList<Asignado> asignados) {
	    
	    //add client values
		for (Asignado asignado : asignados) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(asignado.getId());
			rowData.add(asignado.getDniCientifico());
			rowData.add(asignado.getIdProyecto());
			model_table.addRow(rowData);
		}
	}
}
