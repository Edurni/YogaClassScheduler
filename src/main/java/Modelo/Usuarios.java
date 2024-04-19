package Modelo;

        
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dam2
 */


public class Usuarios {
    
   private String Usuario;
   private String Passwd;
   private String Nombre;
   private String Apellidos;
   private String fechaNacimiento;
   private String correo;

    public Usuarios(String Usuario, String Passwd, String Nombre, String Apellidos, String fechaNacimiento, String correo) {
        this.Usuario = Usuario;
        this.Passwd = Passwd;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

   
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
    public Usuarios(String Usuario, String Passwd) {
        this.Usuario = Usuario;
        this.Passwd = Passwd;
    }

    public Usuarios() {
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

     
    
}
