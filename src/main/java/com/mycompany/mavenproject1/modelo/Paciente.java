/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.modelo;

import java.util.Date;

/**
 *
 * @author DhuDu
 */
public class Paciente extends Usuario {
    private String id;
    private String nombres;
    private String apellidos;
    private String fNacim;
    private String genero;
    private String ciudad;
    private String email;
    private String telefono;

    public Paciente(String id, String nombres, String apellidos, String fNacim, String genero, String ciudad, String email, String telefono, String usuario, String password, String tipo) {
        super(usuario, password, tipo);
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fNacim = fNacim;
        this.genero = genero;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
    }
    public Paciente(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getfNacim() {
        return fNacim;
    }

    public void setfNacim(String fNacim) {
        this.fNacim = fNacim;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
   

    
    
    
    
}
