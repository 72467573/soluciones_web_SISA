package com.api.Api_tutores.controllers;

import com.api.Api_tutores.services.TutorService;
import com.api.Api_tutores.models.TutorModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;



@RestController
@RequestMapping("/tutor")
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	
	@GetMapping
	public ArrayList<TutorModel> getTutores(){
		return this.tutorService.getTutores();
	}
	
	@PostMapping
	public TutorModel savetutor(@RequestBody TutorModel tutor){
		return this.tutorService.saveTutor(tutor);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<TutorModel>getTutoresById(@PathVariable("id") Long id){
		return this.tutorService.getById(id);
	}
	
	@PutMapping(path = "/{id}")
	public TutorModel updateTutorById(@RequestBody TutorModel request,@PathVariable("id") Long id){
		return this.tutorService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id){
		boolean ok = this.tutorService.deletTutor(id);
		if(ok){
			return "Usuario id " + id + "borrado!";
		} else {
			return "Error tenemos un problema con el id " + id;
		}
		
	}
	
	
	

	
}
