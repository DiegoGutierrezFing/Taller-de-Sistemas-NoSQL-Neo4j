package com.diego;


import com.diego.model.Comentario;
import com.diego.model.Persona;
import com.diego.model.Realiza;
import com.diego.model.Responde;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;



@Configuration
public class Neo4JRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration  {
	@Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Persona.class);
        config.exposeIdsFor(Comentario.class);
        config.exposeIdsFor(Realiza.class);
        config.exposeIdsFor(Responde.class);
    }
}