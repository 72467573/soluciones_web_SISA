package com.api.Api_tutores.services;

import com.api.Api_tutores.models.UsuarioModel;
import com.api.Api_tutores.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public ArrayList<UsuarioModel> getUsuario(){
		return (ArrayList<UsuarioModel>)usuarioRepositorio.findAll();
	}
	
	public UsuarioModel saveUsuario(UsuarioModel usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public Optional<UsuarioModel>getById(Long id){
		return usuarioRepositorio.findById(id);
	}
	public UsuarioModel updateById(UsuarioModel request, Long id){
		UsuarioModel tutor = usuarioRepositorio.findById(id).get();
		
		tutor.setNombre(request.getNombre());
		tutor.setApellido(request.getApellido());
		tutor.setEmail(request.getEmail());
		tutor.setTelefono(request.getTelefono());
		return tutor;
	}
	public Boolean deletUsuario(Long id) {
		try {
			usuarioRepositorio.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
}

