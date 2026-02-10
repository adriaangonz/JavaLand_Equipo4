/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Inventario {
    
    private ArrayList<Objeto> objetos;
    public Inventario() {
        objetos = new ArrayList<>();
    }
    public void añadirObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    // Usar un objeto del inventario
    public void usarObjeto(int posicion, Valiente valiente) {

        if (posicion < 0 || posicion >= objetos.size()) {
            System.out.println("Posición inválida.");
            return;
        }

        Objeto objeto = objetos.get(posicion);

        // El objeto aplica su efecto
        objeto.equipar(valiente);

        // Se elimina del inventario (consumido/equipado)
        objetos.remove(posicion);
    }

    // Mostrar inventario
    public void mostrarInventario() {

        if (objetos.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        for (int i = 0; i < objetos.size(); i++) {
            System.out.println(i + " - " + objetos.get(i));
        }
    }
}
