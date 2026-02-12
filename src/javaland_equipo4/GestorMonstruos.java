/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

/**
 *
 * @author DAM124
 */
public class GestorMonstruos {

    private static int contadorMonstruos = 0;

    public Monstruo generarMonstruos(int nivel) {
        Monstruo m = null;
        if (contadorMonstruos > 10) {
            System.out.println("Máximo de monstruos generados");
        } else {
            contadorMonstruos++;

            m = new Monstruo(nivel);
        }
        return m;
    }

    public void eliminarMonstruos(Monstruo m) {
        System.out.println("Monstruo eliminado");
    }

    public static int getContadorMonstruos() {
        return contadorMonstruos;
    }
}
