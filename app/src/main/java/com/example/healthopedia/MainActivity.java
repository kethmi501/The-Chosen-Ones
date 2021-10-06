package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text_age;
    EditText text_height;
    EditText text_weight;
    EditText text_gender;
    RadioButton rdb_light;
    RadioButton rdb_mode;
    RadioButton rdb_high;
    Button btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_age = findViewById(R.id.text_age);
        text_height = findViewById(R.id.text_height);
        text_weight = findViewById(R.id.text_weight);
        text_gender = findViewById(R.id.text_gender);
        rdb_light = findViewById(R.id.rdb_light);
        rdb_mode = findViewById(R.id.rdb_mode);
        rdb_high = findViewById(R.id.rdb_high);
        btn_calculate = findViewById(R.id.btn_calculate);
    }
    public void CalculateAndSendAnswer(View view){
        Calculation cal = new Calculation();
        String age = text_age.getText().toString();
        String height = text_height.getText().toString();
        String weight = text_weight.getText().toString();
        String gender = text_gender.getText().toString();

        if (TextUtils.isEmpty(age)){
            Toast.makeText(this, "Enter the age", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(height)){
            Toast.makeText(this, "Enter the height", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(weight)){
            Toast.makeText(this, "Enter the weight", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Enter the gender", Toast.LENGTH_SHORT).show();
        }else {
            int temp_age = Integer.parseInt(age);
            double temp_height = Integer.parseInt(height);
            double temp_weight = Integer.parseInt(weight);
            double value;
            if (rdb_light.isChecked()){
                value = cal.calculateCalLight(temp_age,temp_height,temp_weight,gender);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("doubleVariable", value);
                startActivity(intent);
            }else if (rdb_mode.isChecked()){
                value = cal.calculateCalModerate(temp_age,temp_height,temp_weight,gender);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("doubleVariable", value);
                startActivity(intent);
            }else if (rdb_high.isChecked()){
                value = cal.calculateCalHigh(temp_age,temp_height,temp_weight,gender);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("doubleVariable", value);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Select the activity level", Toast.LENGTH_SHORT).show();
            }
        }
    }
}