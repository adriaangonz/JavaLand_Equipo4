/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javalandequipo4;

import com.mycompany.javalandequipo4_interfaces.PersonajesInterface;

/**
 * Clase base que define los atributos y comportamientos comunes para todos los 
 * personajes de Javaland, sirviendo como superclase para Valiente y Monstruo.
 * @author saul
 */
public class Personaje implements PersonajesInterface {

    private String nombre;
    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;
    private int nivel;

    /**
     * Constructor por defecto para la inicialización de un personaje vacío.
     * @author saul
     */
    public Personaje() {
    }

    /**
     * Constructor que inicializa un personaje con todas sus estadísticas base.
     * @author saul
     * @param nombre El nombre identificativo del personaje.
     * @param vida Puntos de salud iniciales.
     * @param fuerza Capacidad de daño físico.
     * @param defensa Resistencia ante ataques recibidos.
     * @param habilidad Destreza técnica y precisión.
     * @param velocidad Determina el orden de actuación en combate.
     * @param nivel Rango de poder actual del personaje.
     */
    public Personaje(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
        this.nivel = nivel;
    }

    /**
     * Obtiene el nombre del personaje.
     * @author saul
     * @return String con el nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los puntos de vida actuales.
     * @author saul
     * @return int con la vida restante.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece los puntos de vida del personaje.
     * @author saul
     * @param vida Nuevo valor de salud.
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene el valor de fuerza del personaje.
     * @author saul
     * @return int con la fuerza actual.
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Establece el valor de fuerza del personaje.
     * @author saul
     * @param fuerza Nuevo valor de ataque.
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Obtiene el valor de defensa del personaje.
     * @author saul
     * @return int con la defensa actual.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Establece el valor de defensa del personaje.
     * @author saul
     * @param defensa Nuevo valor de resistencia.
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Obtiene el valor de habilidad del personaje.
     * @author saul
     * @return int con la habilidad actual.
     */
    public int getHabilidad() {
        return habilidad;
    }

    /**
     * Establece el valor de habilidad del personaje.
     * @author saul
     * @param habilidad Nuevo valor de destreza.
     */
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * Obtiene el valor de velocidad del personaje.
     * @author saul
     * @return int con la velocidad actual.
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Establece el valor de velocidad del personaje.
     * @author saul
     * @param velocidad Nuevo valor de rapidez.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Obtiene el nivel actual del personaje.
     * @author saul
     * @return int con el nivel.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel del personaje.
     * @author saul
     * @param nivel Nuevo rango de nivel.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Establece el nombre del personaje.
     * @author saul
     * @param nombre Nuevo nombre identificativo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Realiza una acción de ataque contra otro personaje.
     * @author saul
     * @param <T> Tipo genérico del objetivo.
     * @param Personaje El objetivo del ataque.
     * @return double con el daño calculado (actualmente 0 por defecto).
     */
    @Override
    public <T> double atacar(T Personaje) {
        int danio = 0;
        return danio;
    }

    /**
     * Procesa el daño recibido por el personaje.
     * @author saul
     * @param cantidad Cantidad de daño a restar de la vida.
     */
    @Override
    public void recibirDaño(int cantidad) {
    }

    /**
     * Ejecuta una técnica especial contra un monstruo.
     * @author saul
     * @param m El monstruo objetivo de la habilidad.
     */
    @Override
    public void usarHabilidadEspecial(Monstruo m) {
    }

    /**
     * Incrementa el nivel del personaje y mejora sus estadísticas.
     * @author saul
     */
    @Override
    public void subirNivel() {
    }

    /**
     * Configura los parámetros iniciales para los valientes.
     * @author saul
     * @param fuerza Puntos de ataque inicial.
     * @param velocidad Puntos de agilidad inicial.
     * @param habilidad Descripción o identificador de técnica inicial.
     * @param defensa Puntos de resistencia inicial.
     */
    @Override
    public void crearValientesIniciales(int fuerza, int velocidad, String habilidad, int defensa) {
    }

    /**
     * Crea entidades enemigas basadas en un nivel de dificultad.
     * @author saul
     * @param nivel Nivel que determina la fuerza de los monstruos.
     */
    @Override
    public void generarMonstruos(int nivel) {
    }

    /**
     * Elimina un objeto monstruo del contexto actual.
     * @author saul
     * @param m El monstruo a eliminar.
     */
    @Override
    public void eliminarMonstruo(Monstruo m) {
    }
}