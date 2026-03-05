package javaland_equipo4;

/**
 * Clase que representa un objeto de tipo Escudo para la protección del Valiente.
 * Permite mitigar el daño recibido y puede contener habilidades pasivas defensivas.
 * @author Saul
 */
public class Escudo extends Objeto {
    
    /**
     * Constructor de la clase Escudo.
     * @author Saul
     * @param nombre El nombre identificativo del escudo.
     * @param tipo La categoría del objeto (normalmente "Escudo").
     * @param valor El valor de defensa base que aporta.
     * @param idPasiva El identificador del efecto especial asociado al escudo.
     */
    public Escudo(String nombre, String tipo, int valor, int idPasiva) {
        super(nombre, tipo, valor, idPasiva);
    }

    /**
     * Obtiene el valor de defensa del escudo.
     * @author Saul
     * @return El valor numérico de la defensa.
     */
    public int getDefensa() {
        return valor;
    }

    /**
     * Establece o modifica el valor de defensa del escudo.
     * @author Saul
     * @param defensa El nuevo valor de defensa a asignar.
     */
    public void setDefensa(int defensa) {
        this.valor = valor;
    }
    
    /**
     * Equipa este escudo al Valiente pasado por parámetro, sustituyendo el anterior si lo hubiera.
     * @author Saul
     * @param valiente El personaje que se equipará el escudo.
     */
    @Override
    public void equipar(Valiente valiente) {
        valiente.setEscudo(this);
    }

}