package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
     double result_num;
    TextView tvResult;
    EditText num1, num2;
    Spinner sp;
    Button btnResult;
    String Hitung [] = {"Add","Subtract","Multiply","Divide"};

    String Hitung1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = findViewById(R.id.btnCalculate);

        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        sp = findViewById(R.id.spHitung);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Hitung);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Hitung1 = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
        public void Calculate(View view){
            if (num1.getText().toString().length() == 0 || num2.getText().toString().length() == 0){
                Toast.makeText(this, "Need to input number", Toast.LENGTH_SHORT).show();
            }
            else {
                switch (Hitung1){
                    case "Add":
                        result_num = Double.valueOf(num1.getText().toString()) + Double.valueOf(num2.getText().toString());
                        tvResult.setText(String.valueOf(result_num));
                        break;

                    case "Subtract":
                        result_num = Double.valueOf(num1.getText().toString()) - Double.valueOf(num2.getText().toString());
                        tvResult.setText(String.valueOf(result_num));
                        break;

                    case "Multiply":
                        result_num = Double.valueOf(num1.getText().toString()) * Double.valueOf(num2.getText().toString());
                        tvResult.setText(String.valueOf(result_num));
                        break;

                    case "Divide":
                        result_num = Double.valueOf(num1.getText().toString()) / Double.valueOf(num2.getText().toString());
                        tvResult.setText(String.valueOf(result_num));
                        break;
                }

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("Angka1",num1.getText().toString());
                intent.putExtra("Angka2",num1.getText().toString());
                intent.putExtra("Result",String.valueOf(result_num));
                intent.putExtra("Calculate",String.valueOf(Hitung1));
                Toast.makeText(this,"" + result_num, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        }
    }






