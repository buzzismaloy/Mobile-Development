package com.example.lab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreAddressesAdapter extends RecyclerView.Adapter<StoreAddressesAdapter.AddressViewHolder> {

    private final String[] addresses;

    public StoreAddressesAdapter(String[] addresses) {
        this.addresses = addresses;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        holder.textView.setText(addresses[position]);
    }

    @Override
    public int getItemCount() {
        return addresses.length;
    }

    public static class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
