package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppgaveO3 {

    public static void main(String[] args){

        //lesser inn et heltall.
        int n = gyldigHeltall();

        //Regner ut n! (n fakultet).
        double temp = 1;
        while(n>0){
            temp *=n;
            n--;
        }

        //Skriver verdien til n! ut på skjermen, der n! = 1*2*3* … *(n-1)*n.
        double utTxt = temp;
        showMessageDialog(null, utTxt);
    }

    private static int gyldigHeltall() {
        int tall = 0;
        boolean ok;
        String feilmelding = "";
        do {
            String input = showInputDialog(feilmelding + "Oppgi lønn");
            try
            {
                tall = parseInt(input);
                ok = true;
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


