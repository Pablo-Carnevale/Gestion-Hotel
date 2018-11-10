package interfaces_implementadas;

import controlador.Conexion;
import interfaces.RegistroHotel;
import interfaces.RegistroHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Hotel;


//La utilidad de esta clase es solo para que implemente la interface con el metodo para crear un hotel en la base de datos
public class RegistroHotelImpl implements RegistroHotel {

    private Conexion conectar = new Conexion();
    
    
    //Metodo para asignar cuando ocurra un evento en el boton aceptar
    //Se va a encargar de registrar el hotel a la base de datos    
    @Override
    public boolean registrarHotel(Hotel hot) {
        PreparedStatement ps = null;
        Connection con = conectar.getConexion();
        String sql = "INSERT INTO hoteles (nombre, cantidad_pisos) Values (?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, hot.getNombre());
            ps.setInt(2, hot.getCantidad_pisos());
            ps.execute();
            return true;
        }catch(SQLException e){
           System.err.println("Error al registrar Hotel: "+e.getMessage());
           return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }        
    }
    
    
}
