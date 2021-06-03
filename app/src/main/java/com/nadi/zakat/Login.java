package com.nadi.zakat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import model.DataUser;
import model.user;

public class Login extends AppCompatActivity {

    private Button main_login_button;
    private TextView main_signup_textview;
    private TextInputLayout main_textinput_email, main_textinput_password;
    private ArrayList<user> data;
    private boolean lihat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().hide();
        data = DataUser.bambank;

        main_login_button = findViewById(R.id.main_login_button);
        main_signup_textview = findViewById(R.id.main_signup_textview);
        main_textinput_email = findViewById(R.id.main_textinput_email);
        main_textinput_password = findViewById(R.id.main_textinput_password);
        lihat = false;

        main_signup_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SignUp.class);
                finish();
                startActivity(intent);
            }
        });
        main_textinput_email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = main_textinput_email.getEditText().getText().toString().trim();
                main_login_button.setEnabled(!email.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        main_textinput_password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = main_textinput_password.getEditText().getText().toString().trim();
                main_login_button.setEnabled(!password.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        main_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = main_textinput_email.getEditText().getText().toString().trim();
                String password = main_textinput_password.getEditText().getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()){
                    main_login_button.setEnabled(true);
                    for (int i = 0; i < data.size(); i++){
                        user check = data.get(i);
                        if (check.getEmail().equalsIgnoreCase(email) && check.getPassword().equals(password)){
                            lihat = true;
                            main_login_button.setEnabled(true);
                            Intent intent = new Intent(getBaseContext(), zakat_maal_umum.class);
                            intent.putExtra("user", check);
                            intent.putExtra("index", i);
                            finish();
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                            break;
                        }else{
                        }
                    }
                }else{
                    main_textinput_email.setError("Please Correct the email");
                    main_textinput_password.setError("Please Correct the password");
                    Toast.makeText(getApplicationContext(), "Unable to Login, Wrong Email or Password!", Toast.LENGTH_SHORT).show();
                }
                if (lihat == false){
                    main_textinput_email.setError("Please Correct the email");
                    main_textinput_password.setError("Please Correct the password");
                    Toast.makeText(getApplicationContext(), "Unable to Login, Wrong Email or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}