package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.MyHolder> {

    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater LayoutInflater;

    public NameAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        LayoutInflater = android.view.LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.inflate(R.layout.file_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView Name,Desc;
        ImageView gambar;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            Name =itemView.findViewById(R.id.nama);
            Desc = itemView.findViewById(R.id.nama2);
            gambar = itemView.findViewById(R.id.gambar);

        }
    }


}
