package com.sergi.C4_TA22_PT3.model;

public class Asignado {
	private int id;
	private String dniCientifico;
	private String idProyecto;
	
	public Asignado() {
	}
	
	public Asignado(int id, String dniCientifico, String idProyecto) {
		this.id = id;
		this.dniCientifico = dniCientifico;
		this.idProyecto = idProyecto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDniCientifico() {
		return dniCientifico;
	}

	public void setDniCientifico(String dniCientifico) {
		if (isDni(dniCientifico)) {
			this.dniCientifico = dniCientifico;
		} else {
			System.out.println("Failed to enter data into Asignado, " + dniCientifico + " its not a dni format.");
		}
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		if (isVarchar(idProyecto, 4)) {
			this.idProyecto = idProyecto;
		} else {
			System.out.println("Failed to enter data into Asignado, " + idProyecto + " its not a char(4).");
		}
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
}
