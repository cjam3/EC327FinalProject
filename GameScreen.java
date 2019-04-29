package com.example.gameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        ImageButton pauseButton = findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //creates a menu with the resume and title screen buttons
                //the resume button will resume the game at the instance it was paused
                //the title screen button will return the user to the title screen (MainActivity)
            }
        });
    }
}
