/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Random;
import java.util.Scanner;
import javaland_interfaces.MapaInterface;

/**
 *
 * @author cococ
 */
public class Mapa implements MapaInterface {
    Random r;
    Scanner teclado = new Scanner(System.in);
    protected String[][] casillas;
    private int ancho;
    private int alto;
    public Mapa(){
        System.out.println("Introduce el alto del mapa");
        int alto = teclado.nextInt();
        System.out.println("Introduce el ancho del mapa");
        int ancho = teclado.nextInt();
        this.casillas= new String[alto][ancho];
        for (int i = 0; i < this.casillas.length;i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                   
                System.out.println("[ ]");
            }
        }
        this.casillas[1][1]="[*]";
    }

    public Mapa(int ancho, int alto) {
        int monstruos=5;
        this.ancho = ancho;
        this.alto = alto;
        this.casillas= new String[alto][ancho];
        for (int i = 0; i < this.casillas.length;i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                if(r.nextInt(3)+1==1){
                    System.out.println("[?]");
                }
                else if(r.nextInt(3)+1==2){
                    System.out.println("[!]");
                }
                else{
                    System.out.println("[ ]");
                }
                
                
            }
        }
        this.casillas[1][1]="[*]";
    }
    

        @Override
        public void mostrarCasillasAdyacentes(int[][] posicion) {

        }
        public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public String[][] getCasillas() {
        return casillas;
    }

    public void setCasilla(int Y,int X,String casilla) {
        
        this.casillas[Y][X] = casilla;
    }
    
    

    }



    
    
    

