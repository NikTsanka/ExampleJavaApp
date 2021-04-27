package com.ntsan.examplejavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ntsan.examplejavaapp.databinding.ActivityVideoBinding;

public class VideoActivity extends AppCompatActivity {

    private ActivityVideoBinding binding;

    /*public void nextActivityOnClick(View view){
        Intent intent = new Intent(this, AudioActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

        VideoView videoView = binding.videoView;
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sword);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();

        binding.videoView.setOnClickListener(this::nextActivity);
    }

    private void nextActivity(View view){
        Intent intent = new Intent(this, AudioActivity.class);
        startActivity(intent);
    }
}