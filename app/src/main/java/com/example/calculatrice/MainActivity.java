package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView ecran;
    LinearLayout extendedLayout;
    CheckBox checkBox;
    double value1 = 0, value2 = 0, result = 0;
    String affichage = "";
    char operator;

    static String ZERO = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecran = findViewById(R.id.ecran);
        ecran.setText(ZERO);

        extendedLayout = findViewById(R.id.extendedLayout);
        checkBox = findViewById(R.id.checkBox);
    }

    public void afficherChiffre(View view) {
        Button btn = (Button) view;
        String ecranText = ecran.getText().toString();
        String chiffre = btn.getText().toString();
        ecran.setText(ZERO.equals(ecranText) ?chiffre: ecranText+chiffre);
    }

    public void plusOperation(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        operator = '+';
        ecran.setText(ZERO);
    }

    public void minusOperation(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        operator = '-';
        ecran.setText(ZERO);
    }

    public void divOperation(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        operator = '/';
        ecran.setText(ZERO);
    }

    public void mulOperation(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        operator = '*';
        ecran.setText(ZERO);
    }

    public void equalOperation(View view){
        value2 = Double.parseDouble(ecran.getText().toString());
        switch (operator){
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                if (value2 != 0)
                    result = value1 / value2;
                else{
                    Toast.makeText(MainActivity.this,"Impossible de diviser par zero!",Toast.LENGTH_LONG).show();
                    affichage = "Erreur!";
                }
                break;
        }
        if ("Erreur!".equals(affichage)){
            ecran.setText(affichage);
            affichage = "";
        }
        else
            ecran.setText(String.valueOf(result));
    }

    public void ce(View view) {
        ecran.setText(ZERO);
    }

    public void onChecked(View view) {
        if (checkBox.isChecked())
            extendedLayout.setVisibility(extendedLayout.VISIBLE);
        else
            extendedLayout.setVisibility(extendedLayout.INVISIBLE);
    }

    public void inverse(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        if (value1 != 0){
            result = 1 / value1;
            ecran.setText(String.valueOf(result));
        }
        else
            Toast.makeText(MainActivity.this,"Impossible de diviser par zero!",Toast.LENGTH_LONG).show();
    }

    public void cos(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        result = Math.cos(value1);
        ecran.setText(String.valueOf(result));
    }

    public void sin(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        result = Math.sin(value1);
        ecran.setText(String.valueOf(result));
    }

    public void tan(View view){
        value1 = Double.parseDouble(ecran.getText().toString());
        result = Math.tan(value1);
        ecran.setText(String.valueOf(result));
    }
}