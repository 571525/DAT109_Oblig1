package Oblig1;

import java.util.Random;

public class Terning {

    private boolean hidden = false;
    private Random randomTall;
    private String[] faces = {"Løve", "Panda", "Slange", "Hval", "Elefant", "Gris"};

    public Terning() {
        randomTall = new Random();
    }

    public String trillTerning() {
        return faces[randomTall.nextInt(6)];
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
