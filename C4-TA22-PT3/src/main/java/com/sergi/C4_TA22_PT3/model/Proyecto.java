package com.sergi.C4_TA22_PT3.model;

public class Proyecto {
	private String id;
	private String nombre;
	private int horas;

	public Proyecto() {
	}
	
	public Proyecto(String id, String nombre, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (isChar(id, 4)) {
			this.id = id;
		} else {
			System.out.println("Failed to enter data into Proyecto, " + id + " its not a char(4).");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (isVarchar(nombre, 255)) {
			this.nombre = nombre;
		} else {
			System.out.println("Failed to enter data into Proyecto, " + nombre + " its not a varchar(255).");
		}
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public static boolean isChar(String str, int size) {
		boolean boolIsVarchar = false;
		try {
			if (str.length() == size) {
				boolIsVarchar = true;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return boolIsVarchar;
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
	
}
