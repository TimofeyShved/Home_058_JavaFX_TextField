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

        //------------------------------------------------------- TextField ----------------------------------------------
        // -------------------------------------- добавляем поля для ввода текста
        TextField name = new TextField("Ваше имя");  // уже с тестом внутри
        GridPane.setConstraints(name, 0,0); // место на панеле
        root.getChildren().add(name);

        TextField lastName = new TextField(); // обычный
        GridPane.setConstraints(lastName, 0,1);
        root.getChildren().add(lastName);

        TextField comment = new TextField();
        comment.setPromptText("написать сюда коммент"); // подсказка для ввода
        GridPane.setConstraints(comment, 0,2);
        root.getChildren().add(comment);

        //  кнопки
        Button button1 = new Button("обработать");
        GridPane.setConstraints(button1, 1,0);
        root.getChildren().add(button1);

        Button button2 = new Button("очистить");
        GridPane.setConstraints(button2, 1,1);
        root.getChildren().add(button2);

        // метка (лэйбл)
        Label label = new Label();
        GridPane.setConstraints(label, 3,0);
        root.getChildren().add(label);

        button1.setOnAction(event -> { // действие на кнопку
            if (!comment.getText().isEmpty()){
                label.setText(name.getText()+" "+lastName.getText()+" "+comment.getText()); // вытащить текст из TextField
            }else {
                label.setText("Вы не написали коммент");
            }
        });

        button2.setOnAction(event -> { // действие на кнопку (очистить)
            name.clear();
            lastName.clear();
            comment.clear();
            label.setText(null);
        });

        //-------------------------------------------------------PasswordField  ----------------------------------------------
        // -------------------------------------- добавляем поля для ввода пароля
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Ввидите пароль");
        GridPane.setConstraints(passwordField, 0,3);
        root.getChildren().add(passwordField);

        //  кнопка
        Button button3 = new Button("Проверить");
        GridPane.setConstraints(button3, 1,3);
        root.getChildren().add(button3);

        // метка (лэйбл)
        Label label2 = new Label("результат");
        GridPane.setConstraints(label2, 2,3);
        root.getChildren().add(label2);

        button3.setOnAction(event -> { // действие на кнопку
            PasswordFieldClick(passwordField, label2); // отсылаем ссылки на объекты в статическую функцию
        });

        passwordField.setOnAction(event -> { // действия внутри PasswordField, при нажатии на Enter
            PasswordFieldClick(passwordField, label2); // отсылаем ссылки на объекты в статическую функцию
        });

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }

    // статическая функция для PasswordField
    static public void PasswordFieldClick(PasswordField passwordField, Label label){
        if(!passwordField.getText().equals("123")){ // сверка
            label.setText("Провал");
            label.setTextFill(Color.RED);
        }else{
            label.setText("Успех"); // текст
            label.setTextFill(Color.GREEN); // цвет
        }
        passwordField.clear(); // очистка
    }

    public static void main(String[] args) {
        launch(args);
    }
}