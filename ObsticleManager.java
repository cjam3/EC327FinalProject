package com.example.mgame;

import android.graphics.Canvas;

import java.util.ArrayList;

public class ObsticleManager {
    //higher index = lower on screen = higher y val
    private ArrayList<Obsticle> obsticles;
    private  int playerGap;
    private int obsticleGap;
    private int obsticleHeight;
    private int color;

    public ObsticleManager(int playerGap, int obsticleGap, int obsticleHeight ){
        this.playerGap = playerGap;
        this.obsticleGap = obsticleGap;
        this.obsticleHeight = obsticleHeight;
        this.color = color;

        startTime = System.currentTimeMillis();

        obsticles = new ArrayList<>();

        populateObsticles();


    }

    private void populateObsticles(){
        int currY = -5*Constants.SCREEN_HEIGHT/4;
        while (obsticles.get(obsticles.size()-1).getRectangle().bottom < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obsticles.add(new Obsticle(obsticleHeight, color, xStart, currY, playerGap));
            currY += obsticleHeight + obsticleGap;
        }
    }

    public void update(){
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = Constants.SCREEN_HEIGHT/10000.0f;
        for(Obsticle ob: obsticles){
            ob.incrementY(speed*elapsedTime);
        }
        if (obsticles.get(obsticles.size()-1).getRectangle().top >= Constants.SCREEN_HEIGHT){
            obsticles.add(0, new Obstricle(obsticleHeight, color, xStart,obsticles.get(0).getRectangle().top + obsticleHeight + obsticleGap ,playerGap))
        }

    }

    public void draw(Canvas canvas){
        for(Obsticle ob : obsticles)
            ob.draw(canvas);
    }
}
