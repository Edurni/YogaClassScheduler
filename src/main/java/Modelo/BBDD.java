package Modelo;

import Interfaces.ColorObserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class BBDD {

    private final String URL = "jdbc:mysql://localhost:3306/bbdd";
    private final String USUARIO = "root";
    private final String CONTRASENA = "";
    private static BBDD instancia = new BBDD();
    private static String usuarioActual ;

    public static void setUsuarioActual(String usuarioActual) {
        BBDD.usuarioActual = usuarioActual;
    }

    public static String getUsuarioActual() {
        return usuarioActual;
    }

    

 
    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public  void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    private ArrayList<Usuarios> usuarios = new ArrayList();
     private ArrayList<ColorObserver> observers = new ArrayList<>();

    public ArrayList<ColorObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<ColorObserver> observers) {
        this.observers = observers;
    }

    public static BBDD getInstancia() {
        return instancia;
    }

    public static void setInstancia(BBDD instancia) {
        BBDD.instancia = instancia;
    }

 

    public boolean Conectar(String usuarioe, String contrasena) {
        if (usuarioe.isEmpty() || contrasena.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre de usuario y una contraseña.", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }

        try ( Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ?";
            try ( PreparedStatement statement = con.prepareStatement(sql)) { //Prepare la consulta SQL para ser ejecutada y crear un objeto PreparedStatement
                statement.setString(1, usuarioe);// Asigna el valor de la variable usuario al primer ?
                statement.setString(2, contrasena);
                try ( ResultSet result = statement.executeQuery()) {//Ejecuta la consulta SQL y devuelve un objeto ResultSet que contiene los resultados de la consulta.
                    if (result.next()) { //ResultSet, este método devuelve true, indicando que hay resultados para procesar
                        // Usuario encontrado
                        
                        return true;
                    } else {
                        // Usuario no encontrado, mostrar mensaje de error

                        javax.swing.JOptionPane.showMessageDialog(null, "Logueo incorrecto, vuelve a escribir credenciales", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        } catch (SQLException ex) {
            // Manejar el error (mostrar mensaje o log, según sea necesario)
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al intentar iniciar sesión", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

  

    public boolean DesconectarBD(String usuarioe, String contrasena) {
        Connection conn = null;

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();

                javax.swing.JOptionPane.showMessageDialog(null, "Usuario desconectado de la BD", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void GuardarUsuario(String Usuario, String Contrasena, String nombre, String apellidos, String fechanacimiento, String correo) {

        String sql = "INSERT INTO usuarios (Usuario, Contraseña, Nombre, Apellidos, FechaNacimiento, Correo) VALUES (?, ?, ?, ?, ?, ?)";
        if (!usuarioExiste(Usuario)) {
            //Comprobacion correo 
            if (!correo.isEmpty() && !correo.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un correo electrónico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                correo = null;
            }
            if (Usuario.isEmpty() || Contrasena.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Debe rellenar al menos usuario y contraseña", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd", "root", "");  PreparedStatement pst = con.prepareStatement(sql)) {

                    pst.setString(1, Usuario);
                    pst.setString(2, Contrasena);
                    pst.setString(3, nombre);
                    pst.setString(4, apellidos);
                    pst.setString(5, fechanacimiento);
                    pst.setString(6, correo);
                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        Datos.añadirusuarios(new Usuarios(Usuario, Contrasena));
                        usuarios.add(new Usuarios(Usuario, Contrasena, nombre, apellidos, fechanacimiento, correo));
                        System.out.println("Usuario insertado correctamente.");
                    } else {
                        System.out.println("No se pudo insertar el usuario.");
                    }

                } catch (SQLException ex) {

                    ex.printStackTrace();
                    javax.swing.JOptionPane.showMessageDialog(null, "Error al intentar guardar el usuario", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Este usuario YA EXISTE", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificarContraseña2(String usuario, String nuevaContraseña) {

        String sqlSelect = "SELECT * FROM usuarios WHERE Usuario = ?";
        String sqlUpdate = "UPDATE usuarios SET Contraseña = ? WHERE Usuario = ?";

        try ( Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);  PreparedStatement selectStatement = con.prepareStatement(sqlSelect);  PreparedStatement updateStatement = con.prepareStatement(sqlUpdate)) {

            // Verificar si el usuario existe antes de actualizar la contraseña
            if (usuarioExiste(usuario) == true) {
                // Usuario encontrado, actualizar la contraseña
                updateStatement.setString(1, nuevaContraseña);
                updateStatement.setString(2, usuario);
                updateStatement.executeUpdate();
                System.out.println("Se ha actualizado la contraseña para el usuario: " + usuario);
                
            } else {
                System.out.println("El usuario " + usuario + " no fue encontrado en la base de datos.");
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean usuarioExiste(String nombreUsuario) {
        boolean existe = false;

        try ( Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM usuarios WHERE Usuario = ?";
            try ( PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, nombreUsuario);

                try ( ResultSet result = statement.executeQuery()) {
                    existe = result.next();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existe;
    }

}
