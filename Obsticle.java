package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
//Creating an obstacle object
public class Obstacle implements GameObject {

    private Rect rectangle;
    private int color;

    public Obstacle(Rect rectangle, int color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    //method to see if the player hitting the obstacle object
    public boolean playerCollide(RectPlayer player){
        if(rectangle.contains(player.getRectangle().left, player.getRectangle().top)
                || rectangle.contains(player.getRectangle().right, player.getRectangle().top)
                || rectangle.contains(player.getRectangle().left, player.getRectangle().bottom)
                || rectangle.contains(player.getRectangle().right, player.getRectangle().bottom)
        return true; //true if the player hits the obstacle
        return false;
    }

    //Drawing the obstacle with a color and shape
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }


    @Override
    public void update() {

    }
}
