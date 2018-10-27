package com.diego;

import com.diego.model.Comentario;
import com.diego.model.Persona;
import com.diego.model.Realiza;
import com.diego.model.Responde;
import com.diego.repositorios.ComentarioRepository;
import com.diego.repositorios.PersonaRepository;
import com.diego.repositorios.RealizaRepository;
import com.diego.repositorios.RespondeRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    RealizaRepository realizaRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    RespondeRepository respondeRepository;

    @RequestMapping(value = "/crearComentario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Realiza crearComentario(@RequestBody Map<String, String> body) {

        Realiza realiza;
        Persona persona;

        if (personaRepository.count() != 0) {
            if (!(personaRepository.findByCorreoElectronico(body.get("correo")).isEmpty())) {
                persona = personaRepository.findByCorreoElectronico(body.get("correo")).get(0);
            } else {
                persona = new Persona(body.get("correo"));
                personaRepository.save(persona);
            }
        } else {
            persona = new Persona(body.get("correo"));
            personaRepository.save(persona);
        }

        Comentario comentario = new Comentario(body.get("texto"));
        comentarioRepository.save(comentario);
        realiza = new Realiza(persona, comentario);
        realizaRepository.save(realiza);

        return realiza;
    }

    @RequestMapping(value = "/crearPersona", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Persona crearPersona(@RequestBody Map<String, String> body) {

        Persona persona;

        if (personaRepository.count() != 0) {
            if (!(personaRepository.findByCorreoElectronico(body.get("correo")).isEmpty())) {
                persona = personaRepository.findByCorreoElectronico(body.get("correo")).get(0);
            } else {
                persona = new Persona(body.get("correo"));
                personaRepository.save(persona);
            }

            //personaRepository.save(persona);
        } else {
            persona = new Persona(body.get("correo"));
            personaRepository.save(persona);
        }
        return persona;
    }

    @RequestMapping(value = "/responderComentario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Responde responderComentario(@RequestBody Map<String, String> body) {

        Responde responde;
        Comentario comentario;
        Comentario respuesta;
        Realiza realiza;
        Persona persona;

        if (personaRepository.count() != 0) {
            if (!(personaRepository.findByCorreoElectronico(body.get("correo")).isEmpty())) {
                persona = personaRepository.findByCorreoElectronico(body.get("correo")).get(0);
            } else {
                persona = new Persona(body.get("correo"));
                personaRepository.save(persona);
            }
        } else {
            //persona = new Persona(body.get("correo"));
            return null;
        }

        if (comentarioRepository.count() != 0) {
            comentario = comentarioRepository.findOne(Long.parseLong(body.get("idComentario")));
        } else {
            return null;
        }

        if (comentario == null) {
            return null;
        }

        respuesta = new Comentario(body.get("texto"));
        realiza = new Realiza(persona, respuesta);
        responde = new Responde(respuesta, comentario);
        comentarioRepository.save(respuesta);
        realizaRepository.save(realiza);
        respondeRepository.save(responde);

        return responde;
    }
    
    @RequestMapping(value = "/listarComentarios/{correo}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Comentario> listarComentariosUsuario(@PathVariable String correo){
        
        return comentarioRepository.listarComentariosUsuario(correo);
    }
}
