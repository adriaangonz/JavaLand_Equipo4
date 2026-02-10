
package javaland_equipo4;

import javaland_interfaces.PersonajesInterface;

/**
 *
 * @author DAM106
 */
public class Valiente extends Personaje {

    private Objeto objeto;
    
    public Valiente(int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(vida, fuerza, defensa, habilidad, velocidad, nivel);
    }
    
    
    @Override 
    public <T> double atacar(T Personaje){
    
        if(Objeto != null){
            if(Objeto instanceof Espada)
            
    
        }
        
    
    }
    
    

}
