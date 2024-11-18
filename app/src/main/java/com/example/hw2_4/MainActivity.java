package com.example.hw2_4;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    EditText emailInput;
    EditText passwordInput;
    AppCompatButton button;
    TextView txt;
    TextView txt2;

    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        passwordInput = findViewById(R.id.password);
        emailInput = findViewById(R.id.mail);
        button = findViewById(R.id.button);
        txt = findViewById(R.id.txt);
        txt2 = findViewById(R.id.txt2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkFieldsForEmptyValues();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        emailInput.addTextChangedListener(textWatcher);
        passwordInput.addTextChangedListener(textWatcher);



        button.setOnClickListener(v -> {

            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            if (email.equals("admin") && password.equals("admin")) {
                emailInput.setVisibility(View.INVISIBLE);
                passwordInput.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
                txt2.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                Snackbar.make(v, "Вход выполнен", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(v, "Неверный логин или пароль", Snackbar.LENGTH_SHORT).show();

            }
        });


    }

    private void checkFieldsForEmptyValues() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()) {
            button.setEnabled(true);
            button.setBackgroundColor(getResources().getColor(R.color.orange));
        } else {
            button.setEnabled(false);
            button.setBackgroundColor(getResources().getColor(R.color.gray));
        }

    }
}