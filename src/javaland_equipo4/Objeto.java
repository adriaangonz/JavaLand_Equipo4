/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import javaland_interfaces.ObjetoInterface;

/**
 * Clase abstracta que define la estructura base para todos los objetos del juego.
 * Implementa la interfaz ObjetoInterface para gestionar el equipamiento.
 * @author saul
 */
public abstract class Objeto implements ObjetoInterface {

    protected String nombre;
    protected String tipo;
    protected int valor;
    protected int idPasiva;

    /**
     * Constructor para inicializar un nuevo objeto con sus atributos base.
     * @author saul
     * @param nombre El nombre identificativo del objeto.
     * @param tipo La categoría del objeto (Arma, Armadura, etc.).
     * @param valor El valor numérico de la estadística que otorga.
     * @param idPasiva El identificador único para efectos pasivos especiales.
     */
    public Objeto(String nombre, String tipo, int valor, int idPasiva) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.idPasiva = idPasiva;
    }

    /**
     * Método para equipar el objeto a un Valiente. 
     * @author saul
     * @param valiente El personaje que recibirá los beneficios del objeto.
     */
    @Override
    public void equipar(Valiente valiente) {
        // Lógica a implementar en subclases
    }

    /**
     * Obtiene el nombre del objeto.
     * @author saul
     * @return String con el nombre del objeto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del objeto.
     * @author saul
     * @return String con el tipo de objeto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el valor estadístico del objeto.
     * @author saul
     * @return int con el valor del objeto.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el ID de la pasiva del objeto.
     * @author saul
     * @return int con el identificador de la pasiva.
     */
    public int getIdPasiva() {
        return idPasiva;
    }

    /**
     * Establece el nombre del objeto.
     * @author saul
     * @param nombre Nuevo nombre para el objeto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el tipo del objeto.
     * @author saul
     * @param tipo Nueva categoría para el objeto.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece el valor estadístico del objeto.
     * @author saul
     * @param valor Nuevo valor para el objeto.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Establece el ID de la pasiva del objeto.
     * @author saul
     * @param idPasiva Nuevo identificador de pasiva.
     */
    public void setIdPasiva(int idPasiva) {
        this.idPasiva = idPasiva;
    }
}