package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddAsignadoView {
	private JFrame frmAddAsignado;
	private JTextField tfIdProyecto;
	private JTextField tfDniCientifico;
	public JButton btnAddAsignado;

	/**
	 * Create the application.
	 */
	public AddAsignadoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddAsignado = new JFrame();
		frmAddAsignado.setTitle("Añadir Asignación");
		frmAddAsignado.setBounds(100, 100, 407, 260);
		frmAddAsignado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddAsignado.getContentPane().setLayout(null);
		frmAddAsignado.setLocationRelativeTo(null);
		frmAddAsignado.setResizable(false);
		
		JLabel lblTitle = new JLabel("Añadir Asignación", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmAddAsignado.getContentPane().add(lblTitle);
	    
		JLabel lbDniCientifico = new JLabel("DNI Cientifico:");
		lbDniCientifico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbDniCientifico.setBounds(34, 75, 113, 22);
		frmAddAsignado.getContentPane().add(lbDniCientifico);
		
		tfDniCientifico = new JTextField();
		tfDniCientifico.setColumns(10);
		tfDniCientifico.setBounds(143, 75, 212, 22);
		frmAddAsignado.getContentPane().add(tfDniCientifico);
		
		JLabel lblIdProyecto = new JLabel("ID Proyecto:");
		lblIdProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdProyecto.setBounds(34, 107, 99, 22);
		frmAddAsignado.getContentPane().add(lblIdProyecto);
		
		tfIdProyecto = new JTextField();
		tfIdProyecto.setBounds(143, 107, 212, 22);
		frmAddAsignado.getContentPane().add(tfIdProyecto);
		tfIdProyecto.setColumns(10);
		
		btnAddAsignado = new JButton("Añadir Asignación");
		btnAddAsignado.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddAsignado.setBounds(34, 152, 321, 43);
		frmAddAsignado.getContentPane().add(btnAddAsignado);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmAddAsignado.setVisible(true);
		} else {
			frmAddAsignado.setVisible(false);
		}
	}
	
	public String getTfDniCientifico() {
		return tfDniCientifico.getText();
	}
	
	public String getTfIdProyecto() {
		return tfIdProyecto.getText();
	}
}