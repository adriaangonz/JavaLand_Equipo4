package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Escudo extends Objeto {

    private int defensa;

    public Escudo(String nombre, String tipo, int defensa) {
        super(nombre, tipo);
        this.defensa = defensa;
    }

    //Getters y setters
    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void equipar(Valiente valiente) {
        valiente.setEscudo(this);
    }

}
