package com.proyecto.estudiante.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.estudiante.entity.Usuario;
import com.proyecto.estudiante.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	@Transactional
	public Iterable<Usuario> finAll() {
		return usuariorepository.findAll();
	}

	@Override
	public Page<Usuario> finAll(Pageable pageanle) {
		return usuariorepository.findAll(pageanle);
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuariorepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Override
	public void deletById(Long id) {
		usuariorepository.deleteById(id);
	}

}
