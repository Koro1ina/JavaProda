package com.example.skil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class UserAcaunt implements Initializable {

    @FXML
    private ImageView fotoUser;
    @FXML
    private Label welcome;
    @FXML
    public Label position;

    public static String firstName = " ";
    public static String dolgnost = " ";
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        File fi=new File("src/images/"+firstName+".jpeg");
        Image image=new Image(fi.toURI().toString());
        fotoUser.setImage(image);
        welcome.setText("Добро пожаловать, "+firstName);
        position.setText("Вша должность: "+dolgnost);


    }
}