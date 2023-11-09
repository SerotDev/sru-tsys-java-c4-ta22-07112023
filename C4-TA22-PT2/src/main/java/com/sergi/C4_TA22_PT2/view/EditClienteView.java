package com.sergi.C4_TA22_PT2.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditClienteView {

	private JFrame frmEditClient;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfDni;
	private JTextField tfFecha;
	private JTextField tfId;
	public JButton btnEditCliente;

	/**
	 * Create the application.
	 */
	public EditClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditClient = new JFrame();
		frmEditClient.setTitle("Edit Client");
		frmEditClient.setBounds(100, 100, 407, 391);
		frmEditClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditClient.getContentPane().setLayout(null);
		frmEditClient.setLocationRelativeTo(null);
		frmEditClient.setResizable(false);
		
		JLabel lblTitle = new JLabel("Editar Cliente", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmEditClient.getContentPane().add(lblTitle);
	    
		JLabel lbId = new JLabel("ID:");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbId.setBounds(34, 75, 99, 22);
		frmEditClient.getContentPane().add(lbId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(143, 75, 212, 22);
		tfId.setEditable(false);
		frmEditClient.getContentPane().add(tfId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(34, 107, 99, 22);
		frmEditClient.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(143, 107, 212, 22);
		frmEditClient.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(34, 139, 99, 22);
		frmEditClient.getContentPane().add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(143, 139, 212, 22);
		frmEditClient.getContentPane().add(tfApellidos);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccin.setBounds(34, 171, 99, 22);
		frmEditClient.getContentPane().add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(143, 171, 212, 22);
		frmEditClient.getContentPane().add(tfDireccion);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(34, 203, 99, 22);
		frmEditClient.getContentPane().add(lblDni);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(143, 203, 212, 22);
		frmEditClient.getContentPane().add(tfDni);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(34, 235, 99, 22);
		frmEditClient.getContentPane().add(lblFecha);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(143, 235, 212, 22);
		frmEditClient.getContentPane().add(tfFecha);
		
		btnEditCliente = new JButton("Aceptar");
		btnEditCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCliente.setBounds(34, 283, 321, 43);
		frmEditClient.getContentPane().add(btnEditCliente);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmEditClient.setVisible(true);
		} else {
			frmEditClient.setVisible(false);
		}
	}
	
	public String getTfId() {
		return tfId.getText();
	}
	
	public void setTfId(String id) {
		tfId.setText(id);
	}
	
	public String getTfNombre() {
		return tfNombre.getText();
	}
	
	public void setTfNombre(String nombre) {
		tfNombre.setText(nombre);
	}
	
	public String getTfApellidos() {
		return tfApellidos.getText();
	}
	
	public void setTfApellidos(String apellidos) {
		tfApellidos.setText(apellidos);
	}
	
	public String getTfDireccion() {
		return tfDireccion.getText();
	}
	
	public void setTfDireccion(String direccion) {
		tfDireccion.setText(direccion);
	}
	
	public String getTfDni() {
		return tfDni.getText();
	}
	
	public void setTfDni(String dni) {
		tfDni.setText(dni);
	}
	
	public String getTfFecha() {
		return tfFecha.getText();
	}
	
	public void setTfFecha(String fecha) {
		tfFecha.setText(fecha);
	}

}
