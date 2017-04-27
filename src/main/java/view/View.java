package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

import java.io.IOException;

public class View extends Application{

    static Game ticTacToe;

    public static void main(String[] args) {
        System.out.println("Run main method");
        ticTacToe = new Game("Player1", "Player2");
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("This is Java application");
        Parent root = fxmlSceneGraph();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle(ticTacToe.getName());
    }

    private Parent fxmlSceneGraph() throws IOException {
        return FXMLLoader.load(getClass().getResource("/JavaFxBattleField.fxml"));
    }
}
