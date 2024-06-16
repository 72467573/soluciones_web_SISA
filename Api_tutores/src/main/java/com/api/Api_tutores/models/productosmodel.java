package com.api.Api_tutores.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class productosmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "prod_nom")
    private String prodNom;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "stock")
    private Integer stock;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdNom() {
        return prodNom;
    }

    public void setProdNom(String prodNom) {
        this.prodNom = prodNom;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

