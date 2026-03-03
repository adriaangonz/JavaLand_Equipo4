package javaland_equipo4;

import java.util.Scanner;
import javaland_interfaces.InventarioInterface;

/**
 *
 * @author diego
 */
public class Inventario implements InventarioInterface {

    public Inventario() {

    }

    // Colores
    String CYAN = "\u001B[36m";
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";
    String BOLD = "\u001B[1m";
    String PURPLE = "\u001B[35m";

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
        System.out.println("\n" + CYAN + BOLD + "╔══════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       RECURSOS DEL SISTEMA (INVENTARIO)                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝" + RESET);

        boolean vacio = true;

        System.out.printf(YELLOW + "%-7s %-22s %-12s %-10s %-20s\n" + RESET, "SLOT", "NOMBRE", "TIPO", "VALOR", "PASIVA");
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                vacio = false;
                Objeto obj = inventario[i];
                String statInfo = "";
                String pasivaInfo = "Ninguna";
                String colorFila = GREEN;

                if (obj instanceof Arma) {
                    statInfo = "ATK: " + ((Arma) obj).getAtaque();
                    pasivaInfo = traducirPasiva(obj.getIdPasiva());
                    colorFila = RED; // Las armas en rojo
                } else if (obj instanceof Escudo) {
                    statInfo = "DEF: " + ((Escudo) obj).getDefensa();
                    pasivaInfo = traducirPasiva(obj.getIdPasiva());
                    colorFila = CYAN; // Escudos en cyan
                } else if (obj instanceof Planta) {
                    statInfo = "HP: +" + ((Planta) obj).getRecupera();
                    colorFila = GREEN; // Plantas en verde
                }

                // 2. Imprimir la fila con la información detallada
                System.out.printf(colorFila + "[%02d]" + RESET + " %-22s %-12s %-10s " + PURPLE + "%-20s\n" + RESET,
                        i,
                        obj.getNombre(),
                        obj.getTipo(),
                        statInfo,
                        pasivaInfo);
            } else {
                System.out.printf(RESET + "[%02d]" + " %-22s %-12s %-10s %-20s\n",
                        i, "--- NULL_POINTER ---", "---", "---", "---");
            }
        }

        if (vacio) {
            System.out.println(RED + "\n[!] Advertencia: Stack de memoria vacío." + RESET);
        }
        System.out.println(CYAN + "--------------------------------------------------------------------------------------" + RESET);
    }

    /**
     * Método auxiliar para que el usuario entienda qué hace cada ID de pasiva
     */
    private String traducirPasiva(int id) {
        return switch (id) {
            case 1 ->
                "Vampirismo";
            case 2 ->
                "Crítico (30%)";
            case 3 ->
                "Atk. Progresivo";
            case 4 ->
                "Espinas";
            case 5 ->
                "Restos (Cura)";
            case 6 ->
                "Mitigación (1/2)";
            default ->
                "Ninguna";
        };
    }
}