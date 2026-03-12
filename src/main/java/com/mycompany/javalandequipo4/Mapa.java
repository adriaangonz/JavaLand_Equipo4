/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javalandequipo4;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que gestiona la lógica de generación, representación y eventos del mapa.
 * @author ciro
 */
public class Mapa {

    private final Random r = new Random();
    Scanner teclado = new Scanner(System.in);
    private String[][] casillas;
    private int ancho;
    private int alto;
    private boolean[][] visible;
    private int monstruos;
    private int objetos;
    private boolean nether;

    // Colores ANSI
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";

    /**
     * Constructor por defecto. Solicita dimensiones y crea un mapa básico vacío.
     * @author ciro
     */
    public Mapa() {
        System.out.println("Introduce el alto del mapa");
        int altoIn = teclado.nextInt();
        System.out.println("Introduce el ancho del mapa");
        int anchoIn = teclado.nextInt();
        this.alto = altoIn;
        this.ancho = anchoIn;
        this.casillas = new String[alto][ancho];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                this.casillas[i][j] = "[ ]";
            }
        }
        this.casillas[0][0] = YELLOW + "[*]" + RESET;
    }

    /**
     * Constructor que genera el mapa con obstáculos, monstruos y objetos según la dimensión.
     * @author ciro
     * @param nether Determina si se genera el ambiente del Nether (true) o el Mundo Normal (false).
     */
    public Mapa(boolean nether) {
        this.nether = nether;
        this.monstruos = 5;
        this.objetos = 5;
        int monstruosRestantes = this.monstruos;
        int objetosRestantes = this.objetos;
        this.ancho = 10;
        this.alto = 10;
        this.casillas = new String[alto][ancho];
        this.visible = new boolean[alto][ancho];

        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                int random = r.nextInt(20) + 1;
                
                if (random == 1 && objetosRestantes > 0) {
                    this.casillas[i][j] = GREEN + "[?]" + RESET;
                    objetosRestantes--;
                } else if (random == 2 && monstruosRestantes > 0) {
                    this.casillas[i][j] = RED + "[!]" + RESET;
                    monstruosRestantes--;
                } else if (random == 3) {
                    this.casillas[i][j] = RED + "[/]" + RESET;
                } else if (random == 4) {
                    this.casillas[i][j] = GREEN + "[♣]" + RESET;
                } else if (random == 5) {
                    this.casillas[i][j] = BOLD + "[●]" + RESET;
                } else if (random == 6 && !nether) {
                    this.casillas[i][j] = CYAN + "[≈]" + RESET;
                } else {
                    this.casillas[i][j] = nether ? RED + "[ ]" + RESET : "[ ]";
                }
            }
        }
        this.casillas[0][0] = YELLOW + "[*]" + RESET;
        if (!nether) {
            this.casillas[alto - 1][ancho - 1] = CYAN + "[0]" + RESET;
        } else {
            this.casillas[alto - 1][ancho - 1] = PURPLE + "[#]" + RESET;
        }
    }

    /**
     * Obtiene el ancho del mapa.
     * @author ciro
     * @return int con el número de columnas.
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Obtiene el alto del mapa.
     * @author ciro
     * @return int con el número de filas.
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Establece la cantidad de monstruos vivos en el mapa.
     * @author ciro
     * @param monstruos Entero con la nueva cantidad de monstruos.
     */
    public void setMonstruos(int monstruos) {
        this.monstruos = monstruos;
    }

    /**
     * Establece la cantidad de objetos disponibles en el mapa.
     * @author ciro
     * @param objetos Entero con la nueva cantidad de objetos.
     */
    public void setObjetos(int objetos) {
        this.objetos = objetos;
    }

    /**
     * Obtiene el número de monstruos actuales.
     * @author ciro
     * @return int con el conteo de monstruos.
     */
    public int getMonstruos() {
        return monstruos;
    }

    /**
     * Obtiene el número de objetos actuales.
     * @author ciro
     * @return int con el conteo de objetos.
     */
    public int getObjetos() {
        return objetos;
    }

    /**
     * Devuelve la matriz bidimensional de casillas.
     * @author ciro
     * @return String[][] con la representación visual del mapa.
     */
    public String[][] getCasillas() {
        return casillas;
    }

    /**
     * Actualiza el contenido visual de una casilla específica.
     * @author ciro
     * @param fila Coordenada X (columna) en la lógica del juego.
     * @param columna Coordenada Y (fila) en la lógica del juego.
     * @param casilla String con el nuevo icono/color de la casilla.
     */
    public void setCasilla(int fila, int columna, String casilla) {
        this.casillas[columna][fila] = casilla;
    }

    /**
     * Revela una casilla para que sea visible de forma permanente.
     * @author ciro
     * @param fila Coordenada X (columna).
     * @param columna Coordenada Y (fila).
     */
    public void setVisible(int fila, int columna) {
        this.visible[columna][fila] = true;
    }

    /**
     * Verifica si una casilla ya ha sido descubierta por el jugador.
     * @author ciro
     * @param columna Coordenada Y (fila).
     * @param fila Coordenada X (columna).
     * @return boolean true si es visible, false si está oculta.
     */
    public boolean esVisible(int columna, int fila) {
        return this.visible[fila][columna];
    }

    /**
     * Comprueba si el mapa actual es de tipo Nether.
     * @author ciro
     * @return boolean true si es Nether, false si es mundo normal.
     */
    public boolean isNether() {
        return nether;
    }
}