package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_bmi;
    Button btn_water;
    Button btn_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bmi = findViewById(R.id.btn_bmi);
        btn_water = findViewById(R.id.btn_water);
        btn_info = findViewById(R.id.btn_info);

    }

    public void OnClick1(View v){
        Intent intent = new Intent(this,main.class);
        startActivity(intent);
    }
    public void OnClick2(View v){
        Intent intent = new Intent(this,main3.class);
        startActivity(intent);
    }

    public void water(View v){
        Intent intent = new Intent(this,main4.class);
        startActivity(intent);
    }

}