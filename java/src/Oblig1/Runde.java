package Oblig1;

public class Runde {

    private Spillere[] spillere;
    private int rundeNr;
    private int[] poeng;

    public Runde(int rundeNr, Spillere[] spillere) {
        this.spillere = spillere;
        this.rundeNr = rundeNr;

        poeng = new int[spillere.length];
    }

    /**
     *
     */
    public void nyTur() {
        for (int i = 0; i < spillere.length; i++) {
            Tur tur = new Tur(rundeNr);
            poeng[i] = tur.spillTur();
            System.out.println(poeng[i]);
        }
    }

    public int[] getPoengFromRunde() {
        return poeng;
    }

    public int getRundeNr() {
        return rundeNr;
    }
}
