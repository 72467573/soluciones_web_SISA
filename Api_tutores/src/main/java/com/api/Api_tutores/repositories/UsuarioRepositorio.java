package com.api.Api_tutores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Api_tutores.models.UsuarioModel;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioModel, Long>{
	
}
