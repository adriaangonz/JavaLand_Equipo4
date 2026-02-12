/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaland_interfaces;

import javaland_equipo4.Monstruo;
import javaland_equipo4.Valiente;
/**
 *
 * @author cu3nt
 */
public interface GestoresInterface {

    public void crearValientesIniciales();
    
    public Monstruo generarMonstruos(int nivel);
    
    public void eliminarMonstruos(Monstruo m, Valiente v);
    
    
    
}
