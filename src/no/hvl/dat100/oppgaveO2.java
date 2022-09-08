package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class oppgaveO2 {

    public static void main(String[] args) {

        //Kjører loop 10 ganger.
        for (int elev = 1; elev < (11); elev++) {

            //Leser in poengum til elev nr.x.
            int poeng = gyldigPoeng("Oppgi poengsum (0-100) til elev nr. " + elev);


            //Sjekker karakteren til elev x  basert på poengsum.
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

            //Skriver ut elev x, poeng og karakter i terminalen om poengsum gyldig.
            System.out.println("Elev nr." + elev + " fikk " + poeng + " poeng og får karakter " + karakter);
        }
    }

    private static int gyldigPoeng(String ledetekst) {
        int tall = -1;
        boolean ok;
        String feilmelding = "";
        do {
            String input = showInputDialog(feilmelding + ledetekst);
            try
            {
                tall = parseInt(input);
                ok = tall > 0 && tall <= 100;
            }
            catch (NumberFormatException e)
            {
                ok = false;
            }
            finally {
                if (input == null) System.exit(0);
            }
            feilmelding = "Ulovlig verdi! ";
        } while (!ok);
        return tall;
    }
}