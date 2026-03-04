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
    private Inventario inventario;

    String RESET = "\u001B[0m";
    String CYAN = "\u001B[36m";
    String PURPLE = "\u001B[35m";
    String YELLOW = "\u001B[33m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String BOLD = "\u001B[1m";

    public Valiente() {
        System.out.println(PURPLE + "===== CREACIÓN DE PERSONAJE =====" + RESET);
        this.inventario = new Inventario();

        int totalPuntos = 40;
        int puntosRestantes = totalPuntos;

        System.out.print(CYAN + "Introduce un nombre para tu valiente: " + RESET);
        String nombre = teclado.nextLine();
        this.setNombre(nombre); // Guardamos el nombre

        int vida = 100, ataque = 1, defensa = 1, habilidad = 1, velocidad = 1;
        this.setVida(vida);   // Guardamos vida base
        this.setNivel(1);     // Nivel inicial

        // ATAQUE
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
        this.setFuerza(ataque); // Guardamos ataque
        puntosRestantes -= ataque;

        // DEFENSA
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
        this.setDefensa(defensa); // Guardamos defensa
        puntosRestantes -= defensa;

        // HABILIDAD
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
        this.setHabilidad(habilidad); // Guardamos habilidad
        puntosRestantes -= habilidad;

        // VELOCIDAD
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
        this.setVelocidad(velocidad); // Guardamos velocidad
        puntosRestantes -= velocidad;

        // Resultado final
        System.out.println("\n" + GREEN + "===== PERSONAJE CREADO =====" + RESET);
        System.out.printf("Valiente: " + BOLD + "%s" + RESET + "%n", this.getNombre());
        System.out.printf("Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d%n",
                this.getVida(), this.getFuerza(), this.getDefensa(), this.getHabilidad(), this.getVelocidad());
        System.out.println(YELLOW + "Puntos sin gastar: " + puntosRestantes + RESET);
    }

    public Valiente(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
        this.inventario = new Inventario();
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

    public Inventario getInventario() {
        return inventario;
    }
    
    /**
     * 
     * @param <T>
     * @param personaje
     * @return Fuerza del valiente
     * Meotodo generico que devuelve la fuerza del valiente
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
     * 
     * @param cantidad daño recibido
     * Metodo generico que permite que el valiente reciba daño
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
     * 
     * @param m Monstruo que recibe el efecto
     * Metodo que permite al valiente usar sus habilidades especiales contra los monstruos
     */
    @Override
    public void usarHabilidadEspecial(Monstruo m) {
        String valiente = this.getNombre().toLowerCase();
        int dañoFinal = 0;
        int costeVida = 0;

        // Colores para el feedback del sacrificio
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";

        if (valiente.contains("guerrero")) {
            //cambias arma por ataque multiplicando el daño por 2,5
            if (this.getArma() != null) {
                String nombreArma = getArma().getNombre(); // Guardamos el nombre antes de que sea null
                System.out.println(RED + "¡HOSTIA MONUMENTAL! Rompes tu " + nombreArma + " para un impacto devastador." + RESET);
                dañoFinal = (int) (this.atacar(m) * 2.5); //se multiplica el daño
                this.setArma(null); //se elimina el arma
            } else {
                System.out.println("No tienes un arma equipada para realizar este sacrificio.");
                return;
            }

        } else if (valiente.contains("paladin")) {
            costeVida = 20;
        } else if (valiente.contains("mago")) {
            costeVida = 25;
        } else if (valiente.contains("picaro")) {
            costeVida = 15;
        } else {
            costeVida = 10;
        }

        //comprobamos que no se quede sin vida
        if (!valiente.contains("guerrero") && this.getVida() <= costeVida) {
            System.out.println(RED + "¡VIDA INSUFICIENTE!" + RESET);
            System.out.println(YELLOW + "No tienes suficiente vida para realizar este esfuerzo. Te quedarían 0 HP." + RESET);
            return;
        }

        // Ejecución de habilidades de vida (Solo si no es guerrero, que ya atacó arriba)
        if (!valiente.contains("guerrero")) {
            if (valiente.contains("paladin")) {
                // Cambia vida por defensa
                System.out.println(RED + "¡VOTO DE SANGRE! Sacrificas 20 de vida para fortalecer tu defensa." + RESET);
                this.setVida(this.getVida() - 20);
                this.setDefensa(this.getDefensa() + 3);
                dañoFinal = this.getFuerza() + this.getDefensa();

            } else if (valiente.contains("mago")) {
                // Pierdes vida para usar tu habilidad como fuerza x4
                System.out.println(RED + "¡TRANSFERENCIA OSCURA! Usas tu fuerza vital como combustible mágico." + RESET);
                this.setVida(this.getVida() - 25);
                dañoFinal = this.getHabilidad() * 4;

            } else if (valiente.contains("picaro")) {
                // Pierdes vida y tu golpe hace el doble de daño
                System.out.println(RED + "¡FRENESÍ ASESINO! Te hieres al moverte a velocidades estrepitosas." + RESET);
                this.setVida(this.getVida() - 15);
                dañoFinal = (int) (this.atacar(m) * 2);

            } else {
                // Personaje personalizado
                System.out.println(RED + "¡ESFUERZO LÍMITE! Fuerzas tus músculos más allá de su capacidad." + RESET);
                this.setVida(this.getVida() - 10);
                dañoFinal = this.getFuerza() + 15;
            }
        }

        m.recibirDaño(dañoFinal);
    }
    
    /**
     * Metodo que controla el nivel de los personajes y otorga un punto de estadistica a elegir cada nivel subido
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
    
    /**
     * 
     * @return Estadisiticas del valiente
     * Metodo que muestra las estadisticas del valiente
     */
    @Override
    public String toString() {
        return String.format(
                getNombre() + "    " + "Vida: %d  Ataque: %d  Defensa: %d  Habilidad: %d  Velocidad: %d",
                getVida(), getFuerza(), getDefensa(), getHabilidad(), getVelocidad()
        );
    }

}
