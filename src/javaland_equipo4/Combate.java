/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import javaland_interfaces.CombateInterface;

/**
 *
 * @author DAM115
 */
public class Combate implements CombateInterface {

    @Override
    public void iniciarCombate(Object valiente, Object monstruo) {
        do {
            double Iniciativa_Valiente = valiente.getVelocidad()*
        } while (valiente.getVida()>0); 
    }

    @Override
    public <T> void turno(T atacante, T defensor) {
        
    }

    @Override
    public void combateTerminado(Object valiente, Object monstruo) {
        
    }
    
}
