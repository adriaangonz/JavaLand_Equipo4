
package javaland_equipo4;

import javaland_interfaces.PersonajesInterface;

/**
 *
 * @author DAM106
 */
public class Personaje implements PersonajesInterface { //Clase padre de ella heredan Valiente y Monstruo
    
    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;
    private int nivel;
    
    
    
    public Personaje(){}

    public Personaje(int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
        this.nivel = nivel;
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
