package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;




public class Controller{

    @FXML
    private ImageView IV;
    @FXML
    public ImageView player;

    static boolean w = false;
    static boolean s = false;
    static boolean a = false;
    static boolean d = false;




    public void initialize() {

        KeyValue yValue  = new KeyValue(IV.yProperty(), -183);

        KeyFrame keyFrame  = new KeyFrame(Duration.millis(5000), yValue);
        Timeline timeline  = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();


    }


    public void OKP(KeyEvent event){

        switch (event.getCode()){
            case W:
                w = true;
                System.out.println("w:"+w);
                break;
            case S:
                s = true;
                System.out.println("s:"+s);
                break;
            case A:
                a = true;
                System.out.println("a:"+a);
                break;
            case D:
                d = true;
                System.out.println("d:"+d);
                break;
        }
        Thread1 thread1 = new Thread1("thread1",player.getX(),player.getY(),player);
        thread1.start();
    }
    public void OKR(KeyEvent e){
        //Thread1 thread1 = new Thread1("thread1",player.getX(),player.getY(),player);
        switch (e.getCode()){
            case W:
                w = false;
                System.out.println("w:"+w);
                break;
            case S:
                s = false;
                System.out.println("s:"+s);
                break;
            case A:
                a = false;
                System.out.println("a:"+a);
                break;
            case D:
                d = false;
                System.out.println("d:"+d);
                break;
        }
        //thread1.start();
    }





}
