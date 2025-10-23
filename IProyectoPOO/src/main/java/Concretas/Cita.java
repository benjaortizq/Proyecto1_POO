package Concretas;
import java.time.LocalDate;
import java.time.LocalTime;
import Abstractas.Personal;

/**
 *
 * @author benja
 */
public class Cita {
    LocalDate fecha ; 
    LocalTime hora ; 
    Personal profesionalAsignado ; 
    Paciente pacienteAsignado;
    String estado; 
    int consultorioAsignado;
    String tipoCita; 

    public Cita(LocalDate fecha, LocalTime hora, Personal profesionalAsignado, Paciente pacienteAsignado, int consultorioAsignado) {
        this.fecha = fecha;
        this.hora = hora;
        this.profesionalAsignado = profesionalAsignado;
        this.pacienteAsignado = pacienteAsignado;
        this.consultorioAsignado = consultorioAsignado;
        
        if ("Medico".equals(profesionalAsignado.getRol())){ 
            this.tipoCita = "Medica" ;
        }
        else {this.tipoCita = "Enfermeria";}
        
        
    }
    
    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Personal getProfesionalAsignado() {
        return profesionalAsignado;
    }

    public void setProfesionalAsignado(Personal profesionalAsignado) {
        this.profesionalAsignado = profesionalAsignado;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getConsultorioAsignado() {
        return consultorioAsignado;
    }

    public void setConsultorioAsignado(int consultorioAsignado) {
        this.consultorioAsignado = consultorioAsignado;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }
    
    
    
    
    
    
}
