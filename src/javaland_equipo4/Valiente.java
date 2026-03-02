package javaland_equipo4;

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

    public Valiente() {
        System.out.println("===== CREACIÓN DE PERSONAJE =====");
        int totalPuntos = 40;
        int puntosRestantes = totalPuntos;

        System.out.print("Introduce un nombre para tu valiente: ");
        String nombre = teclado.nextLine();

        int vida = 100, ataque = 1, defensa = 1, habilidad = 1, velocidad = 1;

        // ATAQUE
        do {
            try {
                System.out.print("Cuánto ataque quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                ataque = Integer.parseInt(teclado.nextLine());

                if (ataque < 0) {
                    System.out.println("No puedes introducir números negativos.");
                } else if (ataque > puntosRestantes) {
                    System.out.println("No tienes suficientes puntos. Intenta un valor menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes introducir un número entero.");
                ataque = -1;
            }
        } while (ataque < 0 || ataque > puntosRestantes);
        puntosRestantes -= ataque;

        // DEFENSA
        do {
            try {
                System.out.print("Cuánta defensa quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                defensa = Integer.parseInt(teclado.nextLine());

                if (defensa < 0) {
                    System.out.println("No puedes introducir números negativos.");
                } else if (defensa > puntosRestantes) {
                    System.out.println("No tienes suficientes puntos. Intenta un valor menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes introducir un número entero.");
                defensa = -1;
            }
        } while (defensa < 0 || defensa > puntosRestantes);
        puntosRestantes -= defensa;

        // HABILIDAD
        do {
            try {
                System.out.print("Cuánta habilidad quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                habilidad = Integer.parseInt(teclado.nextLine());

                if (habilidad < 0) {
                    System.out.println("No puedes introducir números negativos.");
                } else if (habilidad > puntosRestantes) {
                    System.out.println("No tienes suficientes puntos. Intenta un valor menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes introducir un número entero.");
                habilidad = -1;
            }
        } while (habilidad < 0 || habilidad > puntosRestantes);
        puntosRestantes -= habilidad;

        // VELOCIDAD
        do {
            try {
                System.out.print("Cuánta velocidad quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                velocidad = Integer.parseInt(teclado.nextLine());

                if (velocidad < 0) {
                    System.out.println("No puedes introducir números negativos.");
                } else if (velocidad > puntosRestantes) {
                    System.out.println("No tienes suficientes puntos. Intenta un valor menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes introducir un número entero.");
                velocidad = -1;
            }
        } while (velocidad < 0 || velocidad > puntosRestantes);
        puntosRestantes -= velocidad;

        // Resultao final
        System.out.println("\n===== PERSONAJE CREADO =====");
        System.out.printf("Valiente: %s%n", nombre);
        System.out.printf("Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d%n",
                vida, ataque, defensa, habilidad, velocidad);
        System.out.println("Puntos sin gastar: " + puntosRestantes);
    }

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
        boolean mejorado = false;
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

            do {
                System.out.println("""
                ¿Qué estadística quieres subir?
                1. Fuerza
                2. Defensa
                3. Vida
                4. Velocidad
                5. Habilidad
                """);
                try {
                    int opcion = Integer.parseInt(teclado.nextLine());

                    switch (opcion) {
                        case 1 -> {
                            this.setFuerza(this.getFuerza() + 1);
                            System.out.println("Has mejorado la Fuerza");
                            mejorado = true;
                        }
                        case 2 -> {
                            this.setDefensa(this.getDefensa() + 1);
                            System.out.println("Has mejorado la Defensa");
                            mejorado = true;
                        }
                        case 3 -> {
                            this.setVida(this.getVida() + 10);
                            System.out.println("Has mejorado la Vida");
                            mejorado = true;
                        }
                        case 4 -> {
                            this.setVelocidad(this.getVelocidad() + 1);
                            System.out.println("Has mejorado la Velocidad");
                            mejorado = true;
                        }
                        case 5 -> {
                            this.setHabilidad(this.getHabilidad() + 1);
                            System.out.println("Has mejorado la Habilidad");
                            mejorado = true;
                        }
                        default ->
                            System.out.println("Opción no válida, intenta de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduce un número válido.");
                }
            } while (!mejorado);
        }
    }

    @Override
    public String toString() {
        return String.format(
                getNombre() + "    " + "Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d",
                getVida(), getFuerza(), getDefensa(), getHabilidad(), getVelocidad()
        );
    }

}
