package com.example.healthopedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthopedia.database.FoodDBHelper;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    EditText text_name;
    EditText text_size;
    EditText text_type;
    EditText text_date;
    Button btn_view;
    Button btn_edit;
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        text_name = findViewById(R.id.text_Viewname);
        text_size = findViewById(R.id.text_Viewsize);
        text_type = findViewById(R.id.text_Viewtype);
        text_date = findViewById(R.id.text_Viewdate);
        btn_view = findViewById(R.id.btn_view);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);
    }
    public void viewAllFood(View view){
        FoodDBHelper dbh  = new FoodDBHelper(this);
        List info = dbh.readAllFoods();
        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Food Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String foodName = infoArray[i].split(":")[0];
                String size = infoArray[i].split(":")[1];
                String type = infoArray[i].split(":")[2];
                String date = infoArray[i].split(":")[3];

                text_name.setText(foodName);
                text_size.setText(size);
                text_type.setText(type);
                text_date.setText(date);
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
    public void deleteFood(View view){
        FoodDBHelper dbh = new FoodDBHelper(this);
        String foodName = text_name.getText().toString();

        if(foodName.isEmpty()){
            Toast.makeText(this, "Select a food", Toast.LENGTH_SHORT).show();
        }else{
            dbh.deleteFood(foodName);
            Toast.makeText(this, foodName + "is successfully deleted", Toast.LENGTH_SHORT).show();

        }
    }

    public void updateFood(View view){
        FoodDBHelper dbh = new FoodDBHelper(this);
        String foodName = text_name.getText().toString();
        String size = text_size.getText().toString();
        String type = text_type.getText().toString();
        String date = text_date.getText().toString();

        if(foodName.isEmpty()||size.isEmpty()||type.isEmpty()||date.isEmpty()){
            Toast.makeText(this, "Select a food", Toast.LENGTH_SHORT).show();
        }else{
            dbh.updateInfo(view,foodName,size,type, date);
            Toast.makeText(this, foodName + " is successfully updated", Toast.LENGTH_SHORT).show();
        }
    }
    public void BacktoPage(View view){
        Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
        startActivity(intent);
    }
}