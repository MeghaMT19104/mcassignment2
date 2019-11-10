package com.example.mcassignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.ViewHolder> {
   private LayoutInflater inflater;
    @NonNull
    @Override
    public contactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull contactAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contact_name,contact_number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_name=itemView.findViewById(R.id.section_label);
            contact_number=itemView.findViewById(R.id.s1);
        }
    }
}
