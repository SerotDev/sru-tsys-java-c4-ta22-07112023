package com.sergi.C4_TA22_PT3.model;

public class Cientifico {
	private String dni;
	private String nomApels;
	
	public Cientifico() {
	}
	
	public Cientifico(String dni, String nomApels) {
		this.dni = dni;
		this.nomApels = nomApels;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (isDni(dni)) {
			this.dni = dni;
		} else {
			System.out.println("Failed to enter data into Cientifico, " + dni + " its not a dni format.");
		}
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		if (isVarchar(nomApels, 255)) {
			this.nomApels = nomApels;
		} else {
			System.out.println("Failed to enter data into Cientifico, " + nomApels + " its not a varchar(255).");
		}
	}

	public static boolean isDni(String dni) {
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
