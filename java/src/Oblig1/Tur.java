package Oblig1;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Tur {

    private Terning[] terninger;
    private String[] resultater;
    private final int max_kast = 3;
    private int runderNr;
    private Spiller spiller;
    private Scanner scanner;

    /**
     * Constructor til Tur klassen
     *
     * @param spiller  spillerene med i
     * @param runderNr
     */
    public Tur(Spiller spiller, int runderNr) {
        //Set variablene opp
        terninger = new Terning[5];
        resultater = new String[5];
        this.spiller = spiller;
        scanner = new Scanner(System.in);
        this.runderNr = runderNr;

        //Lag terningene
        for (int i = 0; i < terninger.length; i++) terninger[i] = new Terning();
    }

    /**
     * Spill en Tur i en runde. En runde kan maks ha 3 Turer per spiller
     *
     * @return Poengsummen til spilleren etter alle Turer er ferdig
     */
    public int spillTur() {
        //Informasjon om hver runde / tur
        System.out.println("Vi er på runde: " + runderNr + ", og det er **" + spiller + "** sin tur!");
        System.out.println(rundeString() + " (Eks: 1,2,5)");

        //Setter opp en kast variabel
        int kast = 0;
        while (kast < max_kast) {
            //Går gjennom alle terningene å ser  om de er gjemt eller ikke
            for (int i = 0; i < terninger.length; i++)
                //Trill bare terninger som ikke er hidden
                if (!terninger[i].isHidden()) resultater[i] = terninger[i].trillTerning();

            //Har man markert alle terninger går man utav loopen, trenger ikke flere kast
            if (allHidden()) break;
            //** UNCOMMENT HER FOR Å GJØR ALT MANUELT
            //velgTerninger(terninger);
            kast++;
        }

        //Skriv ut informasjonen til denne runden til skjermen
        int poengSum = PoengSum.bereknPoengsum(runderNr, resultater);
        System.out.println(spiller + " fikk totalt: " + poengSum + " denne runden!");
        System.out.println("\n\n");
        return poengSum;
    }

    /**
     * Prosessen til å velge ut terninger du vil ta vare på
     *
     * @param terninger alle terningene vi har
     */
    private void velgTerninger(Terning[] terninger) {
        //Begynn med å printe ut informasjonen med terningene
        printTerninger();
        String input = scanner.nextLine().replaceAll(" ", "");
        try {
            //Validerer inputen og endrer en terning
            if (input.length() != 0 && !input.contains(",")) {
                int value = (Integer.parseInt(input) - 1);
                terninger[value].setHidden(true);
            }

            //Validerer og endrer alle terningene uansett hvor mange som skal lagres
            if (input.contains(",")) {
                String splitted[] = input.split(",");
                for (String s : splitted) {
                    int value = (Integer.parseInt(s) - 1);
                    terninger[value].setHidden(true);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("That was an invalid!");
        }

    }

    /**
     * Metode for å skrive ut terningene om de er valgt eller ikke
     */
    private void printTerninger() {
        //Start en counter på terningene å skriv ut alle terningene
        int counter = 1;
        for (Terning t : terninger) {
            if (t.isHidden()) System.out.printf("*(%d):%s*\t", counter, resultater[(counter - 1)]);
            else System.out.printf("(%d):%s\t", counter, resultater[(counter - 1)]);
            counter++;
        }
        System.out.println();
    }

    /**
     * Lag en string som forteller deg hva du er på jakt etter denne runden
     *
     * @return denne runden sitt objekt
     */
    private String rundeString() {
        switch (runderNr) {
            case 1:
                return "Få så mange Løver som mulig!";
            case 2:
                return "Få så mange Slanger som mulig!";
            case 3:
                return "Få så mange Pandaer som mulig!";
            case 4:
                return "Få så mange Griser som mulig!";
            case 5:
                return "Få så mange Elefanter som mulig!";
            case 6:
                return "Få så mange Hvaler som mulig!";
            case 7:
                return "Få tre like!";
            case 8:
                return "Få fire like!";
            case 9:
                return "Få to par like!";
            case 10:
                return "Få 3 like og 2 like";
            case 11:
                return "Få alle dyrene!";
            case 12:
                return "Få alle like!";
        }
        return "";
    }

    /**
     * Se om alle terninger er hidden
     *
     * @return true if alle er hidden false viss ikke
     */
    private boolean allHidden() {
        for (Terning t : terninger) if (!t.isHidden()) return false;
        return true;
    }
}
