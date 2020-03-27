package ee.taltech.game;

import ee.taltech.game.Menu.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.beans.XMLEncoder;


public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/menu.fxml")); // Делаем loader для fxml объекта
        Parent root = loader.load(); //  через loader передаем fxml файл в объект root наш условный лист для рисования
        MenuController menuController = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene); //  объект scene - это окно в котором будет выполняться код
        stage.setTitle("Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
