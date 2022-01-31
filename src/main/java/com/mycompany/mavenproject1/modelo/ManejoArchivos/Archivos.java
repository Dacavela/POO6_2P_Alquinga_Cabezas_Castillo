/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.modelo.ManejoArchivos;

import com.mycompany.mavenproject1.App;
import com.mycompany.mavenproject1.modelo.Paciente;

import com.mycompany.mavenproject1.modelo.Prueba;
import java.io.File;

import com.mycompany.mavenproject1.modelo.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DhuDu
 */
public class Archivos {
    
    
    public static void escribirPaciente(Paciente p)  {
        try(BufferedWriter bf=new BufferedWriter(new FileWriter(App.pathFile+"pacientes.txt",true))){
                bf.write(p.getUsuario()+","+p.getId()+","+p.getNombres()+","+p.getApellidos()+","+p.getfNacim()+","+p.getGenero()+","+p.getCiudad()+","+p.getEmail()+","+p.getTelefono());
                bf.newLine();
                bf.close();
            
        
        } catch (IOException ex) {

            System.out.println("No se pudo guardar en el archivo paciente");

            System.out.println("No se pudo guardar en el archivo paciente");;

        }
    }
    
    
    public static void escribirUsuario(Paciente p)  {
        try(BufferedWriter bf=new BufferedWriter(new FileWriter(App.pathFile+"usuarios.txt",true))){
                bf.write(p.getUsuario()+","+p.getPassword()+","+p.getTipo());
                bf.newLine();
                bf.close();
            
        
        } catch (IOException ex) {

            System.out.println("No se pudo escribir en el archivo usuario");

            System.out.println("No se pudo escribir en el archivo usuario");;

        }
    }
    
    public static ArrayList<Usuario> leerUsuario(){
        ArrayList<Usuario> ListUsu=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(App.pathFile+"usuarios.txt"))){
            String linea;
            while((linea=bf.readLine())!=null){
                String[] datos=linea.split(",");
                ListUsu.add(new Usuario(datos[0],datos[1],datos[2]));                
            }            
        } catch (FileNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return ListUsu;
    }
    
    public static ArrayList<Paciente> leerPaciente(){
        ArrayList<Paciente> ListPaciente=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(App.pathFile+"pacientes.txt"))){
            String linea;
            while((linea=bf.readLine())!=null){
                String[] datos=linea.split(",");
                ListPaciente.add(new Paciente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8]));                
            }            
        } catch (FileNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return ListPaciente;
    }
    
    public static boolean leerGenero(Usuario u){
        boolean genero = false;
        ArrayList<Paciente> lista=leerPaciente();
        for(Paciente p:lista){
            if(u.getUsuario().equals(p.getUsuario())){
                String gener=p.getGenero();
                if(gener.equals("Femenino   ")){
                    genero=true;
                }
                else
                    genero=false;
            }
            
        }
        return genero;
    }    
    
    public static ArrayList<Prueba> leerPrueba(){
        ArrayList<Prueba> ListUsu=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(new File(App.pathFile+"pruebas.txt")))){
            String linea;
            
            while((linea=bf.readLine())!=null){
                String[] datos=linea.split(",");
                
                ListUsu.add(new Prueba(datos[0],datos[1],datos[2], Double.parseDouble(datos[3])));                
            }            
        } catch (FileNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return ListUsu;
    }
    public static ArrayList<String> leerUbi(){
        ArrayList<String> ListUsu=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(new File(App.pathFile+"sucursales.txt")))){
            String linea;
            
            while((linea=bf.readLine())!=null){
                ListUsu.add(linea);                
            }            
        } catch (FileNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return ListUsu;
    }

}
