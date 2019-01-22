package Oblig1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PoengSum {

    /**
     * Metode for å berekne poengsum
     *
     * @param rundenummer rundenummer å berekne
     * @param resultater  resultater fra terninger
     * @return poengsummen gitt runden
     */
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
     * @return 3 om du har 3 like
     */
    private static int poengRunde7(String[] resultater) {
        Arrays.sort(resultater);
        int poeng = 0;
        for (int i = 0; i < resultater.length - 1; i++)
            if (resultater[i].equals(resultater[i + 1])) poeng++;

        if (poeng >= 2) return 3;
        else return 0;
    }

    /**
     * Beregn poengsum om det finst 4 like
     *
     * @param resultater resultater fra tur klassen
     * @return 4 om du har 4 like
     */
    private static int poengRunde8(String[] resultater) {
        Arrays.sort(resultater);
        int poeng = 0;
        for (int i = 0; i < resultater.length - 1; i++) {
            if (resultater[i].equals(resultater[i + 1])) poeng++;
        }

        if (poeng >= 3) return 4;
        else return 0;
    }

    /**
     * Beregn poengsum om du har 2 par
     *
     * @param resultater resultater fra tur klassen
     * @return 4 viss 2 par ellers 0
     */
    private static int poengRunde9(String[] resultater) {
        //Lag et hashmap gruppert med antall "occurences"
        Map<String, Long> map = Arrays.stream(resultater)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        //Tell opp antall av map entries med mer en 2 i value
        int count = (int) map.entrySet().stream().filter(e -> e.getValue() >= 2).count();

        //Har du 2, har du 2 par.
        if (count == 2) return 4;
        else return 0;
    }

    /**
     * Beregn poengsum om du har 3 like og 2 like
     *
     * @param resultater resultater fra tur klassen
     * @return 5 om 3 like og 2 like, 0 viss ikke
     */
    private static int poengRunde10(String[] resultater) {
        //Lag et hashmap gruppert med antall "occurences"
        Map<String, Long> map = Arrays.stream(resultater)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        //Sjekk om vi har har en med 2 og en med 3 i value.
        int moreThan2 = (int) map.entrySet().stream().filter(e -> e.getValue() == 2).count();
        int moreThan3 = (int) map.entrySet().stream().filter(e -> e.getValue() == 3).count();

        //Er begge sanne betyr det at vi har et hus
        if (moreThan3 == 1 && moreThan2 == 1) return 5;
        else return 0;
    }

    /**
     * Beregn poengsum om du har 5 ulike
     *
     * @param resultater resultater fra tur klassen
     * @return 5 om alle er ulike
     */
    private static int poengRunde11(String[] resultater) {
        int count = (int) Arrays.stream(resultater).distinct().count();
        if (count == 5) return 5;
        else return 0;
    }

    /**
     * Bergen poengsum om du har alle like
     *
     * @param resultater resultater fra tur klassen
     * @return 10 om du har alle forskjellige og 0 viss ikke
     */
    private static int poengRunde12(String[] resultater) {
        int count = (int) Arrays.stream(resultater).distinct().count();
        if (count == 1) return 10;
        else return 0;
    }


}
