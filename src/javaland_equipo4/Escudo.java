package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Escudo extends Objeto {

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

    @Override
    public void equipar(Valiente valiente) {
        valiente.setEscudo(this);
    }

}
