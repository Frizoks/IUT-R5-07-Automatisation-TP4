package TP4;

import junit.framework.TestCase;

public class CalculetteTest extends TestCase {

    private Calculette calculette;

    // Méthode setup
    protected void setUp() {
        calculette = new Calculette();
    }

    // Test de l'addition
    public void testAddition() {
        calculette.empiler(2.0);
        calculette.empiler(3.0);
        calculette.addition();
        assertEquals(5.0, calculette.getResultat());
    }

    // Test de la soustraction
    public void testSoustraction() {
        calculette.empiler(5.0);
        calculette.empiler(2.0);
        calculette.soustraction();
        assertEquals(3.0, calculette.getResultat());
    }

    // Test de la multiplication
    public void testMultiplication() {
        calculette.empiler(2.0);
        calculette.empiler(3.0);
        calculette.multiplication();
        assertEquals(6.0, calculette.getResultat());
    }

    // Test de la division
    public void testDivision() {
        calculette.empiler(6.0);
        calculette.empiler(3.0);
        calculette.division();
        assertEquals(2.0, calculette.getResultat());
    }

    // Test de la division par zéro
    public void testDivisionParZero() {
        calculette.empiler(6.0);
        calculette.empiler(0.0);
        try {
            calculette.division();
            fail("Devrait lancer une ArithmeticException");
        } catch (ArithmeticException e) {
            // Attendu, test réussi
        }
    }

    // Test du calcul RPN
    public void testCalculRPN() {
        double resultat = calculette.calculerRPN("1.0 3 + 2 3.2 / +");
        assertEquals(4.625, resultat, 0.001);
    }
}
