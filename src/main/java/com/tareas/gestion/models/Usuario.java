package com.tareas.gestion.models;

public class Usuario {
    public int id;
    public String nombre;
    public String apellidos;
    public int edad;
    public String username;
    public String password;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    public String getNombre() {
        return nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEdad() {
        return String.valueOf(edad);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
