package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Planta extends Objeto {

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

    @Override
    public void equipar(Valiente valiente) {
        valiente.setVida(valiente.getVida() + valor);
    }

}
