package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.SetupHotel;
import controlador.CtrlPregunta;
import java.sql.PreparedStatement;
import java.sql.Connection;
import controlador.Conexion;
import interfaces_implementadas.RegistroHotelImpl;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Hotel;

public class CtrlSetupHotel implements ActionListener {
    
    private SetupHotel frm = new SetupHotel();
    private Hotel hotel = new Hotel();
    private RegistroHotelImpl hotel_impl = new RegistroHotelImpl(); //Objeto instanciado para llamar al metodo de la interface (linea 56)
    
    public CtrlSetupHotel(){
        frm.btn_aceptar.addActionListener(this);
        frm.btn_cancelar.addActionListener(this);
    }
    
    //Metodo que pone activo el frame SetupHotel
    public void iniciar(){
        frm.setTitle("Gestion Hotel: Ingreso de Hotel");
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm.setVisible(true);        
    }
    
    //Metodo para settear info del usuario a los set de hotel
    private void setHotel(){
        hotel.setNombre(frm.txt_nombre.getText());
        hotel.setCantidad_pisos(Integer.parseInt(frm.txt_pisos.getText()));
    }
    
    
    //Metodo para devolver el nombre del hotel al JLabel del frame de pasajeros-habitaciones
    public String getNombreHotel(){
        return hotel.getNombre();
    }
    
    //Metodo para devolver los pisos del hotel al JLabel del frame de pasajeros-habitaciones    
    public String getPisosHotel(){
        return String.valueOf(hotel.getCantidad_pisos());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.btn_aceptar)){
            this.setHotel();
            if(hotel_impl.registrarHotel(hotel)){
                JOptionPane.showMessageDialog(null, "Hotel registrado con éxito! Pulse aceptar para seguír adelante");
                /*Una vez que el codigo pasa por acá, se abre el frame que contiene el JMenuItem de habitaciones y pasajeros*/
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar Hotel");
            }
        }
        
        if(e.getSource().equals(frm.btn_cancelar)){
            frm.setVisible(false);
            new CtrlPregunta().iniciar();
        }
    }
}
