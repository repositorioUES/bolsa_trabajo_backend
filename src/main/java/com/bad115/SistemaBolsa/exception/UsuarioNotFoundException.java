package com.bad115.SistemaBolsa.exception;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario con ese username no existe en la base de datos , vuelva a intentar !!");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }

}