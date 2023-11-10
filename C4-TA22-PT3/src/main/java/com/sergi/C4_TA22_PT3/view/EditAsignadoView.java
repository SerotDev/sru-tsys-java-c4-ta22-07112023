package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditAsignadoView {
	private JFrame frmEditAsignado;
	private JTextField tfDniCientifico;
	private JTextField tfId;
	public JButton btnEditAsignado;
	private JTextField tfIdProyecto;

	/**
	 * Create the application.
	 */
	public EditAsignadoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditAsignado = new JFrame();
		frmEditAsignado.setTitle("Editar Asignación");
		frmEditAsignado.setBounds(100, 100, 407, 299);
		frmEditAsignado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditAsignado.getContentPane().setLayout(null);
		frmEditAsignado.setLocationRelativeTo(null);
		frmEditAsignado.setResizable(false);
		
		JLabel lblTitle = new JLabel("Editar Asignación", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmEditAsignado.getContentPane().add(lblTitle);
	    
		JLabel lbId = new JLabel("ID:");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbId.setBounds(34, 75, 99, 22);
		frmEditAsignado.getContentPane().add(lbId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(143, 75, 212, 22);
		frmEditAsignado.getContentPane().add(tfId);
		
		JLabel lblDniCientifico = new JLabel("DNI Científico:");
		lblDniCientifico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDniCientifico.setBounds(34, 107, 107, 22);
		frmEditAsignado.getContentPane().add(lblDniCientifico);
		
		tfDniCientifico = new JTextField();
		tfDniCientifico.setBounds(143, 107, 212, 22);
		frmEditAsignado.getContentPane().add(tfDniCientifico);
		tfDniCientifico.setColumns(10);
		
		btnEditAsignado = new JButton("Aceptar");
		btnEditAsignado.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditAsignado.setBounds(34, 191, 321, 43);
		frmEditAsignado.getContentPane().add(btnEditAsignado);
		
		tfIdProyecto = new JTextField();
		tfIdProyecto.setColumns(10);
		tfIdProyecto.setBounds(143, 139, 212, 22);
		frmEditAsignado.getContentPane().add(tfIdProyecto);
		
		JLabel lblIdProyecto = new JLabel("ID Proyecto:");
		lblIdProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdProyecto.setBounds(34, 139, 99, 22);
		frmEditAsignado.getContentPane().add(lblIdProyecto);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmEditAsignado.setVisible(true);
		} else {
			frmEditAsignado.setVisible(false);
		}
	}
	
	public String getTfId() {
		return tfId.getText();
	}
	
	public void setTfId(String id) {
		tfId.setText(id);
	}
	
	public String getTfDniCientifico() {
		return tfDniCientifico.getText();
	}
	
	public void setTfDniCientifico(String dniCientifico) {
		tfDniCientifico.setText(dniCientifico);
	}
	
	public String getTfIdProyecto() {
		return tfIdProyecto.getText();
	}
	
	public void setTfIdProyecto(String idProyecto) {
		tfIdProyecto.setText(idProyecto);
	}
}