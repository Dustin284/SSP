package Game;

import java.util.Scanner;

public class SpielSSP {


    public SpielSSP() {
        spielSSP();
    }

    private void spielSSP() {
        int punktePC = 0;
        int punkteSpieler = 0;
        Scanner scanner = new Scanner(System.in);
        String pc = "";
        String m = "";

        System.out.println("Wir Spielen Schere, Stein, Papier.");
        System.out.println("Wer zuerst 3 Punkte hat gewinnt.");



        do {
            //Anweisung
            //for debug:
            System.out.println("Punkte PC: " + punktePC + " Punkte Spieler: " + punkteSpieler);
            System.out.println(" ");
            System.out.println("Was nimmst du? Papier (P), Stein (S) oder Schere (X)?");
            String eingabe = scanner.nextLine().toUpperCase();
            m = eingabe;
            if (m.equals("P")) {
                System.out.println("Du hast Papier genommen.");
            } else if (m.equals("S")) {
                System.out.println("Du hast Stein genommen.");
            } else if (m.equals("X")) {
                System.out.println("Du hast Schere genommen.");
            } else {
                System.out.println("Du hast etwas falsches eingegeben.");
                System.exit(0);
            }


            pc = erzeugePSX();
            // X = Schere
            // S = Stein
            // P = Papier

            if (pc.equals("P") && m.equals("P") || pc.equals("X") && m.equals("X") || pc.equals("S") && m.equals("S")) {
                punktePC++;
                punkteSpieler++;
            } else {
                if (pc.equals("X") && m.equals("P") || pc.equals("P") && m.equals("S") || pc.equals("S") && m.equals("X")) {
                    punktePC++;
                } else {
                    punkteSpieler++;
                }
            }

        }while (punktePC < 3 && punkteSpieler < 3);
        if (punktePC > punkteSpieler){
            System.out.println("");
            System.out.println("Der PC hat gewonnen.");
            System.out.println("Du hast " + punkteSpieler + " Punkte und der PC hat " + punktePC + " Punkte.");
        }else if (punktePC < punkteSpieler){
            System.out.println("");
            System.out.println("Du hast gewonnen.");
            System.out.println("Du hast " + punkteSpieler + " Punkte und der PC hat " + punktePC + " Punkte.");
        }else{
            System.out.println("");
            System.out.println("Unenstchieden");
            System.out.println("Du hast " + punkteSpieler + " Punkte und der PC hat " + punktePC + " Punkte.");
        }
        scanner.close();
    }

    private static String erzeugePSX(){
        String psx = "";
        int zufall = (int) (Math.random() * 3);
        switch(zufall){
            case 0:
                psx = "P";
                System.out.println("Der PC hat Papier genommen.");
                return psx.toUpperCase();
            case 1:
                psx = "S";
                System.out.println("Der PC hat Stein genommen.");
                return psx.toUpperCase();
            default:
                psx = "X";
                System.out.println("Der PC hat Schere genommen.");
                return psx.toUpperCase();
        }
    }
}
