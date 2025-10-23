package Concretas;

import java.util.ArrayList;

public class Hospital {

    // Atributos
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Enfermeria> listaEnfermero;
    private ArrayList<Administrativo> listaAdministrativo;

    // Constructor
    public Hospital() {
        listaPacientes = new ArrayList<>();
        listaDoctores = new ArrayList<>();
        listaEnfermero = new ArrayList<>();
        listaAdministrativo = new ArrayList<>();
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
    }

    public void agregarEnfermero(Enfermeria e) {
        listaEnfermero.add(e);
    }

    public void agregarAdministrativo(Administrativo a) {
        listaAdministrativo.add(a);
    }
}
