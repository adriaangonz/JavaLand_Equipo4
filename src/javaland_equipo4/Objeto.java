package javaland_equipo4;

import javaland_interfaces.ObjetoInterface;

/**
 *
 * @author DAM106
 */
public abstract class Objeto implements ObjetoInterface {

    protected String nombre;
    protected String tipo;
    protected int valor;
    protected int idPasiva;

    public Objeto(String nombre, String tipo, int valor, int idPasiva) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.idPasiva = idPasiva;
    }




    @Override
    public void equipar(Valiente valiente) {

    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public int getIdPasiva() {
        return idPasiva;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setIdPasiva(int idPasiva) {
        this.idPasiva = idPasiva;
    }

 


}
