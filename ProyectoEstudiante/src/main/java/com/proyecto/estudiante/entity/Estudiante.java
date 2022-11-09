package com.proyecto.estudiante.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="estudiante")
public class Estudiante {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiante")
	private long id_estudiante;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="grado")
	private String grado;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="correo")
	private String correo;
	
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List  <Permiso> permiso;
	
	public Estudiante () {
		
	}

	public Estudiante(Long id,String nombre, String apellido, String celular, String correo,  String grado) {
		super();
		this.id_estudiante = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.correo = correo;
		this.grado = grado;
	}
	public Estudiante(String nombre, String apellido, String celular, String correo,  String grado) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.correo = correo;
		this.grado = grado;
	}


	public long getIdEstudiante() {
		return id_estudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Permiso> getPermiso() {
		return permiso;
	}

	public void setPermiso(List<Permiso> permiso) {
		this.permiso = permiso;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String datos() {
		String datos = "";
		datos = this.nombre+" "+this.id_estudiante+" ";
				
		return datos;
	}
	
	
	
	

}
