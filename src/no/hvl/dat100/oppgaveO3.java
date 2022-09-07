package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class oppgaveO3 {

    public static void main(String[] args){


        int n;
        do {
            n = parseInt(showInputDialog("Heltall"));
            if (n < 1){
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
