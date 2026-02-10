
package javaland_equipo4;

import javaland_interfaces.PersonajesInterface;

/**
 *
 * @author DAM106
 */
public class Personaje implements PersonajesInterface { //Clase padre de ella heredan Valiente y Monstruo
    
    private String nombre;
    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;
    private int nivel;
    
    
    
    public Personaje(){}

    public Personaje(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
        this.nivel = nivel;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    

    @Override
    public <T> double atacar(T Personaje) {
        int danio = 0;
        return danio;
    }

    @Override
    public double recibirDaño(int cantidad) {
        
        int danio = 0;
        return danio;
    }

    @Override
    public void usarHabilidadEspecial(Monstruo m) {
        
    }

    @Override
    public void subirNivel() {
        
    }

    @Override
    public void crearValientesIniciales(int fuerza, int velocidad, String habilidad, int defensa) {
        
    }

    @Override
    public void generarMonstruos(int nivel) {
        
    }

    @Override
    public void eliminarMonstruo(Monstruo m) {
        
    }


    
}
