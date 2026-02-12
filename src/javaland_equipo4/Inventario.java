/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaland_equipo4;

import javaland_interfaces.InventarioInterface;

/**
 *
 * @author diego
 */
public class Inventario implements InventarioInterface {

    Objeto[] inventario = new Objeto[4];

    @Override
    public void agregarObjeto(Objeto obj) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) {
                inventario[i] = obj;
                System.out.println("Objeto agregado");
                break;
            }
        }
    }

    @Override
    public void usarObjeto(String nombre, Valiente valiente) {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i].getNombre().equals(nombre)) {
                switch (inventario[i].getTipo()) {
                    case "Arma":
                        inventario[i].equipar(valiente);
                        inventario[i] = null;
                        System.out.println(nombre + " se ha añadido en la pos " + i);
                        break;
                    case "Escudo":
                        inventario[i].equipar(valiente);
                        inventario[i] = null;
                        System.out.println(nombre + " se ha añadido en la pos " + i);
                        break;
                    case "Planta":
                        inventario[i].equipar(valiente);
                        System.out.println("Has usado " + nombre);
                        break;
                }
                break;
            }
        }
    }

    @Override
    public void mostrarInventario() {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                System.out.println(inventario[i].getNombre() + " - ");
            }
        }
    }
}
