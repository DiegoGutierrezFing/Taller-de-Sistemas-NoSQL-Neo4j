package com.diego.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "REALIZO")
public class Realiza {

    @GraphId
    private Long relationshipId;

    @Fetch
    @StartNode
    private Persona persona;

    @Fetch
    @EndNode
    private Comentario comentario;

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Realiza(Persona persona, Comentario comentario) {
        this.persona = persona;
        this.comentario = comentario;
    }

    public Realiza() {
    }

}
