package com.proyecto.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.estudiante.entity.Estudiante;
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
	

}
