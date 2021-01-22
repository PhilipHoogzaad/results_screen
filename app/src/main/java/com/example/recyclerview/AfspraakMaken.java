package com.example.recyclerview;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;


/*
    FIX:
        Kapper selectie wordt niet opgeslagen vanuit "KapperInfo.java"
        Navigatie terug resulteerd in "No Data!" -line 63-
 */

public class AfspraakMaken extends AppCompatActivity {

    ImageView kapperImg;
    TextView kapperNaam;
    TextView slogan;

    String data1, data2;
    int myImage;
    public CardView AfspraakBeheerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afspraak_maken);

        kapperImg = findViewById(R.id.kapperImg);
        kapperNaam = findViewById(R.id.kapperNaam);
        slogan = findViewById(R.id.slogan);

        AfspraakBeheerButton = findViewById(R.id.AfBeheer_bt);
        AfspraakBeheerButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AfspraakMaken.this,
                            AfspraakBeheren.class));
                }
        });

        getData();
        setData();
    }


    private void getData() {

        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);

        } else {

            Toast.makeText(this, "No Data!", Toast.LENGTH_SHORT).show();
        }
    }


    private void setData() {

        kapperNaam.setText(data1);
        slogan.setText(data2);
        kapperImg.setImageResource(myImage);
    }
}