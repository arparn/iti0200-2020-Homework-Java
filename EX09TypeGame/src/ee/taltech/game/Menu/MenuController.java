package ee.taltech.game.Menu;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MenuController {

    public static final String CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM";

    @FXML
    private Button helloBtn;
    @FXML
    private AnchorPane menuPane;

    private List<String> charList = new LinkedList<>();
    private List<Double> coordinateListX = new LinkedList<>();
    private List<Double> coordinateListY = new LinkedList<>();

    private Label character1 = new Label();
    private Label character2 = new Label();
    private Label character3 = new Label();

    private Label scoreLabel = new Label();
    private int score = 0;
    private boolean addScore;
    private boolean startNew = true;

    public String getCharacter(Label character) {
        return character.getText();
    }

    public void destroyLabelChar(Label character) {
        RotateTransition rt = new RotateTransition(Duration.millis(500), character);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.play();
        rt.setOnFinished(finish -> {
                    charList.remove(character.getText());
                    coordinateListX.remove(character.getLayoutX());
                    coordinateListY.remove(character.getLayoutY());
                    createCharacter(character);
                    startNew = true;
                }
        );
    }

    public void createCharacter(Label character) {
        addScore = true;
        Random random = new Random();
        char str;
        double x;
        double y;
        while (true) {
            str = CHARS.charAt(random.nextInt(CHARS.length()));
            if (!charList.contains(Character.toString(str))) {
                charList.add(Character.toString(str));
                break;
            }
        }
        int xStart = 80;
        int xEnd = 520;
        int yStart = 30;
        int yEnd = 320;
        character.setText(Character.toString(str));
        character.setFont(Font.font("Arial Black", 30));
        character.setTextFill(Color.RED);
        while (true) {
            x = random.nextInt(xEnd - xStart) + xStart;
            if (!coordinateListX.contains(x)) {
                coordinateListX.add(x);
                break;
            }
        }
        character.setLayoutX(x);
        while (true) {
            y = random.nextInt(yEnd - yStart) + yStart;
            if (!coordinateListY.contains(y)) {
                coordinateListY.add(y);
                break;
            }
        }
        character.setLayoutY(y);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(pauseFinEve -> addScore = false
        );
        pause.play();
    }

    public void startGame(javafx.event.ActionEvent event) {
        scoreLabel.setLayoutX(25);
        scoreLabel.setLayoutY(10);
        scoreLabel.setText("Your score: " + score);
        AnchorPane layout2 = new AnchorPane();
        createCharacter(character1);
        createCharacter(character2);
        createCharacter(character3);
        layout2.getChildren().add(character1);
        layout2.getChildren().add(character2);
        layout2.getChildren().add(character3);
        layout2.getChildren().add(scoreLabel);
        Scene newGameScreen = new Scene(layout2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newGameScreen);
        window.show();

        newGameScreen.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (startNew) {
                startNew = false;
                String characterPressed = keyEvent.getText();
                if (characterPressed.toUpperCase().equals(getCharacter(character1).toUpperCase())) {
                    destroyLabelChar(character1);
                    if (addScore) {
                        score += 1;
                    }
                    scoreLabel.setText("Your score: " + score);
                } else if (characterPressed.toUpperCase().equals(getCharacter(character2).toUpperCase())) {
                    destroyLabelChar(character2);
                    if (addScore) {
                        score += 1;
                    }
                    scoreLabel.setText("Your score: " + score);
                } else if (characterPressed.toUpperCase().equals(getCharacter(character3).toUpperCase())) {
                    destroyLabelChar(character3);
                    if (addScore) {
                        score += 1;
                    }
                    scoreLabel.setText("Your score: " + score);
                } else if (!charList.contains(characterPressed)) {
                    startNew = true;
                    score -= 1;
                    scoreLabel.setText("Your score: " + score);
                } else if (!addScore) {
                    startNew = true;
                    scoreLabel.setText("Your score: " + score);
                }
            }
        });
    }
}
