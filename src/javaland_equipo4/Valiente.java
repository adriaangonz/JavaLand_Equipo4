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
    private int[][] posicion = {{1, 1}};


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
        int vidaActual = this.getVida();
        int vidaRestante = Math.max(0, vidaActual - cantidad); // he puesto el math.max para que si baja de 0 pilla el 0 en vez de la vida negativa
        this.setVida(vidaRestante);

        System.out.println(this.getNombre() + " recibe " + cantidad
                + " puntos de daño. Vida actual: " + vidaRestante);
    }

    @Override
    public void usarHabilidadEspecial(Monstruo m) {

    }

    @Override
    public void subirNivel() {
        if (experiencia >= experienciaNecesaria) {
            experiencia -= experienciaNecesaria;
            experienciaNecesaria *= 1.5;
            this.setNivel(this.getNivel() + 1);
            this.setVida(this.getVida() + 10);
            this.setFuerza(this.getFuerza() + 1);
            this.setDefensa(this.getDefensa() + 1);
            this.setHabilidad(this.getHabilidad() + 1);
            this.setVelocidad(this.getVelocidad() + 1);

            System.out.println("\n ¡Has subido al nivel " + this.getNivel() + "! Tus atributos han mejorado.");
            System.out.println("Ahora puedes mejorar una estadística adicional.");

            boolean mejorado = false;
            do {
                System.out.println("""
                ¿Qué estadística quieres subir?
                1. Fuerza
                2. Defensa
                3. Vida
                4. Velocidad
                5. Habilidad
                """);
                int opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1 -> {
                        this.setFuerza(this.getFuerza() + 1);
                        mejorado = true;
                        System.out.println("Has mejorado la Fuerza ");
                    }
                    case 2 -> {
                        this.setDefensa(this.getDefensa() + 1);
                        mejorado = true;
                        System.out.println("Has mejorado la Defensa️");
                    }
                    case 3 -> {
                        this.setVida(this.getVida() + 10);
                        mejorado = true;
                        System.out.println("Has mejorado la Vida️");
                    }
                    case 4 -> {
                        this.setVelocidad(this.getVelocidad() + 1);
                        mejorado = true;
                        System.out.println("Has mejorado la Velocidad");
                    }
                    case 5 -> {
                        this.setHabilidad(this.getHabilidad() + 1);
                        mejorado = true;
                        System.out.println("Has mejorado la Habilidad");
                    }
                    default ->
                        System.out.println("Opción no válida, intenta de nuevo.");
                }
            } while (!mejorado);
        }
    }
}
