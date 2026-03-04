package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Planta extends Objeto {
    
    /**
     * 
     * @param nombre nombre de la planta
     * @param tipo tipo de planta
     * @param valor valor de la planta
     * @param idPasiva pasiva de la planta
     * Constructor de la planta por parametros
     */
    public Planta(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }



    //getters y setters
    public int getRecupera() {
        return valor;
    }

    public void setRecupera(int recupera) {
        this.valor = valor;
    }
    /**
     * 
     * @param valiente valiente que usa la planta
     * Metodo que usa la planta
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setVida(valiente.getVida() + valor);
    }

}
