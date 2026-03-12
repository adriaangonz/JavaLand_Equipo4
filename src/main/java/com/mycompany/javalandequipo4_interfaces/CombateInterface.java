/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javalandequipo4_interfaces;

import com.mycompany.javalandequipo4.Valiente;
import com.mycompany.javalandequipo4.Monstruo;

/**
 *
 * @author cu3nt
 */
public interface CombateInterface {

    public boolean iniciarCombate(Valiente valiente, Monstruo monstruo);

    public<T> void turno(T atacante, T defensor);

    public boolean combateTerminado(Valiente valiente, Monstruo monstruo);
}
