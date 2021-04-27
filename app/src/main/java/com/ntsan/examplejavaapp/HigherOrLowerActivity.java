package com.ntsan.examplejavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ntsan.examplejavaapp.databinding.ActivityHigherOrLowerBinding;

public class HigherOrLowerActivity extends AppCompatActivity {

    private ActivityHigherOrLowerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHigherOrLowerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

        ImageView imageView = binding.galaxyImgView;
        Animation rotateBackground = AnimationUtils.loadAnimation(this, R.anim.rotation_anim);
        imageView.startAnimation(rotateBackground);


    }

}