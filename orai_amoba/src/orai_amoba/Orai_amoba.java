
package orai_amoba;

import java.util.Scanner;

public class Orai_amoba {
    public static void main(String[] args) {
        String[][] palya = new String[3][3];
        String jelenlegiJatekos = "X";
        boolean gameOver = false;

        for (String[] palya1 : palya) {
            for (int j = 0; j < palya1.length; j++) {
                palya1[j] = " ";
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            for (String[] palya1 : palya) {
                for (String palya11 : palya1) {
                    System.out.print("| " + palya11 + " ");
                }
                System.out.println("|");
            }

            System.out.println("Jatekos " + jelenlegiJatekos + ", válassz sort(1-3)");
            int row = scanner.nextInt() - 1;
            System.out.println("Jatekos " + jelenlegiJatekos + ", válassz oszlopot(1-3)");
            int column = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && column >= 0 && column < 3 && palya[row][column].equals(" ")) {
                palya[row][column] = jelenlegiJatekos;
            } else {
                System.out.println("Nem jó tesó, adj meg egy helyes számot");
                continue;
            }

            boolean win = false;
            for (int i = 0; i < 3; i++) {
                if ((palya[i][0].equals(jelenlegiJatekos) && palya[i][1].equals(jelenlegiJatekos) && palya[i][2].equals(jelenlegiJatekos)) ||
                    (palya[0][i].equals(jelenlegiJatekos) && palya[1][i].equals(jelenlegiJatekos) && palya[2][i].equals(jelenlegiJatekos))) {
                    win = true;
                    break;
                }
            }

            if (!win) {
                if ((palya[0][0].equals(jelenlegiJatekos) && palya[1][1].equals(jelenlegiJatekos) && palya[2][2].equals(jelenlegiJatekos)) ||
                    (palya[0][2].equals(jelenlegiJatekos) && palya[1][1].equals(jelenlegiJatekos) && palya[2][0].equals(jelenlegiJatekos))) {
                    win = true;
                }
            }

            if (win) {
                for (int i = 0; i < palya.length; i++) {
                    for (int j = 0; j < palya[i].length; j++) {
                        System.out.print("| " + palya[i][j] + " ");
                    }
                    System.out.println("|");
                }
                System.out.println("Player " + jelenlegiJatekos + " wins!");
                gameOver = true;
            
            }else {
                boolean draw = true;
                for (int i = 0; i < palya.length; i++) {
                    for (int j = 0; j < palya[i].length; j++) {
                        if (palya[i][j].equals(" ")) {
                            draw = false;
                            break;
                        }
                    }
                    if (!draw) {
                        break;
                    }
                }
                if (draw) {
                    for (int i = 0; i < palya.length; i++) {
                        for (int j = 0; j < palya[i].length; j++) {
                            System.out.print("| " + palya[i][j] + " ");
                        }
                        System.out.println("|");
                    }
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    jelenlegiJatekos = (jelenlegiJatekos.equals("X")) ? "O" : "X";
                }
            }
        }    
    }
}



        


