package com.api.Api_tutores.services;


import com.api.Api_tutores.repositories.Iproductosrepository;
import com.api.Api_tutores.models.productosmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class productosservice {
    @Autowired
    Iproductosrepository Iproductosrepository;

    public ArrayList<productosmodel> getproductos(){
        return (ArrayList<productosmodel>) Iproductosrepository.findAll();
    }

    public productosmodel saveproducto(productosmodel producto){
        return Iproductosrepository.save(producto);
    }

    public Optional<productosmodel> getById(long id){
        return Iproductosrepository.findById(id);
    }

    public productosmodel updateById(productosmodel request, Long id){
        productosmodel productos = Iproductosrepository.findById(id).get();

        productos.setId(request.getId());
        productos.setProdNom(request.getProdNom());
        productos.setDescripcion(request.getDescripcion());
        productos.setCosto(request.getCosto());
        productos.setStock(request.getStock());
        return productos;
    }

    public Boolean deletproductos(Long id) {
        try {
            Iproductosrepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}

