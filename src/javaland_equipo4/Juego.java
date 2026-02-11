/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.Scanner;
import javaland_interfaces.GestoresInterface;
import javaland_interfaces.JuegoInterface;

/**
 *
 * @author cococ
 */
public class Juego implements JuegoInterface {
    private Mapa mapa;
    private Valiente valiente;
    private static int posicionX;
    private static int posicionY;
    @Override
    public void iniciarJuego() {
        System.out.println("EL COMPILADOR OSCURO");
        this.posicionX=1;
        this.posicionY=1;
        this.valiente=creacionOEleccionValiente();
        if(valiente!=null){
            valiente.setPosicion= [posicionY][posicionX];
            this.mapa= new Mapa(20,10);
            mostrarMenuPrincipal();
        }
        else{
            System.out.println("adios");
        }
        
        
    }

    @Override
    public Valiente creacionOEleccionValiente() {
        Scanner teclado = new Scanner(System.in);
        this.valiente=null;
        int opcion=0;
        do{
            System.out.println("1 - Crear Valiente");
            System.out.println("2 - Usar valientes Iniciales");
            System.out.println("3 - Salir");
            System.out.print("Elige una opcion:");
            opcion=teclado.nextInt();
            switch(opcion){
            case 1->this.valiente = new Valiente();
            case 2->GestoresInterface.crearValientesIniciales();
            default->{
                System.out.println("eso no es una opcion");
            }
        }
        }while(opcion!=3);
        return valiente;
        
        
    }

    @Override
    public void mostrarEstadoJuego() {

    }

    @Override
    public void mostrarMenuPrincipal() {
        
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("1 - Mostrar Valiente");
            System.out.println("2 - Equipar Objeto");
            System.out.println("3 - Mostrar mapa");
            System.out.println("4 - Moverse");
            System.out.println("5 - Salir del juego");
            System.out.print("Elige una opcion:");
            opcion=teclado.nextInt();
            switch(opcion){
            case 1->mostrarValiente();
            case 2->equiparObjeto();
            case 3->mostrarMapa();
            case 4->explorarMapa();
            default->{
                System.out.println("eso no es una opcion");
            }
        }
        }while(opcion!=5);
        
        
    }
    private void mostrarValiente(){
        System.out.println(this.valiente.toString());
    }
    private void equiparObjeto(){
        Scanner teclado = new Scanner(System.in);
        Inventario.mostrarInventario();
        int posicion= teclado.nextInt();
        Inventario.usarObjeto(posicion,this.valiente);
    }
    private void mostrarMapa(){
        for (int i = 0; i < this.mapa.getAlto(); i++) {
            for (int j = 0; j < this.mapa.getAncho(); j++) {
                System.out.print(this.mapa.getCasillas()[i][j]);
            }
            System.out.println();
        }
        mapa.mostrarCasillasAdyacentes(this.valiente.getPosicion());
    }
    @Override
    public void explorarMapa(){
        mostrarMapa();
        Scanner teclado = new Scanner(System.in);
        String opcion="";
            System.out.println("¿Hacia que direccion quieres moverte?: W/A/S/D");
            opcion=teclado.next().substring(0,1);
            switch(opcion.toLowerCase()){
            case "w"->{
                if(movimientoValido(1,1)){
                    mapa.setCasilla(posicionY,posicionX,"[ ]");
                    posicionY--;
                    mapa.setCasilla(posicionY,posicionX,"[*]");
                    this.valiente.setPosicion[posicionY][posicionX];
                    
                }
                else{
                    System.out.println("no se puede mover");
                }
               
            }
            case "a"->{
                if(movimientoValido(-1,-1)){
                    mapa.setCasilla(posicionY,posicionX,"[ ]");
                    posicionX--;
                    mapa.setCasilla(posicionY,posicionX,"[*]");
                    this.valiente.setPosicion[posicionY][posicionX];
                }
                else{
                    System.out.println("no se puede mover");
                }
               
            }
            case "s"->{
                if(movimientoValido(1,-1)){
                    mapa.setCasilla(posicionY,posicionX,"[ ]");
                    posicionY++;
                    mapa.setCasilla(posicionY,posicionX,"[*]");
                    this.valiente.setPosicion[posicionY][posicionX];
                }
                else{
                    System.out.println("no se puede mover");
                }
                
            }
            case "d"->{
                if(movimientoValido(-1,1)){
                    mapa.setCasilla(posicionY,posicionX,"[ ]");
                    posicionX++;
                    mapa.setCasilla(posicionY,posicionX,"[*]");
                    this.valiente.setPosicion[posicionY][posicionX];
                }
                else{
                    System.out.println("no se puede mover");
                }
            }
            default->{
                System.out.println("eso no es una opcion");
            }
            
        }
        
    }
    private boolean movimientoValido(int coordenada,int direccion){
        boolean validacion;
        if(coordenada==1){
            //Y-1
            if(direccion==1){
                validacion = posicionY-1>=0;
            }
            //Y+1
            else{
                validacion= posicionY<mapa.getAlto()-1;
            }
        }
        else{
            //X+1
            if(direccion==1){
                validacion= posicionX<mapa.getAncho()-1;
                
            }
            //X-1
            else{
                validacion = posicionX-1>=0;
            }
        }
        return validacion;
    }
    
}
