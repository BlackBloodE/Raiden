package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Controller{

    @FXML
    private ImageView IV;
    @FXML
    public ImageView player;
    @FXML
    private GridPane pane;
    @FXML
    private ImageView bullet1;

    public ImageView[] bullet = new ImageView[1];
    private Image image = new Image("bullet.png");
    static int bx = 0;

    static boolean w = false;
    static boolean s = false;
    static boolean a = false;
    static boolean d = false;
    static boolean space = false;




    public void initialize(){

        KeyValue yValue  = new KeyValue(IV.yProperty(), -183);

        KeyFrame keyFrame  = new KeyFrame(Duration.millis(5000), yValue);
        Timeline timeline  = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

        Thread1 thread1 = new Thread1("thread1",player.getX(),player.getY(),player);
        thread1.start();

        bullet b = null;
        for (int i = 0;i < 1;i++){

            bullet[i] = bullet1;
            bullet[i].setImage(image);
            bullet[i].setX(165);
            bullet[i].setY(1080);
            //pane.add(bullet[i], 0, 0);

            b = new bullet(165,556,bullet[i]);
            //b.start();


        }

        b.start();


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
            case SPACE:
                space = true;
                if (bx == 999){
                    bx = 0;
                }
                else {
                    bx++;
                }
                System.out.println("空白鍵:"+space);
                break;
        }

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
            case SPACE:
                space = false;
                System.out.println("空白鍵:"+space);
                break;
        }
        //thread1.start();
    }





}
