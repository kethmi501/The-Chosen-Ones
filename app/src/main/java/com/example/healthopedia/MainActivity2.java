package com.example.healthopedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthopedia.database.FoodDBHelper;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    EditText text_goal;
    Button btn_addFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_goal = findViewById(R.id.text_goal);
        btn_addFood = findViewById(R.id.btn_add);

        Intent intent = getIntent();
        double goalValue = intent.getDoubleExtra("doubleVariable", 0.0);
        text_goal.setText(goalValue + "cal");
    }
    public void addFood (View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent);
    }
    public void viewFood(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
        startActivity(intent);
    }
}