package com.tareas.gestion.models;

public class Tarea {
    private static int contadorId = 1;
    
    public int id;
    public int fk_asignatura;
    public String descripcion;
    public boolean estado;
    public String fecha_entrega;

    public Tarea() {
        this.id = contadorId++;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setFkAsignatura(int fk_asignatura) {
        this.fk_asignatura = fk_asignatura;
    }
    public int getFkAsignatura() {
        return fk_asignatura;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fecha_entrega = fechaEntrega;
    }
    public String getFechaEntrega() {
        return fecha_entrega;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
