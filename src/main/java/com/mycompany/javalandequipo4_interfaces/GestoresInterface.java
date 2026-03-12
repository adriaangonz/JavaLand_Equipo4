/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javalandequipo4_interfaces;

import com.mycompany.javalandequipo4.Monstruo;
import com.mycompany.javalandequipo4.Valiente;

/**
 *
 * @author cu3nt
 */
public interface GestoresInterface {

    public Valiente crearValientesIniciales();
    
    public Monstruo generarMonstruos(int nivel);
    
    public void eliminarMonstruos(Monstruo m, Valiente v);
    
    
    
}
