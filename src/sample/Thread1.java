package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Thread1 extends Thread{
    private String id;
    private double X;
    private double Y;
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
        if (Controller.w == true) {
            Y = Y - 10;
        }

        else if (Controller.s == true){
            Y = Y + 10;
        }

        else if (Controller.a == true){
            X = X - 10;
        }

        else if (Controller.d == true){
            X = X + 10;
        }
        player.setX(X);
        player.setY(Y);
    }
}
