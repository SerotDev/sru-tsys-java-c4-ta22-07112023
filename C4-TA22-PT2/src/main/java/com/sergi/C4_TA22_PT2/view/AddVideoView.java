package com.sergi.C4_TA22_PT2.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddVideoView {
	private JFrame frmAddVideo;
	private JTextField tfTitulo;
	private JTextField tfDirector;
	private JTextField tfIdCliente;
	public JButton btnAddVideo;

	/**
	 * Create the application.
	 */
	public AddVideoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddVideo = new JFrame();
		frmAddVideo.setTitle("Añadir video");
		frmAddVideo.setBounds(100, 100, 407, 320);
		frmAddVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddVideo.getContentPane().setLayout(null);
		frmAddVideo.setLocationRelativeTo(null);
		frmAddVideo.setResizable(false);

		JLabel lblTitle = new JLabel("Añadir Nuevo Video", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(10, 21, 373, 32);
		frmAddVideo.getContentPane().add(lblTitle);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(34, 90, 99, 22);
		frmAddVideo.getContentPane().add(lblTitulo);

		tfTitulo = new JTextField();
		tfTitulo.setBounds(143, 90, 212, 22);
		frmAddVideo.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);

		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirector.setBounds(34, 122, 99, 22);
		frmAddVideo.getContentPane().add(lblDirector);

		tfDirector = new JTextField();
		tfDirector.setColumns(10);
		tfDirector.setBounds(143, 122, 212, 22);
		frmAddVideo.getContentPane().add(tfDirector);

		JLabel lblIdCliente = new JLabel("ID Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(34, 154, 99, 22);
		frmAddVideo.getContentPane().add(lblIdCliente);

		tfIdCliente = new JTextField();
		tfIdCliente.setColumns(10);
		tfIdCliente.setBounds(143, 154, 212, 22);
		frmAddVideo.getContentPane().add(tfIdCliente);

		btnAddVideo = new JButton("Añadir Cliente");
		btnAddVideo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddVideo.setBounds(34, 213, 321, 43);
		frmAddVideo.getContentPane().add(btnAddVideo);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmAddVideo.setVisible(true);
		} else {
			frmAddVideo.setVisible(false);
		}
	}

	public String getTfTitulo() {
		return tfTitulo.getText();
	}

	public String getTfDirector() {
		return tfDirector.getText();
	}

	public String getTfIdCliente() {
		return tfIdCliente.getText();
	}

}
