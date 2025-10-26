/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concretas;

import Abstractas.Personal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jackb
 */
public class Cita extends Abstractas.Cita {
    
    public Cita(LocalDate fecha, LocalTime hora, Personal profesionalAsignado, Paciente pacienteAsignado, int consultorioAsignado) {
        super(fecha, hora, profesionalAsignado, pacienteAsignado, consultorioAsignado);
    }
    
}
