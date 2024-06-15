package com.api.Api_tutores.controllers;

import com.api.Api_tutores.services.UsuarioService;
import com.api.Api_tutores.models.UsuarioModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ArrayList<UsuarioModel> getUsuario(){
		return this.usuarioService.getUsuario();
	}
	
	@PostMapping
	public UsuarioModel saveusuario(@RequestBody UsuarioModel usuario){
		return this.usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel>getUsuarioById(@PathVariable("id") Long id){
		return this.usuarioService.getById(id);
	}
	
	@PutMapping(path = "/{id}")
	public UsuarioModel updateUsuarioById(@RequestBody UsuarioModel request,@PathVariable("id") Long id){
		return this.usuarioService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id){
		boolean ok = this.usuarioService.deletUsuario(id);
		if(ok){
			return "Usuario id " + id + "borrado!";
		} else {
			return "Error tenemos un problema con el id " + id;
		}
		
	}
	
	
	

	
}
