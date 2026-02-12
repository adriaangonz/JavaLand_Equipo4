
package javaland_equipo4;

/**
 *
 * @author DAM106
 */

import javaland_interfaces.GestoresInterface;

public class GestorValientes implements GestoresInterface {

    private Valiente[] valientes; // Array de valientes

    public GestorValientes() {
        valientes = new Valiente[4]; // Espacio para los 4 valientes iniciales
    }


    @Override
    public void crearValientesIniciales() {
        valientes[0] = new Valiente("Guerrero", 100, 15, 8, 7, 10, 1, 0);
        valientes[1] = new Valiente("Paladín", 100, 10, 14, 6, 10, 1, 0);
        valientes[2] = new Valiente("Mago", 100, 8, 6, 16, 10, 1, 0);
        valientes[3] = new Valiente("Pícaro", 100, 9, 7, 8, 16, 1, 0);
    }

    @Override
    public Monstruo generarMonstruos(int nivel) {
        return null;
    }

    @Override
    public void eliminarMonstruos(Monstruo m) {

    }


    public void mostrarValientes() {
        System.out.println("\nValientes disponibles");
        for (int i = 0; i < valientes.length; i++) {
            Valiente v = valientes[i];
            System.out.println((i + 1) + ". " + v.getNombre() +
                    " (Nivel " + v.getNivel() + ")" +
                    " - Vida: " + v.getVida() +
                    ", Fuerza: " + v.getFuerza() +
                    ", Defensa: " + v.getDefensa() +
                    ", Habilidad: " + v.getHabilidad() +
                    ", Velocidad: " + v.getVelocidad());
        }
    }

}

