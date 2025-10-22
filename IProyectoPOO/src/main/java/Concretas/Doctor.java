/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concretas;

import Abstractas.Personal;
/**
 *
 * @author Benjamin Ortiz
 */
public class Doctor extends Personal  {
    private int numeroColegiado ;
    private String especialidad; 

    public Doctor(String nombre, String horario, String usuarioEnSistema, String especialidad, int numeroColegiado) {
        super (nombre , horario , usuarioEnSistema);
        this.numeroColegiado = numeroColegiado;
        this.especialidad = especialidad;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    
    @Override
    protected String getRol() {
        return "Médico";
    }
   
    

    
   
}
