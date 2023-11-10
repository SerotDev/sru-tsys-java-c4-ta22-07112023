package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditProyectoView {
	private JFrame frmEditProyecto;
	private JTextField tfNombre;
	private JTextField tfId;
	public JButton btnEditProyecto;
	private JTextField tfHoras;

	/**
	 * Create the application.
	 */
	public EditProyectoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditProyecto = new JFrame();
		frmEditProyecto.setTitle("Editar Proyecto");
		frmEditProyecto.setBounds(100, 100, 407, 299);
		frmEditProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditProyecto.getContentPane().setLayout(null);
		frmEditProyecto.setLocationRelativeTo(null);
		frmEditProyecto.setResizable(false);
		
		JLabel lblTitle = new JLabel("Editar Proyecto", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmEditProyecto.getContentPane().add(lblTitle);
	    
		JLabel lbId = new JLabel("ID:");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbId.setBounds(34, 75, 99, 22);
		frmEditProyecto.getContentPane().add(lbId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(143, 75, 212, 22);
		frmEditProyecto.getContentPane().add(tfId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(34, 107, 99, 22);
		frmEditProyecto.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(143, 107, 212, 22);
		frmEditProyecto.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		btnEditProyecto = new JButton("Aceptar");
		btnEditProyecto.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditProyecto.setBounds(34, 191, 321, 43);
		frmEditProyecto.getContentPane().add(btnEditProyecto);
		
		tfHoras = new JTextField();
		tfHoras.setColumns(10);
		tfHoras.setBounds(143, 139, 212, 22);
		frmEditProyecto.getContentPane().add(tfHoras);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoras.setBounds(34, 139, 99, 22);
		frmEditProyecto.getContentPane().add(lblHoras);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmEditProyecto.setVisible(true);
		} else {
			frmEditProyecto.setVisible(false);
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
	
	public String getTfHoras() {
		return tfHoras.getText();
	}
	
	public void setTfHoras(String horas) {
		tfHoras.setText(horas);
	}
}