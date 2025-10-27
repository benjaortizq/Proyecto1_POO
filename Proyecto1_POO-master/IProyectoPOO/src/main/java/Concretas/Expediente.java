/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concretas;

/**
 *
 * @author Benjamin o 
 */

import Abstractas.Personal;

public class Expediente {
    private final Gestorcitas gestorCitas;
    private Paciente paciente ;
    private Personal personalMedico ;
    private int numeroExpediente; 
    private String alergias ; 

    public Expediente(Paciente paciente, Personal personalMedico, int numeroExpediente, String alergias) {
        this.paciente = paciente;
        this.personalMedico = personalMedico;
        this.numeroExpediente = numeroExpediente;
        this.alergias = alergias;
        this.gestorCitas = new Gestorcitas();
    }
    
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Personal getPersonalMedico() {
        return personalMedico;
    }

    public void setPersonalMedico(Personal personalMedico) {
        this.personalMedico = personalMedico;
    }

    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Gestorcitas getGestorCitas() {
        return gestorCitas;
    }
    
    
    
    
    
    
}
