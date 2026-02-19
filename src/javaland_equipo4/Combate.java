/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import javaland_interfaces.*;

/**
 *
 * @author DAM115
 */
public class Combate implements CombateInterface {

    @Override
    public void iniciarCombate(Valiente valiente, Monstruo monstruo) {
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
        combateTerminado(valiente, monstruo);//si sale del bucle, se acaba el combate
    }

    @Override
    public <T> void turno(T atacante, T defensor) {
        //convierto al atacante y al defensor en personakjes
        Personaje Atacante = (Personaje) atacante;
        Personaje Defensor = (Personaje) defensor;

        System.out.println(Atacante.getNombre() + "intenta el ataque: ");
        int Variable_aleatoria = (int) (Math.random() * 101);

        if (Variable_aleatoria < 4 * Atacante.getHabilidad() - Defensor.getDefensa()) {
            System.out.println("ataque realizado con exito");
            int cantidad = (int) Atacante.atacar(Defensor);
            Defensor.recibirDaño(cantidad);
        } else {
            System.out.println("ataque fallido");
        }
    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
        if (valiente.getVida() > 0) { //si el valiente sobrevive aumenta estadisticas
            valiente.setVida(valiente.getVida() + 10);
            valiente.setFuerza(valiente.getFuerza() + 1);
            valiente.setDefensa(valiente.getDefensa() + 1);
            valiente.setHabilidad(valiente.getHabilidad() + 1);
            valiente.setVelocidad(valiente.getVelocidad() + 1);
            System.out.println("El Valiente ha ganado, recibe...");
        } else { //si el valiente muere gana el monstruo
            System.out.println("El monstruo ha ganado...");
        }
    }
}
