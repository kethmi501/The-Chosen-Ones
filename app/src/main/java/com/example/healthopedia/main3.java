package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main3 extends AppCompatActivity {

    Button btn_range;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_range = findViewById(R.id.btn_range);
        btn_back = findViewById(R.id.btn_back);
    }

    public void OnClick3(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void OnClick4(View v){
        Intent intent = new Intent(this,main1.class);
        startActivity(intent);
    }
}