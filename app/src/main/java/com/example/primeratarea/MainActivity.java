package com.example.primeratarea;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PrimeNumber primeNumber = new PrimeNumber();
    EditText chosenNumber;
    Button calcButton;
    TextView result;
    ArrayList numbersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chosenNumber = findViewById(R.id.editNumber);
        calcButton = findViewById(R.id.calc);
        result = findViewById(R.id.result);

        //Button 'Calcular' event
        calcButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String input = chosenNumber.getText().toString();
                int inputInt = 0;
                int finalNumber = 0;

                if (!input.isEmpty()){

                    inputInt = Integer.parseInt(input);

                    if(inputInt < 99999){
                        finalNumber = primeNumber.calc(inputInt);
                    }
                }

                if (inputInt == 0){
                    result.setText("No has introducido ningún número");
                } else if (inputInt > 99999){
                    result.setText("El número no debe tener más de cinco dígitos");
                } else {
                    result.setText("El número primo nº " + input + " es el " + finalNumber);
                }
            }
        });
    }
}