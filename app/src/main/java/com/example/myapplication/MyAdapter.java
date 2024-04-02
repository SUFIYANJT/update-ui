package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> dataList;
    private OnItemClickListener listener; // Listener for item click events

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to set the item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Constructor to initialize the adapter with data list
    public MyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    // Create view holder for each item in the recycler view
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    // Bind data to view holder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = dataList.get(position);
        holder.textViewTitle.setText(title);

        // Set click listener for card view
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(position); // Invoke item click listener
                }
            }
        });
    }

    // Return the total number of items in the data list
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // View holder class to hold the views of each item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        MaterialCardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.itemText);
            cardView = itemView.findViewById(R.id.cardView);

            // Set click listener for the entire item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(position); // Invoke item click listener
                    }
                }
            });
        }
    }
}
