package com.ntsan.examplejavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ntsan.examplejavaapp.databinding.ActivityButtonBinding;

public class ButtonActivity extends AppCompatActivity {

    private ActivityButtonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButtonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


        binding.imageBtn.setOnClickListener(this::imageBtnClicked);
        binding.nextActivityBtn.setOnClickListener(this::nextActivity);
    }

    public void imageBtnClicked(View view) {
        binding.textView.setText("Image button clicked");
    }

    public void constraintClick(View view) {
        binding.textView.setText("Screen clicked");
    }

    public void buttonClicked(View view) {
        binding.textView.setText("Button clicked");
    }

    public void visibility(View view) {
        ImageView img = binding.profileImage;
        Button btn = binding.hideShowBtn;

        if (img.getVisibility() == View.VISIBLE) {
            img.setVisibility(View.INVISIBLE);
            btn.setText("Show image");
        } else {
            img.setVisibility(View.VISIBLE);
            btn.setText("Hide image");
        }
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, SlowFadingActivity.class);
        startActivity(intent);
    }

}