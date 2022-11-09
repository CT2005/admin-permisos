package com.proyecto.estudiante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.estudiante.entity.Estudiante;

public interface EstudianteService {

	public Iterable<Estudiante> finAll();

	public Page<Estudiante> finAll(Pageable pageanle);

	public Optional<Estudiante> findById(Long id);

	public Estudiante save(Estudiante estudiante);

	void deletById(Long id);

}
