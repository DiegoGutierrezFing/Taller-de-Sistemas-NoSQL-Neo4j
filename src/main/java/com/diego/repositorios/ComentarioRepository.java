package com.diego.repositorios;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chronicler.model.Comentario;

@RepositoryRestResource(collectionResourceRel = "comentarios", path = "comentarios")
public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long> {}
