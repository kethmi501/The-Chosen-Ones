package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main4 extends AppCompatActivity {
    Button btn_bck_w;
    Button btn_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn_bck_w = findViewById(R.id.btn_bck_w);
        btn_msg = findViewById(R.id.btn_msg);
    }

    public void onclick6(View v){
        Intent intent = new Intent(this,main5.class);
        startActivity(intent);
    }
    public void onclick7(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}