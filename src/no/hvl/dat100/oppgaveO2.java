package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppgaveO2 {

    public static void main(String[] args) {

        //Leser inn poengsum 10 ganger
        for (int elev = 1; elev < (11); elev++) {

            int poeng;
            do {
                poeng = parseInt(showInputDialog("Antall poeng av 100 til elev nr."+elev));

                if (poeng < 0 || poeng > 100){
                    showMessageDialog(null, "Ugyldig antall");
                }

            } while (poeng < 0 || poeng > 100);

            //Sjekker karakteren til eleven basert på peongsum
            String karakter;
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
            } else {
                karakter = "A";
            }

            //Skriver ut elevnr, poeng og karakter om poengsum gyldig.
            System.out.println("Elev nr." + elev + " fikk " + poeng + " poeng og får karakter " + karakter);

        }

    }

}