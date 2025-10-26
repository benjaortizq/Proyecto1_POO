package Funcionales;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Benjamin Ortiz
 */
import Concretas.Hospital;
import java.io.File;

public class Persistencia {

    private final String RUTA_POR_DEFECTO;
 
    public Persistencia(String ruta) {
        this.RUTA_POR_DEFECTO = ruta;
    }
    public final void guardarHospital(Hospital hospital) {
        // Guardado "seguro": escribe a temp y luego renombra
        String temp = RUTA_POR_DEFECTO + ".tmp";
        Serializer.serializarObjeto(hospital, temp);
        // renombrar (simple; en Windows puede tener edge cases)
        File fTemp = new File(temp);
        File fFinal = new File(RUTA_POR_DEFECTO);
        if (fTemp.exists()) {
            fFinal.delete(); // eliminar viejo
            fTemp.renameTo(fFinal);
        }
    }

    public final Hospital cargarHospital() {
        Object obj = Serializer.deserializarObjeto(RUTA_POR_DEFECTO);
        if (obj instanceof Hospital hospital) {
            return hospital;
        } else {
            return null;
        }
    }
}
