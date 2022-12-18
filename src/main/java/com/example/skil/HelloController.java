package com.example.skil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
//import java.sql.SQLException;

public class HelloController {
    @FXML
    private TextField login_text;

    @FXML
    private TextField password_text;

    @FXML
    private Button button;

    @FXML
    private Label error;

    @FXML
    private CheckBox open;

    @FXML
    private PasswordField password_;

    @FXML
    private Canvas canvas;

    @FXML
    private TextField textCanvas;


    private CaptchaGenerator captchaGenerator;
    private String captchaText;
    DB db = null;


    @FXML

    void initialize() {

        // Инициируем объект
        db = new DB();

    }

    public void loading() {
        try {
// списки со значениями
            String user_login = login_text.getText();
            String user_password = password_text.getText();
            Integer login = db.getTasks(user_login, user_password);

            int count = 1;
            if(login==1 & count < 3){
                String[] name = db.getTasks1(user_login, user_password);
                UserAcaunt.firstName = name[0].split(" ")[0];
                UserAcaunt.dolgnost = name[1];

                try {

                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("UserAcaunt.fxml"));
                    primaryStage.setTitle("Профиль");
                    primaryStage.setScene(new Scene(root, 500, 275));
                    primaryStage.show();
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }else if(count == 3){
                login_text.setDisable(true);
                password_text.setDisable(true);
                textCanvas.setVisible(true);

            }
            else{
                error.setText("Такого пользователя нет");
                count++;

            }
//                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open(){
        if (open.isSelected()){
            String pass = password_.getText();
            password_text.setText(pass);
            password_.setVisible(true);
            password_text.setVisible(false);
        }else{
            String pass = password_text.getText();
            password_.setText(pass);
            password_text.setVisible(true);
            password_.setVisible(false);
        }


    }

}