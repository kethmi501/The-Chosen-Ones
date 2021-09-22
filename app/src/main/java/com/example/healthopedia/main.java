package com.example.healthopedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthopedia.database.DBhelper;

import java.util.List;

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
            DBhelper dBhelper = new DBhelper(this);
            List info = dBhelper.readAll();
            String[] infoArr = (String[])info.toArray( new String[0]);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("BMI History");

            builder.setItems(infoArr, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    String height = infoArr[i].split(":")[0];//this will only display the un not pw


                    Toast.makeText(main.this,height,Toast.LENGTH_SHORT).show();

                    Etheight.setText(height);
                    Etweight.setText("Enter value to update");

                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show(); //simillar to toast

        }

    public void deleteInfo(View v){
        DBhelper dbhelper = new DBhelper(this); //you can have this global in the oncreate method
        String height = Etheight.getText().toString();

        if(height.isEmpty()){
            Toast.makeText(main.this,"Select a value",Toast.LENGTH_SHORT).show();
        }else{
            dbhelper.deleteInfo(height);
            Toast.makeText(main.this,height+ " User deleted successfully",Toast.LENGTH_SHORT).show();
        }
    }
    }
