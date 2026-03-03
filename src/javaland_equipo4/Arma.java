
package javaland_equipo4;

/**
 *
 * @author DAM106
 */
public class Arma extends Objeto {

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

    @Override
    public void equipar(Valiente valiente) {
        valiente.setArma(this);
    }

}
