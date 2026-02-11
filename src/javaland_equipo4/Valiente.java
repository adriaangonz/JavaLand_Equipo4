package javaland_equipo4;

import javaland_interfaces.PersonajesInterface;
import java.util.Scanner;

/**
 *
 * @author DAM106
 */
public class Valiente extends Personaje {

    Scanner teclado = new Scanner(System.in);

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

    @Override
    public <T> double atacar(T personaje) {

        int danio = this.getFuerza();
        if (this.getArma() != null) {
            danio += this.getArma().getAtaque();
        }

        Monstruo enemigo = (Monstruo) personaje;

        // Restar defensa del monstruo
        danio -= enemigo.getDefensa();

        System.out.println(this.getNombre() + " causa " + danio + " puntos de daño a " + enemigo.getNombre() + ".");

        return danio;
    }

    @Override
    public void recibirDaño(int cantidad) {

        int vida = this.getVida();

        int danio = vida - cantidad;

        this.setVida(danio);

    }

    @Override
    public void usarHabilidadEspecial(Monstruo m) {

    }

    @Override
    public void subirNivel() {
        
        boolean mejorado = false;
        do {
            System.out.println("Que estadistica quieres subir: \n 1. Fuerza \n 2. Defensa \n 3. Vida \n 4. Velocidad \n 5. Habilidad \n  ");
            int opcion = Integer.parseInt(teclado.nextLine());
                switch (opcion) {
                    
                    case 1:
                        this.getFuerza()
                    
                    
                }

        } while (mejorado == false);
    }

}
