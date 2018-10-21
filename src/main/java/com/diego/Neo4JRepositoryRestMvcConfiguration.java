package com.diego;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.chronicler.model.Persona;
import com.chronicler.model.Comenta;
import com.chronicler.model.Comentario;

@Configuration
public class Neo4JRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration  {
	@Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Persona.class);
        config.exposeIdsFor(Comentario.class);
        config.exposeIdsFor(Comenta.class);
    }
}