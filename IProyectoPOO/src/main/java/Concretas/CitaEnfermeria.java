/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concretas;

/**
 *
 * @author benja
 */

import Abstractas.Cita;
import Abstractas.Personal;
import java.time.LocalDate;
import java.time.LocalTime;


public class CitaEnfermeria extends Cita {
    private String procedimiento ; 
    private String observaciones ;     

    public CitaEnfermeria(String procedimiento, String observaciones, LocalDate fecha, LocalTime hora, Personal profesionalAsignado, Paciente pacienteAsignado, int consultorioAsignado) {
        super(fecha, hora, profesionalAsignado, pacienteAsignado, consultorioAsignado);
        this.procedimiento = procedimiento;
        this.observaciones = observaciones;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
}
