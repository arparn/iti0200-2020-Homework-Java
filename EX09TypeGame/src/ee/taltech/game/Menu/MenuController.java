package ee.taltech.game.Menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Random;


public class MenuController {

    public static final String CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM";

    @FXML
    private Button helloBtn;
    @FXML
    private AnchorPane menuPane;

    private Label character = new Label();

    public String getCharacter() {
        return character.getText();
    }

    public void destroyLabel() {
        character.setText("");
    }

    public void createCharacter() {
        Random random = new Random();
        char str = CHARS.charAt(random.nextInt(CHARS.length()));
        character.setText(Character.toString(str));
        character.setLayoutX(300);
        character.setLayoutY(300);
    }

    public void startGame(javafx.event.ActionEvent event) {
        StackPane layout2 = new StackPane();
        createCharacter();
        layout2.getChildren().add(character);
        Scene newGameScreen = new Scene(layout2, 800, 600);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newGameScreen);
        window.setTitle("play");
        window.show();

        newGameScreen.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            String characterPressed = keyEvent.getText();
            if (characterPressed.toUpperCase().equals(getCharacter().toUpperCase())) {
                destroyLabel();
                createCharacter();
            }
        });
    }
}
