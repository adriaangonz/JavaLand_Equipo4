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

    /**
     *
     * @param obj Metodo que agrega objetos
     */
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

    /**
     *
     * @param indice
     * @return Objeto del indice si esta vacio Metodo que devuelve el objeto del
     * inventario por id
     */
    public Objeto getObjeto(int indice) {
        if (indice >= 0 && indice < inventario.length) {
            return inventario[indice];
        }
        return null;
    }

    /**
     *
     * @param indice Metodo que elimina un objeto por id
     */
    public void eliminarObjeto(int indice) {
        if (indice >= 0 && indice < inventario.length) {
            inventario[indice] = null;
        }
    }

    /**
     *
     * @param opcion
     * @param valiente Metodo que permite usar un objeto en el valiente actual
     */
    @Override
    public void usarObjeto(String opcion, Valiente valiente) {
        try {
            Scanner teclado = new Scanner(System.in);
            int indice = Integer.parseInt(opcion);

            // Validaciones
            if (indice < 0 || indice >= inventario.length || inventario[indice] == null) {
                System.out.println(RED + "Ese hueco está vacío o no es válido." + RESET);
                return;
            }

            Objeto nuevo = inventario[indice];
            String pasivaNombre = traducirPasiva(nuevo.getIdPasiva());

            // --- LÓGICA PARA ARMAS ---
            if (nuevo instanceof Arma armaNueva) {
                Arma actual = valiente.getArma();

                // Comparación corregida para mostrar el daño real sin acumular
                int dañoActual = valiente.getFuerza();
                int dañoNuevo = (actual != null)
                        ? (valiente.getFuerza() - actual.getAtaque()) + armaNueva.getAtaque()
                        : valiente.getFuerza() + armaNueva.getAtaque();

                System.out.println("\n--- COMPARACIÓN DE DAÑO ---");
                System.out.println("Actual: " + dañoActual + " | Con " + armaNueva.getNombre() + ": " + dañoNuevo);
                System.out.println("Pasiva: " + PURPLE + pasivaNombre + RESET);
                System.out.print("¿Equipar? (s/n): ");

                if (teclado.nextLine().equalsIgnoreCase("s")) {
                    // La vieja (o null) vuelve al inventario
                    if (valiente.getArma() != null) {
                        valiente.setFuerza(valiente.getFuerza() - valiente.getArma().getAtaque());
                    }
                    inventario[indice] = actual;
                    armaNueva.equipar(valiente); // El valiente se pone la nueva
                    valiente.setFuerza(valiente.getFuerza() + armaNueva.getAtaque());
                    System.out.println(GREEN + "¡Arma equipada!" + RESET);
                }

                // LÓGICA PARA ESCUDOS
            } else if (nuevo instanceof Escudo escudoNuevo) {
                Escudo actual = valiente.getEscudo();

                // Comparación corregida para mostrar la defensa real
                int defActual = valiente.getDefensa();
                int defNueva = (actual != null)
                        ? (valiente.getDefensa() - actual.getDefensa()) + escudoNuevo.getDefensa()
                        : valiente.getDefensa() + escudoNuevo.getDefensa();

                System.out.println("\n--- COMPARACIÓN DE DEFENSA ---");
                System.out.println("Actual: " + defActual + " | Con " + escudoNuevo.getNombre() + ": " + defNueva);
                System.out.println("Pasiva: " + PURPLE + pasivaNombre + RESET);
                System.out.print("¿Equipar? (s/n): ");

                if (teclado.nextLine().equalsIgnoreCase("s")) {
                    if (actual != null) {
                        valiente.setDefensa(valiente.getDefensa() - actual.getDefensa());
                    }
                    inventario[indice] = actual; // Intercambio
                    escudoNuevo.equipar(valiente);
                    valiente.setDefensa(valiente.getDefensa() + escudoNuevo.getDefensa());
                    System.out.println(GREEN + "¡Escudo equipado!" + RESET);
                }

                // --- LÓGICA PARA PLANTAS (Curación y Borrado) ---
            } else if (nuevo instanceof Planta planta) {
                System.out.println("\nHas encontrado una " + planta.getNombre());
                System.out.println("Efecto: Recupera " + planta.getRecupera() + " HP");
                System.out.print("¿Usar ahora? (s/n): ");

                if (teclado.nextLine().equalsIgnoreCase("s")) {
                    planta.equipar(valiente); // Sube la vida
                    inventario[indice] = null; // SE BORRA del inventario
                    System.out.println(GREEN + "¡HP recuperada! La planta se ha consumido." + RESET);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println(RED + "Debes introducir el NÚMERO del hueco (0, 1, 2 o 3)" + RESET);
        }
    }

    /**
     * Metodo que muestra el inventario
     */
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
