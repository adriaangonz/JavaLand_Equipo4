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

            if (Iniciativa_Valiente >= Iniciativa_Monstruo) { //Si la iniciativa de valiente es mayor o igual a la del monstruo, valiente ataca
                turno(valiente, monstruo);
                if (monstruo.getVida() > 0) {
                    turno(monstruo, valiente); //si el monstruo sigue vivo, contraataca
                }
            } else { //En caso contrario, el monstruo ataca primero
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

    }

    @Override
    public void combateTerminado(Object valiente, Object monstruo) {

    }

}
