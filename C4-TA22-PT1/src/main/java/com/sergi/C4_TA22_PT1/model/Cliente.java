package com.sergi.C4_TA22_PT1.model;

import java.util.Date;

public class Cliente {
	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String dni;
	private String fecha;

	public Cliente() {
	}

	public Cliente(int id, String nombre, String apellidos, String direccion, String dni, String fecha) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (isVarchar(nombre, 250)) {
			this.nombre = nombre;
		} else {
			System.out.println("Failed to enter data into Cliente, " + nombre + " its not a varchar(250).");
		}
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (isVarchar(apellidos, 250)) {
			this.apellidos = apellidos;
		} else {
			System.out.println("Failed to enter data into Cliente, " + apellidos + " its not a varchar(250).");
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (isVarchar(direccion, 250)) {
			this.direccion = direccion;
		} else {
			System.out.println("Failed to enter data into Cliente, " + direccion + " its not a varchar(250).");
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (isDni(dni)) {
			this.dni = dni;
		} else {
			System.out.println("Failed to enter data into Cliente, " + dni + " its not a dni format.");
		}
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		if (isDate(fecha)) {
			this.fecha = fecha;
		} else {
		System.out.println("Failed to enter data into Cliente, " + fecha + " its not a date format.");
		}
	}
	
	public boolean isDate(String date) {
		boolean boolIsDate = false;
		try {
			if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
				boolIsDate = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return boolIsDate;
	}
	
	public boolean isDni(String dni) {
		boolean boolIsDni = false;
		try {
			if (dni.matches("^[0-9]{8}[A-Za-z]$")) {
				boolIsDni = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return boolIsDni;
	}
	
	public boolean isVarchar(String str, int size) {
		boolean boolIsVarchar = false;
		try {
			if (str.length() <= size) {
				boolIsVarchar = true;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return boolIsVarchar;
	}
	
	public boolean isNumber(String str) {
		boolean boolIsNumber = false;
		try {
			if (str.matches("^[0-9]*$")) {
				boolIsNumber = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return boolIsNumber;
	}

}
