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

import model.Emas;
import model.Maal;

public class Maal_RecyclerView extends AppCompatActivity {
    private RecyclerView maal_recyclerView;
    private ArrayList<Maal> dataMaal;
    private Maal_RV_Adapter adapter;
    private FloatingActionButton maal_floatingActionButton;
    private ImageView back_maal_rec_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maal_recycler_view);

        getSupportActionBar().hide();

        initView();
        setupRecyclerView();

        clickListener();
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5563){
            if (resultCode == 100){
                Maal maalBaru = data.getParcelableExtra("maalBaru");
                dataMaal.add(maalBaru);
                adapter.notifyDataSetChanged();

            }
        }
    }

    private void clickListener() {
        maal_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), zakat_maal_umum.class);
                startActivityForResult(intent, 5563);
            }
        });
        back_maal_rec_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), MENU.class);
                startActivity(intback);
                finish();
            }
        });

    }

    private void addDummyData() {
        dataMaal.add(new Maal(5000,7));
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        maal_recyclerView.setLayoutManager(manager);
        maal_recyclerView.setAdapter(adapter);
    }

    private void initView() {
        maal_recyclerView = findViewById(R.id.maal_recyclerView);
        maal_floatingActionButton = findViewById(R.id.maal_floatingActionButton);
        dataMaal = new ArrayList<Maal>();
        adapter = new Maal_RV_Adapter(dataMaal);
        back_maal_rec_imageView = findViewById(R.id.back_maal_rec_imageView);
    }
}