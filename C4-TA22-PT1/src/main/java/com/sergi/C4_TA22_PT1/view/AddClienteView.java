package com.sergi.C4_TA22_PT1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.sergi.C4_TA22_PT1.controller.ClienteController;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClienteView {

	private JFrame frmAddNewClient;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfDni;
	private JTextField tfFecha;
	public JButton btnAddCliente;

	/**
	 * Create the application.
	 */
	public AddClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewClient = new JFrame();
		frmAddNewClient.setTitle("Add New Client");
		frmAddNewClient.setBounds(100, 100, 407, 381);
		frmAddNewClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewClient.getContentPane().setLayout(null);
		frmAddNewClient.setLocationRelativeTo(null);
		frmAddNewClient.setResizable(false);
		
		JLabel lblTitle = new JLabel("Añadir Nuevo Cliente", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmAddNewClient.getContentPane().add(lblTitle);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(34, 90, 99, 22);
		frmAddNewClient.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(143, 90, 212, 22);
		frmAddNewClient.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(34, 122, 99, 22);
		frmAddNewClient.getContentPane().add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(143, 122, 212, 22);
		frmAddNewClient.getContentPane().add(tfApellidos);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccin.setBounds(34, 154, 99, 22);
		frmAddNewClient.getContentPane().add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(143, 154, 212, 22);
		frmAddNewClient.getContentPane().add(tfDireccion);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(34, 186, 99, 22);
		frmAddNewClient.getContentPane().add(lblDni);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(143, 186, 212, 22);
		frmAddNewClient.getContentPane().add(tfDni);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(34, 218, 99, 22);
		frmAddNewClient.getContentPane().add(lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(143, 218, 212, 22);
		frmAddNewClient.getContentPane().add(tfFecha);
		
		btnAddCliente = new JButton("Añadir Cliente");
		btnAddCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCliente.setBounds(34, 276, 321, 43);
		frmAddNewClient.getContentPane().add(btnAddCliente);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmAddNewClient.setVisible(true);
		} else {
			frmAddNewClient.setVisible(false);
		}
	}
	
	public String getTfNombre() {
		return tfNombre.getText();
	}
	
	public String getTfApellidos() {
		return tfApellidos.getText();
	}
	
	public String getTfDireccion() {
		return tfDireccion.getText();
	}
	
	public String getTfDni() {
		return tfDni.getText();
	}
	
	public String getTfFecha() {
		return tfFecha.getText();
	}
	
}
