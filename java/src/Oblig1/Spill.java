package Oblig1;

import java.util.Arrays;
import java.util.Collections;

public class Spill {

    private Spiller[] spillere;
    private Runde[] runder;
    private final int MAX_PLAYERS = 5, MIN_PLAYERS = 2;
    private int spillerTotalScore[];
    private String[] farger = {"Gul", "Grå", "Grøn", "Rød", "Blå"};

    /**
     * Konstruktør for spillere
     *
     * @param antallSpillere antall spillere du ønsker
     */
    public Spill(int antallSpillere) {
        //Stopper for muligheten til å lage et spill med feil antall spillere
        if (antallSpillere < MIN_PLAYERS) antallSpillere = 2;
        if (antallSpillere > MAX_PLAYERS) antallSpillere = 5;

        spillere = new Spiller[antallSpillere];
        spillerTotalScore = new int[antallSpillere];
        runder = new Runde[12];
        lagSpillerOgRunder();
    }

    /**
     * Metode for å lage spillere og runder for alle i arrayet
     */
    private void lagSpillerOgRunder() {
        //Set fargene i forskjellige rekkefølger så de ikke blir like hver gang
        Collections.shuffle(Arrays.asList(farger));

        //Lag spillere med farger
        for (int i = 0; i < spillere.length; i++) spillere[i] = new Spiller(farger[i]);

        //Lag runder med nett lagde spillere
        for (int i = 0; i < runder.length; i++) runder[i] = new Runde(i, spillere);

    }

    /**
     * En metode for å starte spillet
     */
    public void start() {
        //Start en runde
        for (Runde runde : runder) runde.nyTur();
    }


    /**
     * Metode til å skrive ut scoren av rundene
     */
    public void skrivUtScore() {
        for (Runde runde : runder) {
            summerScore(runde);
            runde.printPoengRunde();
        }

        skrivUtTotalScore();
        System.out.println("Vinneren av spillet er: " + finnVinner());
    }

    /**
     * Metode for å skrive ut den totale scoren på alle rundene
     */
    private void skrivUtTotalScore() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Totalt ser det slik ut:");
        for (int i = 1; i <= spillere.length; i++) System.out.printf("%s\t", spillere[i - 1]);
        System.out.println();
        for (int i = 0; i < spillere.length; i++) System.out.printf("\t\t%d\t\t", spillerTotalScore[i]);
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    /**
     * Metode for å summere spillescoren til alle spillerene i alle rundene
     *
     * @param runde runde vi skal legge til
     */
    private void summerScore(Runde runde) {
        int rundeScore[] = runde.getPoengFromRunde();
        for (int i = 0; i < spillerTotalScore.length; i++) spillerTotalScore[i] += rundeScore[i];

    }

    /**
     * Finn vinneren med høyest score, velger bare den første om flere har samme score!
     *
     * @return en av de med mest poeng
     */
    private Spiller finnVinner() {
        int maxScore = 0;
        int vinnerIndex = 0;
        for (int i = 0; i < spillere.length; i++) {
            if (spillerTotalScore[i] > maxScore) {
                maxScore = spillerTotalScore[i];
                vinnerIndex = i;
            }
        }
        return spillere[vinnerIndex];
    }

    /**
     * Metode for å skrive ut alle spillerene som er valgt
     */
    public void skrivUtSpillere() {
        System.out.println("\n" + "Her er spillerne i spillet:" + "\n");
        for (Spiller s : spillere) {
            System.out.println(s.toString());
        }
        System.out.println();
    }

    /**
     * Metode for å skrive ut alle regler
     */
    public void skrivUtRegler() {
        System.out.println(
                "Spillet består av 12 runder. Hver runde har hver spiller 3 terningkast til å få så mange poeng som muligt."
                        + "\n" + "For å gå videre i spillet eller trille terningerne tryk 'Enter'."
                        + "\n" + "For å velge terninger og gjemme dem skriv terningnummer, er der flere så adskill med ','." +
                        "\n" + "Om du vil trille gjemte terninger, skriv inn nummeret på terningen igjen!"
                        + "\n\n" + "LYKKE TIL!");
    }
}
