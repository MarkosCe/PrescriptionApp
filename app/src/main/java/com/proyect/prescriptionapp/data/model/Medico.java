package com.proyect.prescriptionapp.data.model;

public class Medico {

    private String id_medico;
    private String cedula_profesional;
    private String email;
    private Usuario usuario;

    public Medico(String id_medico, String cedula_profesional, String email, Usuario usuario) {
        this.id_medico = id_medico;
        this.cedula_profesional = cedula_profesional;
        this.email = email;
        this.usuario = usuario;
    }

    public Medico(){

    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getCedula_profesional() {
        return cedula_profesional;
    }

    public void setCedula_profesional(String cedula_profesional) {
        this.cedula_profesional = cedula_profesional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
