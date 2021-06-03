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
import model.maal;

public class zakat_maal_umum extends AppCompatActivity {
    private TextInputLayout harta_maal_umum_textInputLayout;
    private Button hitung_maal_umum_button;
    Loading loading = new Loading(zakat_maal_umum.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_maal_umum);

       view_maal();
    }
    private void view_maal(){
        harta_maal_umum_textInputLayout = findViewById(R.id.harta_maal_umum_textInputLayout);
        hitung_maal_umum_button = findViewById(R.id.hitung_emas_button);
    }
    private void listener_maal() {
        hitung_maal_umum_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int harta = Integer.parseInt(harta_maal_umum_textInputLayout.getEditText().getText().toString().trim());
                int jumlah  = harta *(25/1000);

                maal user = new maal(harta, jumlah);

                Intent intent = new Intent();
                intent.putExtra("listBaru", user);
                setResult(99, intent);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                }, 500);

                Toast.makeText(getApplicationContext(), "Data Saved!!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private TextWatcher maalWathcer = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String harta = harta_maal_umum_textInputLayout.getEditText().getText().toString().trim();
            if (harta.isEmpty()) {
                harta_maal_umum_textInputLayout.setError("Please Fill All Data");
                hitung_maal_umum_button.setEnabled(false);
            }else{
                harta_maal_umum_textInputLayout.setError("");
                hitung_maal_umum_button.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}