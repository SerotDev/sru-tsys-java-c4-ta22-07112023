package com.sergi.C4_TA22_PT2.services;

import java.util.ArrayList;

import com.sergi.C4_TA22_PT2.model.DbConnection;
import com.sergi.C4_TA22_PT2.model.Video;

public class VideoService {
	/**
	* Create new video
	* 
	* @param titulo the title of the video
	* @param director the director of the video
	* @param idCliente the client id
	*/
	public void createVideo(String titulo, String director, String idCliente){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//it adds the new client to the database
		connection.insertData("videos",""
				+ "(\"" + titulo + "\","
				+ "\"" + director + "\","
				+ "\"" + idCliente + "\")");
		//it closes the connection
		connection.closeConnection();
	}
	
	/**
	 * it returns all videos in the videos table
	 * @return list of all videos
	 */
	public static ArrayList<Video> readTableVideos () {
		ArrayList<Video> listaVideos = new ArrayList<Video>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrVideos = connection.getTableContent("videos");
		for (String row[]: listaStrVideos) { 
			Video video = new Video();
			video.setId(Integer.parseInt(row[0]));
			video.setTitulo(row[1]);
			video.setDirector(row[2]);
			video.setIdCliente(Integer.parseInt(row[3]));
			listaVideos.add(video);
		}
		System.out.println("Videos collected from table videos.");
		//it closes the conection
		connection.closeConnection();
		return listaVideos;
	}
	
	/**
	 * it returns videos whith a condition
	 * @return list of videos that fulfill a condition
	 */
	public static ArrayList<Video> getVideosWithCondition (String condition) {
		ArrayList<Video> listaVideos = new ArrayList<Video>();
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//we get an ArrayList of the data of the specified table in String format and we parse that to String
		ArrayList<String[]> listaStrVideos = connection.getTableContent("videos", condition);
		for (String row[]: listaStrVideos) { 
			Video video = new Video();
			video.setId(Integer.parseInt(row[0]));
			video.setTitulo(row[1]);
			video.setDirector(row[2]);
			video.setIdCliente(Integer.parseInt(row[3]));
			listaVideos.add(video);
		}
		System.out.println("Videos collected from table clientes.");
		//it closes the conection
		connection.closeConnection();
		return listaVideos;
	}

	/**
	 * update specified video by id
	 * @param video video to be updated
	 */
	public void updateVideo(Video video){
		//instanciate the class and open connection
		DbConnection connection = new DbConnection();
		//it opens the connection
		connection.openConnection();
		//updates the client by id
		connection.updateData("videos",""
				+ "title=\"" + video.getTitulo() + "\","
				+ "director=\"" + video.getDirector() + "\","
				+ "cli_id=\"" + video.getIdCliente() + "\""
				, "id=" + video.getId()); //condition
    	//it closes the connection
		connection.closeConnection();
	}

	/**
	 * delete the video by its id
	 * @param id of the video to delete
	 */
	public void deleteVideo(int idVideo){
		//instanciate the class and open connection
	   	DbConnection connection = new DbConnection();
	   	//it opens the connection
	   	connection.openConnection();
	   	//deletes the client by id
	   	connection.deleteData("videos", "id=" + idVideo);
	   	//it closes the connection
	   	connection.closeConnection();
	}
}
