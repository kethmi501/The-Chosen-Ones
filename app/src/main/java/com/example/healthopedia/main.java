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


import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.healthopedia.database.DBhelper;

import java.util.List;

public class main extends AppCompatActivity {
    //initialize variables
    Button btn_vhis;
    Button btn_ok;
    Button btn_bck;
    TextView tv_ans;
    EditText Et_name;
    EditText Etheight;
    EditText Etweight;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign variables
        setContentView(R.layout.activity_main2);
        btn_vhis = findViewById(R.id.btn_vhis);
        btn_ok = findViewById(R.id.btn_ok);
        btn_bck = findViewById(R.id.btn_bck);

        tv_ans =  findViewById(R.id.tv_ans);
        Et_name =  findViewById(R.id.Et_name);
        Etheight = findViewById(R.id.Etheight);
        Etweight = findViewById(R.id.Etweight);

        //initialize validation styles
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //add validation for name
        awesomeValidation.addValidation(this,R.id.Et_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        //add validation for name
        awesomeValidation.addValidation(this,R.id.Etheight,"[0-9]{3}$",R.string.invalid_height);
        //add validation for name
        awesomeValidation.addValidation(this,R.id.Etweight,
                "[0-9]{2}$",R.string.invalid_weight);
    }

    public void s(View v) {
        if(awesomeValidation.validate()){
            String height = Etheight.getText().toString();
            String weight = Etweight.getText().toString();
            String bmi = tv_ans.getText().toString();

        String name = (Et_name.getText().toString());
        float num2 = Float.parseFloat(Etheight.getText().toString());
        float num3 = Float.parseFloat(Etweight.getText().toString());
            DBhelper  dbhelper = new DBhelper(this);
        float s = (num2 * num2);
        float t = (num3/s)*10000;
        tv_ans.setText("Answer is "+t);
        }else{
            Toast.makeText(getApplicationContext(),
                    "Validation Failed!!!",Toast.LENGTH_SHORT).show();
        }
    }


    public void saveUser(View v){

        if(awesomeValidation.validate()){
            Toast.makeText(getApplicationContext(),
                    "User Saved Successfully!!!",Toast.LENGTH_SHORT).show();
            String name = Et_name.getText().toString();
            String height = Etheight.getText().toString();
            String weight = Etweight.getText().toString();
            String bmi = tv_ans.getText().toString();
            DBhelper  dbhelper = new DBhelper(this);


            if(height.isEmpty() || weight.isEmpty()){
                Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
            }else{
                dbhelper.addInfo(name,height, weight, bmi);
            }
        }else{
            Toast.makeText(getApplicationContext(),
                    "Validation Failed!!!",Toast.LENGTH_SHORT).show();
        }

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
