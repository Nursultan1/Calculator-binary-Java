package sample;

import javafx.application.Application; //главный класс fx приложения
import javafx.fxml.FXMLLoader; // класс для загрузки xml
import javafx.scene.Parent; // корневой узел
import javafx.scene.Scene; // хранилище для контента
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        Scene normal= new Scene(root);
        primaryStage.setScene(normal);
        primaryStage.show();
    }
}