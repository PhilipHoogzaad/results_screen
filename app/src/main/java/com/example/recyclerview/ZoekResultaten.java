package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class ZoekResultaten extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] s1, s2, s3;
    int[] images = {R.drawable.kapper1, R.drawable.kapper2, R.drawable.kapper3, R.drawable.kapper4, R.drawable.kapper5, R.drawable.kapper6, R.drawable.kapper7};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoekresultaten);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.kapperNaam);
        s2 = getResources().getStringArray(R.array.slogan);
        s3 = getResources().getStringArray(R.array.kapperBeschrijving);

        KapperAdapter kapperAdapter = new KapperAdapter(this, s1, s2, s3, images);
        recyclerView.setAdapter(kapperAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}