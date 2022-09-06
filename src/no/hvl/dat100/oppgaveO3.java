package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;


public class oppgaveO3 {

    public static void main(String[] args){

        double n = 0;
        do {
            String input = showInputDialog("Heltall");
            boolean ugyldig = false;

            if (input == null){
                System.exit(0);
            }
            try {
                n = parseInt(input);
            }
            catch (NumberFormatException e) {
                showMessageDialog(null, "Ugyldig input");
                ugyldig = true;
            }
            if (n < 1 && !ugyldig){
                showMessageDialog(null, "Ugyldig antall");
            }
        } while (n < 1);


        double temp = 1;
        while(n>0){
            temp *=n;
            n--;
        }


        double utTxt = temp;
        showMessageDialog(null, utTxt);
    }
}
