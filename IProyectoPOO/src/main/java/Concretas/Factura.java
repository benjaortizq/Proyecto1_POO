/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concretas;

/**
 *
 * @author Benjamin Ortiz
 */
import Abstractas.Cita;
import java.util.ArrayList;

public class Factura {

    private Cita cita; // la cita asociada
    private String[][] matrizFactura; // filas x columnas
    private int columnas; // número de productos en la factura
    private final int FILAS = 5; // Cantidad, Prescripcion, Insumo/Medicamento, Presentación, Precio

    public Factura(Cita cita) {
        this.cita = cita;
        this.columnas = cita.getProductosUsados().size();
        this.matrizFactura = new String[FILAS][columnas];
        generarMatriz();
    }

    // Genera la matriz a partir de los productos usados en la cita
    private void generarMatriz() {
        ArrayList<Item> productos = cita.getProductosUsados();

        for (int col = 0; col < productos.size(); col++) {
            Item item = productos.get(col);
            matrizFactura[0][col] = String.valueOf(item.getCantidad()); // Cantidad
            matrizFactura[1][col] = item.getProducto().getNombre();      // Prescripcion / Nombre
            matrizFactura[2][col] = item.getProducto() instanceof Insumo ? "Insumo" : "Medicamento"; // Tipo
            matrizFactura[3][col] = item.getProducto().getPresentacion(); // Presentación
            matrizFactura[4][col] = String.valueOf(item.getProducto().getPrecio()); // Precio
        }
    }

    // Mostrar factura por consola
    public void mostrarFactura() {
        String[] filasNombres = {"Cantidad", "Prescripcion", "Tipo", "Presentación", "Precio"};
        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print(filasNombres[fila] + ":\t");
            for (int col = 0; col < columnas; col++) {
                System.out.print(matrizFactura[fila][col] + "\t");
            }
            System.out.println();
        }
    }

    public String[][] getMatrizFactura() {
        return matrizFactura;
    }

    public Cita getCita() {
        return cita;
    }
}