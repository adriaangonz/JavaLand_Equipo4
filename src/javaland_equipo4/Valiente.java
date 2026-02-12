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
    private double experiencia;
    private double experienciaNecesaria = 100;

    public Valiente(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel, double experiencia) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
        this.experiencia = experiencia;
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

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }

    public double getExperiencia() {
        return experiencia;
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
        if (experiencia >= experienciaNecesaria) {

            experienciaNecesaria = experienciaNecesaria * 1.5; 
            

            do{
                System.out.println("Que estadistica quieres subir: \n 1. Fuerza \n 2. Defensa"
                        + "\n 3. Vida \n 4. Velocidad \n 5. Habilidad \n  ");
                int opcion = Integer.parseInt(teclado.nextLine());
                
                switch (opcion) {

                    case 1:
                        this.setFuerza(this.getFuerza() + 1);
                        System.out.println("Has mejorado la Fuerza :) ");
                        mejorado = true;
                    case 2:
                        this.setDefensa(this.getDefensa() + 1);
                        System.out.println("Has mejorado la Defensa :) ");
                        mejorado = true;
                    case 3:
                        this.setVida(this.getVida() + 10);
                        System.out.println("Has mejorado la Vida :) ");
                        mejorado = true;
                    case 4:
                        this.setVelocidad(this.getVelocidad() + 1);
                        System.out.println("Has mejorado la Velocidad :) ");
                        mejorado = true;
                    case 5:
                        this.setHabilidad(this.getHabilidad() + 1);
                        System.out.println("Has mejorado la Habilidad :) ");
                        mejorado = true;

                }

            } while (mejorado == false);
        }
    }
}
