package com.example.hw2_4;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;



public class MainActivity extends AppCompatActivity {


    EditText emailInput;
    EditText passwordInput;
    AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        passwordInput = findViewById(R.id.password);
        emailInput = findViewById(R.id.mail);
        button = findViewById(R.id.button);


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
                Toast.makeText(MainActivity.this, "Вы успешно вошли", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();

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