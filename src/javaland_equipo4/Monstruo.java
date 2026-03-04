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
    private double experiencia;
    
    public Monstruo(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }

    public Monstruo(int nivel) {
        super(
                "Monstruo Lv." + nivel, //Random para asignar los atributos al monstruo aleatorios
                random.nextInt(101),
                random.nextInt(20) + 1,
                random.nextInt(20) + 1,
                random.nextInt(20) + 1, 
                random.nextInt(20) + 1, 
                nivel
        );
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }


    /**
     * 
     * @param <T>
     * @param personaje
     * @return Fuerza del monstruo
     * Meotodo generico que devuelve la fuerza del monstruo
     */
    @Override
    public <T> double atacar(T personaje) {
        return this.getFuerza();
    }
    
    /**
     * 
     * @param cantidad daño recibido
     * Metodo generico que permite que el monstruo reciba daño
     */
    @Override
    public void recibirDaño(int cantidad) {

        int vidaActual = this.getVida();

        int vidaRestante = vidaActual - cantidad;

        this.setVida(vidaRestante);
        
        System.out.println(this.getNombre() + " recibe " + cantidad
                + " puntos de daño. Vida actual: " + vidaRestante);
    }
}
