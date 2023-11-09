package com.sergi.C4_TA22_PT1.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.sergi.C4_TA22_PT1.model.Cliente;
import java.awt.Font;

public class ClienteView {
	
	private JFrame frmClientes;
	private JPanel mainPanel;
	private JTable table;
	private DefaultTableModel model_table;
	private JScrollPane scroll_table;
	public JButton btnDeleteCliente;
	public JButton btnAddNewCliente;
	public JButton btnEditCliente;

	/**
	 * Create the application.
	 */
	public ClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmClientes = new JFrame();
		frmClientes.setBounds(100, 100, 650, 459);
		frmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientes.setLocationRelativeTo(null);
		frmClientes.setResizable(false);
		frmClientes.getContentPane().setLayout(null);
        
		mainPanel = new JPanel(null);
		mainPanel.setLocation(10, 0);
		mainPanel.setSize(616, 412);
		
		JLabel lblTitle = new JLabel("Lista de Clientes", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 10, 596, 32);
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
	    scroll_table.setBounds(10, 49, 596, 303);
	    scroll_table.setVisible(true);
	    //add column names
	    model_table.addColumn("Id");
	    model_table.addColumn("Nombre");
	    model_table.addColumn("Apellidos");
	    model_table.addColumn("Dirección");
	    model_table.addColumn("DNI");
	    model_table.addColumn("Fecha");
	    mainPanel.add(scroll_table);

	    frmClientes.getContentPane().add(mainPanel);
	    
	    btnEditCliente = new JButton("Editar Cliente");
	    btnEditCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnEditCliente.setBounds(211, 362, 194, 40);
	    mainPanel.add(btnEditCliente);
	    
	    btnDeleteCliente = new JButton("Eliminar Cliente");
	    btnDeleteCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnDeleteCliente.setBounds(10, 362, 191, 40);
	    mainPanel.add(btnDeleteCliente);
	    
	    btnAddNewCliente = new JButton("Añadir Cliente");
	    btnAddNewCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnAddNewCliente.setBounds(415, 362, 191, 40);
	    mainPanel.add(btnAddNewCliente);
	}

	public void setTitle(String title) {
		frmClientes.setTitle(title);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmClientes.setVisible(true);
		} else {
			frmClientes.setVisible(false);
		}

	}
	
	public void clearClientes() {
		//delete all rows
		int rows = model_table.getRowCount();
		for (int i = rows-1; i >= 0; i--) {
			model_table.removeRow(i);
		}
	}

	public void printClientes(ArrayList<Cliente> clientes) {
	    
	    //add client values
		for (Cliente cliente : clientes) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(cliente.getId());
			rowData.add(cliente.getNombre());
			rowData.add(cliente.getApellidos());
			rowData.add(cliente.getDireccion());
			rowData.add(cliente.getDni());
			rowData.add(cliente.getFecha());
			model_table.addRow(rowData);
		}
	}
}
