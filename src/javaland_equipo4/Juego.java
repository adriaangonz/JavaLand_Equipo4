/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import javaland_interfaces.JuegoInterface;

/**
 *
 * @author cococ
 */
public class Juego implements JuegoInterface {

    private Mapa mapa;
    private Scanner teclado;
    private static int enemigosAsesinados;
    private GestorMonstruos gm1;
    private Combate c1;
    private Valiente valiente;
    private static int posicionX;
    private static int posicionY;
    private final Random r = new Random();
    boolean muerto;
    boolean victoria;

    // Colores 
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";

    @Override
    public void iniciarJuego() {
        teclado = new Scanner(System.in);
        System.out.println(PURPLE + BOLD + "\n╔════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + BOLD + "       JAVALAND: EL COMPILADOR OSCURO         " + RESET);
        System.out.println(PURPLE + BOLD + "╚════════════════════════════════════════════╝" + RESET);

        this.posicionX = 0;
        this.posicionY = 0;
        this.victoria = false;
        this.muerto = false;
        this.gm1 = new GestorMonstruos();
        this.valiente = null;
        this.c1 = new Combate();

        // Introduccion
        mostrarIntro();

        this.valiente = creacionOEleccionValiente();
        if (valiente != null) {
            this.mapa = new Mapa(false);
            mostrarMenuPrincipal();
            if (this.victoria) {
                System.out.println(GREEN + "¡Enhorabuena, héroe de Javaland!" + RESET);
            }
            if (this.muerto) {
                System.out.println(RED + "Has caído en la batalla... pero el código vive en ti." + RESET);
            }
        }
    }

    private void mostrarIntro() {
        String intro = """
                
                \u001B[36m\u001B[1mLa Tierra de los Códigos Olvidados\u001B[0m
                
                En los remotos confines del Reino Digital, donde los algoritmos susurran antiguos
                secretos y los bucles se entrelazan como místicas serpientes, se extiende un mundo
                al borde del colapso. Los bytes se desmoronan, los lenguajes de programación luchan
                por sobrevivir, y una sombra inmensa amenaza con borrar toda la memoria: el
                Compilador Oscuro.

                Este no es un mundo para programadores débiles. Aquí, cada valiente es un guerrero
                del código, cada misión una batalla contra la entropía digital. Tu misión: reunir un
                equipo de valientes, dominar tus habilidades de programación, y derrotar al ser que
                amenaza con fragmentar la realidad misma.

                Programa por programa, función por función, línea por línea, construirás la resistencia
                que salvará este reino. ¿Serás capaz de escribir el código que cambiará la historia?

                El Compilador Oscuro te espera. ¡Que comience la compilación!
                """;

        for (char c : intro.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(18); // velocidad del texto
            } catch (InterruptedException e) {
                System.out.println("Error inesperado :( ");
            }
        }

        System.out.println("\n\n" + PURPLE + "Presiona ENTER para comenzar tu aventura..." + RESET);
        new Scanner(System.in).nextLine();
    }

    @Override
    public Valiente creacionOEleccionValiente() {
        try {
            this.valiente = null;
            int opcion = 0;

            System.out.println(PURPLE + BOLD + "\n╔════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + BOLD + "        ELIGE TU VALIENTE           " + RESET);
            System.out.println(PURPLE + BOLD + "╚════════════════════════════════════╝" + RESET);

            System.out.println(YELLOW + "1 - Valiente Personalizado" + RESET);
            System.out.println(YELLOW + "2 - Valientes Iniciales" + RESET);

            System.out.print(CYAN + "\nElige un Valiente: " + RESET);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println(GREEN + "Creando Valiente personalizado..." + RESET);
                    this.valiente = new Valiente();
                }
                case 2, 3, 4, 5 -> {
                    // Llama a tu método que ya gestiona los 4 valientes y devuelve el elegido
                    this.valiente = new GestorValientes().crearValientesIniciales();
                }
                case 6 -> {
                    System.out.println(RED + "Saliendo del juego..." + RESET);
                    return null;
                }
                default -> {
                    System.out.println(RED + "Esa no es una opción válida." + RESET);
                }
            }

        } catch (InputMismatchException e) {
            System.out.println(RED + "Eso no es un número válido." + RESET);
            teclado.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(RED + "Ese no es un Valiente." + RESET);
        }

        return valiente;
    }

    @Override
    public void mostrarEstadoJuego() {
        System.out.println(BOLD + CYAN + "\n ESTADO DEL JUEGO" + RESET);
        System.out.println(valiente);
        System.out.println("Objetos restantes: " + mapa.getObjetos());
        System.out.println("Monstruos restantes: " + mapa.getMonstruos());
    }

    @Override
    public void mostrarMenuPrincipal() {
        explorarMapa();
    }

    private void mostrarValiente() {
        System.out.println(this.valiente.toString());
    }

    private void equiparObjeto() {
        System.out.println(GREEN + "Mostrando inventario..." + RESET);
        String objeto = teclado.nextLine();
        System.out.println(GREEN + "Usando inventario..." + RESET);
    }

    private void mostrarMapa() {
        for (int i = 0; i < this.mapa.getAlto(); i++) {
            for (int j = 0; j < this.mapa.getAncho(); j++) {
                if (casillasAdyacentes(j, i)) {
                    System.out.print(this.mapa.getCasillas()[i][j]);
                } else {
                    System.out.print("[x]");
                }

            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int coordenada, int direccion) {
        boolean validacion;
        if (coordenada == 1) {
            if (direccion == 1) {
                validacion = posicionX - 1 >= 0;
            } else {
                validacion = posicionX < mapa.getAlto() - 1;
            }
        } else {
            if (direccion == 1) {
                validacion = posicionY < mapa.getAncho() - 1;
            } else {
                validacion = posicionY - 1 >= 0;
            }
        }
        return validacion;
    }

    public boolean casillasAdyacentes(int fila, int columna) {
        return mapa.esVisible(fila, columna)
                || posicionY + 1 == fila && columna == posicionX
                || posicionY - 1 == fila && columna == posicionX
                || fila == posicionY && posicionX + 1 == columna
                || fila == posicionY && posicionX - 1 == columna
                || fila == posicionY && columna == posicionX;
    }

@Override
    public void explorarMapa() {
        String opcion = "";
        do {
            try {
                mostrarMapa();

                System.out.println(BOLD + "───────────────────────────────" + RESET);
                System.out.println(CYAN + "[W/A/S/D] " + RESET + "Moverse | "
                        + YELLOW + "[E] " + RESET + "Estado | "
                        + GREEN + "[I] " + RESET + "Items | "
                        + RED + "[Q] " + RESET + "Salir");
                System.out.print("Comando: ");

                opcion = teclado.next().substring(0, 1).toLowerCase();
                teclado.nextLine();

                switch (opcion) {
                    case "w" -> {
                        if (movimientoValido(1, 1)) {
                            mapa.setCasilla(posicionY, posicionX, "[ ]");
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionX--;
                        } else {
                            System.out.println(RED + "Muro detectado arriba." + RESET);
                        }
                    }
                    case "a" -> {
                        if (movimientoValido(-1, -1)) {
                            mapa.setCasilla(posicionY, posicionX, "[ ]");
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionY--;
                        } else {
                            System.out.println(RED + "Muro detectado a la izquierda." + RESET);
                        }
                    }
                    case "s" -> {
                        if (movimientoValido(1, -1)) {
                            mapa.setCasilla(posicionY, posicionX, "[ ]");
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionX++;
                        } else {
                            System.out.println(RED + "Muro detectado abajo." + RESET);
                        }
                    }
                    case "d" -> {
                        if (movimientoValido(-1, 1)) {
                            mapa.setCasilla(posicionY, posicionX, "[ ]");
                            mapa.setVisible(posicionY, posicionX);
                            posicionY++;
                        } else {
                            System.out.println(RED + "Muro detectado a la derecha." + RESET);
                        }
                    }
                    case "e" ->
                        mostrarEstadoJuego();
                    case "i" ->
                        equiparObjeto();
                    case "q" ->
                        System.out.println(RED + "Saliendo..." + RESET);
                    default ->
                        System.out.println(RED + "Acción no reconocida." + RESET);
                }

                if ("wasd".contains(opcion)) {
                    if (mapa.getCasillas()[posicionX][posicionY].equals("[?]")) {
                        switch (r.nextInt(3)) {
                            case 0 ->
                                System.out.println(GREEN + "Has encontrado una espada." + RESET);
                            case 1 ->
                                System.out.println(GREEN + "Has encontrado un escudo." + RESET);
                            default ->
                                System.out.println(GREEN + "Has encontrado un objeto misterioso..." + RESET);
                        }
                        mapa.setObjetos(mapa.getObjetos() - 1);
                    }
                    if (mapa.getCasillas()[posicionX][posicionY].equals("[!]")) {
                        int nivel = posicionY > posicionX ? posicionY : posicionX;
                        this.c1.iniciarCombate(valiente, gm1.generarMonstruos(nivel));
                        mapa.setMonstruos(mapa.getMonstruos() - 1);
                        enemigosAsesinados++;
                    }
                    if (mapa.getCasillas()[posicionX][posicionY].equals("[0]")) {
                        mapa = new Mapa(true);
                        this.posicionX = 0;
                        this.posicionY = 0;
                    }
                    if (mapa.getCasillas()[posicionX][posicionY].equals("[#]")) {
                        System.out.println(RED + "El aire se torna oscuro... El Compilador Oscuro aparece." + RESET);
                        this.c1.iniciarCombate(valiente, new CompiladorOscuro(enemigosAsesinados));
                        this.victoria = true;
                    }
                    mapa.setCasilla(posicionY, posicionX, "[*]");
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Eso no es un movimiento válido." + RESET);
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println(RED + "Error: " + e.getMessage() + RESET);
            }
        } while (!opcion.equals("q") && !victoria && !muerto);
    }
}
