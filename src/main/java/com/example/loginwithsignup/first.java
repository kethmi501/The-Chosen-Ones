package com.example.loginwithsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first extends AppCompatActivity {

    private Button btn_alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void OnClickAlarmBut(View v){
        Intent intent = new Intent(this,AlarmMainActivity.class);
        startActivity(intent);
    }
}