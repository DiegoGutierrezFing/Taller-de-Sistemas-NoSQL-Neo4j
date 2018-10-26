package com.diego;

import com.diego.model.Comentario;
import com.diego.model.Persona;
import com.diego.model.Realiza;
import com.diego.model.Responde;
import com.diego.repositorios.ComentarioRepository;
import com.diego.repositorios.PersonaRepository;
import com.diego.repositorios.RealizaRepository;
import com.diego.repositorios.RespondeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/crearComentario", method = RequestMethod.POST)
    public Realiza crearComentario(@RequestBody String correo, @RequestBody String texto) {

        Realiza realiza;

        if (personaRepository.count() != 0) {
            Persona persona = personaRepository.findByCorreoElectronico(correo).get(0);
            Comentario comentario = new Comentario(texto);
            realiza = new Realiza(persona, comentario);
            realizaRepository.save(realiza);
        } else {
            return null;
        }

        return realiza;
    }

    @RequestMapping(value = "/crearPersona", method = RequestMethod.POST)
    public Persona crearPersona(@RequestBody String correo) {
        
        Persona persona;
        
        if (personaRepository.count() != 0) {
            persona = personaRepository.findByCorreoElectronico(correo).get(0);
            personaRepository.save(persona);
        } else {
            persona = new Persona(correo);
        }
        return persona;
    }
    
    @RequestMapping(value = "/responderComentario", method = RequestMethod.POST)
    public Responde crearComentario(@RequestBody Long id, @RequestBody String correo, @RequestBody String texto) {

        Responde responde;
        Comentario comentario;
        Comentario respuesta;
        Realiza realiza;
        Persona persona;

        if ((personaRepository.count() != 0) && (personaRepository.count() != 0)) {
            persona = personaRepository.findByCorreoElectronico(correo).get(0);
            comentario = comentarioRepository.findOne(id);
            
            if (comentario == null)
                return null;
            
            respuesta = new Comentario(texto);
            realiza = new Realiza(persona, respuesta);
            responde = new Responde(respuesta, comentario);
            realizaRepository.save(realiza);
            respondeRepository.save(responde);
        }
        else {
            return null;
        }

        return responde;
    }
}
