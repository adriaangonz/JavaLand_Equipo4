package javaland_equipo4;

import java.util.InputMismatchException;
import java.util.Scanner;
import javaland_interfaces.GestoresInterface;

/**
 * Clase que gestiona la creación y selección de los personajes tipo Valiente.
 * @author Saul
 */
public class GestorValientes implements GestoresInterface {

    private Valiente[] valientes; // Array de valientes
    
    /**
     * Constructor que inicia el array con un tamaño de 4 para los héroes iniciales.
     * @author Saul
     */
    public GestorValientes() {
        valientes = new Valiente[4]; // Espacio para los 4 valientes iniciales
    }
    
    /**
     * Instancia los personajes predefinidos y solicita al usuario elegir uno.
     * @author Saul
     * @return El objeto Valiente seleccionado por el usuario.
     * @throws ArrayIndexOutOfBoundsException Si el índice de selección no es válido.
     */
    @Override
    public Valiente crearValientesIniciales() throws ArrayIndexOutOfBoundsException {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        valientes[0] = new Valiente("Guerrero", 100, 15, 8, 7, 10, 1);
        valientes[1] = new Valiente("Paladín", 100, 10, 14, 6, 10, 1);
        valientes[2] = new Valiente("Mago", 100, 8, 6, 16, 10, 1);
        valientes[3] = new Valiente("Pícaro", 100, 9, 7, 8, 16, 1);
            
        System.out.println("1 - "+new Valiente("Guerrero", 100, 15, 8, 7, 10, 1).toString());
        System.out.println("2 - "+new Valiente("Paladín", 100, 10, 14, 6, 10, 1).toString());
        System.out.println("3 - "+new Valiente("Mago", 100, 8, 6, 16, 10, 1).toString());
        System.out.println("4 - "+new Valiente("Pícaro", 100, 9, 7, 8, 16, 1).toString());
        System.out.print("Elige un Valiente: ");
        opcion = teclado.nextInt();
            
        return valientes[opcion-1];
    }
    
    /**
     * Método de la interfaz no implementado en este gestor.
     * @author Saul
     * @param nivel Nivel del monstruo.
     * @return null ya que no genera monstruos.
     */
    @Override
    public Monstruo generarMonstruos(int nivel) {
        return null;
    }

    /**
     * Método de la interfaz no implementado en este gestor.
     * @author Saul
     * @param m Monstruo.
     * @param v Valiente.
     */
    @Override
    public void eliminarMonstruos(Monstruo m , Valiente v) {
        
    }
    
    /**
     * Muestra por pantalla la lista detallada de los valientes disponibles y sus estadísticas.
     * @author Saul
     */
    public void mostrarValientes() {
        System.out.println("\nValientes disponibles");
        for (int i = 0; i < valientes.length; i++) {
            Valiente v = valientes[i];
            if (v != null) {
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

}