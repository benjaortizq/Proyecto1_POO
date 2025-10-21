package Abstractas;
public class Personal {
    private String nombre;
    private String horario; 

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Personal(String nombre, String horario ) {
        this.nombre = nombre ; 
        this.horario = horario ;
    };
    
}
