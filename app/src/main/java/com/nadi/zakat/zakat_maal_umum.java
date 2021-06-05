package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.Loading;
import model.Maal;


public class zakat_maal_umum extends AppCompatActivity {
    private TextInputLayout harta_maal_umum_textInputLayout;
    private Button hitung_maal_umum_button;
    private int hasil = 0;
//    Loading loading = new Loading(zakat_maal_umum.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_maal_umum);

       view_maal();
       listener_maal();
    }

    private void listener_maal() {
        hitung_maal_umum_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int harta = Integer.parseInt(harta_maal_umum_textInputLayout.getEditText().getText().toString().trim());
                Maal temp = new Maal(harta, hasil);
                Intent intent = new Intent();
                intent.putExtra("maalBaru", temp);
                setResult(100, intent);
                finish();
            }
        });

    }

    private void view_maal(){
        harta_maal_umum_textInputLayout = findViewById(R.id.harta_maal_umum_textInputLayout);
        hitung_maal_umum_button = findViewById(R.id.hitung_maal_umum_button);
    }

}

