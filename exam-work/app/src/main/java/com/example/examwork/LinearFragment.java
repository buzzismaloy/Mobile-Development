package com.example.examwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examwork.R;
import com.example.examwork.CarAdapter;
import com.example.examwork.Car;

import java.util.ArrayList;
import java.util.List;

public class LinearFragment extends Fragment {

    public LinearFragment() {
        // Пустой конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_linear, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewLinear);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<Car> carList = getCarList();
        CarAdapter adapter = new CarAdapter(carList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Car> getCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi R8", "20 000 $", R.drawable.audi_r8));
        cars.add(new Car("BMW M1", "25 000 $", R.drawable.bmw_m1));
        cars.add(new Car("Ferrari F50", "28 000 $", R.drawable.ferrari_f50));
        cars.add(new Car("Koenigsegg Agera", "22 000 $", R.drawable.koenigsegg_agera));
        cars.add(new Car("Lamborgini Diablo", "30 000 $", R.drawable.lamborgini_diablo));
        cars.add(new Car("Lotus Elise Series 2", "35 000 $", R.drawable.lotus_elise_series_2));
        cars.add(new Car("Tesla Model S", "33 000 $", R.drawable.tesla_model_s));
        cars.add(new Car("Volkswagen", "18 000 $", R.drawable.volkswagen));
        return cars;
    }
}