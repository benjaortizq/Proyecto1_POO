package Concretas;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import Abstractas.Personal;

public class Hospital implements Serializable {

    // Atributos
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Enfermeria> listaEnfermero;
    private ArrayList<Administrativo> listaAdministrativo;
    private final HashMap<String, Personal> mapaPersonal;


    // Constructor
    public Hospital() {
        listaPacientes = new ArrayList<>();
        listaDoctores = new ArrayList<>();
        listaEnfermero = new ArrayList<>();
        listaAdministrativo = new ArrayList<>();
        mapaPersonal = new HashMap<>();
    }

    // Getters y Setters
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public ArrayList<Enfermeria> getListaEnfermero() {
        return listaEnfermero;
    }

    public void setListaEnfermero(ArrayList<Enfermeria> listaEnfermero) {
        this.listaEnfermero = listaEnfermero;
    }

    public ArrayList<Administrativo> getListaAdministrativo() {
        return listaAdministrativo;
    }

    public void setListaAdministrativo(ArrayList<Administrativo> listaAdministrativo) {
        this.listaAdministrativo = listaAdministrativo;
    }

    // Métodos para agregar a las listas
    public void agregarPaciente(Paciente p) {
        listaPacientes.add(p);
    }

    public void agregarDoctor(Doctor d) {
        listaDoctores.add(d);
        mapaPersonal.put(d.getUsuarioEnSistema(), d);
    }

    public void agregarEnfermero(Enfermeria e) {
        listaEnfermero.add(e);
         mapaPersonal.put(e.getUsuarioEnSistema(), e);
    }

    public void agregarAdministrativo(Administrativo a) {
        listaAdministrativo.add(a);
         mapaPersonal.put(a.getUsuarioEnSistema(), a);
    }
    
    public Personal buscarPersonal(String usuario) {
        return mapaPersonal.get(usuario);
}
}
