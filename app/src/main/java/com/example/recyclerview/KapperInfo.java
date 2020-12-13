package com.example.recyclerview;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class KapperInfo extends AppCompatActivity {

    ImageView mainImageView;
    TextView title;
    TextView description;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapper_info);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

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

        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);

    }
}