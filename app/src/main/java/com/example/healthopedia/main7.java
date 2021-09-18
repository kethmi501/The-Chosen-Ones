package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main7 extends AppCompatActivity {

    Button btn_e_b;
    Button btn_e_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        btn_e_b = findViewById(R.id.btn_e_b);
        btn_e_u = findViewById(R.id.btn_e_u);
    }
    public void onclick12(View v){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
}