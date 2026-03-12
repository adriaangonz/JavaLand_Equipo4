/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javalandequipo4;

import java.util.Scanner;

/**
 * Clase que representa al protagonista del juego. Gestiona la asignación de puntos iniciales,
 * el inventario, el equipamiento y las habilidades especiales según la clase del héroe.
 * @author saul
 */
public class Valiente extends Personaje {

    Scanner teclado = new Scanner(System.in);

    private Arma arma;
    private Escudo escudo;
    private double experiencia;
    private double experienciaNecesaria = 100;
    private int[][] posicion = {{1, 1}};
    private Inventario inventario;

    // Colores para la interfaz de consola
    String RESET = "\u001B[0m";
    String CYAN = "\u001B[36m";
    String PURPLE = "\u001B[35m";
    String YELLOW = "\u001B[33m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String BOLD = "\u001B[1m";

    /**
     * Constructor por defecto que inicia el proceso interactivo de creación de personaje.
     * Permite al usuario repartir puntos entre ataque, defensa, habilidad y velocidad.
     * @author saul
     */
    public Valiente() {
        System.out.println(PURPLE + "===== CREACIÓN DE PERSONAJE =====" + RESET);
        this.inventario = new Inventario();

        int totalPuntos = 40;
        int puntosRestantes = totalPuntos;

        System.out.print(CYAN + "Introduce un nombre para tu valiente: " + RESET);
        String nombreInput = teclado.nextLine();
        this.setNombre(nombreInput); 

        int vidaBase = 100;
        this.setVida(vidaBase);  
        this.setNivel(1);     

        // Distribución de puntos de ATAQUE
        int ataque;
        do {
            try {
                System.out.print("¿Cuánto ataque quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                ataque = Integer.parseInt(teclado.nextLine());

                if (ataque < 0) {
                    System.out.println(RED + "No puedes introducir números negativos." + RESET);
                } else if (ataque > puntosRestantes) {
                    System.out.println(RED + "No tienes suficientes puntos." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida. Introduce un número entero." + RESET);
                ataque = -1;
            }
        } while (ataque < 0 || ataque > puntosRestantes);
        this.setFuerza(ataque); 
        puntosRestantes -= ataque;

        // Distribución de puntos de DEFENSA
        int defensa;
        do {
            try {
                System.out.print("¿Cuánta defensa quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                defensa = Integer.parseInt(teclado.nextLine());

                if (defensa < 0) {
                    System.out.println(RED + "No puedes introducir números negativos." + RESET);
                } else if (defensa > puntosRestantes) {
                    System.out.println(RED + "No tienes suficientes puntos." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida." + RESET);
                defensa = -1;
            }
        } while (defensa < 0 || defensa > puntosRestantes);
        this.setDefensa(defensa); 
        puntosRestantes -= defensa;

        // Distribución de puntos de HABILIDAD
        int habilidad;
        do {
            try {
                System.out.print("¿Cuánta habilidad quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                habilidad = Integer.parseInt(teclado.nextLine());

                if (habilidad < 0) {
                    System.out.println(RED + "No puedes introducir números negativos." + RESET);
                } else if (habilidad > puntosRestantes) {
                    System.out.println(RED + "No tienes suficientes puntos." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida." + RESET);
                habilidad = -1;
            }
        } while (habilidad < 0 || habilidad > puntosRestantes);
        this.setHabilidad(habilidad); 
        puntosRestantes -= habilidad;

        // Distribución de puntos de VELOCIDAD
        int velocidad;
        do {
            try {
                System.out.print("¿Cuánta velocidad quieres añadir? (Puntos restantes: " + puntosRestantes + "): ");
                velocidad = Integer.parseInt(teclado.nextLine());

                if (velocidad < 0) {
                    System.out.println(RED + "No puedes introducir números negativos." + RESET);
                } else if (velocidad > puntosRestantes) {
                    System.out.println(RED + "No tienes suficientes puntos." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida." + RESET);
                velocidad = -1;
            }
        } while (velocidad < 0 || velocidad > puntosRestantes);
        this.setVelocidad(velocidad); 
        puntosRestantes -= velocidad;

        System.out.println("\n" + GREEN + "===== PERSONAJE CREADO =====" + RESET);
        System.out.printf("Valiente: " + BOLD + "%s" + RESET + "%n", this.getNombre());
        System.out.printf("Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d%n",
                this.getVida(), this.getFuerza(), this.getDefensa(), this.getHabilidad(), this.getVelocidad());
        System.out.println(YELLOW + "Puntos sin gastar: " + puntosRestantes + RESET);
    }

    /**
     * Constructor parametrizado para instanciar un Valiente con valores predefinidos.
     * @author saul
     * @param nombre Nombre del héroe.
     * @param vida Puntos de salud iniciales.
     * @param fuerza Puntos de ataque físico.
     * @param defensa Puntos de resistencia.
     * @param habilidad Puntos de destreza técnica.
     * @param velocidad Puntos de agilidad.
     * @param nivel Nivel actual del personaje.
     */
    public Valiente(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
        this.inventario = new Inventario();
    }

    /** @author saul @return El arma actualmente equipada. */
    public Arma getArma() { return arma; }

    /** @author saul @return El escudo actualmente equipado. */
    public Escudo getEscudo() { return escudo; }

    /** @author saul @param arma Arma a equipar al Valiente. */
    public void setArma(Arma arma) { this.arma = arma; }

    /** @author saul @param escudo Escudo a equipar al Valiente. */
    public void setEscudo(Escudo escudo) { this.escudo = escudo; }

    /** @author saul @param experiencia Cantidad de experiencia a establecer. */
    public void setExperiencia(double experiencia) { this.experiencia = experiencia; }

    /** @author saul @return Valor decimal de la experiencia actual. */
    public double getExperiencia() { return experiencia; }

    /** @author saul @return El objeto Inventario del personaje. */
    public Inventario getInventario() { return inventario; }
    
    /**
     * Calcula el daño total combinando la fuerza base y el ataque del arma equipada.
     * @author saul
     * @param <T> Tipo genérico del objetivo.
     * @param personaje El objetivo del ataque.
     * @return double con el daño total infligido.
     */
    @Override
    public <T> double atacar(T personaje) {
        int danio = this.getFuerza();
        if (this.getArma() != null) {
            danio += this.getArma().getAtaque();
        }
        return danio;
    }
    
    /**
     * Aplica daño a la vida del valiente y muestra el resultado en consola.
     * @author saul
     * @param cantidad Entero que representa el daño a recibir.
     */
    @Override
    public void recibirDaño(int cantidad) {
        int vidaActual = this.getVida();
        int vidaRestante = vidaActual - cantidad;
        this.setVida(vidaRestante);
        System.out.println(this.getNombre() + " recibe " + cantidad
                + " puntos de daño. Vida actual: " + vidaRestante);
    }
    
    /**
     * Ejecuta una técnica especial sacrificando recursos (vida o equipo) según la clase.
     * Soporta Guerrero (sacrifica arma), Paladín, Mago y Pícaro.
     * @author saul
     * @param m El monstruo que recibirá el impacto de la habilidad.
     */
    @Override
    public void usarHabilidadEspecial(Monstruo m) {
        String clase = this.getNombre().toLowerCase();
        int dañoFinal = 0;
        int costeVida = 0;

        if (clase.contains("guerrero")) {
            if (this.getArma() != null) {
                String nombreArma = getArma().getNombre();
                System.out.println(RED + "¡HOSTIA MONUMENTAL! Rompes tu " + nombreArma + " para un impacto devastador." + RESET);
                dañoFinal = (int) (this.atacar(m) * 2.5);
                this.setArma(null);
            } else {
                System.out.println("No tienes un arma equipada para realizar este sacrificio.");
                return;
            }
        } else if (clase.contains("paladin")) {
            costeVida = 20;
        } else if (clase.contains("mago")) {
            costeVida = 25;
        } else if (clase.contains("picaro")) {
            costeVida = 15;
        } else {
            costeVida = 10;
        }

        if (!clase.contains("guerrero") && this.getVida() <= costeVida) {
            System.out.println(RED + "¡VIDA INSUFICIENTE!" + RESET);
            return;
        }

        if (!clase.contains("guerrero")) {
            if (clase.contains("paladin")) {
                System.out.println(RED + "¡VOTO DE SANGRE! Sacrificas 20 de vida para fortalecer tu defensa." + RESET);
                this.setVida(this.getVida() - 20);
                this.setDefensa(this.getDefensa() + 3);
                dañoFinal = this.getFuerza() + this.getDefensa();
            } else if (clase.contains("mago")) {
                System.out.println(RED + "¡TRANSFERENCIA OSCURA! Usas tu fuerza vital como combustible mágico." + RESET);
                this.setVida(this.getVida() - 25);
                dañoFinal = this.getHabilidad() * 4;
            } else if (clase.contains("picaro")) {
                System.out.println(RED + "¡FRENESÍ ASESINO! Te hieres al moverte a velocidades estrepitosas." + RESET);
                this.setVida(this.getVida() - 15);
                dañoFinal = (int) (this.atacar(m) * 2);
            } else {
                System.out.println(RED + "¡ESFUERZO LÍMITE! Fuerzas tus músculos más allá de su capacidad." + RESET);
                this.setVida(this.getVida() - 10);
                dañoFinal = this.getFuerza() + 15;
            }
        }
        m.recibirDaño(dañoFinal);
    }
    
    /**
     * Gestiona el incremento de nivel, mejora de estadísticas base y 
     * permite al usuario elegir una estadística adicional para subir.
     * @author saul
     */
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

            do {
                System.out.println("¿Qué estadística adicional quieres subir? (1: Fuerza, 2: Defensa, 3: Vida, 4: Velocidad, 5: Habilidad)");
                try {
                    int opcion = Integer.parseInt(teclado.nextLine());
                    switch (opcion) {
                        case 1 -> { this.setFuerza(this.getFuerza() + 1); mejorado = true; }
                        case 2 -> { this.setDefensa(this.getDefensa() + 1); mejorado = true; }
                        case 3 -> { this.setVida(this.getVida() + 10); mejorado = true; }
                        case 4 -> { this.setVelocidad(this.getVelocidad() + 1); mejorado = true; }
                        case 5 -> { this.setHabilidad(this.getHabilidad() + 1); mejorado = true; }
                        default -> System.out.println("Opción no válida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número válido.");
                }
            } while (!mejorado);
        }
    }
    
    /**
     * Genera una cadena con el resumen de las estadísticas actuales del Valiente.
     * @author saul
     * @return String formateado con nombre, vida, ataque, defensa, habilidad y velocidad.
     */
    @Override
    public String toString() {
        return String.format(
                getNombre() + "    " + "Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d",
                getVida(), getFuerza(), getDefensa(), getHabilidad(), getVelocidad()
        );
    }
}