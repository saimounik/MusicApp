package com.example.android.music;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {
    private List<Song> songsList;

    SongAdapter(List<Song> songsList) {
        this.songsList = songsList;
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Song song = songsList.get(position);
        holder.song.setText(song.getSong_name());
        holder.artist.setText(song.getArtist_name());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView song, artist;
        ImageButton play;
        ImageView art;

        MyViewHolder(View view) {
            super(view);
            song = view.findViewById(R.id.song_name_textView_ID);
            artist = view.findViewById(R.id.artist_name_textView_ID);
            play = view.findViewById(R.id.play_Image_button);
            art = view.findViewById(R.id.art);
        }
    }


}
