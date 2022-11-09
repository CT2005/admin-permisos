package com.proyecto.estudiante.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

import com.proyecto.Permisos.Dto.PermisoDto;
import com.proyecto.estudiante.entity.Permiso;
import com.proyecto.estudiante.service.EstudianteService;
import com.proyecto.estudiante.service.PermisoService;
import com.proyecto.estudiante.util.Util;

@RestController
@RequestMapping("/api/permiso")
public class PermisoController {

	@Autowired
	@Lazy
	private PermisoService permisoService;
	@Autowired
	@Lazy
	private EstudianteService estudianteService;

	@PostMapping
	@RequestMapping("/add")
	public ResponseEntity<?> create(@RequestBody PermisoDto permisoDto) {

		if (Util.verificarPermisoDto(permisoDto.getFecha(),permisoDto.getDescripcion(),permisoDto.getIdEstudiante(),permisoDto.getIdUsuario())); {
			
			PermisoDto permiso = new PermisoDto(permisoDto.getFecha(), permisoDto.getDescripcion(), permisoDto.getIdEstudiante(), permisoDto.getIdEstudiante());

			return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(permisoDto));		
		} else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parametros incorrectos");
	
	}

	@GetMapping
	@RequestMapping("consultar/{idPermiso}")
	public ResponseEntity<?> read(@PathVariable Long idPermiso) {
		Optional<Permiso> permiso = permisoService.findById(idPermiso);

		Permiso respuesta = new Permiso(permiso.get().getFecha(), permiso.get().getDescripcion(),
				 permiso.get().getEstudiante(), permiso.get().getUsuario());

		if (!permiso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(respuesta);
	}

	@PutMapping
	@RequestMapping("/modificar")
	public ResponseEntity<?> update(@RequestBody PermisoDto permisoAtributos) {

		if (Util.validarPermiso(permisoAtributos)) {

			Optional<PermisoDto> permisoDto = permisoService.findByIdDto(permisoAtributos.getIdPermiso());

			if (!permisoDto.isPresent())
				return ResponseEntity.notFound().build();

			permisoDto.get().setFecha(permisoAtributos.getFecha());
			permisoDto.get().setDescripcion(permisoAtributos.getDescripcion());

			return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(permisoAtributos));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");

	}

	@DeleteMapping
	@RequestMapping("eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (Util.validarId(id)) {

			Optional<Permiso> usuario = permisoService.findById(id);

			if (!usuario.isPresent())

				return ResponseEntity.notFound().build();

			permisoService.deletById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");
	}

}
