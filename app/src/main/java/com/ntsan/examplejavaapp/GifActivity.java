package com.ntsan.examplejavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ntsan.examplejavaapp.databinding.ActivityGifBinding;

public class GifActivity extends AppCompatActivity {

    private ActivityGifBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGifBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


        binding.button.setOnClickListener(this::nextActivity);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, ButtonActivity.class);
        startActivity(intent);
    }

}