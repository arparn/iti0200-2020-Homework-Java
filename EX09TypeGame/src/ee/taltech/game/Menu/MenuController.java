package ee.taltech.game.Menu;

import javafx.animation.RotateTransition;
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

    public static final int ANGLE = 360;
    public static final int DURATION = 500;
    public static final int X_START = 80;
    public static final int X_END = 520;
    public static final int Y_START = 30;
    public static final int Y_END = 320;
    public static final int FONT_SIZE = 30;
    public static final int SCORE_X = 25;
    public static final int SCORE_Y = 10;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int CHECK = 3;


    public static final String CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM";

    private List<Label> charList = new LinkedList<>();
    private List<String> stringList = new LinkedList<>();
    private LocalTime localTime;

    private Label scoreLabel = new Label();
    private int score = 0;

    public void destroyLabelChar(Label character) {
        LocalTime timeNow = LocalTime.now();
        long seconds = ChronoUnit.SECONDS.between(timeNow, localTime);
        if (seconds >= -1) {
            score++;
        }
        RotateTransition rt = new RotateTransition(Duration.millis(DURATION), character);
        rt.setFromAngle(0);
        rt.setToAngle(ANGLE);
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
        while (true) {
            str = CHARS.charAt(random.nextInt(CHARS.length()));
            if (!stringList.contains(Character.toString(str))) {
                stringList.add(Character.toString(str));
                break;
            }
        }
        character.setText(Character.toString(str));
        character.setFont(Font.font("Arial Black", FONT_SIZE));
        character.setTextFill(Color.RED);
        while (true) {
            boolean repeat = false;
            x = random.nextInt(X_END - X_START) + X_START;
            character.setLayoutX(x);
            y = random.nextInt(Y_END - Y_START) + Y_START;
            character.setLayoutY(y);
            if (charList.size() < 1) {
                break;
            }
            for (Label c : charList) {
                if (character.getBoundsInParent().intersects(c.getBoundsInParent())) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                break;
            }
        }
        charList.add(character);
        localTime = LocalTime.now();
    }

    public void startGame(javafx.event.ActionEvent event) {
        Label character3 = new Label();
        Label character1 = new Label();
        Label character2 = new Label();
        scoreLabel.setLayoutX(SCORE_X);
        scoreLabel.setLayoutY(SCORE_Y);
        scoreLabel.setText("Your score: " + score);
        AnchorPane layout2 = new AnchorPane();
        createCharacter(character3);
        createCharacter(character1);
        createCharacter(character2);
        for (Label character : charList) {
            layout2.getChildren().add(character);
        }
        layout2.getChildren().add(scoreLabel);
        Scene newGameScreen = new Scene(layout2, WIDTH, HEIGHT);
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
            if (check >= CHECK) {
                score--;
            }
            scoreLabel.setText("Your score: " + score);
        });
    }
}
