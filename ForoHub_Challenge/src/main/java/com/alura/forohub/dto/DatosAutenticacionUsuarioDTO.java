package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public class DatosAutenticacionUsuarioDTO {

    @NotBlank
    private String login;

    @NotBlank
    private String contrasena;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
