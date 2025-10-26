package Concretas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Benjamin Ortiz
 */

import java.util.HashMap;
import Abstractas.Producto;
public class Inventario {
    private final HashMap <String, Item> inventario ; 

    public Inventario() {
        this.inventario = new HashMap <>() ;
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        String nombre = producto.getNombre();

        if (inventario.containsKey(nombre)) {
            Item itemExistente = inventario.get(nombre);
            itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
        } else {
            Item nuevoItem = new Item(producto, cantidad);
            inventario.put(nombre, nuevoItem);
        }
    }
    public void eliminarProducto(String nombre) {
        inventario.remove(nombre);
    }
    public Item buscarProducto(String nombre) {
        return inventario.get(nombre);
    }    
}
