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

import com.proyecto.estudiante.entity.Estudiante;
import com.proyecto.estudiante.service.EstudianteService;
import com.proyecto.estudiante.util.Util;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
	 
	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping
	@RequestMapping("/add/")
	public ResponseEntity<?> create(@RequestBody Estudiante estudianteResp) {

		if (Util.verificarParametros(estudianteResp.getNombre(), estudianteResp.getApellido(), estudianteResp.getCelular(), estudianteResp.getCorreo(), estudianteResp.getGrado())) {
			Estudiante estudiante = new Estudiante(estudianteResp.getNombre(), estudianteResp.getApellido(), estudianteResp.getCelular(), estudianteResp.getCorreo(), estudianteResp.getGrado());

			return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parametros incorrectos");
	}
	
	@GetMapping
	@RequestMapping("consultar/{idEstudiante}")
	public ResponseEntity<?> read(@PathVariable("idEstudiante") Long idEstudiante) {
		if(Util.validarId(idEstudiante)) {
			
			Optional<Estudiante> estudiante = estudianteService.findById(idEstudiante);
			
			Estudiante respuesta = new Estudiante(estudiante.get().getIdEstudiante(),estudiante.get().getNombre(), estudiante.get().getApellido(), estudiante.get().getCelular(), estudiante.get().getCorreo(), estudiante.get().getGrado());
			
			if (!estudiante.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(respuesta);
		}
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no ingreso un id");

	}
	
	@PutMapping
	@RequestMapping("/modificar")
	public ResponseEntity<?> update(@RequestBody Estudiante estudianteAtributos) {

		if (Util.validarEstudiante(estudianteAtributos)) {

			Optional<Estudiante> estudiante = estudianteService.findById(estudianteAtributos.getIdEstudiante());

			if (!estudiante.isPresent())
				return ResponseEntity.notFound().build();
			
			estudiante.get().setNombre(estudianteAtributos.getNombre());
			estudiante.get().setApellido(estudianteAtributos.getApellido());
			estudiante.get().setCelular(estudianteAtributos.getCelular());
			estudiante.get().setCorreo(estudianteAtributos.getCorreo());
			estudiante.get().setGrado(estudianteAtributos.getGrado());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante.get()));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");

	}
	
	@DeleteMapping
	@RequestMapping("eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	
		if (Util.validarId(id)) {

			Optional<Estudiante> empleado = estudianteService.findById(id);

			if (!empleado.isPresent())

				return ResponseEntity.notFound().build();

			estudianteService.deletById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");
	}
}
	
