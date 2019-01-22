import Oblig1.PoengSum;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PoengTest {

    private String resultat[] = new String[]{"Løve", "Elefant", "Slange", "Løve", "Løve"};

    @Test
    public void checkPoengSumRunde1() {
        assertEquals(3, PoengSum.bereknPoengsum(1, resultat));
    }

    @Test
    public void checkPoengSumRunde2() {
        assertEquals(1, PoengSum.bereknPoengsum(2, resultat));
    }

    @Test
    public void checkPoengSumRunde3() {
        assertEquals(0, PoengSum.bereknPoengsum(3, resultat));
    }

    @Test
    public void checkPoengSumRunde4() {
        assertEquals(0, PoengSum.bereknPoengsum(4, resultat));
    }

    @Test
    public void checkPoengSumRunde5() {
        assertEquals(1, PoengSum.bereknPoengsum(5, resultat));
    }


    @Test
    public void checkPoengSumRunde6() {
        assertEquals(0, PoengSum.bereknPoengsum(6, resultat));
    }


    @Test
    public void checkPoengSumRunde7() {
        assertEquals(3, PoengSum.bereknPoengsum(7, resultat));
    }

    @Test
    public void checkPoengSumRunde8() {
        String[] resultat = {"Hval", "Hval", "Slange", "Hval", "Hval"};
        assertEquals(4, PoengSum.bereknPoengsum(8, resultat));
    }

    @Test
    public void checkPoengSumRunde9() {
        String[] resultat = {"Hval", "Slange", "Slange", "Hval", "Slange"};
        assertEquals(4, PoengSum.bereknPoengsum(9, resultat));
    }

    @Test
    public void checkPoengSumRunde10() {
        String[] resultat = {"Slange", "Slange", "Gris", "Slange", "Gris"};
        assertEquals(5, PoengSum.bereknPoengsum(10, resultat));
    }

    @Test
    public void checkPoengSumRunde11() {
        String[] resultat = {"Panda", "Hval", "Elefant", "Slange", "Gris"};
        assertEquals(5, PoengSum.bereknPoengsum(11, resultat));
    }

    @Test
    public void checkPoengSumRunde12() {
        String[] resultat = {"Slange", "Slange", "Slange", "Slange", "Slange"};
        assertEquals(10, PoengSum.bereknPoengsum(12, resultat));
    }
}
