package ee.taltech.game;

import ee.taltech.game.Menu.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/menu.fxml")); // Делаем loader для fxml объекта
        Parent root = loader.load(); //  через loader передаем fxml файл в объект root наш условный лист для рисования
        MenuController menuController = loader.getController();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene); //  объект scene - это окно в котором будет выполняться код
        stage.setTitle("TypeGame");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
