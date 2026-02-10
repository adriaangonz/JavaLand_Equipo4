/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import javaland_interfaces.JuegoInterface;

/**
 *
 * @author cococ
 */
public class Juego extends Mapa implements JuegoInterface {

    @Override
    public void iniciarJuego() {
        String mapa="";
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                if(i==1 && j==1){
                    mapa+="[*]";
                }
                else{
                    mapa+="[x]";
                }
                
            }
            mapa+="\n";
        }
    }

    @Override
    public void creacionOEleccionValiente() {

    }

    @Override
    public void explorarMapa() {

    }

    @Override
    public void mostrarEstadoJuego() {

    }
    
}
