/**
 *
 */
package com.diego.model;

import java.util.Iterator;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

/**
 * @author Diego Gutierrez, Valeri Macarov, Jose Villalba
 *
 */
@NodeEntity
public class Persona {

    public Long getId() {
        return id;
    }
    @GraphId
    private Long id;

    private String correoElectronico;
    
    @RelatedToVia(type = "REALIZO")
    @Fetch
    private Set<Realiza> comentarios;

    public Set<Realiza> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Realiza> comentarios) {
        this.comentarios = comentarios;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Persona() {
    }

    public Persona(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}
