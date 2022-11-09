package com.proyecto.estudiante.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.estudiante.entity.Usuario;
import com.proyecto.estudiante.service.UsuarioService;
import com.proyecto.estudiante.util.Util;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	@RequestMapping("/add/")
	public ResponseEntity<?> create(@RequestBody Usuario usuarioResp) {
		
		if (Util.verificarParametrosUsuario(usuarioResp.getIdUsuarios(), usuarioResp.getNombre(),usuarioResp.getCorreo(),usuarioResp.getCargo(),usuarioResp.getContraseña(),usuarioResp.getLogin())){
			Usuario usuario = new Usuario(usuarioResp.getIdUsuarios(),usuarioResp.getNombre(),usuarioResp.getCorreo(),usuarioResp.getCargo(),usuarioResp.getContraseña(),usuarioResp.getLogin()) ;
			
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parametros incorrectos");
	}
	
	@GetMapping
	@RequestMapping("consultar/{idUsuario}")
	public ResponseEntity<?> read(@PathVariable("idUsuario") Long idUsuario) {
		System.out.println(idUsuario +" aquii");
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);
		
		Usuario respuesta = new Usuario(usuario.get().getIdUsuarios(),usuario.get().getNombre(),usuario.get().getCorreo(), usuario.get().getCargo(), usuario.get().getContraseña(), usuario.get().getLogin());
		
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(respuesta);
	}
	
	@PutMapping
	@RequestMapping("/modificar")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioAtributos) {

		if (Util.validarUsuario(usuarioAtributos)) {

			Optional<Usuario> usuario = usuarioService.findById(usuarioAtributos.getIdUsuarios());

			if (!usuario.isPresent())
				return ResponseEntity.notFound().build();
			
			usuario.get().setNombre(usuarioAtributos.getNombre());
			usuario.get().setCorreo(usuarioAtributos.getCorreo());
			usuario.get().setCargo(usuarioAtributos.getCargo());
			usuario.get().setContraseña(usuarioAtributos.getContraseña());
			usuario.get().setLogin(usuarioAtributos.getLogin());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");

	}
		
	
	@DeleteMapping
	@RequestMapping("eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (Util.validarId(id)) {

			Optional<Usuario> usuario = usuarioService.findById(id);

			if (!usuario.isPresent())

				return ResponseEntity.notFound().build();

			usuarioService.deletById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");
	}
}


