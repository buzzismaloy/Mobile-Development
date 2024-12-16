package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class StoreAddressesFragment extends Fragment {

    private String[] storeAddresses = {
            "Moscow, Ordzhonikidze str., 11",
            "Moscow, ave. Vernadsky, 87 building.2",
            "St. Petersburg, Bolshaya Pushkarskaya str., 20",
            "St. Petersburg, Tchaikovsky str., 63",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_addresses, container, false);

        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, storeAddresses);
        listView.setAdapter(adapter);

        return view;
    }
}