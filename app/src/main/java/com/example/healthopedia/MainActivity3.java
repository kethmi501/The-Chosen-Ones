package com.example.healthopedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthopedia.database.DBHelper;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    EditText text_name;
    EditText text_size;
    EditText text_calory;
    Button btn_edit;
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text_name = findViewById(R.id.text_name);
        text_size = findViewById(R.id.text_size);
        text_calory = findViewById(R.id.text_calory);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);


    }

    public void deleteFood(View view){
        DBHelper dbh = new DBHelper(this);
        String foodName = text_name.getText().toString();

        if(foodName.isEmpty()){
            Toast.makeText(this, "Select a food", Toast.LENGTH_SHORT).show();
        }else{
            dbh.deleteFood(foodName);
            Toast.makeText(this, foodName + "is successfully deleted", Toast.LENGTH_SHORT).show();

        }
    }

    public void updateFood(View view){
        DBHelper dbh = new DBHelper(this);
        String foodName = text_name.getText().toString();
        String size = text_size.getText().toString();
        String calory = text_calory.getText().toString();

        if(foodName.isEmpty()||size.isEmpty()||calory.isEmpty()){
            Toast.makeText(this, "Select or type food", Toast.LENGTH_SHORT).show();
        }else{
            dbh.updateInfo(view,foodName,size,calory);
            Toast.makeText(this, foodName + "is successfully updated", Toast.LENGTH_SHORT).show();
        }
    }


}