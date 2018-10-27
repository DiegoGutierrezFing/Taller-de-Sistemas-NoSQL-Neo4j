package com.diego;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

@SpringBootApplication
@EnableNeo4jRepositories
@Configuration
public class LaboratorioApplication extends Neo4jConfiguration {

	public LaboratorioApplication() {
		setBasePackage("com.diego");
	}

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new SpringCypherRestGraphDatabase("http://40.114.26.125:7474/db/data", "neo4j", "afx2.0+");
	}
	public static void main(String[] args) {
		SpringApplication.run(LaboratorioApplication.class, args);
	}
}
