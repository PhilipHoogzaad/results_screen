package com.example.recyclerview;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class KapperInfo extends AppCompatActivity {

    ImageView kapperImg;
    TextView kapperNaam;
    TextView slogan;
    TextView overOns;

    // NOTE: kapper beschrijving heeft String-array: "kapperBeschrijving"
    // NOTE: beschrijving == s3
    // NOTE: TextView "txt1" = positie weergeving "kapperBeschrijving" zie "KapperInfo.java"
    // NOTE: setData -> txt1.setText(s3[0]); <- "0" moet dynamisch worden naar geclickte kapper


    String data1, data2;
    String[] s3;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapper_info);

        kapperImg = findViewById(R.id.kapperImg);
        kapperNaam = findViewById(R.id.kapperNaam);
        slogan = findViewById(R.id.slogan);
        overOns = findViewById(R.id.overOns);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);

            s3 = getResources().getStringArray(R.array.kapperBeschrijving);

        } else {

            Toast.makeText(this, "No Data!", Toast.LENGTH_SHORT).show();

        }
    }

    private void setData() {

        kapperNaam.setText(data1);
        slogan.setText(data2);

        //overOns.setText(s3[0]); <- import string at index position "0" from string-array "s3"
        overOns.setText(s3[0]);

        kapperImg.setImageResource(myImage);

    }
}