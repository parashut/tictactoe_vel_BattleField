package model;


import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {

        String player1name = "Marcin";
        String player2name = "Przemo";

        Game ticTacToe = new Game(player1name, player2name);

        Scanner sc = new Scanner(System.in);
        int pos;

        do {
            System.out.println(ticTacToe.getCurrentPlayer().getSign());
            showGrid(ticTacToe);
            pos = sc.nextInt();
            ticTacToe.playerMove(pos);
            System.out.println();
        } while (!ticTacToe.checkWin() && ticTacToe.getCounter() < 9);

        if (ticTacToe.checkWin()) {
            System.out.println("Wygrał " + ticTacToe.getWinnerPlayer().getSign());
        } else {
            System.out.println("REMIS!");
        }
        showGrid(ticTacToe);
    }

    static void showGrid(Game ticTacToe){
        char[] tab = {'-','-','-',
                      '-','-','-',
                      '-','-','-'};
        for (int i = 0; i < tab.length; i++) {
            if (ticTacToe.getGrid().signOnPosition(i) == Sign.CROSS){
                tab[i] = 'X';
            } else if (ticTacToe.getGrid().signOnPosition(i) == Sign.CIRCLE){
                tab[i] = 'O';
            }
        }
        System.out.println(tab[0] + " " + tab[1] + " " + tab[2]);
        System.out.println(tab[3] + " " + tab[4] + " " + tab[5]);
        System.out.println(tab[6] + " " + tab[7] + " " + tab[8]);
    }
}
