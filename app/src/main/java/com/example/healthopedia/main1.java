package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main1 extends AppCompatActivity {
    Button bt_bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        bt_bck = findViewById(R.id.bt_bck);
    }

    public void OnClick5(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}