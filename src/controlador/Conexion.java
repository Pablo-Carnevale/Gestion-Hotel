
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static Conexion instancia = null;
    private final String base = "formularios";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con  = null; 
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    private Conexion(){
    
    }
    
    public Connection getConexion(){
        try {
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
