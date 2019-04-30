package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Point;
import android.graphics.Paint;



public class RectPlayer implements GameObject {
    private Rect rectangle; //rect object
    private int color;

    private Animation idle; // added recently
    private Animation walkRight;
    private Animation walkLeft;
    private AnimationManager animManager; //added recently

    //Returning our rectangle
    public Rect getRectangle(){
        return rectangle;
    }

    public RectPlayer(Rect rectangle, int  color) {

        this.rectangle = rectangle;
        this.color = color;
        //creating the animation and modifying bitmap (alienBlue -> alienblue)
        BitmapFactory bf = new BitmapFactory();
        Bitmap idleImg = bf.decodeResourse(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienblue);
        Bitmap walk1 = bf.decodeResourse(Constants.CURRENT_CONTEX.getResources(), R.drawable.alienblue_walk1);
        Bitmap walk2 = bf.decodeResourse(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienblue_walk2);

        //By default alien's walking to the right so at this point we only create walkRight 
        idle = new Animation(new Bitmap[]{idleImg}, 2); 
        walkRight = new Animation(new Bitmap[]{walk1, walk2}, 0.5f);

        Matrix m = new Matrix(); //
        m.preScale(-1,1); //x coordinates gets flipped
        // ALTERING THE FACE TO THE OTHER WAY
        walk1 = Bitmap.createBitmap(walk1, 0, 0, walk1.getWidth(), walk1.getHeight(), m, false);
        walk2 = Bitmap.createBitmap(walk1, 0, 0, walk2.getWidth(), walk2 .getHeight(), m, false);

        walkLeft = new Animation(new Bitmap[]{walk1, walk2}, 0.5f); 

        animManager = new AnimationManager(new Animation[]{idle, walkRight, walkLeft} )
    }   


    //Drawing the player onto the canvas
    @Override
    public void draw(Canvas canvas) {
        //Paint paint = new Paint(); //creating a paint here
        //paint.setColor(color);
        //canvas.drawRect(rectangle, paint);
        animManager.draw(canvas, rectangle);
    }

    @Override
    public void update() {
        animManager.update();

    }
    // point to the center of the rectangle
    // The top of the screen is the zero y value(going down is positive)
    public void update(Point point){
        float oldLeft = rectangle.left;

        //left,top,right, bottom
        rectangle.set(point.x - rectangle.width()/2,point.y - rectangle.height()/2,point.x + rectangle.width()/2, point.y + rectangle.height()/2);

        //state is 1 means walking to the right, 2 walking to the left 
        int state = 0;
        if(rectangle.left - oldLeft > 5) // if 0 only walk a fraction of pixel so not good so 5
            state = 1;
        else if (rectangle.left - oldLeft < -5)
            state = 2;

        animManager.playAnim(state)
        animManager.update(); 

    }

}
