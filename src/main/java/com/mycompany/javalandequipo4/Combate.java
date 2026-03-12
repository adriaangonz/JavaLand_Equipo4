
package com.mycompany.javalandequipo4;

import com.mycompany.javalandequipo4_interfaces.CombateInterface;
import java.util.Scanner;

/**
 * Clase que gestiona la lógica de los enfrentamientos entre Valientes y Monstruos.
 * @author Adrian (Pasivas por Saul)
 */
public class Combate implements CombateInterface {

    // Colores para los mensajes de pasivas
    String RESET = "\u001B[0m";
    String YELLOW = "\u001B[33m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String PURPLE = "\u001B[35m";
    String CYAN = "\u001B[36m";

    private final GestorMonstruos gestor = new GestorMonstruos();
    
    /**
     * Método que inicia el combate contra un monstruo y gestiona el bucle de turnos e iniciativa.
     * @author Adrian
     * @param valiente El personaje del jugador.
     * @param monstruo El enemigo a enfrentar.
     * @return true si el valiente sobrevive al combate, false si muere.
     */
    @Override
    public boolean iniciarCombate(Valiente valiente, Monstruo monstruo) {
        do {

            aplicarPasivasInicioTurno(valiente, monstruo);
            double Iniciativa_Valiente = valiente.getVelocidad() * (0.75 + Math.random() * 0.25);
            double Iniciativa_Monstruo = monstruo.getVelocidad() * (0.75 + Math.random() * 0.25);

            if (Iniciativa_Valiente >= Iniciativa_Monstruo) { //si la iniciativa de valiente es mayor o igual a la del monstruo, valiente ataca
                turno(valiente, monstruo);
                if (monstruo.getVida() > 0) {
                    turno(monstruo, valiente); //si el monstruo sigue vivo, contraataca
                }
            } else { //en caso contrario, el monstruo ataca primero
                turno(monstruo, valiente);
                if (valiente.getVida() > 0) {
                    turno(valiente, monstruo); //si el valiente sigue vivo, contraataca
                }
            }
        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);
        return combateTerminado(valiente, monstruo);//si sale del bucle, se acaba el combate
    }
    
    /**
     * Aplica los efectos de pasivas que ocurren al inicio de cada turno.
     * @author Saul
     * @param v El valiente que posee el equipamiento.
     * @param m El monstruo enfrentado.
     */
    private void aplicarPasivasInicioTurno(Valiente v, Monstruo m) {
        if (v.getEscudo() != null && v.getEscudo().getIdPasiva() == 5) {
            int cura = 5 + (v.getNivel() * 2);
            v.setVida(v.getVida() + cura);
            System.out.println(GREEN + "✦ [PASIVA: RESTOS] La armadura repara tus circuitos. +" + cura + " HP" + RESET);
        }
    }

    /**
     * Gestiona el turno de un personaje, permitiendo elegir acciones si es un Valiente o atacando automáticamente si es un Monstruo.
     * @author Adrian
     * @param <T> Tipo genérico para los personajes en combate.
     * @param atacante El personaje que realiza la acción este turno.
     * @param defensor El personaje que recibe la acción.
     */
    @Override
    public <T> void turno(T atacante, T defensor) {
        Scanner teclado = new Scanner(System.in);
        Personaje Atacante = (Personaje) atacante;
        Personaje Defensor = (Personaje) defensor;

        if (Atacante instanceof Valiente v) {
            Monstruo m = (Monstruo) Defensor;
            boolean turnoFinalizado = false;

            while (!turnoFinalizado) {
                // PANEL DE ESTADO VISUAL
                System.out.println("\n" + PURPLE + "----------------------------------------------------------" + RESET);
                System.out.println(String.format("  " + GREEN + "%-20s" + RESET + " vs " + RED + "%25s",
                        v.getNombre() + " (LVL " + v.getNivel() + ")", m.getNombre()));
                System.out.println(String.format("  HP: " + GREEN + "%-18d" + RESET + " | HP: " + RED + "%22d",
                        v.getVida(), m.getVida()));
                System.out.println(PURPLE + "----------------------------------------------------------" + RESET);

                System.out.println(CYAN + " ACCIONES DE COMBATE:" + RESET);
                System.out.println("  1. ATACAR");
                System.out.println("  2. USAR OBJETO");
                System.out.println("  3. HABILIDAD ESPECIAL");
                System.out.print(CYAN + " Seleccion: " + RESET);

                String opcion = teclado.nextLine();

                switch (opcion) {
                    case "1" -> {
                        ejecutarAtaque(v, m);
                        turnoFinalizado = true;
                    }
                    case "2" -> {
                        v.getInventario().mostrarInventario();
                        System.out.print("Elige hueco (0-3) o 'n' para volver: ");
                        String indice = teclado.nextLine();
                        if (!indice.equalsIgnoreCase("n")) {
                            v.getInventario().usarObjeto(indice, v);
                            System.out.println(YELLOW + "Equipo actualizado." + RESET);
                        }
                    }
                    case "3" -> {
                        String valienteNombre = v.getNombre().toLowerCase();
                        boolean puedeUsarHabilidad = true;

                        //comprobacion para que no muera al usar la habilidad
                        if (valienteNombre.contains("guerrero") && v.getArma() == null) {
                            System.out.println(RED + "No tienes un arma equipada para realizar este sacrificio." + RESET);
                            puedeUsarHabilidad = false;
                        } else if (valienteNombre.contains("paladin") && v.getVida() <= 20) {
                            System.out.println(RED + "¡VIDA INSUFICIENTE! El sacrificio te mataría." + RESET);
                            puedeUsarHabilidad = false;
                        } else if (valienteNombre.contains("mago") && v.getVida() <= 25) {
                            System.out.println(RED + "¡VIDA INSUFICIENTE! Necesitas al menos 26 HP." + RESET);
                            puedeUsarHabilidad = false;
                        } else if (valienteNombre.contains("picaro") && v.getVida() <= 15) {
                            System.out.println(RED + "¡VIDA INSUFICIENTE! Necesitas al menos 16 HP." + RESET);
                            puedeUsarHabilidad = false;
                        } else if (!valienteNombre.contains("guerrero") && !valienteNombre.contains("paladin") && !valienteNombre.contains("mago") && !valienteNombre.contains("picaro") && v.getVida() <= 10) {
                            System.out.println(RED + "¡VIDA INSUFICIENTE! Estás demasiado débil." + RESET);
                            puedeUsarHabilidad = false;
                        }

                        //si puede lo hace
                        if (puedeUsarHabilidad) {
                            v.usarHabilidadEspecial(m);
                            turnoFinalizado = true;
                        }
                    }
                    default ->
                        System.out.println(RED + "Opcion no valida." + RESET);
                }
            }
        } else {
            // TURNO DEL MONSTRUO
            ejecutarAtaque(Atacante, Defensor);
        }
    }

    /**
     * Calcula y ejecuta un ataque físico, aplicando probabilidades de acierto y pasivas de daño/defensa.
     * @author Adrian (Pasivas por Saul)
     * @param <T> Tipo genérico de los personajes.
     * @param atacante Personaje que golpea.
     * @param defensor Personaje que intenta esquivar o mitigar.
     */
    private <T> void ejecutarAtaque(T atacante, T defensor) {
        Personaje Atacante = (Personaje) atacante;
        Personaje Defensor = (Personaje) defensor;

        int valorEscudo = 0;
        boolean escudoAdminActivo = false;

        if (Defensor instanceof Valiente Def) {
            if (Def.getEscudo() != null) {
                valorEscudo = Def.getEscudo().getValor();
                if (Def.getEscudo().getIdPasiva() == 6) {
                    escudoAdminActivo = true;
                }
            }
        }

        
        if (defensor instanceof Valiente && ((Valiente) defensor).getEscudo() != null) {
            valorEscudo = ((Valiente) defensor).getEscudo().getDefensa();
        }

        String color = (Atacante instanceof Valiente) ? GREEN : RED;
        System.out.println("\n" + color + ">>> " + Atacante.getNombre().toUpperCase() + " INICIA EL ATAQUE" + RESET);

        int Variable_aleatoria = (int) (Math.random() * 101);

        if (Variable_aleatoria < 4 * Atacante.getHabilidad() - (Defensor.getDefensa() + valorEscudo)) {
            System.out.println(YELLOW + " IMPACTO CONFIRMADO" + RESET);
            int cantidad = (int) Atacante.atacar(Defensor);

            // PASIVAS DE ARMA
            if (Atacante instanceof Valiente v && v.getArma() != null) {
                int id = v.getArma().getIdPasiva();
                if (id == 2 && (Math.random() * 100) < 30) {
                    System.out.println(RED + " [PASIVA: CRITICO] Daño duplicado!!!!! " + RESET);
                    cantidad *= 2;
                }
                if (id == 3) {
                    v.setFuerza(v.getFuerza() + 1);
                    System.out.println(CYAN + " [PASIVA: ESCALADO] Fuerza aumentada permanentemente." + RESET);
                }
            }

            // PASIVA 6
            if (escudoAdminActivo) {
                cantidad /= 2;
                System.out.println(PURPLE + " [PASIVA: ADMIN] Daño reducido a la mitad por cortafuegos." + RESET);
            }

            System.out.println(" Resultado: " + RED + "-" + cantidad + " HP" + RESET);
            Defensor.recibirDaño(cantidad);

            // PASIVA 1: VAMPIRISMO
            if (Atacante instanceof Valiente v && v.getArma() != null && v.getArma().getIdPasiva() == 1) {
                int vidaRecuperada = (int) (cantidad * 0.20);
                v.setVida(v.getVida() + vidaRecuperada);
                System.out.println(GREEN + " [PASIVA: VAMPIRISMO] Has recuperado " + vidaRecuperada + " HP." + RESET);
            }

            // PASIVA 4: ESPINAS
            if (Defensor instanceof Valiente d && d.getEscudo() != null && d.getEscudo().getIdPasiva() == 4) {
                int reflejo = (int) (cantidad * 0.15);
                Atacante.recibirDaño(reflejo);
                System.out.println(YELLOW + " [PASIVA: ESPINAS] El atacante recibe " + reflejo + " de daño por contacto." + RESET);
            }

        } else {
            System.out.println(YELLOW + " ATAQUE FALLIDO: El objetivo ha esquivado el proceso." + RESET);
        }
        System.out.println("----------------------------------------------------------");
    }
    
    /**
     * Finaliza el combate, otorgando experiencia y subiendo nivel si el Valiente ha ganado.
     * @author Adrian
     * @param valiente El jugador.
     * @param monstruo El enemigo derrotado.
     * @return true si el valiente terminó vivo, false si murió.
     */
    @Override
    public boolean combateTerminado(Valiente valiente, Monstruo monstruo) {
        boolean vivo = false;
        if (valiente.getVida() > 0) { //si el valiente sobrevive aumenta estadisticas
            gestor.eliminarMonstruos(monstruo, valiente);
            valiente.subirNivel();
            vivo = true;
        } else { //si el valiente muere gana el monstruo
            System.out.println("El monstruo ha ganado...");
        }
        return vivo;
    }
}