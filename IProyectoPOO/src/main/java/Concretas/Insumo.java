package Concretas;
import Abstractas.Producto;
/**
 *
 * @author Benjamin Ortiz
 */
public class Insumo extends Producto {
    private String preescripcion = "Medicos y Enfermeria" ; 
    
    public Insumo (String nombre , String presentacion , int precio ) { 
        super (nombre , presentacion , precio ) ; 
    }

    public String getPreescripcion() {
        return preescripcion;
    }
    
    
}