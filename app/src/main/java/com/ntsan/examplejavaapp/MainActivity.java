package com.ntsan.examplejavaapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ntsan.examplejavaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        binding.button.setOnClickListener(this::nextActivity);
        binding.hiOrLowBtn.setOnClickListener(this::hiOrLowActivity);
        binding.musicPlayerBtn.setOnClickListener(this::playerActivity);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, GifActivity.class);
        startActivity(intent);
    }
    public void hiOrLowActivity(View view) {
        Intent intent = new Intent(this, HigherOrLowerActivity.class);
        startActivity(intent);
    }

    public void playerActivity(View view) {
        Intent intent = new Intent(this, AudioPlayerActivity.class);
        startActivity(intent);
    }

}