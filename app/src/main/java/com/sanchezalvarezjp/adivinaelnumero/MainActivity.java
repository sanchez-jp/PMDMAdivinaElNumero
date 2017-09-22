package com.sanchezalvarezjp.adivinaelnumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int numero;
    TextView textView;
    EditText editText;
    Button button;
    Button btnAgain;

    String ACIERTO = "HAS ACERTADO!";
    String FALLO = "ERROR! Prueba otra vez";

    NumeroSecreto ns;


    public MainActivity() {
        numero = new Random().nextInt(10);
        System.out.println(numero);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        btnAgain = (Button)findViewById(R.id.btnAgain);

        ns = new NumeroSecreto();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!String.valueOf(editText.getText()).equals("")) {
                    if (ns.checkNumber(Integer.parseInt(String.valueOf(editText.getText())))) {
                        Toast.makeText(MainActivity.this, ACIERTO, Toast.LENGTH_SHORT).show();
                        button.setEnabled(false);
                        btnAgain.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(MainActivity.this, FALLO, Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    }
                }


            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().clear();
                button.setEnabled(true);
                btnAgain.setVisibility(View.INVISIBLE);
            }
        });

    }
}
