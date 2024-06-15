package com.api.Api_tutores.services;

import com.api.Api_tutores.models.ServicioModel;
import com.api.Api_tutores.repositories.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioService {
	
	@Autowired
	ServicioRepositorio servicioRepositorio;
	
	public ArrayList<ServicioModel> getServicio(){
		return (ArrayList<ServicioModel>)servicioRepositorio.findAll();
	}
	
	public ServicioModel saveServicio(ServicioModel servicio) {
		return servicioRepositorio.save(servicio);
	}
	
	public Optional<ServicioModel>getById(Long id){
		return servicioRepositorio.findById(id);
	}
	public ServicioModel updateById(ServicioModel request, Long id){
		ServicioModel servicio = servicioRepositorio.findById(id).get();
		
		servicio.setTitulo(request.getTitulo());
		servicio.setDescripcion(request.getDescripcion());
		servicio.setCosto(request.getCosto());
		servicio.setCupos(request.getCupos());
		return servicio;
	}
	public Boolean deletServicio(Long id) {
		try {
			servicioRepositorio.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
}

