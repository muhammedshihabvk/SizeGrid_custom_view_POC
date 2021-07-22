package com.shabs.sizegridpoc;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.CustomViewHolder> {

    Context context;
    List<String> sizeList;
    boolean status = true;

    public SizeAdapter(Context context, List<String> sizeList) {
        this.context = context;
        this.sizeList = sizeList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_size_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeAdapter.CustomViewHolder holder, int position) {
        holder.bindData(sizeList.get(position));
    }

    @Override
    public int getItemCount() {
        return sizeList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CustomTextView customView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sizegridText);
            customView = itemView.findViewById(R.id.customDiagonalview);
        }

        void bindData(String size) {
            textView.setText(size);

            if (status == true) {
                textView.setTextColor(Color.BLACK);
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.layout_size_available));
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, textView.getText(), Toast.LENGTH_SHORT).show();
                        textView.setBackgroundColor(Color.parseColor("#8E8E8E"));
                    }
                });
                status = !status;
            } else {
                textView.setTextColor(context.getResources().getColor(R.color.grey));
                customView.setVisibility(View.VISIBLE);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item not available", Toast.LENGTH_SHORT).show();
                    }
                });
                status = !status;
            }
        }
    }
}
