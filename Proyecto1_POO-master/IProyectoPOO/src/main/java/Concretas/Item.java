package Concretas;
import Abstractas.Producto;
public class Item {
    private final Producto producto  ; 
    private int cantidad; 
    
    public Item(Producto producto , int cantidad) { 
        this.producto = producto ; 
        this.cantidad= cantidad ; 
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
   
}
