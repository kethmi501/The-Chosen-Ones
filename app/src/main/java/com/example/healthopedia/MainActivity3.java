package com.example.healthopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthopedia.database.FoodDBHelper;

public class MainActivity3 extends AppCompatActivity {
    EditText text_name;
    EditText text_size;
    EditText text_type;
    EditText text_date;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text_name = findViewById(R.id.text_name);
        text_size = findViewById(R.id.text_size);
        text_type = findViewById(R.id.text_type);
        text_date = findViewById(R.id.text_date);
        btn_save = findViewById(R.id.btn_save);

    }
    public void saveFood(View view){
        String foodName = text_name.getText().toString();
        String size = text_size.getText().toString();
        String type = text_type.getText().toString();
        String date = text_date.getText().toString();
        FoodDBHelper dbh = new FoodDBHelper(this);

        if (foodName.isEmpty()||size.isEmpty()||type.isEmpty()||date.isEmpty()){
            Toast.makeText(this,"Enter values ",Toast.LENGTH_SHORT).show();
        }else{
            long inserted = dbh.addFood(foodName,size,type,date);

            if (inserted>0){
                Toast.makeText(this,"Data inserted successfully ",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Something went wrong ",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void BacktoPage(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);
    }
}