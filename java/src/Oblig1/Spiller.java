package Oblig1;

public class Spiller {
    private String farge;

    /**
     * Constructor
     * @param farge farge på spiller
     */
    public Spiller(String farge) {
        this.farge = farge;
    }

    /**
     * Få fargen til spilleren
     * @return fargen til spilleren
     */
    public String getFarge() {
        return farge;
    }

    /**
     * Set fragen til spilleren
     * @param farge fargen å sette
     */
    public void setFarge(String farge) {
        this.farge = farge;
    }

    @Override
    public String toString() {
        return "Spiller (" + farge + ")";
    }
}
