
package javaland_equipo4;

/**
 *
 * @author DAM106
 */
public class Arma extends Objeto{
    
    private int ataque;
    
    
    //Getters y setters

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    
    
    @Override
    public void equipar(Valiente valiente){
    
        valiente.setArma(this);
    
    }
    

    
}
    
    
