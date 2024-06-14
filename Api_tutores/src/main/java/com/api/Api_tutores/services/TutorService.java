package com.api.Api_tutores.services;

import com.api.Api_tutores.models.TutorModel;
import com.api.Api_tutores.repositories.TutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TutorService {
	
	@Autowired
	TutorRepositorio tutorRepositorio;
	
	public ArrayList<TutorModel> getTutores(){
		return (ArrayList<TutorModel>)tutorRepositorio.findAll();
	}
	
	public TutorModel saveTutor(TutorModel tutor) {
		return tutorRepositorio.save(tutor);
	}
	
	public Optional<TutorModel>getById(Long id){
		return tutorRepositorio.findById(id);
	}
	public TutorModel updateById(TutorModel request, Long id){
		TutorModel tutor = tutorRepositorio.findById(id).get();
		
		tutor.setFirstname(request.getFirstname());
		tutor.setLastname(request.getLastname());
		tutor.setEmail(request.getEmail());
		tutor.setTelefono(request.getTelefono());
		return tutor;
	}
	public Boolean deletTutor(Long id) {
		try {
			tutorRepositorio.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
}

