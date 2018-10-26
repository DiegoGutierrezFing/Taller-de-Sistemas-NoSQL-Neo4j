package com.diego.repositorios;


import com.diego.model.Comentario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "comentarios", path = "comentarios")
public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long> {}
