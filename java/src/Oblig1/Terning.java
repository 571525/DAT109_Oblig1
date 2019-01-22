package Oblig1;

import java.util.Random;

public class Terning {

    private boolean hidden = false;
    private Random randomTall;
    private String[] faces = {"Løve", "Panda", "Slange", "Hval", "Elefant", "Gris"};

    /**
     * Constructor
     */
    public Terning() {
        randomTall = new Random();
    }

    /**
     * Trill terningen
     * @return gir tilbake en av de 6 dyrene en kan få
     */
    public String trillTerning() {
        return faces[randomTall.nextInt(6)];
    }

    /**
     * Muligheten for å se om terningen er gjemt
     * @return om den er hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Muligheten til å sette noe gjemt
     * @param hidden true or false
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
