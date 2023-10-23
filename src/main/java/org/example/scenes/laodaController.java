package org.example.scenes;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.Main;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class laodaController implements Initializable {


    @FXML
    private Button ButtonOne;
    @FXML
    private ProgressBar RecurProgress;
    @FXML
    private Label ReSuccess;
    @FXML
    private MediaView Audio;

    @FXML
    private Label ProgressLabel;
    @FXML
    private ImageView pictureOfLaoda;
    @FXML
    private ImageView back;
    @FXML
    private Pane pane;
    //   private List<Double> doubles = List.of(1.0,2.0,5.0,10.0,20.0,100.0);
    @FXML
    private ComboBox<Integer> comboBox ;
    @FXML
    private Button ClickNoButton;

    @FXML
    private Button ClickYesButton;
    @FXML
    private Pane ResPane;
    @FXML Label laodaLabel;

    private double op=0;
    private int isclick=0;
    private double Rt=0;
    private RotateTransition rotateTransition;
   /* @FXML
    public void initialize() {





        //System.out.println(file.toURI().toString());

    }*/
    public Button getButtonOne(){
        return ButtonOne;
    }
    public MediaView getAudio(){
        return Audio;
    }
    public void setAudio(MediaView audio){
        this.Audio=audio;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Audio.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        Audio.getMediaPlayer().setAutoPlay(true);

        comboBox.getItems().setAll(1,2,5,10,20,100);
        comboBox.setValue(1);
        rotateTransition = new RotateTransition(Duration.seconds(0.10), back);

    }


    //private void changed(double doubles) {
    //    Audio.getMediaPlayer().setRate(doubles);
    //}
    @FXML
    public void handle(MouseEvent mouseEvent) {


        double items=(comboBox.getValue());
        items/=100;
        if(op<0.001){
            op=0;
        }
        //System.out.println(items);
        op = op + items;
        if((op-1)>0.01){
            op=1;
        }
        String Op = (int) (Math.round(op * 100)) + "%";

        pictureOfLaoda.setOpacity(op);
        RecurProgress.setProgress(op);
        ProgressLabel.setText(Op);
        //Audio.getMediaPlayer().pause();
        double rate = op + 1;

        Audio.getMediaPlayer().setRate(rate);
        //changed(op+1);
        //System.out.println(Audio.getMediaPlayer().getCurrentTime());
        //System.out.println(SeeYouAgainAudio.getMediaPlayer().);
       // Audio.getMediaPlayer().play();
        if ((op - 1) < 0.001 && (1 - op) < 0.001) {
            ReSuccess.setVisible(true);
            back.setVisible(true);
            laodaLabel.setVisible(false);
            ButtonOne.setVisible(false);
            ResPane.setVisible(true);
            pictureOfLaoda.setOpacity(0);
            //RecurProgress.setProgress(0);
        }
    }

    @FXML
    void ClickNo(ActionEvent event) {



        //back.setRotate(Rt);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        rotateTransition.setCycleCount(Timeline.INDEFINITE);

        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

    }

    @FXML
    void ClickYes(ActionEvent event) {
        rotateTransition.stop();
        back.setRotate(0);
        op=0;
        Rt=0;
        Audio.getMediaPlayer().setRate(1);
        ReSuccess.setVisible(false);
        back.setVisible(false);
        RecurProgress.setProgress(0);
        ProgressLabel.setText("0%");
        ResPane.setVisible(false);
        laodaLabel.setVisible(true);
        ButtonOne.setVisible(true);
    }

}
