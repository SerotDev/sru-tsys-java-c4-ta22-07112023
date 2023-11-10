package com.sergi.C4_TA22_PT2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sergi.C4_TA22_PT2.model.Video;
import com.sergi.C4_TA22_PT2.services.ClienteService;
import com.sergi.C4_TA22_PT2.services.VideoService;
import com.sergi.C4_TA22_PT2.view.AddClienteView;
import com.sergi.C4_TA22_PT2.view.AddVideoView;
import com.sergi.C4_TA22_PT2.view.ClienteView;
import com.sergi.C4_TA22_PT2.view.EditClienteView;
import com.sergi.C4_TA22_PT2.view.EditVideoView;
import com.sergi.C4_TA22_PT2.view.VideoView;

public class VideoController {
	private VideoView videoView;
	private AddVideoView addVideoView;
	private EditVideoView editVideoView;
	
	public VideoController(VideoView videoView, AddVideoView addVideoView, EditVideoView editVideoView) {
		this.videoView = videoView;
		this.addVideoView = addVideoView;
		this.editVideoView = editVideoView;
	}
	
	public void initializeView() {
		printAllVideos();
		videoView.setTitle("Lista de Videos de clientes");
		videoView.setLblTitle("Lista de Videos de clientes");
		videoView.setVisible(true);
		videoView.btnAddVideo.addActionListener(addVideoBtn);
		videoView.btnEditVideo.addActionListener(editVideoBtn);
		videoView.btnDeleteVideo.addActionListener(deleteVideoBtn);
		videoView.btnViewClientes.addActionListener(viewClientesBtn);
		//add action listener to add video view
		addVideoView.btnAddVideo.addActionListener(addVideo);
		//add action listener to edit video view
		editVideoView.btnEditVideo.addActionListener(editVideo);
		
	}
	
	public void updateVideos() {
		videoView.clearVideos();
		printAllVideos();
	}
	
	public void printAllVideos() {
		ArrayList<Video> videos = VideoService.readTableVideos();
		videoView.printVideos(videos);
	}
	
	ActionListener addVideoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//we set window visible
			addVideoView.setVisible(true);
		}
	};
	
	ActionListener addVideo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//inserts the data of the new video
				VideoService videoService = new VideoService();
				videoService.createVideo(
						addVideoView.getTfTitulo(), 
						addVideoView.getTfDirector(),
						addVideoView.getTfIdCliente());
				
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "El video ha sido insertado correctamente para el cliente " + addVideoView.getTfIdCliente() + ".","Video Añadido",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido insertar el nuevo video.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the video values in VideoView
			updateVideos();
			//hidden the AddVideoView
			addVideoView.setVisible(false);
		}
	};
	
	ActionListener editVideoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int idVideoToEdit = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la ID del Video a ediar:","ID de Video a Editar", JOptionPane.INFORMATION_MESSAGE));
				//gets and prints video from database to EditVideoView
				VideoService videoService = new VideoService();
				Video videoAEditar = videoService.getVideosWithCondition("WHERE id=" + idVideoToEdit).get(0);
				editVideoView.setTfId(String.valueOf(videoAEditar.getId()));
				editVideoView.setTfTitulo(videoAEditar.getTitulo());
				editVideoView.setTfDirector(videoAEditar.getDirector());
				editVideoView.setTfIdCliente(String.valueOf(videoAEditar.getIdCliente()));
				//we set window visible
				editVideoView.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el video, si deseas editar el video inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
		}
	};
	
	ActionListener editVideo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//updates the video with the new data
				VideoService videoService = new VideoService();
				Video videoToUpdate = new Video();
				videoToUpdate.setId(Integer.parseInt(editVideoView.getTfId()));
				videoToUpdate.setTitulo(editVideoView.getTfTitulo());
				videoToUpdate.setDirector(editVideoView.getTfDirector());
				videoToUpdate.setIdCliente(Integer.parseInt(editVideoView.getTfIdCliente()));
				//try to updates the video
				videoService.updateVideo(videoToUpdate);
				//shows a message of the insert confirmation
				JOptionPane.showConfirmDialog(null, "El video con id " + editVideoView.getTfId() + " ha sido actualizado correctamente.",
						"Video Actualizado",JOptionPane.CLOSED_OPTION);
			//if it have some problem during execution
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el video","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			//update the client values in ClienteView
			updateVideos();
			//hidden the AddClienteView
			editVideoView.setVisible(false);
		}
	};
	
	ActionListener deleteVideoBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int idVideoToDelete = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la ID del video a eliminar:","Eliminar Video", JOptionPane.INFORMATION_MESSAGE));
				int returnValue = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el video con id " + idVideoToDelete + "?", 
						"Quieres eliminar el video?",
						JOptionPane.YES_NO_OPTION);
				if (returnValue == JOptionPane.YES_OPTION) {
					VideoService videoService = new VideoService();
					videoService.deleteVideo(idVideoToDelete);
					JOptionPane.showConfirmDialog(null, "El video " + idVideoToDelete + " ha sido eliminado correctamente.","Video Eliminado",JOptionPane.CLOSED_OPTION);
					updateVideos();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el video, si deseas eliminar el video inténtalo de nuevo.","ERROR",JOptionPane.CLOSED_OPTION);
				System.out.println("Exeption:" + e2);
			}
			
		}
	};
	
	ActionListener viewClientesBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			videoView.setVisible(false);
			//it initialize the Video Views using VideoController
			ClienteView view = new ClienteView();
			AddClienteView addView = new AddClienteView();
			EditClienteView editView = new EditClienteView();
			ClienteController clienteController = new ClienteController (view, addView, editView); 
			clienteController.initializeView();
		}
	};
}
