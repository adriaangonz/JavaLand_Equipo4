/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Scanner;
import javaland_interfaces.MapaInterface;

/**
 *
 * @author cococ
 */
public class Mapa implements MapaInterface {
    Scanner teclado = new Scanner(System.in);
    protected int[][] casillas;
    public Mapa(){
        System.out.println("Introduce el alto del mapa");
        int x = teclado.nextInt();
        System.out.println("Introduce el ancho del mapa");
        int y = teclado.nextInt();
        this.casillas= new int[x][y];
    }

    @Override
    public void casillasVisibles(int[][] posicion) {
    }

    @Override
    public boolean hayMonstruo(int[][] posicion) {
        
    }

    @Override
    public boolean hayObjeto(int[][] posicion) {
        
    }
    
}
