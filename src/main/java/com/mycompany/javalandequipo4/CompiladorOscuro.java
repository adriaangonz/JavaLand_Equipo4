package com.mycompany.javalandequipo4;

/**
 * Clase que representa al jefe final del juego, el Compilador Oscuro.
 * Posee estadísticas superiores y un escalado basado en el nivel del jugador.
 * @author Marcos
 */
public class CompiladorOscuro extends Monstruo {

    /**
     * Constructor detallado para crear un Compilador Oscuro con estadísticas específicas.
     * @author Marcos
     * @param nombre El nombre del jefe.
     * @param vida Puntos de salud iniciales.
     * @param fuerza Capacidad de daño físico.
     * @param defensa Resistencia a ataques.
     * @param habilidad Precisión y probabilidad de acierto.
     * @param velocidad Determina la iniciativa en combate.
     * @param nivel Nivel actual del jefe.
     */
    public CompiladorOscuro(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }
    
    /**
     * Constructor que genera un Compilador Oscuro escalando sus estadísticas automáticamente según el nivel.
     * @author Marcos
     * @param nivel El nivel que determina la potencia de las estadísticas base del jefe.
     */
    public CompiladorOscuro(int nivel) {
        
        int estadisticaBase = 10 + (3 * nivel);
        
        super(
                "COMPILADOR OSCURO" + nivel,
                150,
                estadisticaBase,
                estadisticaBase,
                estadisticaBase,
                estadisticaBase,
                nivel
        );

        System.out.println("EL COMPILADOR OSCURO HA APARECIDO PEGATE DE HOSTIAS CON EL Y TEN COJONES A DERROTARLE");
        System.out.println("Estadisticas: Fuerza-" + this.getFuerza() + " Defensa-" + this.getDefensa() + " Habilidad-" + this.getHabilidad() + " Velocidad-" + this.getVelocidad());
    }
}