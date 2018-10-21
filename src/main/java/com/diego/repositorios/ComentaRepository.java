package com.diego.repositorios;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chronicler.model.Comenta;

@RepositoryRestResource(collectionResourceRel = "comentas", path = "comentas")
public interface ComentaRepository extends PagingAndSortingRepository<Comenta, Long> {
}
