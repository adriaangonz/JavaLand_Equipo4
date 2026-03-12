/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javalandequipo4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import com.mycompany.javalandequipo4_interfaces.JuegoInterface;

/**
 * Clase principal que gestiona el flujo del juego Javaland.
 * Controla la navegación por el mapa, el inventario, los obstáculos y el combate.
 * * @author Ciro
 * 
 */
public class Juego implements JuegoInterface {

    private Mapa mapa;
    private Scanner teclado;
    private static int enemigosAsesinados;
    private GestorMonstruos gm1;
    private Combate c1;
    private Valiente valiente;
    private static int posicionX;
    private static int posicionY;
    private final Random r = new Random();
    private boolean muerto;
    private boolean victoria;
    

    // Colores para la interfaz de consola
    String RESET = "\u001B[0m";
    String CYAN = "\u001B[36m";
    String PURPLE = "\u001B[35m";
    String YELLOW = "\u001B[33m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String BOLD = "\u001B[1m";
    
    /**
     * Inicia el ciclo de vida del juego: inicialización, introducción, 
     * selección de personaje y bucle principal.
     */
    @Override
    public void iniciarJuego() {
        teclado = new Scanner(System.in);
        System.out.println(PURPLE + BOLD + "\n╔════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + BOLD + "        JAVALAND: EL COMPILADOR OSCURO          " + RESET);
        System.out.println(PURPLE + BOLD + "╚════════════════════════════════════════════╝" + RESET);

        this.posicionX = 0;
        this.posicionY = 0;
        this.victoria = false;
        this.muerto = false;
        this.gm1 = new GestorMonstruos();
        this.valiente = null;
        this.c1 = new Combate();

        // Introducción narrativa
        mostrarIntro();

        this.valiente = creacionOEleccionValiente();
        if (valiente != null) {
            this.mapa = new Mapa(false);
            mostrarMenuPrincipal();
            if (this.victoria) {
                mostrarCreditosFinales();
            }
            if (this.muerto) {
                System.out.println(RED + "Has caído en la batalla... pero el código vive en ti." + RESET);
            }
        }
    }
    
    /**
     * Muestra la introducción narrativa con un efecto de escritura.
     */
    private void mostrarIntro() {
        String intro = """
                
                \u001B[36m\u001B[1mLa Tierra de los Códigos Olvidados\u001B[0m      [Presiona ENTER para saltar]               
                
                En los remotos confines del Reino Digital, donde los algoritmos susurran antiguos
                secretos y los bucles se entrelazan como místicas serpientes, se extiende un mundo
                al borde del colapso. Los bytes se desmoronan, los lenguajes de programación luchan
                por sobrevivir, y una sombra inmensa amenaza con borrar toda la memoria: el
                Compilador Oscuro.

                Este no es un mundo para programadores débiles. Aquí, cada valiente es un guerrero
                del código, cada misión una batalla contra la entropía digital. Tu misión: reunir un
                equipo de valientes, dominar tus habilidades de programación, y derrotar al ser que
                amenaza con fragmentar la realidad misma.

                Programa por programa, función por función, línea por línea, construirás la resistencia
                que salvará este reino. ¿Serás capaz de escribir el código que cambiará la historia?

                El Compilador Oscuro te espera. ¡Que comience la compilación!
                """;

        boolean saltar = false;

        for (char c : intro.toCharArray()) {
            System.out.print(c);
            try {
                if (!saltar && System.in.available() > 0) {
                    saltar = true;
                    System.in.read(); 
                }
                if (!saltar) {
                    Thread.sleep(18);
                }
            } catch (Exception e) {}
        }
        System.out.println(); 
        System.out.println("\n\n" + PURPLE + "Presiona ENTER para comenzar tu aventura..." + RESET);
        new Scanner(System.in).nextLine();
    }
    
    /**
     * Muestra una animación ASCII y texto al cambiar de sector a través de un portal.
     * @author saul
     */
    private void mostrarTransicionPortal() {
        String tituloAscii = """
        
        \u001B[35m      _____  ____  _____  _______  _       _      
             |  __ \\|  _ \\|  __ \\|__   __|/\\     | |     
             | |__) | | | | |__) |  | |  /  \\    | |     
             |  ___/| | | |  _  /   | | / /\\ \\   | |     
             | |    | |_| | | \\ \\   | |/ ____ \\  | |____ 
             |_|    |____/|_|  \\_\\  |_/_/    \\_\\ |______|
        \u001B[0m
        """;

        String historiaPortal = """
            
            \u001B[36m\u001B[1m¡HAS CRUZADO EL UMBRAL!\u001B[0m
            
            De repente, el suelo bajo tus pies se convierte en puro flujo de datos. 
            El portal [0] brilla con una intensidad cegadora, absorbiendo cada 
            segmento de tu código fuente.
            
            Sientes cómo tus variables se reasignan y tu stack de memoria se expande.
            Has superado las pruebas básicas de la terminal, pero el Compilador 
            Oscuro ha detectado tu intrusión y está reforzando los firewalls.
            
            \u001B[33mEntrando en el SECTOR 2: El Núcleo de la CPU...\u001B[0m
            """;

        for (String linea : tituloAscii.split("\n")) {
            System.out.println(linea);
            try { Thread.sleep(150); } catch (Exception e) {}
        }

        boolean saltar = false;
        for (char c : historiaPortal.toCharArray()) {
            System.out.print(c);
            try {
                if (!saltar && System.in.available() > 0) {
                    saltar = true;
                    System.in.read();
                }
                if (!saltar) { Thread.sleep(20); }
            } catch (Exception e) {}
        }
        System.out.println("\n\n" + PURPLE + "Recompilando realidad... Presiona ENTER" + RESET);
        teclado.nextLine();
    }
    
    /**
     * Muestra la historia final y los créditos con los nombres de los desarrolladores.
     * @author saul
     */
    private void mostrarCreditosFinales() {
        String historiaFinal = """
        
        \u001B[32m\u001B[1m[ SISTEMA RECOMPILADO CON ÉXITO ]\u001B[0m
        
        El Compilador Oscuro se disuelve en un mar de excepciones no controladas.
        La fragmentación digital se detiene y los bytes vuelven a su estado original.
        Javaland vuelve a ser un lugar de sintaxis limpia y lógica perfecta.
        
        Gracias a tu valentía, el código fuente de la realidad ha sido salvado.
        Tu nombre será recordado en cada comentario de cada programa futuro.
        
        """;

        for (char c : historiaFinal.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(30); } catch (Exception e) {}
        }

        System.out.println("\n" + YELLOW + "Presiona ENTER para ver a los arquitectos de este mundo..." + RESET);
        teclado.nextLine();

        String[] creditos = {
            "", "", "",
            PURPLE + "╔════════════════════════════════════╗" + RESET,
            PURPLE + "║           EQUIPO 4 PRESENTA        ║" + RESET,
            PURPLE + "╚════════════════════════════════════╝" + RESET,
            "",
            CYAN + "      SAUL - Master of Logic" + RESET,
            CYAN + "      ADRIAN - Byte Commander" + RESET,
            CYAN + "      MARCOS - Syntax Guardian" + RESET,
            CYAN + "       CIRO - Bug Destroyer" + RESET,
            "",
            YELLOW + "      GRACIAS POR JUGAR JAVALAND" + RESET,
            "", "", ""
        };

        String arteVictoria = """
        
        \u001B[31m           [ LA CAÍDA DEL COMPILADOR OSCURO ]\u001B[0m
            
            \u001B[31m          .      .          .      .          \u001B[0m
            \u001B[31m       .      .     /\\[ ]/\\      .      .    \u001B[0m
            \u001B[31m     .      .      /  ---  \\      .      .    \u001B[0m
            \u001B[31m           .      < <( X )> >    .      .      \u001B[0m
            \u001B[31m       .      .    \\  ---  /      .      .      \u001B[0m
            \u001B[31m     .      .       \\[___]/       .      .      \u001B[0m
            \u001B[31m           .         /     \\         .      .      \u001B[0m
            \u001B[31m       .            /       \\            .     \u001B[0m
            \u001B[31m                  V V V V V V            .      .\u001B[0m
            \u001B[31m          .      .           .      .          .\u001B[0m
        
        \u001B[32m       [ SAUL ]    [ ADRIAN ]    [ MARCOS ]    [ CIRO ]\u001B[0m
        \u001B[32m          O           O             O            O\u001B[0m
        \u001B[32m         /|\\         /|\\           /|\\          /|\\\u001B[0m
        \u001B[32m         / \\         / \\           / \\          / \\\u001B[0m
        
        \u001B[36m    [ LOGIC ]   [ BYTES ]     [ SYNTAX ]   [ BUGS ]\u001B[0m
        \u001B[36m    [ MASTER ]  [ COMMANDER ] [ GUARDIAN ] [ DESTROYER ]\u001B[0m
        """;

        for (String linea : creditos) {
            System.out.println("\t\t" + linea);
            try { Thread.sleep(400); } catch (Exception e) {}
        }
        for (String linea : arteVictoria.split("\n")) {
            System.out.println(linea);
            try { Thread.sleep(200); } catch (Exception e) {}
        }
    }
    
    /**
     * Gestiona el menú de creación o elección del personaje Valiente.
     * * @return El objeto {@link Valiente} con el que se jugará la partida.
     * @author saul
     */
    @Override
    public Valiente creacionOEleccionValiente() {
        try {
            this.valiente = null;
            int opcion = 0;

            System.out.println(PURPLE + BOLD + "\n╔════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + BOLD + "        ELIGE TU VALIENTE           " + RESET);
            System.out.println(PURPLE + BOLD + "╚════════════════════════════════════╝" + RESET);

            System.out.println(YELLOW + "1 - Valiente Personalizado" + RESET);
            System.out.println(YELLOW + "2 - Valientes Iniciales" + RESET);

            System.out.print(CYAN + "\nElige una opción: " + RESET);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println(GREEN + "Creando Valiente personalizado..." + RESET);
                    this.valiente = new Valiente();
                }
                case 2 -> {
                    this.valiente = new GestorValientes().crearValientesIniciales();
                }
                default -> {
                    System.out.println(RED + "Esa no es una opción válida." + RESET);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(RED + "Eso no es un número válido." + RESET);
            teclado.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(RED + "Ese no es un Valiente." + RESET);
        }
        return valiente;
    }
    
    /**
     * Muestra las estadísticas actuales del personaje y el progreso en el mapa.
     * @author saul
     */
    @Override
    public void mostrarEstadoJuego() {
        System.out.println(BOLD + YELLOW + "\n ESTADO DEL JUEGO" + RESET);
        System.out.println(valiente);
        System.out.println("Objetos restantes: " + mapa.getObjetos());
        System.out.println("Monstruos restantes: " + mapa.getMonstruos());
    }
    
    /**
     * Inicia el proceso de exploración del mapa.
     * @author saul
     */
    @Override
    public void mostrarMenuPrincipal() {
        explorarMapa();
    }
    
    /**
     * Muestra por consola los datos del valiente actual.
     */
    private void mostrarValiente() {
        System.out.println(this.valiente.toString());
    }
    
    /**
     * Abre el inventario y permite al usuario equipar o usar un objeto mediante su índice.
     * @author ciro
     */
    private void equiparObjeto() {
        System.out.println(GREEN + "Mostrando inventario..." + RESET);
        valiente.getInventario().mostrarInventario();
        System.out.println(CYAN + "Introduce el número del SLOT (0-3) para equipar/usar, o n para volver:" + RESET); 
        String opcion = teclado.nextLine();
        if (!opcion.equalsIgnoreCase("n")) {
            valiente.getInventario().usarObjeto(opcion, valiente);
        }
    }
    
    /**
     * Renderiza el mapa en consola, mostrando solo las casillas visibles o adyacentes.
     * @author ciro
     */
    private void mostrarMapa() {
        for (int i = 0; i < this.mapa.getAlto(); i++) {
            for (int j = 0; j < this.mapa.getAncho(); j++) {
                if (casillasAdyacentes(j, i)) {
                    System.out.print(this.mapa.getCasillas()[i][j]);
                } else {
                    if(mapa.isNether()){
                        System.out.print(RED +"[x]"+ RESET);
                    }
                    else{
                        System.out.print("[x]");
                    }
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Valida si el movimiento solicitado está dentro de los límites del mapa.
     * * @param coordenada 1 para eje X, diferente para eje Y.
     * @param direccion 1 para positivo (abajo/derecha), diferente para negativo (arriba/izquierda).
     * @return true si el movimiento es válido, false en caso contrario.
     * @author ciro
     */
    public boolean movimientoValido(int coordenada, int direccion) {
        boolean validacion;
        if (coordenada == 1) {
            if (direccion == 1) {
                validacion = posicionX - 1 >= 0;
            } else {
                validacion = posicionX < mapa.getAlto() - 1;
            }
        } else {
            if (direccion == 1) {
                validacion = posicionY < mapa.getAncho() - 1;
            } else {
                validacion = posicionY - 1 >= 0;
            }
        }
        return validacion;
    }
    
    /**
     * Determina si una casilla es visible para el jugador (si ya fue visitada o es adyacente).
     * * @param fila Coordenada Y de la casilla.
     * @param columna Coordenada X de la casilla.
     * @return true si la casilla es visible, false de lo contrario.
     * @author ciro
     */
    public boolean casillasAdyacentes(int fila, int columna) {
        return mapa.esVisible(fila, columna)
                || posicionY + 1 == fila && columna == posicionX
                || posicionY - 1 == fila && columna == posicionX
                || fila == posicionY && posicionX + 1 == columna
                || fila == posicionY && posicionX - 1 == columna
                || fila == posicionY && columna == posicionX;
    }
    
    /**
     * Bucle principal de exploración. Gestiona el input de movimiento y eventos del mapa.
     * @author ciro
     */
    @Override
    public void explorarMapa() {
        String opcion = "";
        do {
            try {
                mostrarMapa();
                System.out.println(BOLD + "───────────────────────────────" + RESET);
                System.out.println(CYAN + "[W/A/S/D] " + RESET + "Moverse | "
                        + YELLOW + "[E] " + RESET + "Estado | "
                        + GREEN + "[I] " + RESET + "Items | "
                        + RED + "[Q] " + RESET + "Salir");
                System.out.print("Comando: ");

                opcion = teclado.next().substring(0, 1).toLowerCase();
                teclado.nextLine();

                switch (opcion) {
                    case "w" -> {
                        if (movimientoValido(1, 1)&&hayObstaculo(posicionX-1,posicionY)) {
                            mapa.setCasilla(posicionY, posicionX, BOLD + "[ ]" + RESET);
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionX--;
                        } else {
                            System.out.println(RED + "No puedes atravesarlo" + RESET);
                        }
                    }
                    case "a" -> {
                        if (movimientoValido(-1, -1)&&hayObstaculo(posicionX,posicionY-1)) {
                            mapa.setCasilla(posicionY, posicionX, BOLD + "[ ]" + RESET);
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionY--;
                        } else {
                            System.out.println(RED + "No puedes atravesarlo" + RESET);
                        }
                    }
                    case "s" -> {
                        if (movimientoValido(1, -1)&&hayObstaculo(posicionX+1,posicionY)) {
                            mapa.setCasilla(posicionY, posicionX, BOLD + "[ ]" + RESET);
                            mapa.setVisible(posicionY, posicionX);
                            this.posicionX++;
                        } else {
                            System.out.println(RED + "No puedes atravesarlo" + RESET);
                        }
                    }
                    case "d" -> {
                        if (movimientoValido(-1, 1)&&hayObstaculo(posicionX,posicionY+1)) {
                            mapa.setCasilla(posicionY, posicionX, BOLD + "[ ]" + RESET);
                            mapa.setVisible(posicionY, posicionX);
                            posicionY++;
                        } else {
                            System.out.println(RED + "No puedes atravesarlo" + RESET);
                        }
                    }
                    case "e" -> mostrarEstadoJuego();
                    case "i" -> equiparObjeto();
                    case "q" -> System.out.println(RED + "Saliendo..." + RESET);
                    default -> System.out.println(RED + "Acción no reconocida." + RESET);
                }

                if ("wasd".contains(opcion)) {
                    // Evento Objeto [?]
                    if (mapa.getCasillas()[posicionX][posicionY].equals(GREEN + "[?]" + RESET)) {
                        Objeto objetoEncontrado = GeneradorObjetos.generarLootAleatorio();
                        System.out.println("\n" + YELLOW + "╔════════════════════════════════════╗" + RESET);
                        System.out.println(YELLOW + "║         ¡OBJETO ENCONTRADO!        ║" + RESET);
                        System.out.println(YELLOW + "╚════════════════════════════════════╝" + RESET);
                        System.out.println("Has encontrado: " + BOLD + objetoEncontrado.getNombre() + RESET);
                        System.out.println("Tipo: " + objetoEncontrado.getTipo() + " | Poder: " + objetoEncontrado.getValor());

                        this.valiente.getInventario().agregarObjeto(objetoEncontrado);
                        mapa.setObjetos(mapa.getObjetos() - 1);
                        mapa.setCasilla(posicionY, posicionX, BOLD + "[ ]" + RESET);
                    }
                    // Evento Monstruo [!]
                    if (mapa.getCasillas()[posicionX][posicionY].equals(RED + "[!]" + RESET)) {
                        int nivel = posicionY > posicionX ? posicionY : posicionX;
                        if(this.c1.iniciarCombate(valiente, gm1.generarMonstruos(nivel))){
                            mapa.setMonstruos(mapa.getMonstruos() - 1);
                            enemigosAsesinados++;
                        } else {
                            this.muerto=true;
                        }
                    }
                    // Evento Portal [0]
                    if (mapa.getCasillas()[posicionX][posicionY].equals(CYAN + "[0]" + RESET)) {
                        mostrarTransicionPortal();
                        mapa = new Mapa(true);
                        this.posicionX = 0;
                        this.posicionY = 0;
                    }
                    // Evento Boss [#]
                    if (mapa.getCasillas()[posicionX][posicionY].equals(PURPLE + "[#]" + RESET)) {
                        System.out.println(RED + "El aire se torna oscuro... El Compilador Oscuro aparece." + RESET);
                        if(this.c1.iniciarCombate(valiente, new CompiladorOscuro(enemigosAsesinados))){
                            this.victoria = true;
                        } else {
                            this.muerto=true;
                        }
                    }
                    mapa.setCasilla(posicionY, posicionX, YELLOW + "[*]" + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Eso no es un movimiento válido." + RESET);
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println(RED + "Error: " + e.getMessage() + RESET);
            }
        } while (!opcion.equals("q") && !victoria && !muerto);
    }
    
    /**
     * Verifica si hay un obstáculo en la posición y si el Valiente tiene las estadísticas necesarias para superarlo.
     * * @param posicionX Coordenada X a comprobar.
     * @param posicionY Coordenada Y a comprobar.
     * @return true si no hay obstáculo o si el obstáculo ha sido superado; false si el paso está bloqueado.
     * @author ciro
     */
    public boolean hayObstaculo(int posicionX,int posicionY){
        boolean superado=true;
        // Obstáculo Muro
        if (mapa.getCasillas()[posicionX][posicionY].equals(RED + "[/]" + RESET)){
            if(valiente.getFuerza()<15){
                System.out.println("No puedes romper el muro");
                superado=false;
            } else {
                System.out.println("Has partido el muro");
            }
        }
        // Obstáculo Árbol
        if (mapa.getCasillas()[posicionX][posicionY].equals(GREEN + "[♣]" + RESET)){
            if(valiente.getHabilidad()<16){
                System.out.println("No puedes escalar el arbol");
                superado=false;
            } else {
                System.out.println("Has escalado el arbol");
            }
        }
        // Obstáculo Roca
        if (mapa.getCasillas()[posicionX][posicionY].equals(BOLD + "[●]" + RESET)){
            if(valiente.getDefensa()<14){
                System.out.println("No puedes pasar la roca");
                superado=false;
            } else {
                System.out.println("Has partido la roca");
            }
        }
        // Obstáculo Río
        if (mapa.getCasillas()[posicionX][posicionY].equals(CYAN+ "[≈]" + RESET)){
            if(valiente.getVelocidad()<16){
                System.out.println("No puedes cruzar el rio");
                superado=false;
            } else {
                System.out.println("Has cruzado el rio");
            }
        }
        return superado;
    }
}