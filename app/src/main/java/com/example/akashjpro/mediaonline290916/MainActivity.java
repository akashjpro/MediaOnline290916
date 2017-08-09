package com.example.akashjpro.mediaonline290916;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    Button btnPlayMp3, btnPlayMp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        btnPlayMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayNhacMp3("http://khoapham.vn/download/vietnamoi.mp3");
            }
        });

        btnPlayMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayVideo.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnPlayMp3 = (Button) findViewById(R.id.btnPlayMp3);
        btnPlayMp4 = (Button) findViewById(R.id.btnPlayMp4);
    }

    public void PlayNhacMp3(String url){
        //url = "http://khoapham.vn/download/vietnamoi.mp3";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
