package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddProyectoView {
	private JFrame frmAddProyecto;
	private JTextField tfNombre;
	private JTextField tfId;
	public JButton btnAddProyecto;
	private JTextField tfHoras;

	/**
	 * Create the application.
	 */
	public AddProyectoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddProyecto = new JFrame();
		frmAddProyecto.setTitle("Añadir Proyecto");
		frmAddProyecto.setBounds(100, 100, 407, 299);
		frmAddProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddProyecto.getContentPane().setLayout(null);
		frmAddProyecto.setLocationRelativeTo(null);
		frmAddProyecto.setResizable(false);
		
		JLabel lblTitle = new JLabel("Añadir Proyecto", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmAddProyecto.getContentPane().add(lblTitle);
	    
		JLabel lbId = new JLabel("ID:");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbId.setBounds(34, 75, 99, 22);
		frmAddProyecto.getContentPane().add(lbId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(143, 75, 212, 22);
		frmAddProyecto.getContentPane().add(tfId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(34, 107, 99, 22);
		frmAddProyecto.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(143, 107, 212, 22);
		frmAddProyecto.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		btnAddProyecto = new JButton("Añadir Proyecto");
		btnAddProyecto.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddProyecto.setBounds(34, 191, 321, 43);
		frmAddProyecto.getContentPane().add(btnAddProyecto);
		
		tfHoras = new JTextField();
		tfHoras.setColumns(10);
		tfHoras.setBounds(143, 139, 212, 22);
		frmAddProyecto.getContentPane().add(tfHoras);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoras.setBounds(34, 139, 99, 22);
		frmAddProyecto.getContentPane().add(lblHoras);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmAddProyecto.setVisible(true);
		} else {
			frmAddProyecto.setVisible(false);
		}
	}
	
	public String getTfId() {
		return tfId.getText();
	}
	
	public String getTfNombre() {
		return tfNombre.getText();
	}

	public String getTfHoras() {
		return tfHoras.getText();
	}
}