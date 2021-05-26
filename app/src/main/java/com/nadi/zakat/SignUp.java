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

import model.DataUser;
import model.user;

public class SignUp extends AppCompatActivity {

    private TextView create_login_textview;
    private Button create_signup_button;
    private TextInputLayout create_nama_input, create_email_input, create_password_input;
    private boolean createEmail, createPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        getSupportActionBar().hide();

        create_login_textview = findViewById(R.id.create_login_textview);
        create_signup_button = findViewById(R.id.create_signup_button);
        create_nama_input = findViewById(R.id.create_nama_input);
        create_email_input = findViewById(R.id.create_email_input);
        create_password_input = findViewById(R.id.create_password_input);
        createEmail = false;
        createPassword = false;

        create_email_input.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = create_email_input.getEditText().getText().toString().trim();

                if (email.isEmpty()){
                    create_email_input.setError("Please Fil The Email Coloumn");
                    createEmail = false;
                }else{
                    create_email_input.setError("");
                    createEmail = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        create_password_input.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = create_password_input.getEditText().getText().toString().trim();

                if (password.isEmpty()){
                    create_password_input.setError("Please Fill the PASSWORD");
                    createPassword = false;
                }else{
                    createPassword = true;
                    create_password_input.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        create_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = create_nama_input.getEditText().getText().toString().trim();
                String email = create_email_input.getEditText().getText().toString().trim();
                String password = create_password_input.getEditText().getText().toString().trim();


                if (nama.isEmpty()){
                    create_nama_input.setError("Please Fil The Name Coloumn");
                }else{

                }
                if (!nama.isEmpty() && createPassword == true && createEmail == true ){
                    create_signup_button.setEnabled(true);
                    Intent intent = new Intent(getBaseContext(), Login.class);
                    user user = new user(nama, email, password);
                    DataUser.bambank.add(user);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(), "Account Created !!", Toast.LENGTH_SHORT).show();
                }else{
                    create_signup_button.setEnabled(false);
                }
            }
        });

        create_login_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                finish();
                startActivity(intent);
            }
        });
    }
}