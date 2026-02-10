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
        System.out.println("El atacante intenta el ataque: ");
        atacante.atacar();
        int Variable_aleatoria = (int) (Math.random() * 101);
        if (Variable_aleatoria < 4 * atacante.getHabilidad() - defensor.getDefensa()) {
            System.out.println("Atace realizado con exito");
            defensor.recibirDaño(atacante.getFuerza());
        } else {
            System.out.println("Ataque realizado sin exito");
        }
    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
        if (valiente.getVida() > 0) {
            valiente.setVida(valiente.getVida() + 10);
            valiente.setFuerza(valiente.getFuerza() + 1);
            valiente.setDefensa(valiente.getDefensa() + 1);
            valiente.setHabilidad(valiente.getHabilidad() + 1);
            valiente.setVelocidad(valiente.getVelocidad() + 1);
            System.out.println("El Valiente ha ganado, recibe...");
        } else {
            System.out.println("El monstruo ha ganado...");
        }
    }
}
