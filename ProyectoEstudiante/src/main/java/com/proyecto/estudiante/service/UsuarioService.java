package com.proyecto.estudiante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.estudiante.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> finAll();

	public Page<Usuario> finAll(Pageable pageanle);

	public Optional<Usuario> findById(Long id);

	public Usuario save(Usuario usuario);

	void deletById(Long id);

}
