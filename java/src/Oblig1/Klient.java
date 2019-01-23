package Oblig1;

import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Velg antall spillere:");
        int antallSpillere = in.nextInt();

        //spill spillet
        Spill spill = new Spill(antallSpillere);
        spill.skrivUtRegler();
        spill.skrivUtSpillere();
        spill.start();
        spill.skrivUtScore();
    }
}
