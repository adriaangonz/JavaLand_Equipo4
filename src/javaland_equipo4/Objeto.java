package javaland_equipo4;

import javaland_interfaces.ObjetoInterface;

/**
 *
 * @author DAM106
 */
public abstract class Objeto implements ObjetoInterface {

    protected String nombre;
    protected String tipo;

    public Objeto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public void equipar(Valiente valiente) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
