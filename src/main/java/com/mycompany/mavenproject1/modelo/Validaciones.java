/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.modelo;

/**
 *Clase creada para validar todos los datos ingresados por teclado
 * Esta clase es muy importante, sirve para validar que el usuario no asesine el programa. 
 * Puede mejorarse aun mas para realizar otro tipo de validaciones, pero para iniciar hace su trabajo basico
 * Nota: Todas estas validaciones reciben un TextField y algunas sirven para cancelar e ir al menu principal.
 * @author DhuDu
 */

import javafx.scene.control.TextField;


public class Validaciones {
    
    /**   
    * Metodo de Validacion de entradas por teclado para el correcto funcionamiento, 
    * esta sirve para el nombre de usuario o entradas similares
    * @param sc define el objeto TextField para ahorrar lineas de codigo
    * @return  retorna un string que no tenga espacios que no es vacio y que no tiene simbolos
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validNameUser(TextField sc) throws RegistroException{
        String valUser = sc.getText().trim();
        if( (valUser.matches("[a-zA-Z0-9]*"))||(valUser.length()<5 || valUser.equals(""))){
            valUser = sc.getText();
        }else{
            throw new RegistroException("USUARIO NO PUEDE CONTENER ESPACIOS, CARACTERES ESPECIALES O ESTAR VACIO (mas de 5 caracteres)");
        }
        return valUser.toLowerCase();
    }//Cierre del metodo
    /**
    //Metodo de Validacion para la contraseña
    * @param sc define el objeto TextField para la entrada por teclado
    * @return devuelve un string que sea de 4 o más caracteres y que no contenga comas.
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validPassword(TextField sc) throws RegistroException{
        String vlidPass = sc.getText().trim();
        if(!(vlidPass.length()<4 || vlidPass.contains(",")) ){
            //System.out.println("Contraseña no debe tener [ , ] y 4 caracteres mínimo\n(Espacios al inicio o al final seran suprimidos)\nIngrese contraseña valida:");
            vlidPass = sc.getText().trim();
        }else{
            throw new RegistroException("Contraseña no debe tener [ , ] y 4 caracteres mínimo\n(Espacios al inicio o al final seran suprimidos)\nIngrese contraseña valida:");
        }
        //System.out.println("Su nueva contraseña es:"+vlidPass);
        return vlidPass;
    }//Cierre del metodo
    /**Metodo de Validacion para la cedula
    * @param sc define el objeto TextField para la entrada por teclado
    * @return devuelve un string que sea de tipo numerico y con length 10.
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validarCedula(TextField sc) throws RegistroException{
        
        String cedulaValida = sc.getText().trim();
        
        if((cedulaValida.matches("[0-9]{1,10}")&&cedulaValida.length()==10) || cedulaValida.equals("")){
            
            cedulaValida = sc.getText().trim();
        }else{
            throw new RegistroException("Ingrese una cedula Valida:");
        }
        return cedulaValida;
    }//Cierre del metodo
    /**Metodo de Validacion para Nombres y Apellidos
    * @param sc define el objeto TextField para la entrada por teclado
    * @return devuelve un string que sea de letras sin simbolos.
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validarNames(TextField sc) throws RegistroException{
        String validName = sc.getText().trim();

        if(validName.matches("^[a-zA-Z]+((['. ][a-zA-Z ])?[a-zA-Z]*)*$")||validName.equals("")){
            validName = sc.getText().trim();
        }else{
            throw new RegistroException("Ingrese Nombre Valido");
        }
        return validName;
    }//Cierre del metodo
    /**Metodo de Validacion para Celular
    * @param sc define el objeto TextField para la entrada por teclado
    * @return devuelve un string que sea de 9 digitos empezando por 09.
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validarCelular(TextField sc) throws RegistroException{
        String cllValido = sc.getText().trim();
        if((cllValido.matches("[0-9]{1,10}")&&cllValido.length()==10&&cllValido.startsWith("09")) || cllValido.equals("")){

            cllValido = sc.getText().trim();
        }else{
            throw new RegistroException("Ingrese celular valido");
        }
        return cllValido;
    }
    /**Metodo de Validacion para Ruta
    * @param sc define el objeto TextField para la entrada por teclado
    * @return devuelve un string sin comas que representa la ruta.
     * @throws com.mycompany.mavenproject1.modelo.RegistroException
    */
    public static String validarRuta(TextField sc) throws RegistroException{
        String validRuta = sc.getText().trim();
        if(!(validRuta.contains(",") || validRuta.equals("") ||validRuta.matches("[ ]*"))){
            validRuta = sc.getText().trim();
        }else{
            throw new RegistroException("Direccion no debe contener ',' ni estar vacio");
        }
        return validRuta;
    }//Cierre del metodo
    
    public static String validarEmail(TextField sc) throws RegistroException{
        String email = sc.getText().trim();
        if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            return email;
        }else{
            throw new RegistroException("Ingrese E-mail valido");
        }
    }
}