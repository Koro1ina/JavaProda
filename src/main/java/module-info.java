module com.example.skil {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skil to javafx.fxml;
    exports com.example.skil;
}