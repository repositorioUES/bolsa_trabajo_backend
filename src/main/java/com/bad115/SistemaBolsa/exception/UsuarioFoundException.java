package com.bad115.SistemaBolsa.exception;

public class UsuarioFoundException extends Exception{

    public UsuarioFoundException(){
        super("El usuario con ese username ya existe en la base de datos , vuelva a intentar !!");
    }

    public UsuarioFoundException(String mensaje){
        super(mensaje);
    }
}