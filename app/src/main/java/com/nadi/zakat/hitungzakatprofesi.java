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

import model.InputanZakatProfesi;
import model.Loading;

public class hitungzakatprofesi extends AppCompatActivity {

    private TextInputLayout textInputpenghasilan, textInputambah, textInputcicilan;
    private Button button_hit;
    int penghasilan, tambah, cicilan, hasil;
    private ImageView back_profesi_imageView;
    private Loading loading = new Loading(hitungzakatprofesi.this);


            //https://github.com/UnknownArt01/ProgTech_Zakat/tree/lia
            //  private TextView textViewhasil;
            //  private TextView card_hasil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatprofesi);

        getSupportActionBar().hide();


        initView();
        setListener();
    }

    private void setListener() {


        button_hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penghasilan = Integer.parseInt(textInputpenghasilan.getEditText().getText().toString().trim());
                tambah = Integer.parseInt(textInputambah.getEditText().getText().toString().trim());
                cicilan = Integer.parseInt(textInputcicilan.getEditText().getText().toString().trim());

                InputanZakatProfesi temp = new InputanZakatProfesi(penghasilan, tambah, cicilan, hasil);
                Intent in = new Intent();
                in.putExtra("jumlahinput", temp);
                setResult(200, in);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat profesi Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_profesi_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), listinputzakatprofesi.class);
                startActivity(intback);
                finish();
            }
        });
    }
    private void initView() {

        textInputpenghasilan = findViewById(R.id.textInputpenghasilan);
        textInputambah = findViewById(R.id.textInputambah);
        textInputcicilan = findViewById(R.id.textInputcicilan);
        button_hit = findViewById(R.id.button_hit);
        back_profesi_imageView = findViewById(R.id.back_profesi_imageView);
        //  textViewhasil = findViewById(R.id.textViewhasil);
        // card_hasil = findViewById(R.id.card_hasil);


    }
}