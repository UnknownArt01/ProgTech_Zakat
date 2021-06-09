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

import model.Loading;
import model.Perak;
import model.Perak_Guide;

public class zakat_perak extends AppCompatActivity {
    private TextInputLayout perak_mentah_textInputLayout, harga_perak_textInputLayout;
    private Button hitung_perak_button;
    private ImageView back_perak_imageView, question_perak_imageView;
    private int hasil = 0;
    private Loading loading = new Loading(zakat_perak.this);
    private Perak_Guide perak_guide = new Perak_Guide(zakat_perak.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perak);
        getSupportActionBar().hide();

        initView();
        setListener();
    }

    private void setListener() {
        hitung_perak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int perak = Integer.parseInt(perak_mentah_textInputLayout.getEditText().getText().toString().trim());
                int harga = Integer.parseInt(harga_perak_textInputLayout.getEditText().getText().toString().trim());
                Perak temp = new Perak(perak, harga, hasil);
                Intent intent = new Intent();
                intent.putExtra("perakBaru", temp);
                setResult(500, intent);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Perak Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_perak_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), Perak_RecyclerView.class);
                startActivity(intback);
                finish();
            }
        });
        question_perak_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perak_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        perak_guide.dismiss();
                    }
                },5000);
            }
        });
    }

    private void initView() {
        perak_mentah_textInputLayout = findViewById(R.id.perak_mentah_textInputLayout);
        harga_perak_textInputLayout = findViewById(R.id.harga_perak_textInputLayout);
        hitung_perak_button = findViewById(R.id.hitung_perak_button);
        back_perak_imageView = findViewById(R.id.back_perak_imageView);
        question_perak_imageView = findViewById(R.id.question_perak_imageView);
    }
}