/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Random;
import java.util.Scanner;
import javaland_interfaces.MapaInterface;

/**
 *
 * @author cococ
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

    // Colores 
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";
    
    public Mapa() {
        System.out.println("Introduce el alto del mapa");
        int alto = teclado.nextInt();
        System.out.println("Introduce el ancho del mapa");
        int ancho = teclado.nextInt();
        this.casillas = new String[alto][ancho];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                
                System.out.println("[ ]");
                
            }
        }
        this.casillas[0][0] = YELLOW + "[*]" + RESET;
    }
    /**
     * 
     * @param nether es el nether
     * Constructor de mapa
     */
    public Mapa(boolean nether) {
        this.nether=nether;
        if (!nether) {
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
                    if (random == 1 && objetos > 0) {
                        this.casillas[i][j] = GREEN + "[?]" + RESET;
                        objetosRestantes--;

                    } else if (random == 2 && monstruos > 0) {
                        this.casillas[i][j] = RED + "[!]" + RESET;
                        monstruosRestantes--;
                    }else if (random == 3) {
                        this.casillas[i][j] = RED + "[/]" + RESET;
                        monstruosRestantes--;
                    }
                    else if (random == 4) {
                        this.casillas[i][j] = GREEN + "[♣]" + RESET;
                        monstruosRestantes--;
                    }else if (random == 5) {
                        this.casillas[i][j] = BOLD + "[●]" + RESET;
                        monstruosRestantes--;
                    }else if (random == 6) {
                        this.casillas[i][j] = CYAN + "[≈]" + RESET;
                        monstruosRestantes--;
                    }
                    else {
                        this.casillas[i][j] = "[ ]";
                    }
                }
            }
            this.casillas[0][0] = YELLOW + "[*]" + RESET;
            this.casillas[alto - 1][ancho - 1] = CYAN + "[0]" + RESET;
        } else {
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
                    if (random == 1 && objetos > 0) {
                        this.casillas[i][j] = GREEN + "[?]" + RESET;
                        objetosRestantes--;

                    } else if (random == 2 && monstruos > 0) {
                        this.casillas[i][j] = RED + "[!]" + RESET;
                        monstruos--;
                    }else if (random == 3) {
                        this.casillas[i][j] = RED + "[/]" + RESET;
                        monstruosRestantes--;
                    }
                    else if (random == 4) {
                        this.casillas[i][j] = GREEN + "[♣]" + RESET;
                        monstruosRestantes--;
                    }else if (random == 5) {
                        this.casillas[i][j] = BOLD + "[●]" + RESET;
                        monstruosRestantes--;
                    } 
                    else {
                        this.casillas[i][j] =RED +  "[ ]" +  RESET;
                    }
                }
            }
            this.casillas[0][0] = YELLOW + "[*]" + RESET;
            this.casillas[alto - 1][ancho - 1] = PURPLE + "[#]" + RESET;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setMonstruos(int monstruos) {
        this.monstruos = monstruos;
    }

    public void setObjetos(int objetos) {
        this.objetos = objetos;
    }

    public int getMonstruos() {
        return monstruos;
    }

    public int getObjetos() {
        return objetos;
    }

    public String[][] getCasillas() {
        return casillas;
    }
    /**
     * 
     * @param fila fila del array
     * @param columna columna del array
     * @param casilla la casilla importada
     * Meotodo que cambia una casilla
     */
    public void setCasilla(int fila, int columna, String casilla) {

        this.casillas[columna][fila] = casilla;
    }
    
    /**
     * 
     * @param fila fila del array
     * @param columna columna del array
     * Meotodo que hace visible una casilla
     */
    public void setVisible(int fila, int columna) {
        this.visible[columna][fila] = true;
    }
    
    /**
     * 
     * @param columna columna del array
     * @param fila fila del array
     * @return Si es visible
     * Meotodo que devuelve si la casilla es visible
     */
    public boolean esVisible(int columna, int fila) {
        return this.visible[fila][columna];
    }
    /**
     * 
     * @return Si estas en el nether
     * Metodo que devuelve si estas en el nether
     */
    public boolean isNether() {
        return nether;
    }
    

}
