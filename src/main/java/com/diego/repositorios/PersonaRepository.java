package com.diego.repositorios;


import com.diego.model.Persona;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {
	List<Persona> findByCorreoElectronico(@Param("name") String correo);
}
