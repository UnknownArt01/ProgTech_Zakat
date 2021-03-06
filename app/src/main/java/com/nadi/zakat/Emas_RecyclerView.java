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

public class Emas_RecyclerView extends AppCompatActivity {

    private RecyclerView emas_recyclerView;
    private FloatingActionButton emas_floatingActionButton;
    private ArrayList<Emas> dataEmas;
    private Emas_RV_Adapter adapter;
    private ImageView back_emas_rec_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emas_recycler_view);

        getSupportActionBar().hide();

        emasInitView();
        setupRecyclerView();

        clickListener();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 5587){
            if (resultCode == 300){
                Emas emasBaru = data.getParcelableExtra("emasBaru");
                dataEmas.add(emasBaru);
                adapter.notifyDataSetChanged();

            }
        }
    }

    private void clickListener() {
        emas_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), zakat_emas.class);
                startActivityForResult(intent, 5587);
            }
        });
        back_emas_rec_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), MENU.class);
                startActivity(intback);
                finish();
            }
        });
    }

    private void addDummyData() {
        dataEmas.add(new Emas(5000,7,4000,3000));
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        emas_recyclerView.setLayoutManager(manager);
        emas_recyclerView.setAdapter(adapter);
    }

    private void emasInitView() {
        emas_recyclerView = findViewById(R.id.emas_recyclerView);
        emas_floatingActionButton = findViewById(R.id.emas_floatingActionButton);
        dataEmas = new ArrayList<Emas>();
        adapter = new Emas_RV_Adapter(dataEmas);
        back_emas_rec_imageView = findViewById(R.id.back_emas_rec_imageView);
    }
}