package com.example.lab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreAddressesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ADDRESS = 0;
    private static final int TYPE_AD = 1;
    private final String[] addresses;

    public StoreAddressesAdapter(String[] addresses) {
        this.addresses = addresses;
    }

    @Override
    public int getItemViewType(int position) {
        return (position + 1) % 4 == 0 ? TYPE_AD : TYPE_ADDRESS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AD) {
            View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ad, parent, false);
            return new AdViewHolder(adView);
        } else {
            View addressView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new AddressViewHolder(addressView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AddressViewHolder) {
            ((AddressViewHolder) holder).textView.setText(addresses[getActualPosition(position)]);
        } else if (holder instanceof AdViewHolder) {
            ((AdViewHolder) holder).textView.setText("Advertising: discounts on bogu!");
        }
    }

    @Override
    public int getItemCount() {
        return addresses.length + addresses.length / 3; // Учитываем добавление рекламы
    }

    private int getActualPosition(int position) {
        return position - position / 3; // Реальная позиция элемента в массиве данных
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    static class AdViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.adTextView);
        }
    }
}
