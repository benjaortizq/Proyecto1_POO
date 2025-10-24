/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionales.JSON;

/**
 *
 */

import Funcionales.Serializer; 
import Concretas.Expediente; 
public class JSONUtil { 

    // Guardar Expediente (o cualquier objeto Serializable) en archivo
    public static void toJSON(Object obj, String archivo) {
        Serializer.serializarObjeto(obj, archivo);
    }

    // Leer Expediente (o cualquier objeto Serializable) desde archivo
    public static Object fromJSON(String archivo) {
        return Serializer.deserializarObjeto(archivo);
    }

    // Sobrecarga específica para Expediente
    public static Expediente fromJSONExpediente(String archivo) {
        return (Expediente) Serializer.deserializarObjeto(archivo);
    }
}