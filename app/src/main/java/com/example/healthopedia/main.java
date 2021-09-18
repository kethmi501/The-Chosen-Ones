package com.example.healthopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class main extends AppCompatActivity {
    private Button btn_vhis;
    private Button btn_ok;
    private TextView tv_ans;
    private EditText Etheight;
    private EditText Etweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_vhis = (Button)findViewById(R.id.btn_vhis);

        btn_ok = (Button)findViewById(R.id.btn_ok);
        tv_ans = (TextView) findViewById(R.id.tv_ans);
        Etheight = (EditText)findViewById(R.id.Etheight);
        Etweight = (EditText)findViewById(R.id.Etweight);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num2 = Integer.parseInt(Etheight.getText().toString());
                float num3 = Integer.parseInt(Etweight.getText().toString());
                float s = (num2 * num2);
                float t = num3/s;
                tv_ans.setText("ans : "+t);
            }
        });

    }

    public void sum(View v)
    {

    }
    public void OnClick14(View v){
        Intent intent = new Intent(this,main6.class);
        startActivity(intent);
    }
}