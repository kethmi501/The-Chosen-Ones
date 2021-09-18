package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main5 extends AppCompatActivity {
    Button bt_s_bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bt_s_bck = findViewById(R.id.bt_s_bck);
    }
    public void onclick8(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}