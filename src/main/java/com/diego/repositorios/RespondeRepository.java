package com.diego.repositorios;

import com.diego.model.Responde;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "responden", path = "responden")
public interface RespondeRepository extends PagingAndSortingRepository<Responde, Long> {
}
