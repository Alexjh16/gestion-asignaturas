package com.tareas.gestion.controllers;
import org.springframework.ui.Model;
import com.tareas.gestion.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String inicio() {
        return "Login";
    }

    @PostMapping("/Login")
    

    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Usuario Ely = new Usuario();
        Ely.setUsername("Ely@mail.com");
        Ely.setPassword("123");
        Ely.setNombre("Ely");
        Ely.setApellidos("Gonzalez");


        Usuario Mafe = new Usuario();
        Mafe.setUsername("Mafe@mail.com");
        Mafe.setPassword("123");
        Mafe.setNombre("Maria");
        Mafe.setApellidos("Quintana");

        Usuario Alexx = new Usuario();
        Alexx.setUsername("Alexx@mail.com");
        Alexx.setPassword("123");
        Alexx.setNombre("Alexander");
        Alexx.setApellidos("Vides");

        Usuario Marlon = new Usuario();
        Marlon.setUsername("Marlon@mail.com");
        Marlon.setPassword("123");
        Marlon.setNombre("Marlon");
        Marlon.setApellidos("Yi");

        Usuario Omar = new Usuario();
        Omar.setUsername("Omar@mail.com");
        Omar.setPassword("123");
        Omar.setNombre("Omar");
        Omar.setApellidos("Borre");

        Usuario Boris = new Usuario();
        Boris.setUsername("Boris@mail.com");
        Boris.setPassword("123");
        Boris.setNombre("Boris");
        Boris.setApellidos("Sierra");

        Usuario Jaime = new Usuario();
        Jaime.setUsername("Jaime@mail.com");
        Jaime.setPassword("123");
        Jaime.setNombre("Jaime");
        Jaime.setApellidos("Machacon");

        usuarios.add(Ely); usuarios.add(Mafe); usuarios.add(Alexx); usuarios.add(Marlon); usuarios.add(Omar); usuarios.add(Boris); usuarios.add(Jaime);

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                model.addAttribute("usuario", u);  // 👉 lo agregas al modelo
                return "inicio";
            }
        }
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "Login";
    }
    
}
