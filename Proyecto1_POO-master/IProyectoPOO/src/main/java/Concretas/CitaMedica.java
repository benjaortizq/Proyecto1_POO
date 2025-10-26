
package Concretas;

import Abstractas.Cita;
import Abstractas.Personal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica extends Cita {
    private String dagnostico ; 
    private String tratamiento ; 

    public CitaMedica(String dagnostico, String tratamiento, LocalDate fecha, LocalTime hora, Personal profesionalAsignado, Paciente pacienteAsignado, int consultorioAsignado) {
        super(fecha, hora, profesionalAsignado, pacienteAsignado, consultorioAsignado);
        this.dagnostico = dagnostico;
        this.tratamiento = tratamiento;
    }

    public String getDagnostico() {
        return dagnostico;
    }

    public void setDagnostico(String dagnostico) {
        this.dagnostico = dagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    
    
 
    
    
    
    
}
