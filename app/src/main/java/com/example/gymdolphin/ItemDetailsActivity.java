package com.example.gymdolphin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;
    private TextView itemSmallDescription;
    private TextView itemBigDescription;
    private TextView itemStockCount;
    private Button addButton;

    private FirebaseFirestore db;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemImage = findViewById(R.id.itemImageDetails);
        itemName = findViewById(R.id.itemNameDetails);
        itemPrice = findViewById(R.id.itemPriceDetails);
        itemSmallDescription = findViewById(R.id.itemSmallDescriptionDetails);
        itemBigDescription = findViewById(R.id.itemBigDescriptionDetails);
        itemStockCount = findViewById(R.id.itemStockCountDetails);
        addButton = findViewById(R.id.addButton);

        db = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String imageUrl = extras.getString("image");
            String name = extras.getString("name");
            double price = extras.getDouble("price");
            String smallDescription = extras.getString("smallDescription");
            String bigDescription = extras.getString("bigDescription");
            int stockCount = extras.getInt("stockCount");
            String username = extras.getString("USERNAME_EXTRA");

            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.back_ic)
                    .error(R.drawable.back_ic)
                    .into(itemImage);
            itemName.setText(name);
            itemPrice.setText(String.format("£%.2f", price));
            itemSmallDescription.setText(smallDescription);
            itemBigDescription.setText(bigDescription);
            itemStockCount.setText(String.valueOf(stockCount));

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentUser != null) {
                        addToCart(username, name, stockCount, imageUrl, price);
                    }
                }
            });
        }

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    // Inside addToCart method
    private void addToCart(final String username, final String name, int stockCount, String imageUrl, double price) {
        final DocumentReference itemRef = db.collection("carts").document(username)
                .collection("items").document(name);

        db.runTransaction(transaction -> {
            DocumentSnapshot snapshot = transaction.get(itemRef);

            if (snapshot.exists()) {
                transaction.update(itemRef,
                        "quantity", FieldValue.increment(1),
                        "price", FieldValue.increment(price));
            } else {
                double updatedPrice = price * 1;
                CartItemModel cartItem = new CartItemModel(imageUrl, updatedPrice, name, username, 1);
                transaction.set(itemRef, cartItem);
            }

            return null;
        }).addOnSuccessListener(aVoid -> {
            decrementStockCount(1);
        });
    }



    private void decrementStockCount(long initialQuantity) {
        // Decrement stock count only if the update is successful and the initial quantity is greater than 0
        if (initialQuantity > 0) {
            int newStockCount = Integer.parseInt(itemStockCount.getText().toString()) - 1;
            itemStockCount.setText(String.valueOf(newStockCount));
        }
    }
}