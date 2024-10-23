package TP4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculetteTest {

    private Calculette calculette;

    @BeforeEach
    public void setUp() {
        calculette = new Calculette();
    }

    @Test
    public void testAddition() {
        calculette.empiler(2.0);
        calculette.empiler(3.0);
        calculette.addition();
        assertEquals(5.0, calculette.getResultat());
    }

    @Test
    public void testSoustraction() {
        calculette.empiler(5.0);
        calculette.empiler(2.0);
        calculette.soustraction();
        assertEquals(3.0, calculette.getResultat());
    }

    @Test
    public void testMultiplication() {
        calculette.empiler(2.0);
        calculette.empiler(3.0);
        calculette.multiplication();
        assertEquals(6.0, calculette.getResultat());
    }

    @Test
    public void testDivision() {
        calculette.empiler(6.0);
        calculette.empiler(3.0);
        calculette.division();
        assertEquals(2.0, calculette.getResultat());
    }

    @Test
    public void testDivisionParZero() {
        calculette.empiler(6.0);
        calculette.empiler(0.0);
        assertThrows(ArithmeticException.class, () -> calculette.division());
    }

    @Test
    public void testCalculRPN() {
        double resultat = calculette.calculerRPN("1.0 3 + 2 3.2 / +");
        assertEquals(5.625, resultat);
    }
}
