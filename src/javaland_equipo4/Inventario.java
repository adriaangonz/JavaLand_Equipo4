/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Scanner;
import javaland_interfaces.InventarioInterface;

/**
 *
 * @author diego
 */
public class Inventario implements InventarioInterface {

    Objeto[] inventario = new Objeto[4];

    @Override
    public void agregarObjeto(Objeto obj) {
        boolean guardado = false;
        for (int i = 0; i < inventario.length && !guardado; i++) {
            if (inventario[i] == null) {
                inventario[i] = obj;
                System.out.println("Objeto agregado en el hueco " + i);
                guardado = true;// si se guarda se termina
            }
        }
        if (!guardado) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("inventario lleno has encontrado " + obj.getNombre());
            mostrarInventario();
            System.out.println("que numero de objeto quieres tirar para hacer sitio del 0 al 3 o n para dejarlo");

            String respuesta = teclado.nextLine();

            if (!respuesta.equalsIgnoreCase("n")) {
                try {
                    int indice = Integer.parseInt(respuesta);

                    if (getObjeto(indice) != null) {
                        System.out.println("tirando " + inventario[indice].getNombre());
                        eliminarObjeto(indice);
                        inventario[indice] = obj;
                        System.out.println("objeto guardado con exito");
                    } else {
                        System.out.println("indice no valido el objeto se ha perdido");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("entrada no valida el objeto se queda en el suelo");
                }
            } else {
                System.out.println("has decidido dejar el objeto en el suelo");
            }
        }
    }

    //mtodo para obtener el objeto sin borrarlo
    public Objeto getObjeto(int indice) {
        if (indice >= 0 && indice < inventario.length) {
            return inventario[indice];
        }
        return null;
    }

    //metodo para eliminar el objeto tras equiparlo
    public void eliminarObjeto(int indice) {
        if (indice >= 0 && indice < inventario.length) {
            inventario[indice] = null;
        }
    }

    @Override
    public void usarObjeto(String nombre, Valiente valiente) {
        try {
            Scanner teclado = new Scanner(System.in);
            //convertimos el "nombre" a un entero
            int indice = Integer.parseInt(nombre);

            //validamos que el indice es correcto y no este vacio
            if (indice < 0 || indice >= inventario.length || inventario[indice] == null) {
                System.out.println("Ese hueco esta vacio o no es valido");
                return;
            }

            Objeto nuevo = inventario[indice];

            if (nuevo instanceof Arma) {
                Arma nuevaArma = (Arma) nuevo;
                Arma actual = valiente.getArma();

                //calculamos el daño total para comparar
                int dañoActual = valiente.getFuerza() + (actual != null ? actual.getAtaque() : 0);
                int dañoNuevo = valiente.getFuerza() + nuevaArma.getAtaque();

                System.out.println("\n--- COMPARACION DE DAÑO ---");
                System.out.println("Actual: " + dañoActual + " | Con " + nuevaArma.getNombre() + ": " + dañoNuevo);
                System.out.print("Equipar? (s/n): ");

                if (teclado.nextLine().equalsIgnoreCase("s")) {
                    inventario[indice] = actual; //la vieja vuelve al inventario
                    nuevaArma.equipar(valiente); //el valiente equipa la nueva
                    System.out.println("Arma equipada!");
                }
            } else if (nuevo instanceof Escudo) {
                Escudo nuevoEscudo = (Escudo) nuevo;
                Escudo actual = valiente.getEscudo();

                //calculamos el daño total para comparar
                int escudoActual = valiente.getDefensa() + (actual != null ? actual.getDefensa() : 0);
                int escudoNuevo = valiente.getDefensa() + nuevoEscudo.getDefensa();

                System.out.println("\n--- COMPARACION DE DEFENSA ---");
                System.out.println("Actual: " + escudoActual + " | Con " + nuevoEscudo.getNombre() + ": " + escudoNuevo);
                System.out.print("Equipar? (s/n): ");

                if (teclado.nextLine().equalsIgnoreCase("s")) {
                    inventario[indice] = actual; // Intercambio: la vieja vuelve al inventario
                    nuevoEscudo.equipar(valiente); // La nueva se la pone el valiente
                    System.out.println("Escudo equipado!");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Debes introducir el NUMERO del hueco (0, 1, 2 o 3)");
        }
    }

    @Override
    public void mostrarInventario() {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                System.out.println("[" + i + "] " + inventario[i].getNombre() + " (" + inventario[i].getTipo() + ")");
            } else {
                System.out.println("Inventario vacio");
            }
        }
    }
}
