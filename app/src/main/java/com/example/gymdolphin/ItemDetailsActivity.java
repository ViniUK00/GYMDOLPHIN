package com.example.gymdolphin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;
    private TextView itemSmallDescription;
    private TextView itemBigDescription;
    private TextView itemStockCount;
    private Button addButton;  // Updated: removeButton is removed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // Initialize view variables
        itemImage = findViewById(R.id.itemImageDetails);
        itemName = findViewById(R.id.itemNameDetails);
        itemPrice = findViewById(R.id.itemPriceDetails);
        itemSmallDescription = findViewById(R.id.itemSmallDescriptionDetails);
        itemBigDescription = findViewById(R.id.itemBigDescriptionDetails);
        itemStockCount = findViewById(R.id.itemStockCountDetails);
        addButton = findViewById(R.id.addButton);  // Updated: removeButton is removed

        // Retrieve data from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String imageUrl = extras.getString("image");
            String name = extras.getString("name");
            double price = extras.getDouble("price");
            String smallDescription = extras.getString("smallDescription");
            String bigDescription = extras.getString("bigDescription");
            int stockCount = extras.getInt("stockCount");

            // Set data to views
            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.back_ic)
                    .error(R.drawable.back_ic)
                    .into(itemImage);
            itemName.setText(name);
            itemPrice.setText(String.format("$%.2f", price));
            itemSmallDescription.setText(smallDescription);
            itemBigDescription.setText(bigDescription);
            itemStockCount.setText(String.valueOf(stockCount));

            // Handle add to cart button click
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Add item to cart (you can implement this logic)
                }
            });
        }

        // Handle back button click
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    // Handle back button click programmatically
    public void onBackButtonClick(View view) {
        onBackPressed();
    }
}
