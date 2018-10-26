package com.diego.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "RESPONDE")
public class Responde {

    @GraphId
    private Long relationshipId;

    @Fetch
    @StartNode
    private Comentario respuesta;

    @Fetch
    @EndNode
    private Comentario comentario;

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Comentario getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Comentario respuesta) {
        this.respuesta = respuesta;
    }

    public Responde(Comentario respuesta, Comentario comentario) {
        this.respuesta = respuesta;
        this.comentario = comentario;
    }

    public Responde() {
    }

}
