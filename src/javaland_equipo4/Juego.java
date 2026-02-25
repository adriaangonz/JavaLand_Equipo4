/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javaland_interfaces.GestoresInterface;
import javaland_interfaces.JuegoInterface;
import javaland_interfaces.MapaInterface;

/**
 *
 * @author cococ
 */
public class Juego implements JuegoInterface {

    private Mapa mapa;

    private static int enemigosAsesinados;
    private GestorMonstruos gm1;
    private GestorValientes gv1;
    private Combate c1;
    private Valiente valiente;
    private static int posicionX;
    private static int posicionY;
    private final Random r = new Random();
    boolean muerto;
    boolean victoria;

    @Override
    public void iniciarJuego() {
        System.out.println("EL COMPILADOR OSCURO");
        this.posicionX = 0;
        this.posicionY = 0;
        this.victoria = false;
        this.muerto = false;
        this.valiente = creacionOEleccionValiente();
        if (valiente != null) {
            this.mapa = new Mapa(false);
            mostrarMenuPrincipal();
            if (this.victoria) {
                System.out.println("Enhorabuena!");
            }
            if (this.muerto) {
                System.out.println("La proxima vez sera...");
            }

        }

    }

    @Override
    public Valiente creacionOEleccionValiente() {
        try (Scanner teclado = new Scanner(System.in);) {
            this.valiente = null;
            int opcion = 0;
            System.out.println("1 - Crear Valiente");
            System.out.println("2 - Usar valientes Iniciales");
            System.out.println("3 - Salir");
            System.out.print("Elige una opcion:");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1 ->
                    this.valiente = new Valiente();
                case 2 -> this.valiente=gv1.crearValientesIniciales();
                default -> {
                    System.out.println("eso no es una opcion");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Eso no es un numero");
        }

        return valiente;

    }

    @Override
    public void mostrarEstadoJuego() {
        System.out.println(valiente);
        System.out.println("Objetos restantes: " + mapa.getObjetos());
        System.out.println("Monstruos restantes: " + mapa.getMonstruos());

    }

    @Override
    public void mostrarMenuPrincipal() {

        try (Scanner teclado = new Scanner(System.in);) {

            int opcion = 0;
            do {
                System.out.println("1 - Mostrar Valiente");
                System.out.println("2 - Equipar Objeto");
                System.out.println("3 - Mostrar mapa");
                System.out.println("4 - Moverse");
                System.out.println("5 - Mostrar estado del juego");
                System.out.println("6 - Salir del juego");
                System.out.print("Elige una opcion:");
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println(valiente.toString());
                    }
                    case 2 -> {
                        System.out.println("equipando objeto");
                    }
                    case 3 ->
                        mostrarMapa();
                    case 4 ->
                        explorarMapa();
                    case 5 ->
                        mostrarEstadoJuego();
                    default -> {
                        System.out.println("eso no es una opcion");
                    }
                }
            } while (opcion != 6 && !victoria && !muerto);
        } catch (InputMismatchException e) {
            System.out.println("Eso no es un numero");
        }

    }

    private void mostrarValiente() {
        System.out.println(this.valiente.toString());
    }

    private void equiparObjeto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("mostrando inventario");
        String objeto = teclado.nextLine();
        System.out.println("usando inventario");
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

//    public boolean movimientoValido(int coordenada, int direccion) {
//        boolean validacion;
//        if (coordenada == 1) {
//            //Y-1
//            if (direccion == 1) {
//                validacion = posicionX - 1 >= 0;
//            } //Y+1
//            else {
//                validacion = posicionX < mapa.getAlto() - 1;
//            }
//        } else {
//            //X+1
//            if (direccion == 1) {
//                validacion = posicionY < mapa.getAncho() - 1;
//
//            } //X-1
//            else {
//                validacion = posicionY - 1 >= 0;
//            }
//        }
//        return validacion;
//    }
    public boolean casillasAdyacentes(int fila, int columna) {
        return mapa.esVisible(fila, columna) || posicionY + 1 == fila && columna == posicionX || posicionY - 1 == fila && columna == posicionX || fila == posicionY && posicionX + 1 == columna || fila == posicionY && posicionX - 1 == columna || fila == posicionY && columna == posicionX;
    }

    @Override
    public void explorarMapa() {
        try (Scanner teclado = new Scanner(System.in);) {
            mostrarMapa();
            String opcion = "";
            System.out.println("¿Hacia que direccion quieres moverte?: W/A/S/D");
            opcion = teclado.next().substring(0, 1);
            switch (opcion.toLowerCase()) {
                case "w" -> {
                    mapa.setCasilla(posicionY, posicionX, "[ ]");
                    mapa.setVisible(posicionY, posicionX);
                    this.posicionX--;
                }

                case "a" -> {

                    mapa.setCasilla(posicionY, posicionX, "[ ]");
                    mapa.setVisible(posicionY, posicionX);
                    this.posicionY--;
                }

                case "s" -> {
                    mapa.setCasilla(posicionY, posicionX, "[ ]");
                    mapa.setVisible(posicionY, posicionX);
                    this.posicionX++;
                }

                case "d" -> {
                    mapa.setCasilla(posicionY, posicionX, "[ ]");
                    mapa.setVisible(posicionY, posicionX);
                    posicionY++;
                }

                default -> {
                    System.out.println("eso no es una opcion");
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Eso se puede mover");
        }

        if (mapa.getCasillas()[posicionX][posicionY].equals("[?]")) {
            switch (r.nextInt(3)) {
                case 0 -> {
                    System.out.println("has encontrado una espada");
                }

                case 1 -> {
                    System.out.println("has encontrado un esucudo");
                }
                default -> {
                    System.out.println("has encontrado marihuana");
                }
            }
            mapa.setObjetos(mapa.getObjetos() - 1);

        }
        if (mapa.getCasillas()[posicionX][posicionY].equals("[!]")) {
            int nivel = posicionY < posicionX ? posicionY : posicionX;
            this.c1.iniciarCombate(valiente, new Monstruo(nivel));
            mapa.setMonstruos(mapa.getMonstruos() - 1);
            enemigosAsesinados++;

        }
        if (mapa.getCasillas()[posicionX][posicionY].equals("[0]")) {
            mapa = new Mapa(true);
            this.posicionX = 0;
            this.posicionY = 0;

        }
        if (mapa.getCasillas()[posicionX][posicionY].equals("[#]")) {
            System.out.println("Generando al compilador oscuro");
            System.out.println("iniciando pelea...");
            System.out.println("has ganado");
            this.victoria = true;

        }
        mapa.setCasilla(posicionY, posicionX, "[*]");

        mostrarMapa();

    }
}
