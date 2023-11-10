package com.sergi.C4_TA22_PT2.model;

public class Video {
	private int id;
	private String titulo;
	private String director;
	private int idCliente;
	
	public Video() {
	}
	
	public Video(int id, String titulo, String director, int idCliente) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
