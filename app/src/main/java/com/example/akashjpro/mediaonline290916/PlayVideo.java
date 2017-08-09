package com.example.akashjpro.mediaonline290916;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.example.akashjpro.mediaonline290916.R.id.videoView1;

public class PlayVideo extends AppCompatActivity {

    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        mVideoView = (VideoView) findViewById(videoView1);


        MediaController mediaController = new MediaController(PlayVideo.this);
        mediaController.setAnchorView(mVideoView);
        mediaController.setMediaPlayer(mVideoView);
        //Uri uri = Uri.parse("http://khoapham.vn/download/vuoncaovietnam.mp4");
        Uri uri = Uri.parse("https://ia800201.us.archive.org/22/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");

        mVideoView.setMediaController(mediaController);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.requestFocus();
    }
}
