package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class zakat_perak extends AppCompatActivity {
    private TextInputLayout perak_mentah_textInputLayout, harga_perak_textInputLayout;
    private Button hitung_perak_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perak);

        perak_mentah_textInputLayout = findViewById(R.id.perak_mentah_textInputLayout);
        harga_perak_textInputLayout = findViewById(R.id.harga_perak_textInputLayout);
        hitung_perak_button = findViewById(R.id.hitung_perak_button);
    }
}