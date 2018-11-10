package interfaces_implementadas;

import controlador.Conexion;
import interfaces.ObtenerHotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Hotel;

public class ObtenerHotelImpl implements ObtenerHotel {

    private Conexion conectar = new Conexion();
    
    @Override
    public boolean obtenerHotel(Hotel hot) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar.getConexion();
        String sql = "SELECT * FROM hoteles WHERE nombre = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, hot.getNombre()); 
            rs = ps.executeQuery();
            if(rs.next()){
                hot.setNombre(rs.getString("nombre"));
                hot.setCantidad_pisos(rs.getInt("cantidad_pisos"));
                return true;
            }
            return false;
        }catch(SQLException e){
           System.err.println("Error con la búsqueda del hotel "+e.getMessage());
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
