package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;


public class KapperInfo extends AppCompatActivity {

    ImageView kapperImg;
    TextView kapperNaam;
    TextView slogan;
    TextView overOns;


    /*
       NOTE:    Persoonlijke kapper beschrijving
                string.xml -line 123-	string-array name="kapperBeschrijving"
                TextView "overOns" = positie weergeving

       FIX: setData -> overOns.setText(s3[0]); <- "0" moet dynamisch worden naar geclickte kapper
       FIX: class: AfspraakMaken, AfspraakBeheren = data1, data2, myImage: "No Data!"
     */


    String data1, data2;
    String[] s3;
    int myImage;

    public CardView AfspraakButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapper_info);

        kapperImg = findViewById(R.id.kapperImg);
        kapperNaam = findViewById(R.id.kapperNaam);
        slogan = findViewById(R.id.slogan);
        overOns = findViewById(R.id.overOns);

        AfspraakButton = findViewById(R.id.Afspraak_bt);
        AfspraakButton.setOnClickListener(new View.OnClickListener() {

            /*
            NOTE:   This is a Nested Activity, not well orginized when dealing with multiple buttons,
                    then use a switch instead: see below
             */

            @Override
            public void onClick(View v) {

                startActivity(new Intent(KapperInfo.this,
                        AfspraakMaken.class));

            }
        });

        getData();
        setData();
    }

    public void getData() {

        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")) {

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
        kapperImg.setImageResource(myImage);

        /*
            NOTE:   overOns.setText(s3[0]);
                    import string at index position "0" from string-array "s3"
         */

        overOns.setText(s3[0]);

    }
}

    /*
        NOTE: Use this for multiple buttons:        switch
                                                    -> case -> break (Repreat till finished)

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.afspraak_button :
                i = new Intent(this, AfspraakMaken.class);
                startActivity(i);
                break;
        }
    }

    */

