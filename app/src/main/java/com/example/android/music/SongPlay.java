package com.example.android.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SongPlay extends AppCompatActivity {
    ImageButton prevButton, nextButton, playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_play);
        idButton();
        intentCall();

        prevButton.setOnClickListener((View v) -> Toast.makeText(getApplicationContext(), "previous Song ", Toast.LENGTH_SHORT).show());
        playButton.setOnClickListener((View v) -> Toast.makeText(getApplicationContext(), "Play Song ", Toast.LENGTH_SHORT).show());
        nextButton.setOnClickListener((View v) -> Toast.makeText(getApplicationContext(), "next Song ", Toast.LENGTH_SHORT).show());
    }

    public void intentCall() {
        Intent in = getIntent();
        TextView song_name = findViewById(R.id.song_name_display);
        TextView artist_name = findViewById(R.id.artist_name_display);
        song_name.setText(in.getStringExtra("SONG_NAME"));
        artist_name.setText(in.getStringExtra("ARTIST_NAME"));
    }

    public void idButton() {
        prevButton = findViewById(R.id.prev_image_button);
        nextButton = findViewById(R.id.next_image_button);
        playButton = findViewById(R.id.play_Image_button);
    }
}
