package com.example.hitoentornoservidor;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.TreeMap;

@Service
@ApplicationScope
public class Usuarios {
    private TreeMap<String, Usuario> usuarios;

    public Usuarios() {
        this.usuarios = new TreeMap<String, Usuario>();
        this.usuarios.put("fernando", new Usuario("Fernando", "123"));
        this.usuarios.get("fernando").getRecomendaciones().add("Torrente 5");
        this.usuarios.get("fernando").getRecomendaciones().add("Scary Moovie");
        this.usuarios.get("fernando").getRecomendaciones().add("Spanish Moovie");
        this.usuarios.put("sergio", new Usuario("Sergio", "456"));
        this.usuarios.get("sergio").getRecomendaciones().add("Casi 300");
        this.usuarios.get("sergio").getRecomendaciones().add("Ace Ventura");
        this.usuarios.get("sergio").getRecomendaciones().add("Wild hunting");
        this.usuarios.put("alvaro", new Usuario("Alvaro", "789"));
        this.usuarios.get("alvaro").getRecomendaciones().add("8 apellidos vascos");
        this.usuarios.get("alvaro").getRecomendaciones().add("Padre no hay mas que uno");
        this.usuarios.get("alvaro").getRecomendaciones().add("Los manolos");
    }

    public TreeMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
