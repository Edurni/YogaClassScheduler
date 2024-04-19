package Modelo;


import Modelo.BBDD;
import java.awt.Color;
import java.util.ArrayList;
import keeptoo.KGradientPanel;


public class Datos {
   private static ArrayList<Usuarios>usuario = new ArrayList();
 private static Usuarios actual;
 
  public static BBDD basedeDatos = new BBDD();
      
  public static ArrayList<KGradientPanel> paneles = new ArrayList();

  
   public static void addPanel(KGradientPanel panel) {
        paneles.add(panel);
    }
      public static ArrayList<KGradientPanel> getAllPanels() {
        return paneles;
    }
    public static Usuarios getActual() {
        return actual;
    }
 
    public static void setActual(Usuarios actual) {
        Datos.actual = actual;
    }
 
 
    public static ArrayList<Usuarios> getUsuarioañadir() {
        return usuario;
    }

    public static void setUsuarioañadir(ArrayList<Usuarios> usuarioañadir) {
        Datos.usuario = usuarioañadir;
    }
   
    public static ArrayList<Usuarios> añadirusuarios( Usuarios e){
        
        usuario.add(e);
        return usuario;
        
    }
        

    public static void cambiarColorInicio(Color inicio, ArrayList<KGradientPanel> paneles) {
        for (KGradientPanel panel : paneles) {
            panel.setkStartColor(inicio);
            panel.repaint();
        }
    
}
     
    public static void cambiarColorFin(Color fin, ArrayList<KGradientPanel> paneles) {
        for (KGradientPanel panel : paneles) {
            panel.setkEndColor(fin);
            panel.repaint();
        }
        
    }
}
