package com.proyecto.estudiante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.Permisos.Dto.PermisoDto;
import com.proyecto.estudiante.entity.Permiso;

public interface PermisoService  {
	
	public Iterable<Permiso> finAll();

	public Page<Permiso> finAll(Pageable pageanle);

	public Optional<Permiso> findById(Long id);
	
	public Optional<PermisoDto> findByIdDto(Long id);
	
	public PermisoDto save(PermisoDto permisoDto);

	void deletById(Long id);

}
