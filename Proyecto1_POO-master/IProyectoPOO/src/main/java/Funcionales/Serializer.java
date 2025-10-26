/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionales;

/**
 *
 * @author Benjamin Ortiz
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
public class Serializer {
 
    public static void serializarObjeto(Object objeto, String archivo) {
        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
 
            oos.writeObject(objeto);
            System.out.println("Objeto serializado correctamente: " + archivo);
 
        } catch (IOException e) {
            System.err.println("Error en serialización: " + e.getMessage());
            e.printStackTrace();
        }
    }
 
    public static Object deserializarObjeto(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
 
            return ois.readObject();
 
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en deserialización: " + e.getMessage());
            e.printStackTrace(); 
            return null;
        }
    }
}