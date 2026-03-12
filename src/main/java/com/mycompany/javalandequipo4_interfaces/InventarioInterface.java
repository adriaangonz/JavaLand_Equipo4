/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javalandequipo4_interfaces;

import com.mycompany.javalandequipo4.Valiente;
import com.mycompany.javalandequipo4.Objeto;

/**
 *
 * @author cu3nt
 */
public interface InventarioInterface {

    public void agregarObjeto(Objeto obj);

    public void usarObjeto(String nombre, Valiente valiente);

    public void mostrarInventario();
}
