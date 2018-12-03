package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class bullet extends Thread{
    private double X;
    private double Y;

    public ImageView bullet1;
    private ImageView[] imageViews = new ImageView[100];
    private int spaceX = 0;
    private KeyValue[] keyValues = new KeyValue[100];
    private KeyFrame[] keyFrames = new KeyFrame[100];
    private Timeline[] timelines  = new Timeline[100];
    //private Timer timer = new Timer();

    public bullet(double x, double y, ImageView IV) {
        X = x;
        Y = y;
        bullet1 = IV;
        for (int i = 0;i < 100;i++){
            imageViews[i] = bullet1;
        }
    }
    public void run(){
        while (true){
            if (Controller.space == true){

                if (spaceX<100){
                    imageViews[spaceX].setY(Thread1.Y-51);
                    imageViews[spaceX].setX(Thread1.X);
                    keyValues[spaceX] = new KeyValue(imageViews[spaceX].yProperty(),Y-720);
                    keyFrames[spaceX]  = new KeyFrame(Duration.millis(500), keyValues[spaceX]);
                    timelines[spaceX]  = new Timeline();
                    //timeline.setCycleCount(Timeline.INDEFINITE);
                    timelines[spaceX].setAutoReverse(false);
                    timelines[spaceX].getKeyFrames().addAll(keyFrames[spaceX]);
                    //timelines[spaceX+1].setDelay(Duration.millis(1000));
                    timelines[spaceX].play();
                }
//                bullet1.setY(Thread1.Y-51);
//                bullet1.setX(Thread1.X);
//                //System.out.println(bullet1.yProperty());
//            KeyValue keyValue = new KeyValue(bullet1.yProperty(),Y-720);
//            KeyFrame keyFrame  = new KeyFrame(Duration.millis(500), keyValue);
//            Timeline timeline  = new Timeline();
//            //timeline.setCycleCount(Timeline.INDEFINITE);
//            timeline.setAutoReverse(false);
//            timeline.getKeyFrames().addAll(keyFrame);
//            timeline.play();

                if (spaceX == 99) {
                    spaceX = 0;
                }
                else {
                    spaceX++;
                }
                System.out.println(spaceX);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
