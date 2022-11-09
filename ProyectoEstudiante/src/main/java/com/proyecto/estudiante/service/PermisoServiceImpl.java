package com.proyecto.estudiante.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.Permisos.Dto.PermisoDto;
import com.proyecto.estudiante.entity.Permiso;
@Service
public class PermisoServiceImpl  implements PermisoService{
	
	@Autowired 
	@Lazy
	private PermisoService permisoService;

	@Override
	@Transactional
	public Iterable<Permiso> finAll() {
		return permisoService.finAll();
	}

	@Override
	public Page<Permiso> finAll(Pageable pageanle) {
		return permisoService.finAll(pageanle);
	}

	@Override
	public Optional<Permiso> findById(Long id) {
		return permisoService.findById(id);
	}

	@Override
	public Permiso save(Permiso permiso) {
		return permisoService.save(permiso);
	}

	@Override
	@Transactional
	public void deletById(Long id) {
		permisoService.deletById(id);
	}

	@Override
	public Optional<PermisoDto> findByIdDto(Long id) {
		return permisoService.findByIdDto(id);
	}

	@Override
	public PermisoDto save(PermisoDto permisoDto) {
		return permisoService.save(permisoDto);
	}

}
