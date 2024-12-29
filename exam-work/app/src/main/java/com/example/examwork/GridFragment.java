package com.example.examwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examwork.R;
import com.example.examwork.CarAdapter;
import com.example.examwork.Car;

import java.util.ArrayList;
import java.util.List;

public class GridFragment extends Fragment {

    public GridFragment() {
        // Пустой конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        List<Car> carList = getCarList();
        CarAdapter adapter = new CarAdapter(carList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Car> getCarList() {
        List<com.example.examwork.Car> cars = new ArrayList<>();
        cars.add(new com.example.examwork.Car("Audi R8", "20 000 $", com.example.examwork.R.drawable.audi_r8));
        cars.add(new com.example.examwork.Car("BMW M1", "25 000 $", com.example.examwork.R.drawable.bmw_m1));
        cars.add(new com.example.examwork.Car("Ferrari F50", "28 000 $", com.example.examwork.R.drawable.ferrari_f50));
        cars.add(new com.example.examwork.Car("Koenigsegg Agera", "22 000 $", com.example.examwork.R.drawable.koenigsegg_agera));
        cars.add(new com.example.examwork.Car("Lamborgini Diablo", "30 000 $", com.example.examwork.R.drawable.lamborgini_diablo));
        cars.add(new com.example.examwork.Car("Lotus Elise Series 2", "35 000 $", com.example.examwork.R.drawable.lotus_elise_series_2));
        cars.add(new com.example.examwork.Car("Tesla Model S", "33 000 $", com.example.examwork.R.drawable.tesla_model_s));
        cars.add(new com.example.examwork.Car("Volkswagen", "18 000 $", com.example.examwork.R.drawable.volkswagen));
        return cars;
    }
}