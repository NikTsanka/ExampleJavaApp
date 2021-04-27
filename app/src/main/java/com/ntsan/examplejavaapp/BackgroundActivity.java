package com.ntsan.examplejavaapp;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ntsan.examplejavaapp.databinding.ActivityBackgroundBinding;

public class BackgroundActivity extends AppCompatActivity {

    private ActivityBackgroundBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBackgroundBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      binding.nextActivityBtn.setOnClickListener(this::nextActivity);

        ImageView imageView = binding.rotateBackground;
        Animation rotateBackground = AnimationUtils.loadAnimation(this, R.anim.rotation_anim);
        imageView.startAnimation(rotateBackground);
    }

    private void rotateAnim(View view) {
        ImageView imageView = binding.rotateBackground;
        Animation rotateBackground = AnimationUtils.loadAnimation(this, R.anim.rotation_anim);
        imageView.startAnimation(rotateBackground);
    }

    private void nextActivity(View view){
        Intent intent = new Intent(this, AudioActivity.class);
        startActivity(intent);
    }
}