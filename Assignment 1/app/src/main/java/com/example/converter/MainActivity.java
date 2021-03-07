package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity
{
    EditText e1;
    TextView t2,t3,t5,t6;
    RadioButton r1, r2;
    String result ="";
    private String c = "Celsius Degrees:";
    private String f = "Fahrenheit Degrees:";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t6.setMovementMethod(new ScrollingMovementMethod());
        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);

        r1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Enter Degrees in Fahrenheit", Toast.LENGTH_SHORT).show();
                t2.setText(f);
                t3.setText(c);
            }
        });

        r2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Enter Degrees in Celsius", Toast.LENGTH_SHORT).show();
                t2.setText(c);
                t3.setText(f);
            }
        });

    }

    public void convertButton (View v)
    {
        String deg = e1.getText().toString().trim();

        if (r1.isChecked())
        {
            if(deg.isEmpty())
            {
               Toast.makeText(getApplicationContext(),"'Enter Value!",Toast.LENGTH_SHORT).show();
            }

            else
            {
                double input=Double.parseDouble(deg);
                double res;
                res = (input - 32.0) / 1.8;
                String output = String.format("%.1f", res);
                t5.setText(output);
                result = deg + " F ==> " + String.format("%.1f", res) + " C \n" + result;
                t6.setText(result);
            }

        }


        if (r2.isChecked())
        {
            if(deg.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"'Enter Value!",Toast.LENGTH_SHORT).show();
            }
            else
                {
                    double input=Double.parseDouble(deg);
                    double res;
                res = (input * 1.8) + 32.0;
                String output = String.format("%.1f", res);
                t5.setText(output);
                result = deg + " C ==> " + String.format("%.1f", res) + " F \n" + result;
                t6.setText(result);
            }
        }

    }

    public void clearButton(View v)
    {
        t5.setText("");
        t6.setText(" ");
        result = "";
        Toast.makeText(getApplicationContext(), "History Cleared", Toast.LENGTH_SHORT).show();
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("Text6",t6.getText().toString());
        outState.putString("Text5",t5.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        t6.setText(savedInstanceState.getString("Text6"));
        t5.setText(savedInstanceState.getString("Text5"));
        result=savedInstanceState.getString("Result");

    }

}
