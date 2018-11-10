package modelo;

public class Hotel {
    
    private String nombre;
    private int cantidad_pisos;
    
    public Hotel(){
        
    }
    
    public Hotel(String nombre, int cantidad_pisos){
        this.nombre = nombre;
        this.cantidad_pisos = cantidad_pisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_pisos() {
        return cantidad_pisos;
    }

    public void setCantidad_pisos(int cantidad_pisos) {
        this.cantidad_pisos = cantidad_pisos;
    }
    
}
