package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main8 extends AppCompatActivity {
    Button btn_d_b;
    Button btn_d_d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        btn_d_b = findViewById(R.id.btn_d_b);
        btn_d_d = findViewById(R.id.btn_d_d);

    }

    public void onclick13(View v){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
    public void delete(View view){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
}