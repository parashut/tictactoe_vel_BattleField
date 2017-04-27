package model;


public class Game {
    private String name = "BattleField";
    private Player player1;
    private Player player2;
    private Grid grid = new Grid();
    private int[][] combinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private Player currentPlayer;
    private Player winnerPlayer;
    private boolean isWinner = false;
    private int counter = 0;

    public Game(String player1, String player2) {
        this.player1 = new Player(player1, Sign.CROSS);
        this.player2 = new Player(player2, Sign.CIRCLE);
        currentPlayer = this.player1;
    }

    public boolean checkWin() {
        for (int[] combination : combinations) {
            int pos1 = combination[0];
            int pos2 = combination[1];
            int pos3 = combination[2];
            if (grid.signOnPosition(pos1) == player1.getSign() &&
                    grid.signOnPosition(pos2) == player1.getSign() &&
                    grid.signOnPosition(pos3) == player1.getSign()) {
                winnerPlayer = player1;
                winnerPlayer.addPoint();
                isWinner = true;
                return true;
            }
            if (grid.signOnPosition(pos1) == player2.getSign() &&
                    grid.signOnPosition(pos2) == player2.getSign() &&
                    grid.signOnPosition(pos3) == player2.getSign()) {
                winnerPlayer = player2;
                winnerPlayer.addPoint();
                isWinner = true;
                return true;
            }
        }
        return false;
    }

    public void playerMove(int position){
        if (grid.isEmptyPosition(position)){
            grid.setSignOnGrid(position, currentPlayer.getSign());
            switchPlayer();
            counter++;
        }
    }

    private void switchPlayer() {
        if (currentPlayer.getSign() == player1.getSign()){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getCounter() {
        return counter;
    }

    public void resetGame(){
        for (int i = 0; i < grid.getGrid().length ; i++) {
            this.grid.resetSignOnGrid(i);
        }
        this.winnerPlayer = null;
        this.counter = 0;
        currentPlayer = this.player1;
        isWinner = false;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public String getName() {
        return name;
    }
}
