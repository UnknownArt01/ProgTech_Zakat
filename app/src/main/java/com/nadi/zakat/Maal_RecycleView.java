package com.nadi.zakat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.maal;

public class Maal_RecycleView extends AppCompatActivity {

    private RecyclerView maal_recyclerView;
    private ArrayList<maal> zakatMaal = new ArrayList<>();
    private Maal_RV_Adapter maal_adapter;
    private FloatingActionButton maal_floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maal_recycle_view);
        initView();
        setupRecycleView();
        addDummyData();
        clickListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == 99){
                maal baru = data.getParcelableExtra("listBaru");
                zakatMaal.add(baru);
                maal_adapter.notifyDataSetChanged();
            }
        }
    }
    private void clickListener() {
        maal_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), zakat_maal_umum.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void addDummyData(){
        maal_adapter.notifyDataSetChanged();
    }
    private void setupRecycleView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        maal_recyclerView.setLayoutManager(manager);
        maal_recyclerView.setAdapter(maal_adapter);
    }
    private void initView(){
        maal_recyclerView = findViewById(R.id.maal_recyclerView);
        maal_adapter = new Maal_RV_Adapter(zakatMaal);
        maal_floatingActionButton = findViewById(R.id.maal_floatingActionButton);

    }
}