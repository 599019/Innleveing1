package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class oppgaveO1 {

    public static void main(String[] args) {


        //Vinduet for lønn input, sjekker at lønn er ikke mindre enn 1.
        int lonn;
        do {
            lonn = parseInt(showInputDialog("Bruttolønn"));
            if (lonn < 1){
                showMessageDialog(null, "Ugyldig antall");
            }

        } while (lonn < 1);


        //Ja og Nei valg om personen bor i Troms of Finnmark, brukes til å beregne riktig trinnskatt.
        String[] valg = {"Ja", "Nei"};
        int nord = showInternalOptionDialog( null,"Bor du i Troms og Finnmark", "helløpo",
                 DEFAULT_OPTION, INFORMATION_MESSAGE, null, valg,valg[0]);


        //Start verdi for trinn 0,1,2,3,4,5
        double[] trinn = {0,0,0,0,0,0};

        //Trinn og Prosent verdier trinn 0,1,2,3,4,5
        double[] t = {0, 190350, 267900, 643800, 969200, 2000000};
        double[] p = {0, 0.017, 0.04, 0.134, 0.164, 0.174};


        //Bytter prosent verdi på trinn 3 om personen bor i Troms og Finnmark
        String nordTxt = "Nei";
        if (nord == 0){
            p[3] = 0.114;
            nordTxt= "Ja";

        }


        //Sjekker om lønn verdi er mellom t1 og t2, om det stemmer regner ut ny trinn 1 verdi.
        if (lonn >= t[1] && lonn <= t[2]) {
            trinn[1] = (lonn - t[1]) * p[1];
            //Om lønn er støre enn t2, regnes ut trinn 1 og koden fortsetter.
        } else if (lonn > t[2]){
            trinn[1] = (t[2] - t[1]) * p[1];

            if (lonn <= t[3]) {
                trinn[2] = (lonn - t[2]) * p[2];
            } else {
                trinn[2] = (t[3] - t[2]) * p[2];

                if (lonn <= t[4]) {
                    trinn[3] = (lonn - t[3]) * p[3];
                } else {
                    trinn[3] = (t[4] - t[3]) * p[3];

                    if (lonn <= t[5]) {
                        trinn[4] = (lonn - t[4]) * p[4];
                    } else {
                        trinn[4] = (t[5] - t[4]) * p[4];
                        trinn[5] = (lonn - t[5]) * p[5];

                    }

                }

            }

        }


        //Finner ut tottal trinnskat, og skriver det ut til bruker avrundet til nærmeste heltall.
        double trinnskatt = (trinn[1] + trinn[2] + trinn[3] + trinn[4] +trinn[5]);
        String utTxt =
                "Lønn: "+lonn+"kr"+ "\nTroms og Finnmark: " + nordTxt+ "\nTrinnskatt: "+round(trinnskatt)+"kr"+
                        "\n"+" \nTrinn 1: "+round(trinn[1])+"kr"+ "\nTrinn 2: "+round(trinn[2])+"kr"+ "\nTrinn 3: "+round(trinn[3])+"kr"+
                        "\nTrinn 4: "+round(trinn[4])+"kr"+ "\nTrinn 5: "+round(trinn[5]) + "kr";
        showMessageDialog(null, utTxt);

    }

}