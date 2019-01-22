package Oblig1;

public class Tur {

    private Terning[] terninger;
    private String[] resultater;
    private final int max_kast = 3;
    private int runderNr;

    public Tur(int runderNr) {
        terninger = new Terning[5];
        resultater = new String[5];
        this.runderNr = runderNr;
    }

    public int spillTur() {
        int kast = 0;
        while (kast < max_kast) {
            for (int i = 0; i < terninger.length; i++) {
                if (!terninger[i].isHidden()) resultater[i] = terninger[i].trillTerning();
            }
            kast++;
        }
        return PoengSum.bereknPoengsum(runderNr, resultater);
    }
}
