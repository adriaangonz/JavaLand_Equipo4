/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaland_interfaces;

import javaland_equipo4.*;

/**
 *
 * @author cu3nt
 */
public interface InventarioInterface {

    public void agregarObjeto(Objeto obj);

    public void usarObjeto(String nombre, Valiente valiente);

    public void mostrarInventario();
}
