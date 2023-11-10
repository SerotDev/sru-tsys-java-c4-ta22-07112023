package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditCientificoView {
	private JFrame frmEditCientifico;
	private JTextField tfNomApels;
	private JTextField tfDni;
	public JButton btnEditCientifico;

	/**
	 * Create the application.
	 */
	public EditCientificoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditCientifico = new JFrame();
		frmEditCientifico.setTitle("Editar Cientifico");
		frmEditCientifico.setBounds(100, 100, 407, 267);
		frmEditCientifico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditCientifico.getContentPane().setLayout(null);
		frmEditCientifico.setLocationRelativeTo(null);
		frmEditCientifico.setResizable(false);
		
		JLabel lblTitle = new JLabel("Editar Cientifico", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmEditCientifico.getContentPane().add(lblTitle);
	    
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbDni.setBounds(34, 75, 99, 22);
		frmEditCientifico.getContentPane().add(lbDni);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(143, 75, 212, 22);
		frmEditCientifico.getContentPane().add(tfDni);
		
		JLabel lblNomApels = new JLabel("Nom Apels:");
		lblNomApels.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomApels.setBounds(34, 107, 99, 22);
		frmEditCientifico.getContentPane().add(lblNomApels);
		
		tfNomApels = new JTextField();
		tfNomApels.setBounds(143, 107, 212, 22);
		frmEditCientifico.getContentPane().add(tfNomApels);
		tfNomApels.setColumns(10);
		
		btnEditCientifico = new JButton("Aceptar");
		btnEditCientifico.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCientifico.setBounds(34, 157, 321, 43);
		frmEditCientifico.getContentPane().add(btnEditCientifico);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmEditCientifico.setVisible(true);
		} else {
			frmEditCientifico.setVisible(false);
		}
	}
	
	public String getTfDni() {
		return tfDni.getText();
	}
	
	public void setTfDni(String dni) {
		tfDni.setText(dni);
	}
	
	public String getTfNomApels() {
		return tfNomApels.getText();
	}
	
	public void setTfNomApels(String nomApels) {
		tfNomApels.setText(nomApels);
	}

}