package Concretas;

/**
 *
 * @author Benjamin Ortiz
 */

import java.util.ArrayList ;
import Abstractas.Personal;

public class Gestorcitas {
    private ArrayList<Cita> listaCitas; 
    
    public Gestorcitas() { 
        listaCitas = new ArrayList<>();  
    }

    public void agregarCita(Cita cita, Personal solicitante) { 
        if (solicitante instanceof Administrativo) {
            listaCitas.add(cita);
        } else {
            System.out.println("Solo personal administrativo puede agregar citas.");
        }
    }

    public void eliminarCita(Cita cita, Personal solicitante) { 
        if (solicitante instanceof Administrativo) {
            listaCitas.remove(cita);
        } else {
            System.out.println("Solo personal administrativo puede eliminar citas.");
        }
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }
}
