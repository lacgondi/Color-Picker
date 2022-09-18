package com.example.colorpicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private Slider red;
    private int redValue;
    private Slider green;
    private int greenValue;
    private Slider blue;
    private int blueValue;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;
    private RelativeLayout coloredLay;
    private TextView currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        red.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                redValue = (int) red.getValue();
                redText.setText("Red: " + redValue);
                currentColor.setText(colorTextString(redValue, greenValue, blueValue));
                coloredLay.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }
        });

        green.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                greenValue = (int) green.getValue();
                greenText.setText("Green: " + greenValue);
                currentColor.setText(colorTextString(redValue, greenValue, blueValue));
                coloredLay.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }
        });

        blue.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                blueValue = (int) blue.getValue();
                blueText.setText("Blue: " + blueValue);
                currentColor.setText(colorTextString(redValue, greenValue, blueValue));
                coloredLay.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
            }
        });
    }

    private void init() {
        red = findViewById(R.id.redSlider);
        redValue = (int) red.getValue();
        green = findViewById(R.id.greenSlider);
        greenValue = (int) green.getValue();
        blue = findViewById(R.id.blueSlider);
        blueValue = (int) blue.getValue();
        redText = findViewById(R.id.redLabel);
        greenText = findViewById(R.id.greenLabel);
        blueText = findViewById(R.id.blueLabel);
        coloredLay = findViewById(R.id.coloredLayout);
        currentColor = findViewById(R.id.currentColor);
    }

    private String colorTextString(int r, int g, int b) {
        return "(" + r + "," + g + "," + b + ")";
    }
}