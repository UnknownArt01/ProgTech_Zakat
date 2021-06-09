package com.nadi.zakat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.InputanZakatSimpanan;

public class listinputzakatsimpanan extends AppCompatActivity {


    private ImageView imageView_backs;
    private RecyclerView recyclerview_sm;
    private ArrayList<InputanZakatSimpanan> datainputzakattabungan;
    private panggilinputzakatsimpanan panggilIntabungan;
    private FloatingActionButton floatingActionButton_sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinputzakatsimpanan);

        initView();
        setupRecyclerView();
        addDummyData();
        setListener();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 3) {
            if (resultCode == 80) {
                InputanZakatSimpanan jumlahinputsimpanan = data.getParcelableExtra("jumlahinputsimpanan");
                datainputzakattabungan.add(jumlahinputsimpanan);
                panggilIntabungan.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        floatingActionButton_sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnn = new Intent(getBaseContext(), hitungzakatsimpanan.class);
                startActivityForResult(intnn, 3 );
            }
        });

    }

    private void addDummyData() {
        panggilIntabungan.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerview_sm.setLayoutManager(manager);
        recyclerview_sm.setAdapter(panggilIntabungan);
    }

    private void initView() {
        recyclerview_sm = findViewById(R.id.recyclerview_sm);
        datainputzakattabungan = new ArrayList<InputanZakatSimpanan>();
        panggilIntabungan = new panggilinputzakatsimpanan(datainputzakattabungan);
        floatingActionButton_sm = findViewById(R.id.floatingActionButton_sm);
        imageView_backs = findViewById(R.id.imageView_backs);

        imageView_backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), MENU.class);
                startActivity(intback);
                finish();
            }
        });
    }
}