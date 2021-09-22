package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthopedia.database.DBhelper;

public class main extends AppCompatActivity {
    //initialize
    Button btn_vhis;
    Button btn_ok;
    TextView tv_ans;
    EditText Etheight;
    EditText Etweight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_vhis = findViewById(R.id.btn_vhis);
        btn_ok = findViewById(R.id.btn_ok);

        tv_ans =  findViewById(R.id.tv_ans);
        Etheight = findViewById(R.id.Etheight);
        Etweight = findViewById(R.id.Etweight);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num2 = Float.parseFloat(Etheight.getText().toString());
                float num3 = Float.parseFloat(Etweight.getText().toString());
                float s = (num2 * num2);
                float t = (num3/s)*10000;
                tv_ans.setText("Answer is "+t);
            }
        });

    }

    public void saveUser(View v){
        String height = Etheight.getText().toString();
        String weight = Etweight.getText().toString();
        String bmi = tv_ans.getText().toString();
        DBhelper dbhelper = new DBhelper(this);

        if(height.isEmpty() || weight.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            dbhelper.addInfo(height, weight, bmi);
        }
    }

    public void sum(View v)
    {

    }
    public void OnClick14(View v){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
}