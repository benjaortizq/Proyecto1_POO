package com.mycompany.iproyectopoo;

/**
 *
 * @author benjamin ortiz 
 */
import javax.swing.*;
import Concretas.Hospital ;
import Concretas.Doctor ;
import Concretas.Administrativo ;
import Concretas.Enfermeria;
import UI.Login;

public class IProyectoPOO {

    public static void main(String[] args) {

        // Inicializamos la instancia del hospital con personal, pacientes, etc.
        Hospital hospital = new Hospital();

        Administrativo ADMIN = new Administrativo("Juan Andres", "Manana-Tarde" ,"JuanAndres", 119610999);
        Doctor Doc = new Doctor("Pablo Esteban ", "Manana-Tarde" ,"PabloEst" , "General", 12378293);
        Enfermeria Enf = new Enfermeria("Maria Auxiliadora", "Manana-Tarde" ,"MariaAux", 12378293);
        
        hospital.agregarDoctor(Doc);
        hospital.agregarEnfermero(Enf);
        hospital.agregarAdministrativo(ADMIN);
        
        SwingUtilities.invokeLater(() -> {
            new Login(hospital).setVisible(true);
        });
    }
} 
/**TODO : 
 * - PANTALLAS LOGIN ETC 
 * - LOGICA PANTALLAS 
 * - SERIALIZADOR Y PERSISTENCIA CON JSON 
 * - 
 */