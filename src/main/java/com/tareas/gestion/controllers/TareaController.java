package com.tareas.gestion.controllers;
import com.tareas.gestion.models.Tarea;
import org.springframework.ui.Model;
import com.tareas.gestion.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TareaController {
    private List<Tarea> tareas = new ArrayList<>(); 

    @PostMapping("/tarea/agregar")
    public String registrarTarea(@RequestParam String descripcion,
                                 @RequestParam String fechaEntrega,
                                 @RequestParam int fk_asignatura,

                                 @RequestParam int usuarioId,
                                 @RequestParam String usuarioNombre,
                                 @RequestParam String usuarioApellidos,
                                 @RequestParam String usuarioUsername,
                                 @RequestParam String usuarioPassword,
                                 
                                 
                                 org.springframework.ui.Model model) {
        Usuario usuarioLoggin = new Usuario();
        usuarioLoggin.setId(usuarioId);
        usuarioLoggin.setNombre(usuarioNombre);
        usuarioLoggin.setApellidos(usuarioApellidos);
        usuarioLoggin.setUsername(usuarioUsername);
        usuarioLoggin.setPassword(usuarioPassword);


        Tarea nueva = new Tarea();
        nueva.setDescripcion(descripcion);
        nueva.setFechaEntrega(fechaEntrega);
        nueva.setEstado(false);
        nueva.setFkAsignatura(fk_asignatura);
        tareas.add(nueva);
        model.addAttribute("tareas", tareas);
        model.addAttribute("usuario", usuarioLoggin);
        return "inicio";
    }


    @PostMapping("/tarea/marcar/{id}")
    public String marcarTarea(@PathVariable int id, Model model,
    @RequestParam int usuarioId,
    @RequestParam String usuarioNombre,
    @RequestParam String usuarioApellidos,
    @RequestParam String usuarioUsername,
    @RequestParam String usuarioPassword) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.setEstado(!t.getEstado()); // Alterna entre true y false
                break;
            }
        }
        Usuario usuarioLoggin = new Usuario();
        usuarioLoggin.setId(usuarioId);
        usuarioLoggin.setNombre(usuarioNombre);
        usuarioLoggin.setApellidos(usuarioApellidos);
        usuarioLoggin.setUsername(usuarioUsername);
        usuarioLoggin.setPassword(usuarioPassword);
        model.addAttribute("usuario", usuarioLoggin);
        model.addAttribute("tareas", tareas);
        return "inicio";
    }

    @PostMapping("/tarea/eliminar/{id}")
    public String eliminarTarea(@PathVariable int id, Model model,
    @RequestParam int usuarioId,
    @RequestParam String usuarioNombre,
    @RequestParam String usuarioApellidos,
    @RequestParam String usuarioUsername,
    @RequestParam String usuarioPassword) {
        tareas.removeIf(t -> t.getId() == id);
        Usuario usuarioLoggin = new Usuario();
        usuarioLoggin.setId(usuarioId);
        usuarioLoggin.setNombre(usuarioNombre);
        usuarioLoggin.setApellidos(usuarioApellidos);
        usuarioLoggin.setUsername(usuarioUsername);
        usuarioLoggin.setPassword(usuarioPassword);
        model.addAttribute("usuario", usuarioLoggin);
        model.addAttribute("tareas", tareas);
        return "inicio";
    }


    @GetMapping("/tarea/filtrar")
public String filtrarTareas(@RequestParam String estado,
                            @RequestParam int usuarioId,
                            @RequestParam String usuarioNombre,
                            @RequestParam String usuarioApellidos,
                            @RequestParam String usuarioUsername,
                            @RequestParam String usuarioPassword,
                            Model model) {

    List<Tarea> tareasFiltradas = new ArrayList<>();

    switch (estado) {
        case "PENDIENTE":
            for (Tarea t : tareas) {
                if (!t.getEstado()) {
                    tareasFiltradas.add(t);
                }
            }
            break;
        case "COMPLETADA":
            for (Tarea t : tareas) {
                if (t.getEstado()) {
                    tareasFiltradas.add(t);
                }
            }
            break;
        case "TODAS":
        default:
            tareasFiltradas = tareas;
            break;
    }

    Usuario usuario = new Usuario();
    usuario.setId(usuarioId);
    usuario.setNombre(usuarioNombre);
    usuario.setApellidos(usuarioApellidos);
    usuario.setUsername(usuarioUsername);
    usuario.setPassword(usuarioPassword);

    model.addAttribute("tareas", tareasFiltradas);
    model.addAttribute("usuario", usuario);

    return "inicio";
}
    
}
