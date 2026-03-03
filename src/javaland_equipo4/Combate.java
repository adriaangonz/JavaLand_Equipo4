/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Scanner;
import javaland_interfaces.*;

/**
 *
 * @author DAM115
 */
public class Combate implements CombateInterface {

    private final GestorMonstruos gestor = new GestorMonstruos();

    @Override
    public boolean iniciarCombate(Valiente valiente, Monstruo monstruo) {
        do {
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

    @Override
    public <T> void turno(T atacante, T defensor) {
        
        Scanner teclado = new Scanner(System.in);
        //convierto al atacante y al defensor en personajes
        Personaje Atacante = (Personaje) atacante;
        Personaje Defensor = (Personaje) defensor;

        if (Atacante instanceof Valiente) {
            Valiente v = (Valiente) Atacante;
            Monstruo m = (Monstruo) Defensor;
            boolean turnoFinalizado = false;

            while (!turnoFinalizado) {
                System.out.println("\n--- turno de " + v.getNombre() + " ---");
                System.out.println("1 atacar");
                System.out.println("2 cambiar equipo");
                System.out.println("3 usar habilidad especial");
                System.out.print("elige una opcion: ");

                String opcion = teclado.nextLine();

                switch (opcion) {
                    case "1":
                        ejecutarAtaque(v, m);
                        turnoFinalizado = true;
                        break;
                    case "2":
                        System.out.println("--- inventario de combate ---");
                        // llamamos al metodo mostrar para que el usuario vea sus indices 0 a 3
                        inventario.mostrarInventario();

                        System.out.print("elige el numero de hueco del objeto a usar (0-3) o n para volver: ");
                        String indice = teclado.nextLine();

                        if (!indice.equalsIgnoreCase("n")) {
                            // usamos el metodo usarObjeto que ya convierte el String a int y gestiona el equipo
                            inventario.usarObjeto(indice, v);
                            System.out.println("equipo actualizado");
                        }
                        break;
                    case "3":
                        v.usarHabilidadEspecial(m);
                        turnoFinalizado = true;
                        break;
                    default:
                        System.out.println("opcion no valida");
                        break;
                }
            }
        } else {
            // si el atacante es el monstruo ataca
            ejecutarAtaque(Atacante, Defensor);
        }

    }

    private <T> void ejecutarAtaque(T atacante, T defensor) { //metodo auxiliar para no escribirlo varias veces en turno
        Personaje Atacante = (Personaje) atacante;
        Personaje Defensor = (Personaje) defensor;
        //calculamos valor de escudo de valiente por si defiende
        int valorEscudo = 0;
        if (defensor instanceof Valiente && ((Valiente) defensor).getEscudo() != null) {
            valorEscudo = ((Valiente) defensor).getEscudo().getDefensa();
        }

        System.out.println(Atacante.getNombre() + "intenta el ataque: ");
        int Variable_aleatoria = (int) (Math.random() * 101);

        if (Variable_aleatoria < 4 * Atacante.getHabilidad() - (Defensor.getDefensa() + valorEscudo)) {
            System.out.println("ataque realizado con exito");
            int cantidad = (int) Atacante.atacar(Defensor);
            Defensor.recibirDaño(cantidad);
        } else {
            System.out.println("ataque fallido");
        }
    }

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
