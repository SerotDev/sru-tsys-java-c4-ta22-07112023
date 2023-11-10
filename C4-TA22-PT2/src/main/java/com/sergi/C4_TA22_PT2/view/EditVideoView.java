package com.sergi.C4_TA22_PT2.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditVideoView {
	private JFrame frmEditVideo;
	private JTextField tfId;
	private JTextField tfTitulo;
	private JTextField tfDirector;
	private JTextField tfIdCliente;
	public JButton btnEditVideo;

	/**
	 * Create the application.
	 */
	public EditVideoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditVideo = new JFrame();
		frmEditVideo.setTitle("Editar Video");
		frmEditVideo.setBounds(100, 100, 407, 339);
		frmEditVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditVideo.getContentPane().setLayout(null);
		frmEditVideo.setLocationRelativeTo(null);
		frmEditVideo.setResizable(false);
		
		JLabel lblTitle = new JLabel("Editar Video", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 21, 373, 32);
	    frmEditVideo.getContentPane().add(lblTitle);
	    
		JLabel lbId = new JLabel("ID:");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbId.setBounds(34, 75, 99, 22);
		frmEditVideo.getContentPane().add(lbId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(143, 75, 212, 22);
		tfId.setEditable(false);
		frmEditVideo.getContentPane().add(tfId);
		
		JLabel lblTtitulo = new JLabel("Nombre:");
		lblTtitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTtitulo.setBounds(34, 107, 99, 22);
		frmEditVideo.getContentPane().add(lblTtitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(143, 107, 212, 22);
		frmEditVideo.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirector.setBounds(34, 139, 99, 22);
		frmEditVideo.getContentPane().add(lblDirector);
		
		tfDirector = new JTextField();
		tfDirector.setColumns(10);
		tfDirector.setBounds(143, 139, 212, 22);
		frmEditVideo.getContentPane().add(tfDirector);
		
		JLabel lblIdCliente = new JLabel("ID Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(34, 171, 99, 22);
		frmEditVideo.getContentPane().add(lblIdCliente);
		
		tfIdCliente = new JTextField();
		tfIdCliente.setColumns(10);
		tfIdCliente.setBounds(143, 171, 212, 22);
		frmEditVideo.getContentPane().add(tfIdCliente);
		
		btnEditVideo = new JButton("Aceptar");
		btnEditVideo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditVideo.setBounds(34, 227, 321, 43);
		frmEditVideo.getContentPane().add(btnEditVideo);
	}
	
	public void setVisible(boolean visible) {
		if (visible) {
			frmEditVideo.setVisible(true);
		} else {
			frmEditVideo.setVisible(false);
		}
	}
	
	public String getTfId() {
		return tfId.getText();
	}
	
	public void setTfId(String id) {
		tfId.setText(id);
	}
	
	public String getTfTitulo() {
		return tfTitulo.getText();
	}
	
	public void setTfTitulo(String titulo) {
		tfTitulo.setText(titulo);
	}
	
	public String getTfDirector() {
		return tfDirector.getText();
	}
	
	public void setTfDirector(String director) {
		tfDirector.setText(director);
	}
	
	public String getTfIdCliente() {
		return tfIdCliente.getText();
	}
	
	public void setTfIdCliente(String idCliente) {
		tfIdCliente.setText(idCliente);
	}
}
