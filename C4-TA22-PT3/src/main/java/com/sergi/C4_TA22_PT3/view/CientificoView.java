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

import com.sergi.C4_TA22_PT3.model.Cientifico;

public class CientificoView {
	private JFrame frmCientificos;
	private JPanel mainPanel;
	public JButton btnViewProyectos;
	public JButton btnViewAsignados;
	private JTable table;
	private DefaultTableModel model_table;
	private JScrollPane scroll_table;
	public JButton btnDeleteCientifico;
	public JButton btnAddCientifico;
	public JButton btnEditCientifico;

	/**
	 * Create the application.
	 */
	public CientificoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCientificos = new JFrame();
		frmCientificos.setBounds(100, 100, 650, 521);
		frmCientificos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCientificos.setLocationRelativeTo(null);
		frmCientificos.setResizable(false);
		frmCientificos.getContentPane().setLayout(null);
        
		mainPanel = new JPanel(null);
		mainPanel.setLocation(10, 0);
		mainPanel.setSize(616, 474);
		
	    btnViewProyectos = new JButton("Ver Lista de Proyectos");
	    btnViewProyectos.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewProyectos.setBounds(10, 10, 293, 40);
	    mainPanel.add(btnViewProyectos);
	    
	    btnViewAsignados = new JButton("Ver Lista de Asignados");
	    btnViewAsignados.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnViewAsignados.setBounds(313, 10, 293, 40);
	    mainPanel.add(btnViewAsignados);
		
		JLabel lblTitle = new JLabel("Lista de Cientificos", SwingConstants.CENTER);
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
	    model_table.addColumn("DNI");
	    model_table.addColumn("Nombre y Apellidos");
	    mainPanel.add(scroll_table);

	    frmCientificos.getContentPane().add(mainPanel);
	    
	    btnEditCientifico = new JButton("Editar Cientifico");
	    btnEditCientifico.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnEditCientifico.setBounds(210, 424, 196, 40);
	    mainPanel.add(btnEditCientifico);
	    
	    btnDeleteCientifico = new JButton("Eliminar Cientifico");
	    btnDeleteCientifico.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnDeleteCientifico.setBounds(10, 424, 190, 40);
	    mainPanel.add(btnDeleteCientifico);
	    
	    btnAddCientifico = new JButton("Añadir Cientifico");
	    btnAddCientifico.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnAddCientifico.setBounds(416, 424, 190, 40);
	    mainPanel.add(btnAddCientifico);
	}

	public void setTitle(String title) {
		frmCientificos.setTitle(title);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmCientificos.setVisible(true);
		} else {
			frmCientificos.setVisible(false);
		}

	}
	
	public void clearCientificos() {
		//delete all rows
		int rows = model_table.getRowCount();
		for (int i = rows-1; i >= 0; i--) {
			model_table.removeRow(i);
		}
	}

	public void printCientificos(ArrayList<Cientifico> cientificos) {
	    
	    //add client values
		for (Cientifico cientifico : cientificos) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(cientifico.getDni());
			rowData.add(cientifico.getNomApels());
			model_table.addRow(rowData);
		}
	}
}
