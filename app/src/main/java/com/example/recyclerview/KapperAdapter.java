package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class KapperAdapter extends RecyclerView.Adapter<KapperAdapter.KapperViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public KapperAdapter(Context ct, String s1[], String s2[], String s3[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
    }

    @NonNull
    @Override
    public KapperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.kapper_card, parent, false);
        return new KapperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KapperViewHolder holder, final int position) {
        holder.kapperNaam.setText(data1[position]);
        holder.slogan.setText(data2[position]);
        holder.kapperImg.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (context, KapperInfo.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                intent.putExtra("overOnstxt", data3[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class KapperViewHolder extends RecyclerView.ViewHolder {

        TextView kapperNaam, slogan;
        ImageView kapperImg;

        ConstraintLayout mainLayout;

        public KapperViewHolder(@NonNull View itemView) {
            super(itemView);

            kapperNaam = itemView.findViewById(R.id.kapperNaam);
            slogan = itemView.findViewById(R.id.slogan);
            kapperImg = itemView.findViewById(R.id.kapperImg);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
