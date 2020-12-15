package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    TextView txt1;

    //String[] s1, s2, s3;
    String[] s1, s2;
    int[] images = {R.drawable.kapper1, R.drawable.kapper2, R.drawable.kapper3, R.drawable.kapper4, R.drawable.kapper5, R.drawable.kapper6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.kapperNaam);
        s2 = getResources().getStringArray(R.array.slogan);
        //s3 = getResources().getStringArray(R.array.kapperBeschrijving);

        //MyAdapter myAdapter = new MyAdapter (this, s1, s2, s3, images);
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Werkt niet!
        //txt1.setVisibility(View.GONE);
    }
}