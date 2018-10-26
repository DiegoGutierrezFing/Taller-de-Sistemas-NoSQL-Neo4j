package com.diego.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Comentario {

    public Long getId() {
        return id;
    }

    @GraphId
    private Long id;

    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Comentario(String texto) {
        this.texto = texto;
    }

    public Comentario() {
    }
    
    

}
