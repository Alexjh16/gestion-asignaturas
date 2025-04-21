package com.tareas.gestion.controllers;
import com.tareas.gestion.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestParam String nombre,
                                   @RequestParam String username,
                                   @RequestParam String password) {
        Usuario nuevo = new Usuario();
        nuevo.setNombre(nombre);
        nuevo.setUsername(username);
        nuevo.setPassword(password);
        usuarios.add(nuevo);
        return "redirect:/login.html";
    }
    
}
