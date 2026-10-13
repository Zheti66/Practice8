package com.example.practice8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();
    ProductAdapter adapter;
    EditText newName;
    EditText newUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products.add(new Product("Лук", "кг."));
        products.add(new Product("Чай", "шт."));
        products.add(new Product("Яйца", "шт."));
        products.add(new Product("Молоко", "л."));
        products.add(new Product("Сахар", "кг."));
        products.add(new Product("Картофель", "кг."));

        ListView productList = findViewById(R.id.productList);
        newName = findViewById(R.id.newName);
        newUnit = findViewById(R.id.newUnit);
        Button createButton = findViewById(R.id.createButton);

        adapter = new ProductAdapter(this, R.layout.list_item, products);
        productList.setAdapter(adapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = newName.getText().toString().trim();
                String unit = newUnit.getText().toString().trim();

                if (!name.isEmpty() && !unit.isEmpty()) {
                    products.add(new Product(name, unit));
                    adapter.notifyDataSetChanged();
                    newName.setText("");
                    newUnit.setText("");
                }
            }
        });
    }
}