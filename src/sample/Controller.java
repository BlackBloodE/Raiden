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

    public ImageView[] bullet = new ImageView[10];
    public Image image = new Image("bullet.png");
    public bullet[] bullets = new bullet[10];
    //static int bx = 0;

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

//        bullet b = null;
//        for (int i = 0;i < 1;i++){
//
//            bullet[i] = bullet1;
//            bullet[i].setImage(image);
//            bullet[i].setX(165);
//            bullet[i].setY(1080);
//            //pane.add(bullet[i], 0, 0);
//
//            b = new bullet(165,556,bullet[i]);
//            //b.start();
//
//
//        }
        bullet1.setImage(image);
        bullet1.setX(165);
        bullet1.setY(1080);
        for (int x = 0;x < 10;x++){
            bullet[x] = bullet1;
            bullets[x] = new bullet(165,556,bullet[x]);
        }
        Thread bullet1_thread = new Thread(bullets[0]);
        Thread bullet2_thread = new Thread(bullets[1]);
//        Thread bullet3_thread = new Thread(bullets[2]);
//        Thread bullet4_thread = new Thread(bullets[3]);
//        Thread bullet5_thread = new Thread(bullets[4]);
//        Thread bullet6_thread = new Thread(bullets[5]);
//        Thread bullet7_thread = new Thread(bullets[6]);
//        Thread bullet8_thread = new Thread(bullets[7]);
//        Thread bullet9_thread = new Thread(bullets[8]);
//        Thread bullet10_thread = new Thread(bullets[9]);

        bullet1_thread.start();
        bullet2_thread.start();
//        bullet3_thread.start();
//        bullet4_thread.start();
        //bullet5_thread.start();
//        bullet6_thread.start();
//        bullet7_thread.start();
//        bullet8_thread.start();
//        bullet9_thread.start();
//        bullet10_thread.start();

        //b .start();


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
//                if (bx == 999){
//                    bx = 0;
//                }
//                else {
//                    bx++;
//                }
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
