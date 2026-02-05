
package javaland_interfaces;

/**
 *
 * @author cu3nt
 */
public interface PersonajesInterface {
    
    //Monstruos y valientes
    public<T> double atacar(T Personaje);
    
    public double recibirDaño(int cantidad);
    
    //Valientes
    public void usarHabilidadEspecial(Monstruo m);
    
    public void subirNivel();
    
    public void crearValientesIniciales(int fuerza, int velocidad, String habilidad, int defensa);
    
    //Monstruos
    
    public void generarMonstruos(int nivel);
    
    public void eleminarMonstruo(Monstruo m);
    
    
   
    
    
}
