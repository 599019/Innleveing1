package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppgaveO2 {

    public static void main(String[] args) {

        //Bruker velger antall elever
        int antall = 0;
        do {
            String personer = showInputDialog("Antall elever");
            boolean ugyldig = false;

            if (personer == null){
                System.exit(0);
            }
            try {
                antall = parseInt(personer);
            }
            catch (NumberFormatException e) {
                showMessageDialog(null, "Ugyldig input");
                ugyldig = true;
            }
            if (antall < 1 && !ugyldig){
                showMessageDialog(null, "Ugyldig antall");
            }
        } while (antall < 1);



        //Leser inn poengsum, x antall ganger som blitt oppgit av bruker
        for (int elev = 1; elev < (antall+1); elev++) {

            //Starter int for poeng og lager string for array som justeres etter antall.
            int poeng = 0;
            String karakter[] = new String[antall+1];

            //Sjekker om gyldig antall og input, om gyldig fortsetter koden.
            do {
                String antallpeong = showInputDialog("Antall peong av 100 til elev nr."+elev);
                boolean ugyldig2 = false;

                if (antallpeong == null){
                    System.exit(0);
                }
                try
                {
                    poeng = parseInt(antallpeong);
                }
                catch (NumberFormatException e)
                {
                    showMessageDialog(null, "Ugyldig input");
                    ugyldig2 = true;
                }
                if (poeng < 0 || poeng > 100 && !ugyldig2){
                    showMessageDialog(null, "Ugyldig antall");
                } else if (poeng < 40) {
                    karakter[elev] = "F";
                } else if (poeng < 50) {
                    karakter[elev] = "E";
                } else if (poeng < 60) {
                    karakter[elev] = "D";
                } else if (poeng < 80) {
                    karakter[elev] = "C";
                } else if (poeng < 90) {
                    karakter[elev] = "B";
                } else {
                    karakter[elev] = "A";
                }

            } while (poeng < 0 || poeng > 100);

            System.out.println("Elev nr." + elev + " fikk " + poeng + " poeng og får karakter " + karakter[elev]);

        }






    }

}