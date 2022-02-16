package com.example.android3lesson2.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android3lesson2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Android3lesson2);
        setContentView(R.layout.activity_main);

    }
}