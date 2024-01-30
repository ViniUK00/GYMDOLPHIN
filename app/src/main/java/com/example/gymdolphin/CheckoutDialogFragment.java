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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_checkout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            deleteCartForUser();

            showToast("Thank You for your purchase!");

            dismiss();
        });

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(c-> {
            dismiss();
        });
    }

    private void deleteCartForUser() {
        String username = requireActivity().getIntent().getStringExtra("USERNAME_EXTRA");

        CollectionReference cartItemsRef = FirebaseFirestore.getInstance()
                .collection("carts")
                .document(username)
                .collection("items");

        cartItemsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    cartItemsRef.document(document.getId()).delete();
                }

                FirebaseFirestore.getInstance().collection("carts").document(username).delete();
                
                showToast("Cart deleted successfully!");
                updateUI();
            } else {
                // Handle errors, if any
                showToast("Failed to delete cart. Please try again.");
            }
        });
    }

    private void updateUI() {
    }

    private void showToast(String message) {
        // Show a toast with the provided message
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}
