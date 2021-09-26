package com.example.healthopedia;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthopedia.database.DBHelper;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    EditText text_goal;
    EditText text_food;
    EditText text_remain;
    Button btn_addFood;
    Button btn_viewFood;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_goal = findViewById(R.id.text_goal);
        text_food = findViewById(R.id.text_food);
        text_remain = findViewById(R.id.text_remain);
        btn_addFood = findViewById(R.id.btn_addFood);
        btn_viewFood = findViewById(R.id.btn_viewFood);


        Intent intent = getIntent();
        double goalValue = intent.getDoubleExtra("doubleVariable", 0.0);
        text_goal.setText(goalValue + "cal");


    }

    public void addFood (View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
        startActivity(intent);
    }

    public void viewAllFood(View view){
        DBHelper dbh  = new DBHelper(this);
        List info = dbh.readAllFoods();
        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Food Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String foodName = infoArray[i].split(":")[0];
                String size = infoArray[i].split(":")[1];
                String calory = infoArray[i].split(":")[2];

                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}