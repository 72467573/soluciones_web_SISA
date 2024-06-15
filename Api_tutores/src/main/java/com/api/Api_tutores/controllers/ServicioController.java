package com.api.Api_tutores.controllers;

import com.api.Api_tutores.services.ServicioService;
import com.api.Api_tutores.models.ServicioModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;



@RestController
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping
	public ArrayList<ServicioModel> getServicio(){
		return this.servicioService.getServicio();
	}
	
	@PostMapping
	public ServicioModel saveservicio(@RequestBody ServicioModel servicio){
		return this.servicioService.saveServicio(servicio);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<ServicioModel>getServicioById(@PathVariable("id") Long id){
		return this.servicioService.getById(id);
	}
	
	@PutMapping(path = "/{id}")
	public ServicioModel updateServicioById(@RequestBody ServicioModel request,@PathVariable("id") Long id){
		return this.servicioService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id){
		boolean ok = this.servicioService.deletServicio(id);
		if(ok){
			return "Usuario id " + id + "borrado!";
		} else {
			return "Error tenemos un problema con el id " + id;
		}
		
	}
}
