package Concretas;
import java.time.LocalDate;
import java.time.LocalTime;
import Abstractas.Personal;
import java.util.ArrayList;

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
    ArrayList<Item> productosUsados ;
    

    public Cita(LocalDate fecha, LocalTime hora, Personal profesionalAsignado, Paciente pacienteAsignado, int consultorioAsignado) {
        this.fecha = fecha;
        this.hora = hora;
        this.profesionalAsignado = profesionalAsignado;
        this.pacienteAsignado = pacienteAsignado;
        this.consultorioAsignado = consultorioAsignado;
        this.productosUsados = new ArrayList<>();
        
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

    public ArrayList<Item> getProductosUsados() {
        return productosUsados;
    }
    
    
    
    public void anadirProducto(Item item ) { 
        boolean encontrado = false ; 
        
        for (Item i : productosUsados) {
            if (i.getProducto().getNombre().equals(item.getProducto().getNombre())) {
                // Sumar la cantidad
                i.setCantidad(i.getCantidad() + item.getCantidad());
                encontrado = true;
                break;
        }
        if (!encontrado) {
        productosUsados.add(item);
        }
    }
  } 

public void eliminarProducto(Item item) {
    for (int i = 0; i < productosUsados.size(); i++) {
        Item actual = productosUsados.get(i);
        if (actual.getProducto().getNombre().equals(item.getProducto().getNombre())) {
            int nuevaCantidad = actual.getCantidad() - item.getCantidad();
            if (nuevaCantidad > 0) {
                actual.setCantidad(nuevaCantidad); // restar cantidad
            } else {
                productosUsados.remove(i); // eliminar completamente
            }
            break;
        }
    }
}
}
