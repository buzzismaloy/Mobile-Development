package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class StoreAddressesFragment extends Fragment {

    private String[] storeAddresses = {
            "Moscow, Ordzhonikidze str., 11",
            "Moscow, ave. Vernadsky, 87 building.2",
            "St. Petersburg, Bolshaya Pushkarskaya str., 20",
            "St. Petersburg, Tchaikovsky str., 63",
            "Japan, Kyoto, 25-19 Shogoin Sannocho, Sakyo Ward, ",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_addresses, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.COLUMN_REVERSE); // Элементы располагаются горизонтально
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN); // Равномерное распределение

        recyclerView.setLayoutManager(layoutManager);


        StoreAddressesAdapter adapter = new StoreAddressesAdapter(storeAddresses);
        recyclerView.setAdapter(adapter);

        return view;
    }
}