package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppgaveO2 {

    public static void main(String[] args) {

        final int antall = 10;

        for (int elev = 1; elev < (antall+1); elev++) {

            int poeng;
            String karakter = "";

            do {
                poeng = parseInt(showInputDialog("Poengsum til elev nr." + (elev) + "  NB! max 100 poeng"));

                if (poeng < 40) {
                    karakter = "F";
                } else if (poeng < 50) {
                    karakter = "E";
                } else if (poeng < 60) {
                    karakter = "D";
                } else if (poeng < 80) {
                    karakter = "C";
                } else if (poeng < 90) {
                    karakter = "B";
                } else if (poeng <= 100) {
                    karakter = "A";
                }

            } while (poeng < 0 || poeng > 100);

            System.out.println("Elev nr." + elev + " fikk " + poeng + " poeng og får karakter " + karakter);
        }

    }

}