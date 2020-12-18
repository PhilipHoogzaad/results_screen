
package com.example.recyclerview;

        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;


// FIX: data1, data2, myImage = "No Data!"


public class AfspraakBeheren extends AppCompatActivity {

    ImageView kapperImg;
    TextView kapperNaam;
    TextView slogan;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afspraak_beheren);

        kapperImg = findViewById(R.id.kapperImg);
        kapperNaam = findViewById(R.id.kapperNaam);
        slogan = findViewById(R.id.slogan);

        getData();
        setData();

    }

    public void getData() {

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