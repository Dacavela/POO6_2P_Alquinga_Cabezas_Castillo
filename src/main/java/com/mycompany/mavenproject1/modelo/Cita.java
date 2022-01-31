/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.modelo;

/**
 *
 * @author DhuDu
 */
public class Cita {
    private static int idSolicitud = (int) Math.round(Math.random()*20000.0);
    private String usuarioPaciente;
    private String dirección;
    private String fecha;
    private String hora;
    private double ubicaciónX;
    private double ubicaciónY;
    private double totalPaga;

    public Cita(int idSolicitud, String usuarioPaciente, String dirección, String fecha, String hora, double ubicaciónX, double ubicaciónY, double totalPaga) {
        this.idSolicitud = idSolicitud;
        this.usuarioPaciente = usuarioPaciente;
        this.dirección = dirección;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicaciónX = ubicaciónX;
        this.ubicaciónY = ubicaciónY;
        this.totalPaga = totalPaga;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(String usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getUbicaciónX() {
        return ubicaciónX;
    }

    public void setUbicaciónX(double ubicaciónX) {
        this.ubicaciónX = ubicaciónX;
    }

    public double getUbicaciónY() {
        return ubicaciónY;
    }

    public void setUbicaciónY(double ubicaciónY) {
        this.ubicaciónY = ubicaciónY;
    }

    public double getTotalPaga() {
        return totalPaga;
    }

    public void setTotalPaga(double totalPaga) {
        this.totalPaga = totalPaga;
    }
    
    
    
    
}
