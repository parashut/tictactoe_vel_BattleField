package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Sign;
import static view.View.ticTacToe;


public class BattleFieldControler  {
    private Image imageO = new Image("o.png");
    private Image imageX = new Image("x.png");

    @FXML
    private Label xPoints;

    @FXML
    private Label oPoints;

    @FXML
    private ImageView field0;

    @FXML
    private ImageView field1;

    @FXML
    private ImageView field2;

    @FXML
    private ImageView field3;

    @FXML
    private ImageView field4;

    @FXML
    private ImageView field5;

    @FXML
    private ImageView field6;

    @FXML
    private ImageView field7;

    @FXML
    private ImageView field8;

    @FXML
    private Button restartButton;

    @FXML
    private ImageView nextPlayerImg;

    @FXML
    private Label winnerLabel;

    private void moveOnAndCheck(int position){
        ticTacToe.playerMove(position);
        drawGrid();
        drawNextPlayer();
        if (ticTacToe.getCounter() > 4) {
            if (ticTacToe.checkWin()) {
                disableAllFields(true);
                setPoints();
                showMessage();
            }
        }
        if (ticTacToe.getCounter() == 9 && !ticTacToe.isWinner()){
            disableAllFields(true);
            showMessage();
        }
    }

    private void showMessage() {
        String message;
        if (ticTacToe.isWinner() && ticTacToe.getWinnerPlayer().getSign() == Sign.CROSS){
            message = "KRZYŻYK WYGRAŁ!";
        } else if(ticTacToe.isWinner() && ticTacToe.getWinnerPlayer().getSign() == Sign.CIRCLE){
            message = "KÓŁKO WYGRAŁO!";
        } else {
            message = "REMIS";
        }
        winnerLabel.setText(message);
    }

    private void setPoints() {
        xPoints.setText(String.valueOf(ticTacToe.getPlayer1().getPoints()));
        oPoints.setText(String.valueOf(ticTacToe.getPlayer2().getPoints()));
    }

    private void disableAllFields(boolean value){
        ImageView[] tabOfFields = {field0, field1, field2, field3, field4, field5, field6, field7, field8};
        for(ImageView iv : tabOfFields){
            iv.setDisable(value);
        }
    }

    private void drawGrid(){
        ImageView[] tabOfFields = {field0, field1, field2, field3, field4, field5, field6, field7, field8};
        for (int i = 0; i < 9 ; i++) {
            if(ticTacToe.getGrid().signOnPosition(i) == Sign.CROSS){
                tabOfFields[i].setImage(imageX);
            } else if(ticTacToe.getGrid().signOnPosition(i) == Sign.CIRCLE){
                tabOfFields[i].setImage(imageO);
            } else {
                tabOfFields[i].setImage(null);
            }
        }
    }

    private void drawNextPlayer(){
        if(ticTacToe.getCurrentPlayer().getSign() == Sign.CROSS){
            nextPlayerImg.setImage(imageX);
        } else {
            nextPlayerImg.setImage(imageO);
        }
    }

    @FXML
    void clickedP0(MouseEvent event) {
        moveOnAndCheck(0);
    }

    @FXML
    void clickedP1(MouseEvent event) {
        moveOnAndCheck(1);
    }

    @FXML
    void clickedP2(MouseEvent event) {
        moveOnAndCheck(2);
    }

    @FXML
    void clickedP3(MouseEvent event) {
        moveOnAndCheck(3);
    }

    @FXML
    void clickedP4(MouseEvent event) {
        moveOnAndCheck(4);
    }

    @FXML
    void clickedP5(MouseEvent event) {
        moveOnAndCheck(5);
    }

    @FXML
    void clickedP6(MouseEvent event) {
        moveOnAndCheck(6);
    }

    @FXML
    void clickedP7(MouseEvent event) {
        moveOnAndCheck(7);
    }

    @FXML
    void clickedP8(MouseEvent event) {
        moveOnAndCheck(8);
    }

    @FXML
    void clickedRestart(ActionEvent actionEvent) {
        ticTacToe.resetGame();
        drawGrid();
        drawNextPlayer();
        winnerLabel.setText(null);
        disableAllFields(false);
    }
}
