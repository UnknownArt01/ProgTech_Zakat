package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import model.Emas;

public class zakat_emas extends AppCompatActivity {
    private TextInputLayout emas_mentah_textInputLayout, emas_pakai_textInputLayout, harga_emas_textInputLayout;
    private Button hitung_emas_button;
    private int bayar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_emas);
        initView();
        setListener();


    }

    private void setListener() {
        hitung_emas_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int emas_mentah = Integer.parseInt(emas_mentah_textInputLayout.getEditText().getText().toString().trim());
                int emas_pakai = Integer.parseInt(emas_pakai_textInputLayout.getEditText().getText().toString().trim());
                int harga_emas = Integer.parseInt(harga_emas_textInputLayout.getEditText().getText().toString().trim());

                Emas temp = new Emas(emas_mentah, emas_pakai, harga_emas, bayar);

                Intent intent = new Intent();
                intent.putExtra("emasBaru", temp);
                setResult(300, intent);
                finish();

            }
        });
    }

    private void initView() {
        emas_mentah_textInputLayout = findViewById(R.id.emas_mentah_textInputLayout);
        emas_pakai_textInputLayout = findViewById(R.id.emas_pakai_textInputLayout);
        harga_emas_textInputLayout = findViewById(R.id.harga_emas_textInputLayout);
        hitung_emas_button = findViewById(R.id.hitung_emas_button);
    }

}