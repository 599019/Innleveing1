package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;
import static java.lang.Math.*;

public class oppgaveO1 {

    public static void main(String[] args) {

        //Leser inn lønn.
        int lonn = gyldigTall();

        //Sjekekr om bruker bor i Troms og Finmark.
        int nord = jaOgNeiVindu();

        //Start verdi for trinn 0 til 1, Skattrinn 0 til 5 og prosent vedri for trinn 0 til 5.
        double[] trinn = {0,0,0,0,0,0};
        double[] t = {0, 190350, 267900, 643800, 969200, 2000000};
        double[] p = {0, 0.017, 0.04, 0.134, 0.164, 0.174};

        //Bytter trinn 3 om int nord = 0 (ja)
        String nordTxt;
        if (nord == 0){
            p[3] = 0.114;
            nordTxt = "Ja";
        } else {
            nordTxt = "Nei";
        }

        //Regner ut hvor mye bruker betaller i hver trinn  og legger det sammen.
        if (lonn >= t[1] && lonn <= t[2]) {
            trinn[1] = (lonn - t[1]) * p[1];
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
        double trinnskatt = (trinn[1] + trinn[2] + trinn[3] + trinn[4] +trinn[5]);

        //skriverut trinnskatt til brukeren.
        String utTxt =
                "Lønn: "+lonn+"kr"+ "\nTroms og Finnmark: " + nordTxt+ "\nTrinnskatt: "+round(trinnskatt)+"kr"+
                        "\n"+" \nTrinn 1: "+round(trinn[1])+"kr"+ "\nTrinn 2: "+round(trinn[2])+"kr"+ "\nTrinn 3: "+round(trinn[3])+"kr"+
                        "\nTrinn 4: "+round(trinn[4])+"kr"+ "\nTrinn 5: "+round(trinn[5]) + "kr";
        showMessageDialog(null, utTxt);
    }

    private static int gyldigTall() {
        int tall = 0;
        boolean ok;
        String feilmelding = "";
        do {
            String input = showInputDialog(feilmelding + "Oppgi lønn");
            try
            {
                tall = parseInt(input);
                ok = tall > 0;
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
    private static int jaOgNeiVindu() {
        String[] valg = {"Ja", "Nei"};
        int jaNei = showInternalOptionDialog( null,"Bor du i Troms og Finnmark", "",
                DEFAULT_OPTION, INFORMATION_MESSAGE, null, valg,valg[0]);
        return jaNei;
    }
}