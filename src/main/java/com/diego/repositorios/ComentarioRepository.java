package com.diego.repositorios;

import com.diego.model.Comentario;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "comentarios", path = "comentarios")
public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long> {

    //Consulta para retornar los comentarios realizados por un usuario
    @Query("MATCH (p:Persona)-[r:REALIZO]->(c:Comentario) "
            + "where p.correoElectronico = {correo} RETURN c")
    public List<Comentario> listarComentariosUsuario(@Param("correo") String correo);

    //@Query("MATCH (p:Comentario) OPTIONAL MATCH (p)<-[:RESPONDE]-(c) RETURN {comentario : p.texto, id: ID(p), listaRespuestas : {texto: collect(c.texto)}}")
    @Query("MATCH (c1) WHERE id(c1) = {idComentario} RETURN c1 as comentario UNION MATCH (p) WHERE id(p) = {idComentario} OPTIONAL MATCH (p)<-[:RESPONDE]-(c) RETURN c as comentario")
    public List<Comentario> leerComentarioID(@Param("idComentario") Long idComentario);
}
