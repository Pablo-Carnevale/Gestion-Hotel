package controlador;
import interfaces_implementadas.ObtenerHotelImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Hotel;
import vista.Pregunta;

public class CtrlPregunta implements ActionListener {
    
    private Pregunta frm = new Pregunta();
    private Hotel hotel = new Hotel();
    private ObtenerHotelImpl hotel_impl = new ObtenerHotelImpl();
    
    public CtrlPregunta(){
        frm.btn_si.addActionListener(this);
        frm.btn_no.addActionListener(this); 
    }
    
    //Metodo que pone activo el frame Pregunta
    public void iniciar(){
        frm.setTitle("Gestion Hotel: Ingreso de Usuario");
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm.setVisible(true);
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
        if(e.getSource().equals(frm.btn_si)){
            frm.setVisible(false);
            new CtrlSetupHotel().iniciar();
        }
        
        if(e.getSource().equals(frm.btn_no)){
            hotel.setNombre(JOptionPane.showInputDialog("Escriba el nombre de su hotel:")); 
            if(hotel_impl.obtenerHotel(hotel)){
                JOptionPane.showMessageDialog(null, "Bienvenido! Pulse aceptar para seguír adelante");
            }else{
                JOptionPane.showMessageDialog(null, "Hotel no encontrado, volviendo al menú principal");
            }
            
            /*llamar metodo que consulte en la bd el nombre del hotel pasado por JOptionPane,
            si dicho nombre es verdadero, que me lleve al frame pasajeros-habitaciones,
            de ser falso, que vuelva al frame CtrlPregunta*/
        }
    }
}
