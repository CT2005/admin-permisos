package com.proyecto.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.estudiante.entity.Permiso;
@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {

}
