/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

/**
 *
 * @author DAM124
 */
public class Monstruo extends Personaje {

    public Monstruo(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }

    @Override
    public <T> double atacar(T Personaje) {
        int danio = this.getFuerza();

        Valiente valiente = (Valiente) Personaje;

        if (valiente.getEscudo() != null) {
            danio -= valiente.getEscudo().getDefensa();
        }

        // Restar la defensa del valiente 
        danio -= valiente.getDefensa();

        System.out.println(this.getNombre() + " causa " + danio + " puntos de daño a " + valiente.getNombre() + ".");

        return danio;
    }

    @Override
    public void recibirDaño(int cantidad) {

        int vida = this.getDefensa();

        int danio = vida - cantidad;

        this.setVida(danio);
    }
}
