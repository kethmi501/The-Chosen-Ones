package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main6 extends AppCompatActivity {
    Button btn_h_b;
    Button btn_h_u;
    Button btn_h_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btn_h_b = findViewById(R.id.btn_h_b);
        btn_h_u = findViewById(R.id.btn_h_u);
        btn_h_d = findViewById(R.id.btn_h_d);
    }

    public void onclick9(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void onclick10(View v){
        Intent intent = new Intent(this,main7.class);
        startActivity(intent);
    }
    public void onclick11(View v){
        Intent intent = new Intent(this,main8.class);
        startActivity(intent);
    }
}