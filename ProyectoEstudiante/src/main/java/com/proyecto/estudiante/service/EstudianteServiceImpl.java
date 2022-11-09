package com.proyecto.estudiante.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.estudiante.entity.Estudiante;
import com.proyecto.estudiante.repository.EstudianteRepository;
@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	@Transactional
	public Iterable<Estudiante> finAll() {
		return estudianteRepository.findAll();
	}

	@Override
	@Transactional()
	public Page<Estudiante> finAll(Pageable pageanle) {
		
		return estudianteRepository.findAll(pageanle);
	}

	

	@Override
	public Estudiante save(Estudiante estudiante) {
		
		return estudianteRepository.save(estudiante);
	}

	@Override
	public void deletById(Long id) {
		estudianteRepository.deleteById(id);;
		
	}

	@Override
	public Optional<Estudiante> findById(Long id) {
	
		return estudianteRepository.findById(id) ;
	}

}
