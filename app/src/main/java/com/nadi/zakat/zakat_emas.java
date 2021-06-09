package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.Emas;
import model.Emas_Guide;
import model.Loading;

public class zakat_emas extends AppCompatActivity {
    private TextInputLayout emas_mentah_textInputLayout, emas_pakai_textInputLayout, harga_emas_textInputLayout;
    private ImageView question_imageView, back_emas_imageView;
    private Button hitung_emas_button;
    private int bayar = 1;
    private Loading loading = new Loading(zakat_emas.this);
    private Emas_Guide emas_guide = new Emas_Guide(zakat_emas.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_emas);
        getSupportActionBar().hide();

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
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Emas Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        question_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emas_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        emas_guide.dismiss();
                    }
                },5000);
            }
        });
        back_emas_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), MENU.class);
                startActivity(intback);
                finish();
            }
        });
    }

    private void initView() {
        emas_mentah_textInputLayout = findViewById(R.id.emas_mentah_textInputLayout);
        emas_pakai_textInputLayout = findViewById(R.id.emas_pakai_textInputLayout);
        harga_emas_textInputLayout = findViewById(R.id.harga_emas_textInputLayout);
        hitung_emas_button = findViewById(R.id.hitung_emas_button);
        question_imageView = findViewById(R.id.question_imageView);
        back_emas_imageView = findViewById(R.id.back_emas_imageView);
    }

}