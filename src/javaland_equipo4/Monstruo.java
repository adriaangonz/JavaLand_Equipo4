/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

/**
 *
 * @author DAM124
 */
public class Monstruo extends Personaje{
    
    private int contadormonstruos=0;

    public Monstruo(int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(vida, fuerza, defensa, habilidad, velocidad, nivel);
    }
    
    

    @Override
    public <T> double atacar (T Personaje){
        int danio = fuerza - (Valiente.getDefensa()-Arma.Escudo);
        return danio;
    }
    
    

    @Override
    public void generarMonstruos(int nivel) {
        super.generarMonstruos(nivel);
        contadormonstruos++;
    }

}
