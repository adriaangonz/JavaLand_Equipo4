
package javaland_interfaces;

import javaland_equipo4.Objeto;
import javaland_equipo4.Valiente;

/**
 *
 * @author cu3nt
 */
public interface ObjetoInterface {
    
    
    public void equipar(Valiente valiente);
    
    public void agregar(Objeto obj);
    
    public void usarObjeto(String nombre, Valiente valiente);
    
    public void mostrarInventario();
    
    
    
}
