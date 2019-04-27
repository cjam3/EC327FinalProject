package com.example.myapplication;

import android.graphics.Canvas;
import android .graphics.Rect;
import android.graphics.Point;
import android.graphics.Paint;



public class RectPlayer implements GameObject {
    private Rect rectangle; //rect object
    private int color;

    //Returning our rectangle
    public Rect getRectangle(){
        return rectangle;
    }

    public RectPlayer(Rect rectangle, int  color) {

        this.rectangle = rectangle;
        this.color = color;
    }


    //Drawing the player onto the canvas
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint(); //creating a paint here
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
    // point to the center of the rectangle
    // The top of the screen is the zero y value(going down is positive)
    public void update(Point point){
        //left,top,right, bottom
        rectangle.set(point.x - rectangle.width()/2,point.y - rectangle.height()/2,point.x + rectangle.width()/2, point.y + rectangle.height()/2);
    }

}