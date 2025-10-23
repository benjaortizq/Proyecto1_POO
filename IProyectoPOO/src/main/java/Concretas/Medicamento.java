package Concretas;
import Abstractas.Producto;
/**
 *
 * @author Benjamin Ortiz
 */
public class Medicamento extends Producto {
    private String preescripcion = "Solo Medicos" ; 
    
    public Medicamento (String nombre , String presentacion , int precio ) { 
        super (nombre , presentacion , precio ) ; 
    }

    public String getPreescripcion() {
        return preescripcion;
    }
}
