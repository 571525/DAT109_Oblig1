package Oblig1;

public class Spill {

    public static void main(String[] args) {
        Spillere[] spillere = new Spillere[4];

        Runde[] runder = new Runde[12];

        for (int i = 0; i < runder.length; i++) {
            runder[i] = new Runde(i, spillere);
            runder[i].nyTur();
        }
    }


}
