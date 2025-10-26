package Concretas;

import Abstractas.Cita;
import Abstractas.Personal;

public class Administrativo extends Personal {

    private int cedula;

    // Constructor
    public Administrativo(String nombre, String horario, String usuario, int cedula) {
        super (nombre, horario,usuario );
        this.cedula = cedula;
    }

    // Getter y Setter
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    // Métodos según UML

    public void crearPaciente(Paciente paciente) {
        // TODO: implementar lógica para crear paciente
    }

    public void crearCita(Cita cita) {
        // TODO: implementar lógica para crear cita
    }

    public void crearExpediente(Paciente paciente) {
        // TODO: implementar lógica para crear expediente
    }

    public void agregarProducto(Insumo insumo) {
        // TODO: implementar lógica para agregar insumo
    }

    public void eliminarProducto(Insumo insumo) {
        // TODO: implementar lógica para eliminar insumo
    }

    public void crearFactura(Cita cita) {
        // TODO: implementar lógica para crear factura
    }
    
    @Override
    public String getRol() {
        return "Administrativo";
    }
}