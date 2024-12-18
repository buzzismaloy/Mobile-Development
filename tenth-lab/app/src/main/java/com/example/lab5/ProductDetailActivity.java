package com.example.lab5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImage = findViewById(R.id.productImage);
        TextView productName = findViewById(R.id.productName);
        TextView productDescription = findViewById(R.id.productDescription);
        TextView productPrice = findViewById(R.id.productPrice);

        // Получение данных товара из Intent
        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            productImage.setImageResource(product.imageResourceId);
            productName.setText(product.name);
            productDescription.setText(product.description);
            productPrice.setText(product.price + " RUB");
        }
    }

    public static void start(Context context, Product product) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("product", product);
        context.startActivity(intent);
    }
}