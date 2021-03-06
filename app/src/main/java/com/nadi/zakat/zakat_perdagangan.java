package com.nadi.zakat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.Loading;
import model.Perdagangan;
import model.Perdagangan_Guide;

public class zakat_perdagangan extends AppCompatActivity {
    private TextInputLayout modal_textInputLayout,keuntungan_textInputLayout,piutang_textInputLayout,hutang_textInputLayout,kerugian_textInputLayout;
    private Button hitung_perdangangan_button;
    private ImageView back_perdagangan_imageView, question_perdagangan_imageView;
    private int hasil = 0;
    private Loading loading = new Loading(zakat_perdagangan.this);
    private Perdagangan_Guide perdagangan_guide = new Perdagangan_Guide(zakat_perdagangan.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perdagangan);
        getSupportActionBar().hide();

        initView();
        setListener();
    }

    private void setListener() {
        hitung_perdangangan_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                int modal = Integer.parseInt(modal_textInputLayout.getEditText().getText().toString().trim());
                int keuntungan = Integer.parseInt(keuntungan_textInputLayout.getEditText().getText().toString().trim());
                int piutang = Integer.parseInt(piutang_textInputLayout.getEditText().getText().toString().trim());
                int hutang = Integer.parseInt(hutang_textInputLayout.getEditText().getText().toString().trim());
                int kerugian = Integer.parseInt(kerugian_textInputLayout.getEditText().getText().toString().trim());
                Perdagangan temp = new Perdagangan(modal, keuntungan, piutang, hutang, kerugian, hasil);
                Intent intent = new Intent();
                intent.putExtra("perdaganganBaru", temp);
                setResult(600, intent);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Perdagangan Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_perdagangan_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), Perdagangan_RecyclerView.class);
                startActivity(intback);
                finish();
            }
        });
        question_perdagangan_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perdagangan_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        perdagangan_guide.dismiss();
                    }
                },5000);
            }
        });
    }

    private void initView() {
        modal_textInputLayout = findViewById(R.id.modal_textInputLayout);
        keuntungan_textInputLayout = findViewById(R.id.keuntungan_textInputLayout);
        piutang_textInputLayout = findViewById(R.id.piutang_textInputLayout);
        hutang_textInputLayout = findViewById(R.id.hutang_textInputLayout);
        kerugian_textInputLayout = findViewById(R.id.kerugian_textInputLayout);
        hitung_perdangangan_button = findViewById(R.id.hitung_perdangangan_button);
        back_perdagangan_imageView = findViewById(R.id.back_perdagangan_imageView);
        question_perdagangan_imageView = findViewById(R.id.question_perdagangan_imageView);
    }
}