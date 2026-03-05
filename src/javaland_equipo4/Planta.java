/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

/**
 * Clase que representa un objeto de tipo Planta.
 * Se utiliza principalmente para recuperar puntos de vida del Valiente.
 * @author saul
 */
public class Planta extends Objeto {
    
    /**
     * Constructor de la planta por parámetros.
     * @author saul
     * @param nombre El nombre identificativo de la planta.
     * @param tipo El tipo de categoría al que pertenece.
     * @param valor La cantidad de vida que recupera al ser usada.
     * @param idPasiva El identificador de su efecto pasivo.
     */
    public Planta(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }

    /**
     * Obtiene la cantidad de vida que recupera la planta.
     * @author saul
     * @return int con el valor de recuperación.
     */
    public int getRecupera() {
        return valor;
    }

    /**
     * Establece la cantidad de vida que recupera la planta.
     * @author saul
     * @param recupera El nuevo valor de recuperación.
     */
    public void setRecupera(int recupera) {
        this.valor = recupera;
    }

    /**
     * Implementación del método equipar que, en el caso de la planta, 
     * actúa como un consumible aumentando la vida del Valiente.
     * @author saul
     * @param valiente El personaje que utiliza la planta para sanarse.
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setVida(valiente.getVida() + valor);
    }

}