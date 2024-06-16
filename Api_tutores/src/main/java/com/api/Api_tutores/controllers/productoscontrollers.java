package com.api.Api_tutores.controllers;
import com.api.Api_tutores.models.productosmodel;
import com.api.Api_tutores.services.productosservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class productoscontrollers {
    @Autowired
    private productosservice productosservice;

    @GetMapping
    public ArrayList<productosmodel> getproductos(){
        return this.productosservice.getproductos();
    }

    @PostMapping
    public productosmodel saveproductos(@RequestBody productosmodel productos){
        return this.productosservice.saveproducto(productos);
    }

    @GetMapping(path = "/{id}")
    public Optional<productosmodel> getproductosById(@PathVariable("id")Long id){
        return this.productosservice.getById(id);
    }

    @PutMapping(path = "/{id}")
    public productosmodel updateTutorById(@RequestBody productosmodel request,@PathVariable("id") Long id){
        return this.productosservice.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.productosservice.deletproductos(id);
        if(ok){
            return "productos id " + id + "borrado!";
        } else {
            return "Error tenemos un problema con el id " + id;
        }

    }


}