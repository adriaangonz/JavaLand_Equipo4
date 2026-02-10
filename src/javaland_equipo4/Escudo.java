
package javaland_equipo4;

/**
 *
 * @author saul1
 */
public class Escudo extends Objeto {
    
     private int defensa;
     
     
     //Getters y setters

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
     
     
     
     @Override
     public void equipar(Valiente valiente){
     
         valiente.setEscudo(this);
     
     
     }
    
}
