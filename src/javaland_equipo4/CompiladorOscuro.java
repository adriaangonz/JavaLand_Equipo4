
package javaland_equipo4;

import java.util.Random;

public class CompiladorOscuro extends Personaje {

    private static final Random random = new Random();
    private static final int VIDA_FIJA = 150;

    public CompiladorOscuro(int nivel, int monstruosGenerados) {
        super(
            "Compilador Oscuro",
            VIDA_FIJA,                           //vida
            3 * monstruosGenerados,              //fuerza
            3 * monstruosGenerados,              //defensa
            3 * monstruosGenerados,              //habilidad
            3 * monstruosGenerados,              //velocidad
            nivel
        );

        if (monstruosGenerados == 0) { //estadisticas por si no se generan monstruos
            this.setFuerza(30);
            this.setDefensa(30);
            this.setHabilidad(30);
            this.setVelocidad(30);
        }

        System.out.println("¡EL COMPILADOR OSCURO HA APARECIDO!");
        System.out.printf("Monstruos generados hasta ahora: %d%n", monstruosGenerados);
        System.out.printf("Estadísticas: Fuerza %d | Defensa %d | Habilidad %d%% | Velocidad %d | Vida %d%n",
                getFuerza(), getDefensa(), getHabilidad(), getVelocidad(), getVida());
    }

    public void colocarEnEsquinaOpuesta(Mapa mapa, int posValienteY, int posValienteX) {
        int alto  = mapa.getAlto();
        int ancho = mapa.getAncho();

        int[][] esquinas = {
            {0, 0},
            {0, ancho - 1},
            {alto - 1, 0},
            {alto - 1, ancho - 1}
        };

        int mejorY = 0;
        int mejorX = 0;
        int maximaDistancia = -1;

        for (int[] esquina : esquinas) {
            int dy = Math.abs(esquina[0] - posValienteY);
            int dx = Math.abs(esquina[1] - posValienteX);
            int distancia = dx + dy;

            if (distancia > maximaDistancia) {
                maximaDistancia = distancia;
                mejorY = esquina[0];
                mejorX = esquina[1];
            }
        }

        mapa.setCasilla(mejorY, mejorX, "[C]");

        System.out.printf("%s colocado en [%d,%d] (distancia Manhattan: %d)%n",
                          getNombre(), mejorY, mejorX, maximaDistancia);
    }

    @Override
    public <T> double atacar(T objetivo) {
        if (!(objetivo instanceof Valiente)) {
            System.out.println("El Compilador Oscuro solo ataca a Valientes.");
            return 0;
        }

        Valiente valiente = (Valiente) objetivo;

        int probAcierto = this.getHabilidad();

        probAcierto = Math.min(95, probAcierto);

        boolean acierta = random.nextInt(100) < probAcierto;

        if (!acierta) {
            System.out.println(this.getNombre() + " falla el ataque... ¡Error de sintaxis detectado!");
            return 0;
        }

        int danio = this.getFuerza();

        if (valiente.getEscudo() != null) {
            danio -= valiente.getEscudo().getDefensa();
        }

        danio -= valiente.getDefensa();

        danio = Math.max(1, danio);

        System.out.println(this.getNombre() + " causa " + danio + " puntos de daño a "
                          + valiente.getNombre() + " (acierto con " + probAcierto + "%).");

        return danio;
    }

    @Override
    public void recibirDaño(int cantidad) {
        int danioReal = cantidad - (this.getDefensa() / 3);
        danioReal = Math.max(1, danioReal);

        int nuevaVida = this.getVida() - danioReal;
        this.setVida(nuevaVida);

        if (nuevaVida <= 0) {
            System.out.println("¡El Compilador Oscuro ha sido derrotado!");
        } else {
            System.out.println(this.getNombre() + " recibe " + danioReal
                              + " daño. Vida restante: " + nuevaVida);
        }
    }

    public void dropearRecompensa(Valiente valiente) {
        System.out.println("Felicidades, Derrotaste al Compilador Oscuro y salvaste JavaLand");
    }
}