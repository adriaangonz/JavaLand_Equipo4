/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

/**
 * Clase encargada de la gestión, creación y eliminación de los monstruos en el juego.
 * @author Marcos
 */
import javaland_interfaces.GestoresInterface;

public class GestorMonstruos implements GestoresInterface {

    private static int contadorMonstruos = 0;
    
    /**
     * Genera un nuevo monstruo basado en el nivel proporcionado, siempre que no se supere el límite de 10.
     * @author Marcos
     * @param nivel Nivel estadístico que tendrá el monstruo generado.
     * @return Una instancia de Monstruo o null si se ha alcanzado el máximo permitido.
     */
    @Override
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
    
    /**
     * Procesa la eliminación de un monstruo, calcula la experiencia otorgada y la suma al valiente.
     * @author Marcos
     * @param m El monstruo que ha sido derrotado.
     * @param v El valiente que recibe los puntos de experiencia.
     */
    @Override
    public void eliminarMonstruos(Monstruo m, Valiente v) {

        System.out.println("Monstruo eliminado");
        int dropExperiencia = m.getNivel() * 25;
        System.out.println("El Valiente ha ganado, recibe " + dropExperiencia + " exp");
        v.setExperiencia(v.getExperiencia() + dropExperiencia);
    }

    /**
     * Obtiene la cantidad total de monstruos generados hasta el momento.
     * @author Marcos
     * @return El valor actual del contador de monstruos.
     */
    public static int getContadorMonstruos() {
        return contadorMonstruos;
    }

    /**
     * Método de la interfaz no implementado en esta clase.
     * @author Marcos
     * @return null ya que esta clase no gestiona valientes.
     */
    @Override
    public Valiente crearValientesIniciales() {
        return null;
    }

}