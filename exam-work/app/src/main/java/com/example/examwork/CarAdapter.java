package com.example.examwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examwork.R;
import com.example.examwork.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;

    public CarAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.bind(car);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtName, txtPrice;

        public CarViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageCar);
            txtName = itemView.findViewById(R.id.txtCarName);
            txtPrice = itemView.findViewById(R.id.txtCarPrice);
        }

        public void bind(Car car) {
            imageView.setImageResource(car.getImageResId());
            txtName.setText(car.getName());
            txtPrice.setText(car.getPrice());
        }
    }
}