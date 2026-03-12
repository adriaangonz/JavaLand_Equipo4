/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package javaland_equipo4;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DAM115
 */
public class CombateTest {
    private Personaje valiente;
    private Personaje monstruo;
    private Combate instance;
    public CombateTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        instance = new Combate();
        valiente = new Valiente("Donald Trump", 100, 10, 0, 10, 10, 1);
        monstruo = new Monstruo("Jeffrey Epstein", 100, 10, 10, 100, 10, 1);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of turno method, of class Combate.
     */
    @Test
    public void testTurno() {
        System.out.println("turno");
        Personaje atacante = monstruo;
        Personaje defensor = valiente;
        int vidaInicial= valiente.getVida();
        instance.turno(atacante, defensor);
        assertTrue(defensor.getVida() < vidaInicial);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void testTurnoFallo() {
        monstruo.setHabilidad(0);
        valiente.setDefensa(100);
        int vidaInicial = valiente.getVida();
        instance.turno(monstruo, valiente);
        assertEquals(vidaInicial, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }



    
}
