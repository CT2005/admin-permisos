
package com.proyecto.estudiante.util;

import com.proyecto.Permisos.Dto.PermisoDto;
import com.proyecto.estudiante.entity.Estudiante;
import com.proyecto.estudiante.entity.Permiso;
import com.proyecto.estudiante.entity.Usuario;

public class Util {

	public static boolean verificarParametros(String nombre, String apellido, String celular, String correo,
			String grado) {

		if (nombre == "")
			return false;
		else if (nombre == null)
			return false;
		else if (nombre.trim().length() > 45)
			return false;

		if (apellido == "")
			return false;
		else if (apellido == null)
			return false;
		else if (apellido.trim().length() > 45)
			return false;

		if (celular == (""))
			return false;
		else if (celular == null)
			return false;

		if (correo == "")
			return false;
		else if (correo == null)
			return false;
		else if (correo.trim().length() > 45)
			return false;

		if (grado == "")
			return false;
		else if (grado == null)
			return false;
		else if (grado.trim().length() > 45)
			return false;

		return true;

	}

	public static boolean validarEstudiante(Estudiante estudiante) {

		if (estudiante == null)
			return false;

		else if (estudiante.getNombre() == "")
			return false;
		else if (estudiante.getNombre() == null)
			return false;
		else if (estudiante.getApellido() == null)
			return false;
		else if (estudiante.getApellido() == (""))
			return false;
		else if (estudiante.getGrado() == "")
			return false;
		else if (estudiante.getGrado() == null)
			return false;
		else if (estudiante.getCelular() == (""))
			return false;
		else if (estudiante.getGrado() == null)
			return false;
		else if (estudiante.getCorreo() == "")
			return false;
		else if (estudiante.getCorreo() == null)
			return false;
		return tru
	}

	public static boolean validarPermiso(PermisoDto permisoAtributos) {

		if (permisoAtributos == null)
			return false;
		else if (permisoAtributos.getIdPermiso()==0)
			return false;
		else if (permisoAtributos.getFecha() == "")
			return false;
		else if (permisoAtributos.getFecha() == null)
			return false;
		else if (permisoAtributos.getDescripcion() == null)
			return false;
		else if (permisoAtributos.getDescripcion() == (""))
			return false;
		else if (permisoAtributos.getIdEstudiante()==0)
			return false;
		else if (permisoAtributos.getIdPermiso()==0)
			return false;
		return true;
	}

	public static boolean validarUsuario(Usuario usuario) {

		if (usuario == null)
			return false;
		else if (usuario.getNombre() == null)
			return false;
		else if (usuario.getNombre() == "")
			return false;
		else if (usuario.getCorreo() == null)
			return false;
		else if (usuario.getCorreo() == null)
			return false;
		else if (usuario.getCargo() == (""))
			return false;
		else if (usuario.getCargo() == null)
			return false;
		else if (usuario.getContraseña() == (""))
			return false;
		else if (usuario.getContraseña() == null)
			return false;
		else if (usuario.getLogin() == (""))
			return false;
		else if (usuario.getLogin() == null)
			return false;
		return true;
	}
	
	public static boolean validarId(Long id) {

		if (id == 0)
			return false;
		return true;
	}
	
	public static boolean verificarParametrosUsuario(Long idUsuario, String nombre, String correo, String cargo, String contraseña, String login) {

		if (nombre == "")
			return false;
		else if (nombre == null)
			return false;
		else if (nombre.trim().length() > 45)
			return false;

		if (cargo == "")
			return false;
		else if (cargo == null)
			return false;
		else if (cargo.trim().length() > 45)
			return false;

		if (correo == "")
			return false;
		else if (correo == null)
			return false;
		else if (correo.trim().length() > 45)
			return false;

		if (contraseña == "")
			return false;
		else if (contraseña == null)
			return false;
		else if (contraseña.trim().length() > 45)
			return false;
		
		if (login == "")
			return false;
		else if (login == null)
			return false;
		else if (login.trim().length() > 45)
			return false;
		
		if (idUsuario == null)
			return false;

		return true;

	}
	
	public static boolean verificarParametrosPermiso(String fecha, String descripcion,  Estudiante estudiante, Usuario usuario) {

		if (fecha == "")
			return false;
		else if (fecha == null)
			return false;

		if ( descripcion== "")
			return false;
		else if (descripcion == null)
			return false;
		if (estudiante == null)
			return false;
		if (estudiante == null)
			return false;
		

		return true;

	}
	
	public static boolean verificarPermisoDto(String fecha, String descripcion, int idEstudiante, int idUsuario) {
		
		if ( descripcion== "")
			return false;
		else if (descripcion == null)
			return false;
		if (fecha == null)
			return false;
		if ( idEstudiante== 0)
			return false;
		if (idUsuario == 0)
			return false;
		
		return true;
	}

}
