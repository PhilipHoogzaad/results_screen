package com.example.recyclerview;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class KapperInfo extends AppCompatActivity {

    ImageView kapperImg;
    TextView kapperNaam;
    TextView slogan;
    TextView txt1;

    // NOTE: kapper beschrijving heeft String-array: "kapperBeschrijving"
    // NOTE: beschrijving == s3
    // NOTE: TextView "txt1" = positie weergeving "kapperBeschrijving" zie "KapperInfo.java"


    //String data1, data2, data3;
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
        txt1 = findViewById(R.id.txt1);

        getData();
        setData();
    }

    private void getData() {
        //if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3")) {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            //data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage", 1);

            s3 = getResources().getStringArray(R.array.kapperBeschrijving);

        } else {

            Toast.makeText(this, "No Data!", Toast.LENGTH_SHORT).show();

        }
    }

    private void setData() {

        kapperNaam.setText(data1);
        slogan.setText(data2);
        //txt1.setText(data3);
        txt1.setText(s3);
        kapperImg.setImageResource(myImage);

    }
}