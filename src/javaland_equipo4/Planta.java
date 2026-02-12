package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Planta extends Objeto {

    private int recupera;

    public Planta(String nombre, String tipo, int recupera) {
        super(nombre, tipo);
        this.recupera = recupera;
    }

    //getters y setters
    public int getRecupera() {
        return recupera;
    }

    public void setRecupera(int recupera) {
        this.recupera = recupera;
    }

    @Override
    public void equipar(Valiente valiente) {
        valiente.setVida(valiente.getVida() + recupera);
    }

}
