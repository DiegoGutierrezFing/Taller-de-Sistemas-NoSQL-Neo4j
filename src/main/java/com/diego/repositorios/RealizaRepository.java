package com.diego.repositorios;



import com.diego.model.Realiza;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "realizan", path = "realizan")
public interface RealizaRepository extends PagingAndSortingRepository<Realiza, Long> {
}
