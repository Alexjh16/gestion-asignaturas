package com.tareas.gestion.controllers;

import com.tareas.gestion.models.Asignatura;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AsignaturaController {
    private List<Asignatura> asignaturas = new ArrayList<>();

    @PostMapping("/Asignatura")
    public String registrarAsignatura(@RequestParam String nombre) {
        Asignatura nueva = new Asignatura();
        nueva.setNombre(nombre);
        asignaturas.add(nueva);
        return "redirect:/Asignatura.html";
    }
    
}
