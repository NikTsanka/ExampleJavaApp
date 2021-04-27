package com.ntsan.examplejavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ntsan.examplejavaapp.databinding.ActivitySlowFadingBinding;

public class SlowFadingActivity extends AppCompatActivity {

    private ActivitySlowFadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySlowFadingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        binding.showAnimOne.setOnClickListener(this::showAnimOne);
        binding.showAnimTwo.setOnClickListener(this::showAnimTwo);
        binding.nextActivityBtn.setOnClickListener(this::nextActivity);
    }

    public void showAnimOne(View view){
        ImageView imgView = binding.logoImage;
        Animation fadingAnim = AnimationUtils.loadAnimation(this, R.anim.fading_anim);
        imgView.startAnimation(fadingAnim);

        fadingAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.setFillAfter(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void showAnimTwo(View view){
        ImageView imgView = binding.logoImage;
        Animation fadingAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_anim);
        imgView.startAnimation(fadingAnim);
    }


    public void nextActivity(View view) {
        Intent intent = new Intent(this, BackgroundActivity.class);
        startActivity(intent);
    }
}