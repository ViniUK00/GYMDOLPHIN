package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private static final String TAG = "CartActivity";
    private FirebaseFirestore firestore;
    private List<CartItemModel> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        firestore = FirebaseFirestore.getInstance();


        String username = getIntent().getStringExtra("USERNAME_EXTRA");
        TextView usernameText = findViewById(R.id.usernameText);
        usernameText.setText(username);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCartItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TextView totalValueTextView = findViewById(R.id.totalValueTextView);
        Button proceedToCheckoutButton = findViewById(R.id.proceedToCheckoutButton);
        proceedToCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the credit card details dialog
                CheckoutDialogFragment dialogFragment = new CheckoutDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "CheckoutDialogFragment");
            }
        });


        logCartItems(username, recyclerView, totalValueTextView);

        // Bottom Navigation View setup
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_user) {
                    // Handle user icon click
                    startActivity(new Intent(CartActivity.this, UserProfileActivity.class)
                            .putExtra("USERNAME_EXTRA", username));

                    return true;

                } else if (itemId == R.id.nav_cart) {
                    startActivity(new Intent(CartActivity.this, CartActivity.class)
                            .putExtra("USERNAME_EXTRA", username));

                    return true;
                } else if (itemId == R.id.nav_catalog) {
                    // Handle home icon click
                    startActivity(new Intent(CartActivity.this, CatalogActivity.class)
                            .putExtra("USERNAME_EXTRA", username));

                    return true;
                }

                return false;
            }
        });
    }

    private void logCartItems(String username, RecyclerView recyclerView, TextView totalValueTextView) {
        CollectionReference cartItemsRef = firestore.collection("carts").document(username).collection("items");

        cartItemsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                cartItems = new ArrayList<>();
                double totalValue = 0.0;

                for (QueryDocumentSnapshot document : task.getResult()) {
                    String imageUrl = document.getString("imageUrl");
                    String itemName = document.getString("name");
                    double itemPrice = document.getDouble("price");
                    int quantity = document.getLong("quantity").intValue();

                    CartItemModel cartItem = new CartItemModel(imageUrl, itemPrice, itemName, username, quantity);
                    cartItems.add(cartItem);

                    totalValue += itemPrice;
                }

                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String formattedTotalValue = "Total Value: £" + decimalFormat.format(totalValue);

                totalValueTextView.setText(formattedTotalValue);

                CartItemAdapter adapter = new CartItemAdapter(cartItems);
                recyclerView.setAdapter(adapter);

            } else {
                Log.e(TAG, "Error getting documents: ", task.getException());
            }
        });
    }

    // Adapter class for the RecyclerView
    private static class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

        private List<CartItemModel> cartItems;

        public CartItemAdapter(List<CartItemModel> cartItems) {
            this.cartItems = cartItems;
        }

        @NonNull
        @Override
        public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
            return new CartItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
            CartItemModel cartItem = cartItems.get(position);

            String price = ("£" + String.valueOf(cartItem.getPrice()));
            String quantity = ("Qty. " + String.valueOf(cartItem.getQuantity()));
            // Set data to views
            holder.itemNameTextView.setText(cartItem.getName());
            holder.itemPriceTextView.setText(price);
            holder.quantityTextView.setText(quantity);

            // You can load the image using a library like Glide or Picasso
            // For simplicity, I'm assuming you have an ImageView with id "itemImageView" in your item_cart.xml layout
            Glide.with(holder.itemView.getContext()).load(cartItem.getImageUrl()).into(holder.itemImageView);
        }

        @Override
        public int getItemCount() {
            return cartItems.size();
        }

        // ViewHolder class
        static class CartItemViewHolder extends RecyclerView.ViewHolder {
            TextView itemNameTextView;
            TextView itemPriceTextView;
            TextView quantityTextView;
            ImageView itemImageView;

            public CartItemViewHolder(@NonNull View itemView) {
                super(itemView);
                itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
                itemPriceTextView = itemView.findViewById(R.id.itemPriceTextView);
                quantityTextView = itemView.findViewById(R.id.quantityTextView);
                itemImageView = itemView.findViewById(R.id.itemImageView);
            }
        }
    }
}
