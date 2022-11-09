package com.proyecto.Permisos.Dto;

public class PermisoDto {
	private long idPermiso;
	private String fecha;
	private String descripcion;
	private int idEstudiante;
	private int idUsuario;

	public PermisoDto() {

	}

	public PermisoDto(String fecha, String descripcion, int idEstudiante, int idUsuario) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.idEstudiante = idEstudiante;
		this.idUsuario = idUsuario;
	}



	public long getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
