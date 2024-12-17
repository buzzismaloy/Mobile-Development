package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BoguFragment extends Fragment {

    private Product[] products = {
            new Product("Men", "Men stitched to 6mm to provide a great balance between durability and shock absorption and featuring plenty of core material to provide protection.", 14700, R.drawable.men),
            new Product("Kote", "With its special head construction, the Tora gives you instantly the perfect grip over the Shinai Tsuka. ", 8900, R.drawable.kote),
            new Product("Do", "This simple do is made from a single piece of reinforced resin stitched to a genuine kurozan leather mune.", 13900, R.drawable.do_1),
            new Product("Tare", "Distinguished by its all black futon - the Panther tare combines a striking appearance with practical and protective qualities.", 9700, R.drawable.tare),
            new Product("Kurama", "The Kurama Bogu Set contains Men, Kote, Do, Tare", 42000, R.drawable.kurama),
            new Product("Kurama Tengu", "The Kurama Tengu Bogu Set contains Men, Kote, Do, Tare, men & do himo & chichikawa, tenugui", 44000, R.drawable.kurama_tengu),
            new Product("Tokuren Z Silver", "The Tokuren Silver Bogu is engineered for Shiai, offering lightweight yet durable protection. It features 4mm \"Tight-stitch\" stitching for increased durability and flexibility while maintaining softness.", 46000, R.drawable.tokuren_z_silver),
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View v, int position, long id) -> {
            Intent intent = new Intent(getContext(), ProductDetailActivity.class);
            intent.putExtra("product", products[position]);
            startActivity(intent);
        });

        return view;
    }
}