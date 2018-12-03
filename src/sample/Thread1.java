package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.KeyException;
import java.security.PublicKey;

public class Thread1 extends Thread{
    private String id;
    static double X;
    //private double bX;
    static double Y;
    //private double bY;
    private int xx;
    private int yy;

    public ImageView player;


    public Thread1(String str,double x,double y,ImageView IV){
        id = str;
        X = x;
        Y = y;
        player = IV;
    }
    public void run(){
        while (true){
            if (Controller.w == true){
                if (Y <= -50){
                }
                else {
                    Y = Y - 10;
                }
            }
            if (Controller.s == true){
                if (Y >= 600){
                }
                else {
                    Y = Y + 10;
                }
            }
            if (Controller.a == true){
                if (X <= -70){
                }
                else {
                    X = X - 10;
                }
            }
            if (Controller.d == true){
                if (X >= 400){
                }
                else {
                    X = X + 10;
                }
            }

            player.setX(X);
            player.setY(Y);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
