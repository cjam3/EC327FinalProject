package com.example.mgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;


public class Animation {
    private Bitmap[] frames;
    private int frameIndex;

    private boolean isPlaying = false;
    public boolean isPlaying() {
        return isPlaying;
    }
    public void play() {
        isPlaying = true;
        frameIndex =0;
        lastFrame = System.currentTimeMillis();
    }
    public void stop(){
        isPlaying = false;

    }
    //time between the frames
    private float frameTime;

    private long  lastFrame;

    public Animation(Bitmap[] frames, float animTime){
        this.frames = frames;

        frameIndex = 0;
        //Total animation time divided by the number of frames
        //Evening the space timing between frames
        frameTime = animTime/frames.length;

        lastFrame = System.currentTimeMillis();
    }

    public void draw(Canvas canvas, Rect destination){
        if(!isPlaying)
            return;

        scaleRect(destination);


        canvas.drawBitmap(frames[frameIndex], null, destination, new Paint());
    }
    // So that the rectangle don't get distorted ( no stretching of the image)
    private void scaleRect(Rect rect){
        float whRatio = (float) (frames[frameIndex].getWidth())/frames[frameIndex].getHeight();
        if (rect.width() > rect.height())
            rect.left = rect.right - (int)(rect.height() * whRatio);
        else
            rect.top = rect.bottom - (int)(rect.width() * (1/whRatio));
    }

    public void update() {
        if (!isPlaying)
            return;

        if (System.currentTimeMillis() - lastFrame > frameTime * 1000) {
            //The animtime is in seconds so as the frametime  so we multiply frameTime by 1000 so
            //we're comparing milliseconds with milliseconds
            frameIndex++;
            frameIndex = frameIndex >= frames.length ? 0 : frameIndex;
            lastFrame = System.currentTimeMillis();
        }
    }
}
