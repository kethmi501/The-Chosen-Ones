package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main extends AppCompatActivity {
    Button btn_vhis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_vhis = findViewById(R.id.btn_vhis);
    }

    public void OnClick14(View v){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
}