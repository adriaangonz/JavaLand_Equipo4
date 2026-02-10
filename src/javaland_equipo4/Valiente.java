package javaland_equipo4;

import javaland_interfaces.PersonajesInterface;

/**
 *
 * @author DAM106
 */
public class Valiente extends Personaje {

    private Arma arma;
    private Escudo escudo;

    public Valiente(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }



    //Getters y setters
    public Arma getArma() {
        return arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public <T> double atacar(T personaje) {

        int danio = this.getFuerza();
        if (this.getArma() != null) {
            danio += this.getArma().getAtaque();
        }
        
        Monstruo enemigo = (Monstruo) personaje ;

        // Restar defensa del monstruo
        danio -= enemigo.getDefensa();

        // Aplicar daño al monstruo
        enemigo.recibirDaño(danio);

        System.out.println(this.getNombre() + " causa " + danio + " puntos de daño a " + enemigo.getNombre() +  ".");

        return danio;
    }

    
    
    
    
    
}
