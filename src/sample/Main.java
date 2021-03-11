package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TextField");

        GridPane root = new GridPane(); // Основное
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(5);
        root.setVgap(5);

        TextField name = new TextField("Ваше имя");
        GridPane.setConstraints(name, 0,0);
        root.getChildren().add(name);

        TextField lastName = new TextField();
        GridPane.setConstraints(lastName, 0,1);
        root.getChildren().add(lastName);

        TextField comment = new TextField();
        comment.setPromptText("написать сюда");
        GridPane.setConstraints(comment, 0,2);
        root.getChildren().add(comment);

        Button button1 = new Button("click");
        GridPane.setConstraints(button1, 1,0);
        root.getChildren().add(button1);

        Button button2 = new Button("clear");
        GridPane.setConstraints(button2, 1,1);
        root.getChildren().add(button2);

        Label label = new Label();
        GridPane.setConstraints(label, 3,0);
        root.getChildren().add(label);

        button1.setOnAction(event -> {
            if (!comment.getText().isEmpty()){
                label.setText(name.getText()+" "+lastName.getText()+" "+comment.getText());
            }else {
                label.setText("Вы не написали коммент");
            }
        });

        button2.setOnAction(event -> {
            name.clear();
            lastName.clear();
            comment.clear();
            label.setText(null);
        });

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }

    public static void main(String[] args) {
        launch(args);
    }
}