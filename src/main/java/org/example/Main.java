package org.example;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.scenes.laodaController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main extends Application{

    private Stage primaryStage;
    private static MediaPlayer mediaPlayer;
    private List<Double> doubles = DoubleStream
            .iterate(1.0,x->x+0.02)
            .limit(10)
            .map(x->Double.valueOf(String.format("%.2f",x)))
            .boxed()
            .collect(Collectors.toList());
    private ComboBox<Double> comboBox = new ComboBox<>(FXCollections.observableList(doubles));
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("想你了，老大！");
        showLoginView();
    }
    @Override
    public void init() throws Exception{
        comboBox.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                mediaPlayer.setRate(newValue);
                //System.out.println(mPlayer.getAudioSpectrumListener());
            }
        });
    }

    public void showLoginView() {
        try {
            // Load the login page.
            //String audioFile ="images/SeeYouAgain.mp3"
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/laoda.fxml"));

            Image icon=new Image(getClass().getResource("images/images.jpg").toString());
            //Media media=new Media(getClass().getResource("images/seeyou.mp4").toString());
            //mediaPlayer=new MediaPlayer(media);
            //System.out.println(getClass().getResource("images/images.jpg"));
            //System.out.println(getClass().getResource("images/seeyou.mp3"));
            primaryStage.getIcons().add(icon);
            Parent root = loader.load();
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));

            //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            //mediaPlayer.play();
            //laodaController controller=new laodaController();
            //Pane pane = (Pane) primaryStage.getScene().lookup("#pane");
            //comboBox.setLayoutX(268);
            //comboBox.setLayoutY(373);
            //pane.getChildren().add(comboBox);
            //primaryStage.setOnCloseRequest(event -> mediaPlayer.stop());
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public static MediaPlayer getmediaPlayer(){
        return mediaPlayer;
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public static void main(String[] args){
        launch(args);
    }

}
