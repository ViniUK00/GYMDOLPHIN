package com.example.gymdolphin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class CheckoutDialogFragment extends DialogFragment {

    public CheckoutDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_checkout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            // Delete the user's cart items
            deleteCartForUser();

            // Show a toast with "Thank You" message
            showToast("Thank You for your purchase!");

            dismiss();  // Close the fragment after handling the click
        });

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(c-> {
            dismiss();
        });
    }

    private void deleteCartForUser() {
        // Extract the username from the intent
        String username = requireActivity().getIntent().getStringExtra("USERNAME_EXTRA");

        // Get a reference to the user's cart items collection
        CollectionReference cartItemsRef = FirebaseFirestore.getInstance()
                .collection("carts")
                .document(username)
                .collection("items");

        // Delete all items within the cart
        cartItemsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    // Delete each document/item within the cart
                    cartItemsRef.document(document.getId()).delete();
                }

                // Optionally, you can also delete the cart document itself
                FirebaseFirestore.getInstance().collection("carts").document(username).delete();

                // Notify the user (you can show a Toast or handle it in any way you prefer)
                showToast("Cart deleted successfully!");
            } else {
                // Handle errors, if any
                showToast("Failed to delete cart. Please try again.");
            }
        });
    }

    private void showToast(String message) {
        // Show a toast with the provided message
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}
