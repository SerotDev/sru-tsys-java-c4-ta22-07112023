package com.sergi.C4_TA22_PT3.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddCientificoView {
	private JFrame frmAddCientifico;
	private JTextField tfNomApels;
	private JTextField tfDni;
	public JButton btnAddCientifico;

	/**
	 * Create the application.
	 */
	public AddCientificoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCientifico = new JFrame();
		frmAddCientifico.setTitle("Añadir Cientifico");
		frmAddCientifico.setBounds(100, 100, 407, 267);
		frmAddCientifico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCientifico.getContentPane().setLayout(null);
		frmAddCientifico.setLocationRelativeTo(null);
		frmAddCientifico.setResizable(false);
		
		JLabel lblTitle = new JLabel("Añadir Cientifico", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmAddCientifico.getContentPane().add(lblTitle);
	    
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbDni.setBounds(34, 75, 99, 22);
		frmAddCientifico.getContentPane().add(lbDni);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(143, 75, 212, 22);
		frmAddCientifico.getContentPane().add(tfDni);
		
		JLabel lblNomApels = new JLabel("Nom Apels:");
		lblNomApels.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomApels.setBounds(34, 107, 99, 22);
		frmAddCientifico.getContentPane().add(lblNomApels);
		
		tfNomApels = new JTextField();
		tfNomApels.setBounds(143, 107, 212, 22);
		frmAddCientifico.getContentPane().add(tfNomApels);
		tfNomApels.setColumns(10);
		
		btnAddCientifico = new JButton("Añadir Cientifico");
		btnAddCientifico.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCientifico.setBounds(34, 157, 321, 43);
		frmAddCientifico.getContentPane().add(btnAddCientifico);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmAddCientifico.setVisible(true);
		} else {
			frmAddCientifico.setVisible(false);
		}
	}
	
	public String getTfDni() {
		return tfDni.getText();
	}
	
	public String getTfNomApels() {
		return tfNomApels.getText();
	}

}