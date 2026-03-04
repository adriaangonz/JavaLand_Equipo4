package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Escudo extends Objeto {
    
    /**
     * 
     * @param nombre nombre del escudo
     * @param tipo tipo del escudo
     * @param valor calor del escudo
     * @param idPasiva pasiva del escudo
     */
    public Escudo(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }


    //Getters y setters
    public int getDefensa() {
        return valor;
    }

    public void setDefensa(int defensa) {
        this.valor = valor;
    }
    
    /**
     * 
     * @param valiente valiente que se equipa el escudo
     * Metodo que equipa un escudo
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setEscudo(this);
    }

}
