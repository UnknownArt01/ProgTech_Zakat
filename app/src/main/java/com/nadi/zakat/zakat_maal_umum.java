package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.Emas_Guide;
import model.Loading;
import model.Maal;
import model.Maal_Guide;


public class zakat_maal_umum extends AppCompatActivity {
    private TextInputLayout harta_maal_umum_textInputLayout;
    private Button hitung_maal_umum_button;
    private ImageView back_maal_imageView, question_maal_imageView;
    private int hasil = 0;
    private Loading loading = new Loading(zakat_maal_umum.this);
    private Maal_Guide maal_guide = new Maal_Guide(zakat_maal_umum.this);
//    Loading loading = new Loading(zakat_maal_umum.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_maal_umum);

        getSupportActionBar().hide();

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
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Maal Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_maal_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), Maal_RecyclerView.class);
                startActivity(intback);
                finish();
            }
        });
        question_maal_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maal_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        maal_guide.dismiss();
                    }
                },5000);
            }
        });

    }

    private void view_maal(){
        harta_maal_umum_textInputLayout = findViewById(R.id.harta_maal_umum_textInputLayout);
        hitung_maal_umum_button = findViewById(R.id.hitung_maal_umum_button);
        back_maal_imageView = findViewById(R.id.back_maal_imageView);
        question_maal_imageView = findViewById(R.id.question_maal_imageView);
    }

}

