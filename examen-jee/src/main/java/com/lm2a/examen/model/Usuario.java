package com.lm2a.examen.model;

import java.util.Date;

/**
 * 
 * @author lm2a
 *
 */
public class Usuario {
	protected int id;
	protected String nombre;
	protected String email;
	protected Date fechaNacimiento;
	
	public Usuario() {
	}

	public Usuario(int id, String nombre, String email, Date fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNac;
	}
	
	

	public Usuario(String nombre, String email, Date fechaNac) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNac;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean equals(final java.lang.Object o) {
		Usuario u = (Usuario)o;
		if (this.nombre == null ? u.nombre != null : !this.nombre.equals(u.nombre)) return false;
		return true;
	}

}
