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
    Button btn_bck;
    TextView tv_ans;
    EditText Et_name;
    EditText Etheight;
    EditText Etweight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_vhis = findViewById(R.id.btn_vhis);
        btn_ok = findViewById(R.id.btn_ok);
        btn_bck = findViewById(R.id.btn_bck);

        tv_ans =  findViewById(R.id.tv_ans);
        Et_name =  findViewById(R.id.Et_name);
        Etheight = findViewById(R.id.Etheight);
        Etweight = findViewById(R.id.Etweight);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = (Et_name.getText().toString());
                float num2 = Float.parseFloat(Etheight.getText().toString());
                float num3 = Float.parseFloat(Etweight.getText().toString());
                float s = (num2 * num2);
                float t = (num3/s)*10000;
                tv_ans.setText("Answer is "+t);
            }
        });

    }

    public void saveUser(View v){
        String name = Et_name.getText().toString();
        String height = Etheight.getText().toString();
        String weight = Etweight.getText().toString();
        String bmi = tv_ans.getText().toString();
        DBhelper dbhelper = new DBhelper(this);

        if(height.isEmpty() || weight.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            dbhelper.addInfo(name,height, weight, bmi);
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
                    String name = infoArr[i].split(":")[0];//this will only display the un not pw


                    Toast.makeText(main.this,name,Toast.LENGTH_LONG).show();

                    Et_name.setText(name);


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
        String name = Et_name.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(main.this,"Select a value",Toast.LENGTH_LONG).show();
        }else{
            dbhelper.deleteInfo(name);
            Toast.makeText(main.this,name+ " deleted successfully",Toast.LENGTH_LONG).show();
        }
    }

    public void BackToHome(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
