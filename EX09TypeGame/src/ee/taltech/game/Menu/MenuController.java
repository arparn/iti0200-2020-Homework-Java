package ee.taltech.game.Menu;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MenuController {

    public static final String CHARS = "ASD";

    private List<Label> charList = new LinkedList<>();
    private List<String> stringList = new LinkedList<>();
    private LocalTime localTime;

    private Label scoreLabel = new Label();
    private int score = 0;

    public void destroyLabelChar(Label character) {
        LocalTime timeNow = LocalTime.now();
        long seconds = ChronoUnit.MILLIS.between(timeNow, localTime);// aeg kontrollitakse siin
        if (seconds < 1000) {
            score++;
        }
        RotateTransition rt = new RotateTransition(Duration.millis(500), character);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.play();
        rt.setOnFinished(finish -> {
                    charList.remove(character);
                    stringList.remove(character.getText());
                    createCharacter(character);
                }
        );
    }

    public void createCharacter(Label character) {
        Random random = new Random();
        char str;
        double x;
        double y;
        int xStart = 80;
        int xEnd = 520;
        int yStart = 30;
        int yEnd = 320;
        while (true) {
            str = CHARS.charAt(random.nextInt(CHARS.length()));
            if (!stringList.contains(Character.toString(str))) {
                stringList.add(Character.toString(str));
                break;
            }
        }
        character.setText(Character.toString(str));
        character.setFont(Font.font("Arial Black", 30));
        character.setTextFill(Color.RED);
        x = random.nextInt(xEnd - xStart) + xStart;
        character.setLayoutX(x);
        y = random.nextInt(yEnd - yStart) + yStart;
        character.setLayoutY(y);
        charList.add(character);
        localTime = LocalTime.now();
        //PauseTransition pause = new PauseTransition(Duration.seconds(1));
        //pause.setOnFinished(pauseFinEve -> addScore = false);
        //pause.play();
    }

    public void startGame(javafx.event.ActionEvent event) {
        Label character3 = new Label();
        Label character1 = new Label();
        Label character2 = new Label();
        scoreLabel.setLayoutX(25);
        scoreLabel.setLayoutY(10);
        scoreLabel.setText("Your score: " + score);
        AnchorPane layout2 = new AnchorPane();
        createCharacter(character3);
        createCharacter(character1);
        createCharacter(character2);
        for (Label character : charList) {
            layout2.getChildren().add(character);
        }
        layout2.getChildren().add(scoreLabel);
        Scene newGameScreen = new Scene(layout2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newGameScreen);
        window.show();

        newGameScreen.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            String characterPressed = keyEvent.getText();
            int check = 0;
            for (Label character : charList) {
                if (character.getText().toUpperCase().equals(characterPressed.toUpperCase())) {
                    destroyLabelChar(character);
                    break;
                }
                if (!character.getText().toUpperCase().equals(characterPressed.toUpperCase())) {
                    check++;
                }
            }
            if (check >= 3) {
                score--;
            }
            scoreLabel.setText("Your score: " + score);
        });
    }
}
