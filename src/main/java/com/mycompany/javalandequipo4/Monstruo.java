/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javalandequipo4;

import java.util.Random;

/**
 * Clase que representa a los enemigos dentro de Javaland. 
 * Hereda de Personaje y define la recompensa de experiencia y el comportamiento en combate.
 * @author marcos
 */
public class Monstruo extends Personaje {

    private static final Random random = new Random();
    private double experiencia;
    
    /**
     * Constructor para instanciar un monstruo con atributos específicos.
     * @author marcos
     * @param nombre El nombre identificativo del monstruo.
     * @param vida Puntos de salud iniciales.
     * @param fuerza Capacidad ofensiva.
     * @param defensa Capacidad defensiva.
     * @param habilidad Destreza técnica.
     * @param velocidad Rapidez de acción.
     * @param nivel Nivel jerárquico del monstruo.
     */
    public Monstruo(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }

    /**
     * Constructor que genera un monstruo con atributos aleatorios basados en su nivel.
     * @author marcos
     * @param nivel El nivel que determina el rango de los atributos aleatorios.
     */
    public Monstruo(int nivel) {
        super(
                "Monstruo Lv." + nivel, 
                random.nextInt(101),
                random.nextInt(20) + 1,
                random.nextInt(20) + 1,
                random.nextInt(20) + 1, 
                random.nextInt(20) + 1, 
                nivel
        );
    }

    /**
     * Devuelve la experiencia que el monstruo otorga al morir.
     * @author marcos
     * @return double con el valor de la experiencia.
     */
    public double getExperiencia() {
        return experiencia;
    }

    /**
     * Define la cantidad de experiencia que soltará el monstruo.
     * @author marcos
     * @param experiencia Valor decimal de la experiencia.
     */
    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }


    /**
     * Método genérico que calcula el daño de ataque del monstruo.
     * @author marcos
     * @param <T> Tipo del personaje objetivo.
     * @param personaje El objeto que recibe el ataque.
     * @return double con el valor de la fuerza del monstruo.
     */
    @Override
    public <T> double atacar(T personaje) {
        return this.getFuerza();
    }
    
    /**
     * Aplica una reducción de vida al monstruo basada en el daño recibido.
     * @author marcos
     * @param cantidad Entero que representa los puntos de daño a restar.
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