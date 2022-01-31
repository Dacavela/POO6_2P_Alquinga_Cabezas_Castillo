/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.modelo;
import static com.mycompany.mavenproject1.modelo.ManejoArchivos.Archivos.*;
import java.util.ArrayList;

/**
 *
 * @author DhuDu
 */
public class Prueba {
    public static String[] tiP = {"Diagnostico","Anticuerpos"};
    private String codPrueba;
    private String tipoPrueba;
    private String nombrePrueba;
    private double precio;
    
    public Prueba(){}
    public Prueba(String codPrueba, String tipoPrueba, String nombrePrueba, double precio) {
        this.codPrueba = codPrueba;
        this.tipoPrueba = tipoPrueba;
        this.nombrePrueba = nombrePrueba;
        this.precio = precio;
    }

    public String getCodPrueba() {
        return codPrueba;
    }

    public void setCodPrueba(String codPrueba) {
        this.codPrueba = codPrueba;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public static ArrayList<Prueba> obtenerPrueba(String tipoPrba){
        ArrayList<Prueba> lP = new ArrayList<>();
        for(Prueba p: leerPrueba()){
            if(p.tipoPrueba.equals(tipoPrba)){
                lP.add(p);
            }
        }
        return lP;
    }
    @Override 
    public String toString(){
        return this.nombrePrueba;
    }
}
