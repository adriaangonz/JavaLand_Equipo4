package javaland_equipo4;

public class CompiladorOscuro extends Monstruo {

    public CompiladorOscuro(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        super(nombre, vida, fuerza, defensa, habilidad, velocidad, nivel);
    }
    
    /**
     * 
     * @param nivel nivel del compilador
     * Constructor del compilador oscuro
     */
    public CompiladorOscuro(int nivel) {
        super(
                "COMPILADOR OSCURO" + nivel,
                150,
                3 * GestorMonstruos.getContadorMonstruos(),
                3 * GestorMonstruos.getContadorMonstruos(),
                3 * GestorMonstruos.getContadorMonstruos(),
                3 * GestorMonstruos.getContadorMonstruos(),
                nivel
        );

        System.out.println("EL COMPILADOR OSCURO HA APARECIDO PEGATE DE OSTIAS CON EL Y TEN COJONES A DERROTARLE");
        System.out.println("Estadisticas: Fuerza-" + this.getFuerza() + " Defensa-" + this.getDefensa() + " Habilidad-" + this.getHabilidad() + " Velocidad-" + this.getVelocidad());
    }
}
