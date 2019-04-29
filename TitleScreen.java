package com.example.gameproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageButton;

public class TitleScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.TitleScreen);

        ImageButton dayButton = findViewById(R.id.dayButton);
        ImageButton nightButton = findViewById(R.id.nightButton);
        ImageButton startButton = findViewById(R.id.startButton);

        dayButton.setOnClickListener(this);
        nightButton.setOnClickListener(this);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TitleScreen.this, GameScreen.class));
            }
        });
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.nightButton :
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
                break;
            }
            case R.id.dayButton :
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;
            }
            default :
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
                break;
            }
        }

    }
}
