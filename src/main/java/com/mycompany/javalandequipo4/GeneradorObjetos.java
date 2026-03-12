package com.mycompany.javalandequipo4;

import java.util.Random;

/**
 * Clase encargada de la generación de loot aleatorio (Armas, Escudos y Plantas).
 * @author Saul
 */
public class GeneradorObjetos {
    private static final Random r = new Random();
    
    // --- CATÁLOGO DE ARMAS ---
    private static final Arma[] poolArmas = {
        new Arma("Rama de Árbol", "Arma", 5, 0),        
        new Arma("Puntero Oxidado", "Arma", 8, 0),     
        new Arma("Daga del Vampiro", "Arma", 15, 1),    // Vampirismo
        new Arma("Filo Crítico.exe", "Arma", 20, 2),   // Crítico 30%
        new Arma("Espada Acumuladora", "Arma", 12, 3) // Atk Permanente
    };

    // --- CATÁLOGO DE ESCUDOS ---
    private static final Escudo[] poolEscudos = {
        new Escudo("Tapa de Alcantarilla", "Escudo", 3, 0), 
        new Escudo("Cartón Mojado", "Escudo", 1, 0),        
        new Escudo("Muro de Espinas", "Escudo", 10, 4),      // Espinas
        new Escudo("Armadura de Mipalo", "Escudo", 12, 5), // Restos
        new Escudo("Escudo de Admin", "Escudo", 25, 6)      // Daño / 2
    };

    /**
     * Devuelve un objeto totalmente aleatorio entre armas, escudos y plantas basándose en probabilidades.
     * @author Saul
     * @return Un objeto de tipo Planta (40%), Escudo (30%) o Arma (30%) seleccionado al azar.
     */
    public static Objeto generarLootAleatorio() {
        int suerte = r.nextInt(100);

        if (suerte < 40) { // 40% probabilidad de encontrar Marihuana
            return new Planta("Cogollo Curativo", "Curativo", 25, 0);
        } else if (suerte < 70) { // 30% probabilidad de Escudo
            return poolEscudos[r.nextInt(poolEscudos.length)];
        } else { // 30% probabilidad de Arma
            return poolArmas[r.nextInt(poolArmas.length)];
        }
    }
}