package com.example.android.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Song> songsList = new ArrayList<>();
    SongAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list_item);
        // Custom Adapter
        mAdapter = new SongAdapter(songsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // OnClick on a song fromm the list
        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getApplicationContext(), recyclerView, new RecyclerClickListener.ClickListener() {
            // Single Click
            @Override
            public void onClick(View view, int position) {
                // Launch the song player activity
                Song song = songsList.get(position);
                Intent intent = new Intent(getApplicationContext(), SongPlay.class);
                // pass the song information to be played
                intent.putExtra("SONG_NAME", song.getSong_name());
                intent.putExtra("ARTIST_NAME", song.getArtist_name());
                startActivity(intent);
            }


            @Override
            public void onLongClick(View view, int position) {
                // Do nothing for now
            }
        }));

        recyclerView.setAdapter(mAdapter);
        prepareSongsData();
    }

    private void prepareSongsData() {
        songsList.add(new Song("Anaganaganaga", "Armaan Malik"));
        songsList.add(new Song("Peniviti", "Kaala Bhairava"));
        songsList.add(new Song("Yeda Poyindo", "Nikhita Srivalli,Kailash Kher,Penchal Das"));
        songsList.add(new Song("Reddy Ikkada Soodu", "Daler Mehndi,Anjana Soumya"));
        mAdapter.notifyDataSetChanged();
    }
}