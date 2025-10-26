 package Concretas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Benjamin Ortiz
 */

import Abstractas.Personal;
/**
 *
 * @author Benjamin Ortiz
 */
public class Enfermeria extends Personal  {
    private int numeroColegiado ;
    private final Gestorcitas gestorCitas;


    public Enfermeria(String nombre, String horario, String usuarioEnSistema, int numeroColegiado) {
        super (nombre , horario , usuarioEnSistema);
        this.numeroColegiado = numeroColegiado;
        this.gestorCitas= new Gestorcitas();
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }
    
    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    @Override
    public String getRol() {
        return "Enfermeria";
    }

    public Gestorcitas getGestorCitas() {
        return gestorCitas;
    }
   
    

    
   
}

