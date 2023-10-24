module laoda {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example to javafx.fxml;
    opens org.example.scenes to javafx.fxml;
    exports org.example;
    exports org.example.scenes to javafx.fxml;


}