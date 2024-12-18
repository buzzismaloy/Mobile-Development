package com.example.lab5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

public class WeaponFragment extends Fragment {

    private Product[] products = {
            new Product("Shinai 39 jissengata", "39 sinai with standard parameters. . This sinai is often used in competitions. But you can also use it for everyday workouts.", 3900.0, R.drawable.shinai_jissengata_1),
            new Product("Shinai 39 Koto", "The Koto style implies an almost straight sword body, distributed weight. This gives the impression of more weight in the hands.", 4250, R.drawable.koto_shinai_1),
            new Product("Shinai 38 dobari", "This Dobari style shinai is a high-quality model. And, of course, an ideal choice for all kendoka who are looking for a model that is specially balanced in relation to the upper part of the Tsuka (handle).", 2900, R.drawable.shinai_dobari_38_1),
            new Product("Shinai standart", "A simple practical bamboo sword for Kendo training. This sinai is available in sizes from 32 to 39", 2800, R.drawable.shinai_standart),
            new Product("Shinai oval grip", "For daily training and Kendo competitions. The handle of the oval-shaped sword feels similar to the handle of a bokken. This sinai is available in sizes 39 and 38", 4400, R.drawable.shinai_oval),
            new Product("Shoto", "Shoto is a short sword worn with daito, a long sword. Shoto is necessary for practicing Nito-ryu", 2200, R.drawable.shinay_nito),
            new Product("Bokken/Bokuto", "A classic model of a wooden sword, bokken, made of glued layers of bamboo. Bokken is necessary for Kata practice", 2700, R.drawable.bokken_bamboo),
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        ProductAdapter adapter = new ProductAdapter(Arrays.asList(products), product -> {
            // Открытие детализации продукта
            ProductDetailActivity.start(getContext(), product);
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}