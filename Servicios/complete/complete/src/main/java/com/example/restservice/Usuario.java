package com.example.restservice;

public class Usuario {

    private final String usuario;
    private final String pass;

    public Usuario(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    
}
