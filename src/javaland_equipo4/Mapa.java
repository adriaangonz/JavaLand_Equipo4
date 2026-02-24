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
public class Mapa{
    private final Random r= new Random();
    Scanner teclado = new Scanner(System.in);
    private String[][] casillas;
    private int ancho;
    private int alto;
    private boolean[][] visible;
    private int monstruos;
    private int objetos;
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
        this.casillas[0][0]="[*]";
    }

    public Mapa(boolean nether) {
        if(!nether){
        this.monstruos=5;
        this.objetos=5;
        int monstruosRestantes=this.monstruos;
        int objetosRestantes=this.objetos;
        this.ancho = 10;
        this.alto = 10;
        this.casillas= new String[alto][ancho];
        this.visible= new boolean[alto][ancho];
        for (int i = 0; i < this.casillas.length;i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                int random =r.nextInt(20)+1;
                if(random==1 && objetos>0){
                    this.casillas[i][j]="[?]";
                    objetosRestantes--;
                    
                }
                else if(random==2 && monstruos>0){
                    this.casillas[i][j]="[!]";
                    monstruosRestantes--;
                }
                else{
                    this.casillas[i][j]="[ ]";
                }  
            }
        }
        this.casillas[0][0]="[*]";
        this.casillas[alto-1][ancho-1]="[0]";
    }
        else{
        this.monstruos=5;
        this.objetos=5;
        this.ancho = 5;
        this.alto = 5;
        this.casillas= new String[alto][ancho];
        this.visible= new boolean[alto][ancho];
        for (int i = 0; i < this.casillas.length;i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                int random =r.nextInt(20)+1;
                if(random==1 && objetos>0){
                    this.casillas[i][j]="[?]";
                    objetos--;
                    
                }
                else if(random==2 && monstruos>0){
                    this.casillas[i][j]="[!]";
                    monstruos--;
                }
                else{
                    this.casillas[i][j]="[ ]";
                }  
            }
        }
        this.casillas[0][0]="[*]";
        this.casillas[alto-1][ancho-1]="[#]";
        }
        }
    
       
        public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setMonstruos(int monstruos) {
        this.monstruos = monstruos;
    }

    public void setObjetos(int objetos) {
        this.objetos = objetos;
    }

    public int getMonstruos() {
        return monstruos;
    }

    public int getObjetos() {
        return objetos;
    }
    

    public String[][] getCasillas() {
        return casillas;
    }

    public void setCasilla(int fila,int columna,String casilla) {
        
        this.casillas[columna][fila] = casilla;
    }
    public void setVisible(int fila,int columna){
        this.visible[columna][fila]=true;
    }
    public boolean esVisible(int columna,int fila){
        return this.visible[fila][columna];
    }
    
    

    

    }



    
    
    

