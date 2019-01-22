package Oblig1;

public class Runde {

    private Spiller[] spiller;
    private int rundeNr;
    private int[] poeng;

    /**
     * Constructor til runde
     *
     * @param rundeNr hvilket rundenummer er vi på
     * @param spiller liste av alle spillerene med i runden
     */
    public Runde(int rundeNr, Spiller[] spiller) {
        this.spiller = spiller;
        this.rundeNr = (rundeNr + 1);

        poeng = new int[spiller.length];
    }

    /**
     * Start en ny tur for en spiller
     */
    public void nyTur() {
        for (int i = 0; i < spiller.length; i++) {
            Tur tur = new Tur(spiller[i], rundeNr);
            poeng[i] = tur.spillTur();
        }
    }

    /**
     * Skriv ut poengene i en gitt runde
     */
    public void printPoengRunde() {
        System.out.println("Runde - " + rundeNr);
        for (int i = 1; i <= spiller.length; i++) System.out.printf("%s\t", spiller[i - 1]);
        System.out.println();
        for (int i = 0; i < spiller.length; i++) System.out.printf("\t\t%d\t\t", poeng[i]);
        System.out.println("\n");
    }

    //Getters and setters
    public int[] getPoengFromRunde() {
        return poeng;
    }

    public int getRundeNr() {
        return rundeNr;
    }
}
