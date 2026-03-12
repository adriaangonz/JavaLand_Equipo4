package com.mycompany.javalandequipo4;

/**
 * Clase que representa un arma en el juego.
 * @author Saul
 */
public class Arma extends Objeto {
    
    /**
     * Constructor de la clase Arma.
     * @author Saul
     * @param nombre nombre del arma
     * @param tipo tipo de arma
     * @param valor valor del arma
     * @param idPasiva pasiva del arma
     */
    public Arma(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }

    /**
     * Obtiene el valor de ataque.
     * @author Saul
     * @return valor de ataque
     */
    public int getAtaque() {
        return valor;
    }

    /**
     * Establece el valor de ataque.
     * @author Saul
     * @param ataque nuevo valor
     */
    public void setAtaque(int ataque) {
        this.valor = valor;
    }
    
    /**
     * Equipa el arma al valiente.
     * @author Saul
     * @param valiente valiente al que se le equipa el arma
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setArma(this);
    }
}