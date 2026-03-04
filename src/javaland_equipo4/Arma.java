
package javaland_equipo4;

/**
 *
 * @author DAM106
 */
public class Arma extends Objeto {
    
    /**
     * 
     * @param nombre nombre del arma
     * @param tipo tipo de arma
     * @param valor valor del arma
     * @param idPasiva pasiva del arma
     * Constructor de Arma
     */
    public Arma(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }


    

    //Getters y setters
    public int getAtaque() {
        return valor;
    }

    public void setAtaque(int ataque) {
        this.valor = valor;
    }
    
    /**
     * 
     * @param valiente valiente al que se le equipa el arma
     * Metodo que euipa un arma
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setArma(this);
    }

}
