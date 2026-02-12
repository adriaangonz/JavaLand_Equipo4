/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Random;

/**
 *
 * @author DAM124
 */
public class Monstruo extends Personaje {

    private static final Random random = new Random();

    public Monstruo(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel, double experiencia) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel, experiencia);
    }

    public Monstruo(int nivel) {
        super(
                "Monstruo Lv." + nivel,
                random.nextInt(101), // vida: 0 a 100
                random.nextInt(20) + 1, // fuerza: 1 a 20
                random.nextInt(20) + 1, // defensa: 1 a 20
                random.nextInt(20) + 1, // habilidad: 1 a 20
                random.nextInt(20) + 1, // velocidad: 1 a 20
                random.nextInt(20) + 1, 
                nivel
        );
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
