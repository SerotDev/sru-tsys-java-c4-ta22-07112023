package com.sergi.C4_TA22_PT2.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.sergi.C4_TA22_PT2.model.Cliente;
import com.sergi.C4_TA22_PT2.model.Video;

public class VideoView {
	private JFrame frmVudeo;
	private JPanel mainPanel;
	private JLabel lblTitle;
	private JTable table;
	private DefaultTableModel model_table;
	private JScrollPane scroll_table;
	public JButton btnDeleteVideo;
	public JButton btnAddVideo;
	public JButton btnEditVideo;
	public JButton btnViewClientes;

	/**
	 * Create the application.
	 */
	public VideoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmVudeo = new JFrame();
		frmVudeo.setBounds(100, 100, 650, 459);
		frmVudeo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVudeo.setLocationRelativeTo(null);
		frmVudeo.setResizable(false);
		frmVudeo.getContentPane().setLayout(null);
        
		mainPanel = new JPanel(null);
		mainPanel.setLocation(10, 0);
		mainPanel.setSize(616, 412);
		
		lblTitle = new JLabel("Lista de Videos del Cliente", SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblTitle.setBounds(10, 10, 596, 32);
	    mainPanel.add(lblTitle);

	    table = new JTable();
	    table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    table.setRowHeight(24);
	    model_table = new DefaultTableModel();
	    table.setModel(model_table);
	    
	    // Create a custom renderer for the table header
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 14)); // Set font for column names
        model_table = new DefaultTableModel();
        table.setModel(model_table);
	    
	    // add table to scroll panel
	    scroll_table = new JScrollPane(table);
	    scroll_table.setBounds(10, 49, 596, 303);
	    scroll_table.setVisible(true);
	    //add column names
	    model_table.addColumn("Id");
	    model_table.addColumn("Título");
	    model_table.addColumn("Director");
	    model_table.addColumn("ID Cliente");
	    mainPanel.add(scroll_table);

	    frmVudeo.getContentPane().add(mainPanel);
	    
	    btnEditVideo = new JButton("Editar Video");
	    btnEditVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnEditVideo.setBounds(166, 362, 140, 40);
	    mainPanel.add(btnEditVideo);
	    
	    btnDeleteVideo = new JButton("Eliminar Video");
	    btnDeleteVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnDeleteVideo.setBounds(10, 362, 146, 40);
	    mainPanel.add(btnDeleteVideo);
	    
	    btnAddVideo = new JButton("Añadir Video");
	    btnAddVideo.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnAddVideo.setBounds(316, 362, 140, 40);
	    mainPanel.add(btnAddVideo);
	    
	    btnViewClientes = new JButton("Ver Clientes");
	    btnViewClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnViewClientes.setBounds(466, 362, 140, 40);
	    mainPanel.add(btnViewClientes);
	}

	public void setTitle(String title) {
		frmVudeo.setTitle(title);
	}
	
	public void setLblTitle(String title) {
		lblTitle.setText(title);
	}

	public void setVisible(boolean visible) {
		if (visible) {
			frmVudeo.setVisible(true);
		} else {
			frmVudeo.setVisible(false);
		}

	}
	
	public void clearVideos() {
		//delete all rows
		int rows = model_table.getRowCount();
		for (int i = rows-1; i >= 0; i--) {
			model_table.removeRow(i);
		}
	}

	public void printVideos(ArrayList<Video> videos) {
	    
	    //add client values
		for (Video video : videos) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(video.getId());
			rowData.add(video.getTitulo());
			rowData.add(video.getDirector());
			rowData.add(video.getIdCliente());
			model_table.addRow(rowData);
		}
	}
}
