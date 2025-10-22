package Abstractas;

/**
 * @author Benjamin Ortiz
 */
public abstract class Producto {
    private String nombre ; 
    private String  presentacion ; 
    private  int precio ; 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public int getPrecio() {
        return precio;
    }
    
    
}
