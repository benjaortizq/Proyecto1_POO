/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractas;

/**
 *
 * @author Benjamin Ortiz
 */
public abstract class Personal {
    private String nombre ; 
    private String horario ;
    private  Gestorcitas citas;
    private String usuarioEnSistema ;
   
    protected Personal(String nombre, String horario, String usuarioEnSistema) {
        this.nombre = nombre;
        this.horario = horario;
        this.usuarioEnSistema = usuarioEnSistema;
    }
    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public String getUsuarioEnSistema() {
        return usuarioEnSistema;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setUsuarioEnSistema(String usuarioEnSistema) {
        this.usuarioEnSistema = usuarioEnSistema;
    }
    
    
    public abstract String getRol();
    
    
    
    
    
    
}
