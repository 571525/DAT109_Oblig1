package Oblig1;

import java.util.Arrays;
import java.util.Collections;

public class PoengSum {

    public static int bereknPoengsum(int rundenummer, String[] resultater) {

        switch (rundenummer) {
            case 1:
                return poengRunde1(resultater);
            case 2:
                return poengRunde2(resultater);
            case 3:
                return poengRunde3(resultater);
            case 4:
                return poengRunde4(resultater);
            case 5:
                return poengRunde5(resultater);
            case 6:
                return poengRunde6(resultater);
            case 7:
                return poengRunde7(resultater);
            case 8:
                return poengRunde8(resultater);
            case 9:
                return poengRunde9(resultater);
            case 10:
                return poengRunde10(resultater);
            case 11:
                return poengRunde11(resultater);
            case 12:
                return poengRunde12(resultater);
        }

        return 0;
    }

    /**
     * Berekn poengsum for antall løver
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall løver fra resultatene
     */
    private static int poengRunde1(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Løve")).count();
    }

    /**
     * Berekn poengsum for antall Slanger
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall slanger fra resultatene
     */
    private static int poengRunde2(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Slange")).count();
    }

    /**
     * Berekn poengsum for antall panda
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall panda fra resultatene
     */
    private static int poengRunde3(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Panda")).count();
    }

    /**
     * Berekn poengsum for antall gris
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall gris fra resultatene
     */
    private static int poengRunde4(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Gris")).count();
    }

    /**
     * Berekn poengsum for antall elefant
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall elefant fra resultatene
     */
    private static int poengRunde5(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Elefant")).count();
    }

    /**
     * Berekn poengsum for antall hval
     *
     * @param resultater resultater fått fra tur klassen
     * @return antall hval fra resultatene
     */
    private static int poengRunde6(String[] resultater) {
        return (int) Arrays.stream(resultater).filter(e -> e.equals("Hval")).count();
    }

    /**
     * Beregn poengsum om det finst 3 like
     *
     * @param resultater resultater fra tur klassen
     * @return om du
     */
    private static int poengRunde7(String[] resultater) {
        Arrays.sort(resultater);
        int poeng = 0;
        for (int i = 0; i < resultater.length - 1; i++)
            if (resultater[i].equals(resultater[i + 1])) poeng++;

        if (poeng >= 2) return 3;
        return 0;
    }

    private static int poengRunde8(String[] resultater) {
        Arrays.sort(resultater);
        int poeng = 0;
        for (int i = 0; i < resultater.length - 1; i++) {
            if (resultater[i].equals(resultater[i + 1])) poeng++;
        }

        if (poeng >= 3) return 4;
        return 0;
    }

    private static int poengRunde9(String[] resultater) {
        return 0;
    }

    private static int poengRunde10(String[] resultater) {
        return 0;
    }

    private static int poengRunde11(String[] resultater) {
        return 0;
    }

    private static int poengRunde12(String[] resultater) {
        return 0;
    }


}
