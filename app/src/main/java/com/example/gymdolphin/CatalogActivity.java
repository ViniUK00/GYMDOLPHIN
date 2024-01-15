package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CatalogActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore firestore;
    private FirebaseUser currentUser;
    private TextView welcomeMessageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firestore = FirebaseFirestore.getInstance();

        welcomeMessageTextView = findViewById(R.id.welcomeMessageTextView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USERNAME_EXTRA")) {
            String username = intent.getStringExtra("USERNAME_EXTRA");
            String welcomeMessage = "WELCOME BACK, " + username + "!";
            welcomeMessageTextView.setText(welcomeMessage);
        }

        // Add a divider between items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_user) {
                    // Handle user icon click
                    String username = intent.getStringExtra("USERNAME_EXTRA");
                    startActivity(new Intent(CatalogActivity.this, UserProfileActivity.class)
                            .putExtra("USERNAME_EXTRA", username));

                    return true;

            } else if (itemId == R.id.nav_cart) {
                    // Handle cart icon click
                    // Example: startActivity(new Intent(CatalogActivity.this, CartActivity.class));
                    return true;
                } else if (itemId == R.id.nav_catalog) {
                    // Handle home icon click
                    String username = getIntent().getStringExtra("USERNAME_EXTRA");
                    startActivity(new Intent(CatalogActivity.this, CatalogActivity.class)
                            .putExtra("USERNAME_EXTRA", username));

                    return true;
                }

                return false;
            }

        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        CollectionReference itemsCollection = firestore.collection("items");

        Query query = itemsCollection.orderBy("name"); // Adjust the query as needed

        FirestoreRecyclerOptions<ItemModel> options =
                new FirestoreRecyclerOptions.Builder<ItemModel>()
                        .setQuery(query, ItemModel.class)
                        .build();

        FirestoreRecyclerAdapter<ItemModel, ItemViewHolder> adapter =
                new FirestoreRecyclerAdapter<ItemModel, ItemViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull ItemModel model) {
                        // Bind data to your ViewHolder
                        holder.setItemImage(model.getImage());
                        holder.setItemName(model.getName());
                        holder.setItemPrice(model.getPrice());
                        holder.setItemSmallDescription(model.getSmallDescription());

                        // Add click listener to open ItemDetailsActivity
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(CatalogActivity.this, ItemDetailsActivity.class);
                                intent.putExtra("image", model.getImage());
                                intent.putExtra("name", model.getName());
                                intent.putExtra("price", model.getPrice());
                                intent.putExtra("smallDescription", model.getSmallDescription());
                                intent.putExtra("bigDescription", model.getBigDescription());
                                intent.putExtra("stockCount", model.getStockCount());
                                startActivity(intent);
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        // Create a new ViewHolder
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
                        return new ItemViewHolder(view);
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            itemImage = mView.findViewById(R.id.itemImage);
        }

        public void setItemImage(String imageUrl) {
            // Use Glide to load the image into the ImageView
            try {
                System.out.println(imageUrl);
                Glide.with(itemView.getContext())
                        .load(imageUrl)
                        .placeholder(R.drawable.back_ic) // Placeholder image while loading
                        .error(R.drawable.back_ic) // Error image if loading fails
                        .into(itemImage);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("ImageLoadError", "Error loading image from URL: " + imageUrl);
            }
        }

        public void setItemName(String itemName) {
            TextView itemNameView = mView.findViewById(R.id.itemName);
            itemNameView.setText(itemName);
        }

        public void setItemPrice(double price) {
            TextView priceView = mView.findViewById(R.id.itemPrice);
            // Customize the appearance of the price text
            priceView.setText(String.format("$%.2f", price));
        }

        public void setItemSmallDescription(String smallDescription) {
            TextView smallDescView = mView.findViewById(R.id.itemSmallDescription);
            smallDescView.setText(smallDescription);
        }
    }
}
