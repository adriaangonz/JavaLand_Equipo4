package javaland_equipo4;

/**
 *
 * @author DAM106
 */
public class Arma extends Objeto {

    private int ataque;

    public Arma(String nombre, String tipo, int ataque) {
        super(nombre, tipo);
        this.ataque = ataque;
    }

    //Getters y setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public void equipar(Valiente valiente) {
        valiente.setArma(this);
    }

}
