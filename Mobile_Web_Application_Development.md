![A black background with grey text

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.001.png)

Course: Computer Science

Module: Mobile Web Application Development

Course Leader: Dr. Cain Kazimoglu

Student: Ervin Bilo

Student ID: 21512979

Module Code: CP5CS93E

Video Demonstration: https://youtu.be/LzRP0STbYkQ




# **Table of Contents**
[Introduction	3******](#_toc156801143)***

[**Report Structure	3****](#_toc156801144)

[***Wireframing and UI Development	4******](#_toc156801145)

[**Side-by-side comparison	5****](#_toc156801146)

[***Back-End Development	8******](#_toc156801147)

[Backend Setup	8](#_toc156801148)

[Crucial Parts	9](#_toc156801149)

[***Reflection	14******](#_toc156801150)

[***Conclusion and Future Work	14******](#_toc156801151)

[***References	15******](#_toc156801152)

[***Appendix/Code	16******](#_toc156801153)



# <a name="_toc156801143"></a>Introduction

Application name: **GYMDOLPHIN**

![A black and white logo

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.002.png)







**GYMDOLPHIN** is an E-commerce gym gear store simulation that offers users the flexibility to log in, register, or proceed as a guest. Password recovery via email is integrated into the app. All item listings are dynamically fetched from a Firebase database, ensuring real-time updates on stock counts. The payment activity is implemented using fragments, providing a seamless user experience.

One notable feature is the ability to save the shopping cart into the database, allowing users to retrieve their cart dynamically upon logging back into the app. Each user has their own corresponding cart, providing a tailored and convenient shopping experience. Additionally, users can easily update and modify their profile information directly within the app.

The development process involved the use of various tools, including Figma for wireframing, Photoshop for creating the logo, Firebase for database management, and Android Studio for development environment. I selected these tools based on my familiarity with their functionalities. In Android Studio, I used Java for both backend and frontend development, while XML was applied for app layout, and frontend design.

<a name="_toc156801144"></a>Report Structure:

- Wireframing and UI Development: Explore the look and feel of the app and the reasons behind design choices.
- Back-End Development: Dive into the Java code structure that powers the app's functionality.
- Reflection: Discuss what was learned, any bugs encountered, and insights gained during development.
- Conclusion and Future Work: Wrap up with final thoughts, critiques, and ideas for future improvements.
- References: List the resources used for building the app.
- Appendix/Code: Find detailed code snippets.


# <a name="_toc156801145"></a>Wireframing and UI Development
I designed the app to be user-friendly with a bottom navigation bar. The color scheme blends white and black for a modern appearance.

![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.003.png)

*Figure 1 User flow.*

The image above displays the wireframe for the app, giving a clear outline of how users will navigate through the screens. It's a visual guide that shows the planned design and interaction flow.


## <a name="_toc156801146"></a>Side-by-side comparison
The side-by-side comparison below presents the wireframes and user interfaces (UI) of the app. On one side, the wireframes offer a simplified blueprint, outlining the structure and user flow. On the other side, the UI design brings those wireframes to life with visual elements.


|![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.004.png)![A screen shot of a cell phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.005.png)|![A screen shot of a login

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.006.png)![A screenshot of a login form

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.007.png)|
| :- | :- |
|The splash screen appears until the app finishes loading.|The initial activity provides options for you to either log in, continue as a guest, sign up, or recover a forgotten password.|
|![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.008.png)![A screen shot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.009.png)|![A screenshot of a cell phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.010.png)![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.011.png)|
|The registration activity includes the logo, text fields, and the "Create Account" button. Additionally, it verifies that the fields have the appropriate format.|The Forgot Password activity allows users to recover their password using an email. The "Forgot Password" activity allows users to recover their password using an email.|



|![](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.012.png)![A black and white shopping basket

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.013.png)|![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.014.png)![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.015.png)|
| :- | :- |
|The bottom navigation bar is simple, consisting catalog, cart, and user profile activities. Upon clicking, users can navigate to different screens.|The catalog activity features a simple and elegant user interface, presenting items in a RecyclerView with clickable elements.|
|![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.016.png)![A cellphone with a pink hat

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.017.png)|![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.018.png)![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.019.png)|
|The item details activity provides a more comprehensive view of the item, allowing users to easily add it to the cart with a simple click on the "Add to Bag" button.|The cart activity is retrieved from the database, allowing users to save items. They can then view the total price and quantity, and proceed to checkout with a simple 'Proceed to Checkout' button.|



|![](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.020.png)![](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.021.png)![A screenshot of a phone

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.022.png)|![A screenshot of a login form

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.023.png)![](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.024.png)|
| :- | :- |
|The checkout is a fragment containing text fields that require all necessary information for the checkout process. Users have the option to either cancel the transaction or proceed with payment|The Profile activity allows users to update their details and log out.|



# <a name="_toc156801147"></a>Back-End Development

<a name="_toc156801148"></a>Backend Setup:

I used Java and Firebase for my backend, organizing data into three collections: 'users,' 'cart,' and 'items.'

![A screenshot of a computer

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.025.png)
#### *Users Collection:*
Each user has a unique username created from their first name, last name, and a random number (1-99). Additional details include birthday, email, password.




#### ![A screenshot of a computer

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.026.png)*Items Collection:*
Each item has a unique ID and includes details like name, stock count, small and big descriptions, price, and an imageURL.

####
####
####
####
#### *Cart Collection:*
The 'cart' collection links to 'users' using the username as a primary key.

Inside the 'cart' collection, each user has a subcollection for their items.

The names of the items serve as subcollection keys, with associated details like image URL, name, price, quantity, and the username.
#### ![A screenshot of a computer

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.027.png)![A screenshot of a computer

Description automatically generated](Aspose.Words.80ebe28e-0817-4e49-8df3-7bb1eb0f5adc.028.png)
####

### <a name="_toc156801149"></a>Crucial Parts
##### createAccount
The below method handles user registration using Firebase Authentication in an Android app. It takes email and password, attempts to create an account, and if successful, creates a user profile with additional details. This profile is then stored in the "users" collection of Firebase Firestore. Success or failure messages are displayed to the user.

private void createAccount(String email, String password, String firstName, String lastName, String birthday) {
`    `mAuth.createUserWithEmailAndPassword(email, password)
.addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
`                `@Override
`                `public void onComplete(@NonNull Task<AuthResult> task) {
`                    `progressBar.setVisibility(View.*GONE*);
`                    `if (task.isSuccessful()) {
`                        `FirebaseUser user = mAuth.getCurrentUser();

`                        `User userProfile = new User(firstName, lastName, birthday, email, password);

`                        `FirebaseFirestore db = FirebaseFirestore.*getInstance*();
`                        `CollectionReference usersCollection = db.collection("users");
`                        `DocumentReference userRef = usersCollection.document(userProfile.getUsername());

`                        `userRef.set(userProfile)
.addOnSuccessListener(new OnSuccessListener<Void>() {
`                                    `@Override
`                                    `public void onSuccess(Void aVoid) {
`                                        `showToast("Account created successfully!");
`                                    `}
`                                `})
.addOnFailureListener(new OnFailureListener() {
`                                    `@Override
`                                    `public void onFailure(@NonNull Exception e) {
`                                        `showToast("Failed to store user data: " + e.getMessage());
`                                    `}
`                                `});
`                    `} else {
`                        `showToast("Account creation failed: " + task.getException().getMessage());
`                    `}
`                `}
`            `});
}

##### signInWithUsername
The signInWithUsername method helps users sign in with a username and password. It checks Firebase Firestore to find the username, gets the associated email, and tries to sign in using Firebase Authentication. If successful, it shows a success message and opens a catalog activity. If there's a sign-in issue, it tells the user to check their credentials. If the username isn't found, it lets the user know it's not registered.

private void signInWithUsername(String username, String password) {
`    `FirebaseFirestore db = FirebaseFirestore.*getInstance*();

`    `db.collection("users")
.whereEqualTo("username", username)
.get()
.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
`                `@Override
`                `public void onComplete(@NonNull Task<QuerySnapshot> task) {
`                    `if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {

`                       	`String email =	 task.getResult().getDocuments().get(0).getString("email");


`                        `mAuth.signInWithEmailAndPassword(email, password)
.addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
`                                    `@Override
`                                    `public void onComplete(@NonNull Task<AuthResult> task) {
`                                        `if (task.isSuccessful()) {
`                                            `showToast("Sign-in successful!");
`                                            `launchCatalogActivity(username);
`                                        `} else {
`                                            `showToast("Sign-in failed. Please check your credentials.");
`                                        `}
`                                    `}
`                                `});
`                    `} else {
`                        `showToast("Username not found.");
`                    `}
`                `}
`            `});
}


##### setUpRecyclerView for catalog
The setUpRecyclerView method sets up a display of items from a Firebase collection named "items" in a RecyclerView. It orders the items by name and uses a FirestoreRecyclerAdapter to show them. The adapter binds the data to a custom view holder, handling the display of item details like image, name, price, and small description.

private void setUpRecyclerView() {
`    `CollectionReference itemsCollection = firestore.collection("items");

`    `Query query = itemsCollection.orderBy("name"); // Adjust the query as needed

`    `FirestoreRecyclerOptions<ItemModel> options =
`            `new FirestoreRecyclerOptions.Builder<ItemModel>()
.setQuery(query, ItemModel.class)
.build();

`    `FirestoreRecyclerAdapter<ItemModel, ItemViewHolder> adapter =
`            `new FirestoreRecyclerAdapter<ItemModel, ItemViewHolder>(options) {
`                `@Override
`                `protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull ItemModel model) {
`                    `// Bind data to your ViewHolder
`                    `holder.setItemImage(model.getImage());
`                    `holder.setItemName(model.getName());
`                    `holder.setItemPrice(model.getPrice());
`                    `holder.setItemSmallDescription(model.getSmallDescription());



##### addToCart
The addToCart method adds an item to a user's shopping cart in a Firebase Firestore database. It checks if the item is already in the cart and either increases the quantity and price or creates a new entry with default values. After the transaction, it decreases the stock count by 1 and updates the user interface.

private void addToCart(final String username, final String name, int stockCount, String imageUrl, double price) {
`    `final DocumentReference itemRef = db.collection("carts").document(username)
.collection("items").document(name);

`    `db.runTransaction(transaction -> {
`        `DocumentSnapshot snapshot = transaction.get(itemRef);

`        `if (snapshot.exists()) {
`            `// Item already exists in the cart
`            `transaction.update(itemRef,
`                    `"quantity", FieldValue.*increment*(1),
`                    `"price", FieldValue.*increment*(price));
`        `} else {
`            `// Item doesn't exist in the cart, create a new one
`            `double updatedPrice = price \* 1;
`            `CartItemModel cartItem = new CartItemModel(imageUrl, updatedPrice, name, username, 1);
`            `transaction.set(itemRef, cartItem);
`        `}

`        `return null;
`    `}).addOnSuccessListener(aVoid -> {
`        `decrementStockCount(1); 

`    `});
}


##### deleteCartForUser
The deleteCartForUser method removes a user's entire shopping cart if the user has proceeded and paid.

private void deleteCartForUser() {
`    `String username = requireActivity().getIntent().getStringExtra("USERNAME\_EXTRA");

`    `CollectionReference cartItemsRef = FirebaseFirestore.*getInstance*()
.collection("carts")
.document(username)
.collection("items");

`    `cartItemsRef.get().addOnCompleteListener(task -> {
`        `if (task.isSuccessful()) {
`            `for (QueryDocumentSnapshot document : task.getResult()) {
`                `cartItemsRef.document(document.getId()).delete();
`            `}

`            `FirebaseFirestore.*getInstance*().collection("carts").document(username).delete();

`            `showToast("Cart deleted successfully!");
`            `updateUI();
`        `} else {
`            `// Handle errors, if any
`            `showToast("Failed to delete cart. Please try again.");
`        `}
`    `});


# <a name="_toc156801150"></a>Reflection

Working on this assignment has been a valuable learning experience for me. After this semester of learning and researching, applying this knowledge improved my logical thinking and coding skills.

A key lesson from this assignment is the importance of planning before implementing, I planned thoroughly, from the app's design to activities and class splits.

I encountered challenges in the creation of the cart, specifically as I had to check if the product was already added to the basket or not. However, after many tries, testing, and failures, I managed to show the cart correctly.

One challenge that I didn't overcome is at the cart activity where I could not make the increment or decrement of the item inside the cart.

In conclusion, this assignment has not only boosted my knowledge in full-stack development but also equipped me with skills for future academic and professional pursuits. I'm eager to apply all of these in my future projects.

# <a name="_toc156801151"></a>Conclusion and Future Work

In conclusion, developing GYMDOLPHIN for Mobile Web Application Development has been both educational and rewarding. This project allowed me to apply theoretical knowledge into practical implementation, enhancing my logical thinking and coding skills.

A important lesson I learned was the significance of thorough planning before implementation. Challenges, particularly in cart functionality, provided valuable learning opportunities.

While the project showcases a robust E-commerce application with user authentication, dynamic cart functionality, and real-time updates, there is acknowledgment of areas for potential improvement. Future work could address challenges in cart item increment and decrement functionality and explore additional features such as order history, wishlist, admin panel and implementing a machine learning model that can provide personalized recommendations.

In summary, this project has not only strengthened my skills in full-stack development but has also motivated me for future projects. The combination of theoretical understanding and hands-on application sets a solid foundation for continued growth and exploration in the dynamic field of mobile app development.


# <a name="_toc156801152"></a>References

*30 UI & UX Wireframe examples for businesses in 2022* (2023) *Visme Blog*. Available at: https://visme.co/blog/wireframe-examples/ (Accessed: 22 January 2024). 

*ActionBar  :  android developers* (no date) *Android Developers*. Available at: https://developer.android.com/reference/android/app/ActionBar (Accessed: 22 January 2024). 

Bumptech (no date) *Bumptech/glide: An image loading and caching library for Android focused on smooth scrolling*, *GitHub*. Available at: https://github.com/bumptech/glide (Accessed: 22 January 2024). 

*The Collaborative Interface Design Tool* (no date) *Figma*. Available at: https://www.figma.com/ (Accessed: 22 January 2024). 

*Create dynamic lists with RecyclerView  :  android developers* (no date) *Android Developers*. Available at: https://developer.android.com/develop/ui/views/layout/recyclerview (Accessed: 22 January 2024). 

*Firebase documentation* (no date) *Google*. Available at: https://firebase.google.com/docs (Accessed: 22 January 2024). 

*Intent  :  android developers* (no date) *Android Developers*. Available at: https://developer.android.com/reference/android/content/Intent (Accessed: 22 January 2024). 

*Layoutinflater  :  Android developers* (no date) *Android Developers*. Available at: https://developer.android.com/reference/android/view/LayoutInflater (Accessed: 22 January 2024). 




# <a name="_toc156801153"></a>Appendix/Code

##### MainActivity.java
package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

`    `private EditText usernameEditText, passwordEditText;
`    `private Button signInButton, notMemberButton;
`    `private TextView forgotPasswordTextView, continueAsGuestTextView;
`    `private FirebaseAuth mAuth;

`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_main*);

`        `usernameEditText = findViewById(R.id.*emailEditText*);
`        `passwordEditText = findViewById(R.id.*passwordEditText*);
`        `signInButton = findViewById(R.id.*signInButton*);
`        `forgotPasswordTextView = findViewById(R.id.*forgotPasswordTextView*);
`        `notMemberButton = findViewById(R.id.*notMemberButton*);
`        `continueAsGuestTextView = findViewById(R.id.*continueAsGuestTextView*);
`        `mAuth = FirebaseAuth.*getInstance*();

`        `signInButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `String username = usernameEditText.getText().toString();
`                `String password = passwordEditText.getText().toString();
`                `if (!username.isEmpty() && !password.isEmpty()) {
`                    `signInWithUsername(username, password);
`                `} else {
`                    `showToast("Please enter username and password");
`                `}
`            `}
`        `});

`        `forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `Intent forgotPasswordIntent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
`                `startActivity(forgotPasswordIntent);
`            `}
`        `});

`        `notMemberButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
`                `startActivity(registerIntent);
`            `}
`        `});

`        `continueAsGuestTextView.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `Intent catalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
`                `startActivity(catalogIntent);
`            `}
`        `});
`    `}

`    `private void signInWithUsername(String username, String password) {
`        `FirebaseFirestore db = FirebaseFirestore.*getInstance*();

`        `db.collection("users")
.whereEqualTo("username", username)
.get()
.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
`                    `@Override
`                    `public void onComplete(@NonNull Task<QuerySnapshot> task) {
`                        `if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
`                            `String email = task.getResult().getDocuments().get(0).getString("email");

`                            `mAuth.signInWithEmailAndPassword(email, password)
.addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
`                                        `@Override
`                                        `public void onComplete(@NonNull Task<AuthResult> task) {
`                                            `if (task.isSuccessful()) {
`                                                `showToast("Sign-in successful!");
`                                                `launchCatalogActivity(username);
`                                            `} else {
`                                                `showToast("Sign-in failed. Please check your credentials.");
`                                            `}
`                                        `}
`                                    `});
`                        `} else {
`                            `showToast("Username not found.");
`                        `}
`                    `}
`                `});
`    `}


`    `private void launchCatalogActivity(String username) {
`        `Intent catalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
`        `catalogIntent.putExtra("USERNAME\_EXTRA", username);
`        `startActivity(catalogIntent);
`    `}


`    `private void showToast(String message) {
`        `Toast.*makeText*(this, message, Toast.*LENGTH\_SHORT*).show();
`    `}
}


RegisterActivity.java

package com.example.gymdolphin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;


public class RegisterActivity extends AppCompatActivity {

`    `private EditText firstNameEditText, lastNameEditText, birthdayEditText;
`    `private EditText emailEditText, passwordEditText, confirmPasswordEditText;
`    `private ProgressBar progressBar;
`    `private ImageButton backButton;
`    `private Button createAccountButton;
`    `private FirebaseAuth mAuth;

`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_register*);
`        `mAuth = FirebaseAuth.*getInstance*();

`        `firstNameEditText = findViewById(R.id.*firstNameEditText*);
`        `lastNameEditText = findViewById(R.id.*lastNameEditText*);
`        `birthdayEditText = findViewById(R.id.*birthdayEditText*);
`        `emailEditText = findViewById(R.id.*emailEditText*);
`        `passwordEditText = findViewById(R.id.*passwordEditText*);
`        `confirmPasswordEditText = findViewById(R.id.*confirmPasswordEditText*);
`        `backButton = findViewById(R.id.*backButton*);
`        `createAccountButton = findViewById(R.id.*createAccountButton*);
`        `progressBar = findViewById(R.id.*progressBar*);

`        `birthdayEditText.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `showDatePicker();
`            `}
`        `});

`        `backButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `onBackPressed();
`            `}
`        `});

`        `createAccountButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `progressBar.setVisibility(View.*VISIBLE*);
`                `String firstName = firstNameEditText.getText().toString();
`                `String lastName = lastNameEditText.getText().toString();
`                `String email = emailEditText.getText().toString();
`                `String password = passwordEditText.getText().toString();
`                `String confirmPassword = confirmPasswordEditText.getText().toString();

`                `if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
`                    `if (password.equals(confirmPassword)) {
`                        `createAccount(email, password, firstName, lastName, birthdayEditText.getText().toString());
`                    `} else {
`                        `showToast("Passwords do not match");
`                        `progressBar.setVisibility(View.*GONE*);
`                    `}
`                `} else {
`                    `showToast("Please fill in all fields");
`                    `progressBar.setVisibility(View.*GONE*);
`                `}
`            `}
`        `});
`    `}

`    `private void showDatePicker() {
`        `final Calendar currentDate = Calendar.*getInstance*();
`        `int year = currentDate.get(Calendar.*YEAR*);
`        `int month = currentDate.get(Calendar.*MONTH*);
`        `int day = currentDate.get(Calendar.*DAY\_OF\_MONTH*);

`        `DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
`            `@Override
`            `public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
`                `birthdayEditText.setText(selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay);
`            `}
`        `}, year, month, day);

`        `datePicker.show();
`    `}

`    `private void createAccount(String email, String password, String firstName, String lastName, String birthday) {
`        `mAuth.createUserWithEmailAndPassword(email, password)
.addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
`                    `@Override
`                    `public void onComplete(@NonNull Task<AuthResult> task) {
`                        `progressBar.setVisibility(View.*GONE*);
`                        `if (task.isSuccessful()) {
`                            `FirebaseUser user = mAuth.getCurrentUser();

`                            `User userProfile = new User(firstName, lastName, birthday, email, password);

`                            `FirebaseFirestore db = FirebaseFirestore.*getInstance*();
`                            `CollectionReference usersCollection = db.collection("users");
`                            `DocumentReference userRef = usersCollection.document(userProfile.getUsername());

`                            `userRef.set(userProfile)
.addOnSuccessListener(new OnSuccessListener<Void>() {
`                                        `@Override
`                                        `public void onSuccess(Void aVoid) {
`                                            `showToast("Account created successfully!");
`                                        `}
`                                    `})
.addOnFailureListener(new OnFailureListener() {
`                                        `@Override
`                                        `public void onFailure(@NonNull Exception e) {
`                                            `showToast("Failed to store user data: " + e.getMessage());
`                                        `}
`                                    `});
`                        `} else {
`                            `showToast("Account creation failed: " + task.getException().getMessage());
`                        `}
`                    `}
`                `});
`    `}


`    `private void showToast(String message) {
`        `Toast.*makeText*(this, message, Toast.*LENGTH\_SHORT*).show();
`    `}
}


##### CartActivity.java
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

`    `private static final String *TAG* = "CartActivity";
`    `private FirebaseFirestore firestore;
`    `private List<CartItemModel> cartItems;

`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_cart*);

`        `firestore = FirebaseFirestore.*getInstance*();


`        `String username = getIntent().getStringExtra("USERNAME\_EXTRA");
`        `TextView usernameText = findViewById(R.id.*usernameText*);
`        `usernameText.setText(username);

`        `RecyclerView recyclerView = findViewById(R.id.*recyclerViewCartItems*);
`        `LinearLayoutManager layoutManager = new LinearLayoutManager(this);
`        `recyclerView.setLayoutManager(layoutManager);

`        `TextView totalValueTextView = findViewById(R.id.*totalValueTextView*);
`        `Button proceedToCheckoutButton = findViewById(R.id.*proceedToCheckoutButton*);
`        `proceedToCheckoutButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View v) {
`                `// Show the credit card details dialog
`                `CheckoutDialogFragment dialogFragment = new CheckoutDialogFragment();
`                `dialogFragment.show(getSupportFragmentManager(), "CheckoutDialogFragment");
`            `}
`        `});


`        `logCartItems(username, recyclerView, totalValueTextView);

`        `// Bottom Navigation View setup
`        `BottomNavigationView bottomNavigationView = findViewById(R.id.*bottomNavigationView*);
`        `bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
`            `@Override
`            `public boolean onNavigationItemSelected(@NonNull MenuItem item) {
`                `int itemId = item.getItemId();

`                `if (itemId == R.id.*nav\_user*) {
`                    `// Handle user icon click
`                    `startActivity(new Intent(CartActivity.this, UserProfileActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;

`                `} else if (itemId == R.id.*nav\_cart*) {
`                    `startActivity(new Intent(CartActivity.this, CartActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;
`                `} else if (itemId == R.id.*nav\_catalog*) {
`                    `// Handle home icon click
`                    `startActivity(new Intent(CartActivity.this, CatalogActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;
`                `}

`                `return false;
`            `}
`        `});
`    `}

`    `private void logCartItems(String username, RecyclerView recyclerView, TextView totalValueTextView) {
`        `CollectionReference cartItemsRef = firestore.collection("carts").document(username).collection("items");

`        `cartItemsRef.get().addOnCompleteListener(task -> {
`            `if (task.isSuccessful()) {
`                `cartItems = new ArrayList<>();
`                `double totalValue = 0.0;

`                `for (QueryDocumentSnapshot document : task.getResult()) {
`                    `String imageUrl = document.getString("imageUrl");
`                    `String itemName = document.getString("name");
`                    `double itemPrice = document.getDouble("price");
`                    `int quantity = document.getLong("quantity").intValue();

`                    `CartItemModel cartItem = new CartItemModel(imageUrl, itemPrice, itemName, username, quantity);
`                    `cartItems.add(cartItem);

`                    `totalValue += itemPrice;
`                `}

`                `DecimalFormat decimalFormat = new DecimalFormat("0.00");
`                `String formattedTotalValue = "Total Value: £" + decimalFormat.format(totalValue);

`                `totalValueTextView.setText(formattedTotalValue);

`                `CartItemAdapter adapter = new CartItemAdapter(cartItems);
`                `recyclerView.setAdapter(adapter);

`            `} else {
`                `Log.*e*(*TAG*, "Error getting documents: ", task.getException());
`            `}
`        `});
`    `}

`    `private static class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

`        `private List<CartItemModel> cartItems;

`        `public CartItemAdapter(List<CartItemModel> cartItems) {
`            `this.cartItems = cartItems;
`        `}

`        `@NonNull
`        `@Override
`        `public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
`            `View view = LayoutInflater.*from*(parent.getContext()).inflate(R.layout.*item\_cart*, parent, false);
`            `return new CartItemViewHolder(view);
`        `}

`        `@Override
`        `public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
`            `CartItemModel cartItem = cartItems.get(position);

`            `String price = ("£" + String.*valueOf*(cartItem.getPrice()));
`            `String quantity = ("Qty. " + String.*valueOf*(cartItem.getQuantity()));
`            `// Set data to views
`            `holder.itemNameTextView.setText(cartItem.getName());
`            `holder.itemPriceTextView.setText(price);
`            `holder.quantityTextView.setText(quantity);


`            `Glide.*with*(holder.itemView.getContext()).load(cartItem.getImageUrl()).into(holder.itemImageView);
`        `}

`        `@Override
`        `public int getItemCount() {
`            `return cartItems.size();
`        `}

`        `static class CartItemViewHolder extends RecyclerView.ViewHolder {
`            `TextView itemNameTextView;
`            `TextView itemPriceTextView;
`            `TextView quantityTextView;
`            `ImageView itemImageView;

`            `public CartItemViewHolder(@NonNull View itemView) {
`                `super(itemView);
`                `itemNameTextView = itemView.findViewById(R.id.*itemNameTextView*);
`                `itemPriceTextView = itemView.findViewById(R.id.*itemPriceTextView*);
`                `quantityTextView = itemView.findViewById(R.id.*quantityTextView*);
`                `itemImageView = itemView.findViewById(R.id.*itemImageView*);
`            `}
`        `}
`    `}
}

##### CartItem.java
package com.example.gymdolphin;

public class CartItem {

`    `private String imageUrl;
`    `private String name;
`    `private double price;
`    `private String username;
`    `private int quantity;

`    `public CartItem(String imageUrl, double updatedPrice) {
`    `}

`    `public CartItem(String imageUrl, double price, String name, String username, int quantity) {
`        `this.imageUrl = imageUrl;
`        `this.price = price;
`        `this.name = name;
`        `this.username = username;
`        `this.quantity = quantity;
`    `}


`    `public String getName() {
`        `return name;
`    `}

`    `public void setName(String name) {
`        `this.name = name;
`    `}



`    `public String getUsername() {
`        `return username;
`    `}

`    `public void setUsername(String username) {
`        `this.username = username;
`    `}

`    `public int getQuantity() {
`        `return quantity;
`    `}


}


##### CartItemModel.java
package com.example.gymdolphin;

public class CartItemModel {

`    `private String imageUrl;
`    `private String name;
`    `private double price;
`    `private String username;
`    `private int quantity;

`    `public CartItemModel(String imageUrl, double price, String name, String username, int quantity) {
`        `this.imageUrl = imageUrl;
`        `this.price = price;
`        `this.name = name;
`        `this.username = username;
`        `this.quantity = quantity;
`    `}


`    `public String getImageUrl() {
`        `return imageUrl;
`    `}


`    `public String getName() {
`        `return name;
`    `}

`    `public void setName(String name) {
`        `this.name = name;
`    `}

`    `public double getPrice() {
`        `return price;
`    `}



`    `public String getUsername() {
`        `return username;
`    `}

`    `public void setUsername(String username) {
`        `this.username = username;
`    `}

`    `public int getQuantity() {
`        `return quantity;
`    `}

}


##### CatalogActivity.java
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

`    `private RecyclerView recyclerView;
`    `private FirebaseFirestore firestore;
`    `private FirebaseUser currentUser;
`    `private TextView welcomeMessageTextView;


`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_catalog*);

`        `currentUser = FirebaseAuth.*getInstance*().getCurrentUser();
`        `firestore = FirebaseFirestore.*getInstance*();

`        `welcomeMessageTextView = findViewById(R.id.*welcomeMessageTextView*);
`        `recyclerView = findViewById(R.id.*recyclerView*);
`        `recyclerView.setLayoutManager(new LinearLayoutManager(this));

`        `Intent intent = getIntent();
`        `if (intent != null && intent.hasExtra("USERNAME\_EXTRA")) {
`            `String username = intent.getStringExtra("USERNAME\_EXTRA");
`            `String welcomeMessage = "WELCOME BACK, " + username + "!";
`            `welcomeMessageTextView.setText(welcomeMessage);
`        `}

`        `DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.*VERTICAL*);
`        `recyclerView.addItemDecoration(dividerItemDecoration);

`        `BottomNavigationView bottomNavigationView = findViewById(R.id.*bottomNavigationView*);
`        `bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
`            `@Override
`            `public boolean onNavigationItemSelected(@NonNull MenuItem item) {
`                `int itemId = item.getItemId();

`                `if (itemId == R.id.*nav\_user*) {
`                    `String username = intent.getStringExtra("USERNAME\_EXTRA");
`                    `startActivity(new Intent(CatalogActivity.this, UserProfileActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;

`            `} else if (itemId == R.id.*nav\_cart*) {
`                    `String username = intent.getStringExtra("USERNAME\_EXTRA");
`                    `startActivity(new Intent(CatalogActivity.this, CartActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;
`                `} else if (itemId == R.id.*nav\_catalog*) {
`                    `String username = getIntent().getStringExtra("USERNAME\_EXTRA");
`                    `startActivity(new Intent(CatalogActivity.this, CatalogActivity.class)
.putExtra("USERNAME\_EXTRA", username));

`                    `return true;
`                `}

`                `return false;
`            `}

`        `});

`        `setUpRecyclerView();
`    `}

`    `private void setUpRecyclerView() {
`        `CollectionReference itemsCollection = firestore.collection("items");

`        `Query query = itemsCollection.orderBy("name"); // Adjust the query as needed

`        `FirestoreRecyclerOptions<ItemModel> options =
`                `new FirestoreRecyclerOptions.Builder<ItemModel>()
.setQuery(query, ItemModel.class)
.build();

`        `FirestoreRecyclerAdapter<ItemModel, ItemViewHolder> adapter =
`                `new FirestoreRecyclerAdapter<ItemModel, ItemViewHolder>(options) {
`                    `@Override
`                    `protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull ItemModel model) {
`                        `holder.setItemImage(model.getImage());
`                        `holder.setItemName(model.getName());
`                        `holder.setItemPrice(model.getPrice());
`                        `holder.setItemSmallDescription(model.getSmallDescription());

`                        `holder.itemView.setOnClickListener(new View.OnClickListener() {
`                            `@Override
`                            `public void onClick(View view) {
`                                `Intent intent = new Intent(CatalogActivity.this, ItemDetailsActivity.class);
`                                `intent.putExtra("image", model.getImage());
`                                `intent.putExtra("name", model.getName());
`                                `intent.putExtra("price", model.getPrice());
`                                `intent.putExtra("smallDescription", model.getSmallDescription());
`                                `intent.putExtra("bigDescription", model.getBigDescription());
`                                `intent.putExtra("stockCount", model.getStockCount());
`                                `intent.putExtra("USERNAME\_EXTRA", getIntent().getStringExtra("USERNAME\_EXTRA"));
`                                `startActivity(intent);
`                            `}
`                        `});
`                    `}

`                    `@NonNull
`                    `@Override
`                    `public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
`                        `View view = LayoutInflater.*from*(parent.getContext()).inflate(R.layout.*item\_layout*, parent, false);
`                        `return new ItemViewHolder(view);
`                    `}
`                `};

`        `recyclerView.setAdapter(adapter);
`        `adapter.startListening();
`    `}

`    `public static class ItemViewHolder extends RecyclerView.ViewHolder {
`        `private View mView;
`        `private ImageView itemImage;

`        `public ItemViewHolder(@NonNull View itemView) {
`            `super(itemView);
`            `mView = itemView;
`            `itemImage = mView.findViewById(R.id.*itemImage*);
`        `}

`        `public void setItemImage(String imageUrl) {
`            `try {
`                `System.*out*.println(imageUrl);
`                `Glide.*with*(itemView.getContext())
.load(imageUrl)
.placeholder(R.drawable.*back\_ic*)
.error(R.drawable.*back\_ic*)
.into(itemImage);
`            `} catch (Exception e) {
`                `e.printStackTrace();
`                `Log.*e*("ImageLoadError", "Error loading image from URL: " + imageUrl);
`            `}
`        `}

`        `public void setItemName(String itemName) {
`            `TextView itemNameView = mView.findViewById(R.id.*itemName*);
`            `itemNameView.setText(itemName);
`        `}

`        `public void setItemPrice(double price) {
`            `TextView priceView = mView.findViewById(R.id.*itemPrice*);
`            `priceView.setText(String.*format*("£%.2f", price));
`        `}

`        `public void setItemSmallDescription(String smallDescription) {
`            `TextView smallDescView = mView.findViewById(R.id.*itemSmallDescription*);
`            `smallDescView.setText(smallDescription);
`        `}
`    `}
}



##### CheckOutDialogFragment.java
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

`    `public CheckoutDialogFragment() {
`    `}

`    `@Override
`    `public View onCreateView(LayoutInflater inflater, ViewGroup container,
`                             `Bundle savedInstanceState) {
`        `return inflater.inflate(R.layout.*dialog\_checkout*, container, false);
`    `}

`    `@Override
`    `public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
`        `super.onViewCreated(view, savedInstanceState);

`        `Button okButton = view.findViewById(R.id.*okButton*);
`        `okButton.setOnClickListener(v -> {
`            `deleteCartForUser();

`            `showToast("Thank You for your purchase!");

`            `dismiss();
`        `});

`        `Button cancelButton = view.findViewById(R.id.*cancelButton*);
`        `cancelButton.setOnClickListener(c-> {
`            `dismiss();
`        `});
`    `}

`    `private void deleteCartForUser() {
`        `String username = requireActivity().getIntent().getStringExtra("USERNAME\_EXTRA");

`        `CollectionReference cartItemsRef = FirebaseFirestore.*getInstance*()
.collection("carts")
.document(username)
.collection("items");

`        `cartItemsRef.get().addOnCompleteListener(task -> {
`            `if (task.isSuccessful()) {
`                `for (QueryDocumentSnapshot document : task.getResult()) {
`                    `cartItemsRef.document(document.getId()).delete();
`                `}

`                `FirebaseFirestore.*getInstance*().collection("carts").document(username).delete();

`                `showToast("Cart deleted successfully!");
`                `updateUI();
`            `} else {
`                `showToast("Failed to delete cart. Please try again.");
`            `}
`        `});
`    `}

`    `private void updateUI() {
`    `}

`    `private void showToast(String message) {
`        `Toast.*makeText*(requireContext(), message, Toast.*LENGTH\_SHORT*).show();
`    `}
}


##### ForgotPasswordActivity.java
package com.example.gymdolphin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

`    `private EditText emailEditText;
`    `private Button recoverPasswordButton;
`    `private ImageButton backButton;

`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_forgot\_password*);

`        `ActionBar actionBar = getSupportActionBar();
`        `if (actionBar != null) {
`            `actionBar.setDisplayHomeAsUpEnabled(true);
`            `actionBar.setHomeAsUpIndicator(R.drawable.*back\_ic*);
`        `}

`        `emailEditText = findViewById(R.id.*emailEditText*);
`        `recoverPasswordButton = findViewById(R.id.*recoverPasswordButton*);
`        `backButton = findViewById(R.id.*backButton*);

`        `recoverPasswordButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `String email = emailEditText.getText().toString();

`                `if (!email.isEmpty()) {
`                    `FirebaseAuth.*getInstance*().sendPasswordResetEmail(email)
.addOnCompleteListener(new OnCompleteListener<Void>() {
`                                `@Override
`                                `public void onComplete(@NonNull Task<Void> task) {
`                                    `if (task.isSuccessful()) {
`                                        `Toast.*makeText*(ForgotPasswordActivity.this, "Password reset email sent to " + email, Toast.*LENGTH\_SHORT*).show();
`                                    `} else {
`                                        `Toast.*makeText*(ForgotPasswordActivity.this, "Failed to send reset email: " + task.getException().getMessage(), Toast.*LENGTH\_SHORT*).show();
`                                    `}
`                                `}
`                            `});
`                `} else {
`                    `Toast.*makeText*(ForgotPasswordActivity.this, "Please enter your email", Toast.*LENGTH\_SHORT*).show();
`                `}
`            `}
`        `});

`        `backButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `onBackPressed();
`            `}
`        `});
`    `}
}

ItemDetailsActivity.java

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

`    `private ImageView itemImage;
`    `private TextView itemName;
`    `private TextView itemPrice;
`    `private TextView itemSmallDescription;
`    `private TextView itemBigDescription;
`    `private TextView itemStockCount;
`    `private Button addButton;

`    `private FirebaseFirestore db;
`    `private FirebaseUser currentUser;

`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_item\_details*);

`        `itemImage = findViewById(R.id.*itemImageDetails*);
`        `itemName = findViewById(R.id.*itemNameDetails*);
`        `itemPrice = findViewById(R.id.*itemPriceDetails*);
`        `itemSmallDescription = findViewById(R.id.*itemSmallDescriptionDetails*);
`        `itemBigDescription = findViewById(R.id.*itemBigDescriptionDetails*);
`        `itemStockCount = findViewById(R.id.*itemStockCountDetails*);
`        `addButton = findViewById(R.id.*addButton*);

`        `db = FirebaseFirestore.*getInstance*();
`        `currentUser = FirebaseAuth.*getInstance*().getCurrentUser();

`        `Bundle extras = getIntent().getExtras();
`        `if (extras != null) {
`            `String imageUrl = extras.getString("image");
`            `String name = extras.getString("name");
`            `double price = extras.getDouble("price");
`            `String smallDescription = extras.getString("smallDescription");
`            `String bigDescription = extras.getString("bigDescription");
`            `int stockCount = extras.getInt("stockCount");
`            `String username = extras.getString("USERNAME\_EXTRA");

`            `Glide.*with*(this)
.load(imageUrl)
.placeholder(R.drawable.*back\_ic*)
.error(R.drawable.*back\_ic*)
.into(itemImage);
`            `itemName.setText(name);
`            `itemPrice.setText(String.*format*("£%.2f", price));
`            `itemSmallDescription.setText(smallDescription);
`            `itemBigDescription.setText(bigDescription);
`            `itemStockCount.setText(String.*valueOf*(stockCount));

`            `addButton.setOnClickListener(new View.OnClickListener() {
`                `@Override
`                `public void onClick(View view) {
`                    `if (currentUser != null) {
`                        `addToCart(username, name, stockCount, imageUrl, price);
`                    `}
`                `}
`            `});
`        `}

`        `ImageView backButton = findViewById(R.id.*backButton*);
`        `backButton.setOnClickListener(new View.OnClickListener() {
`            `@Override
`            `public void onClick(View view) {
`                `onBackPressed();
`            `}
`        `});
`    `}

`    `private void addToCart(final String username, final String name, int stockCount, String imageUrl, double price) {
`        `final DocumentReference itemRef = db.collection("carts").document(username)
.collection("items").document(name);

`        `db.runTransaction(transaction -> {
`            `DocumentSnapshot snapshot = transaction.get(itemRef);

`            `if (snapshot.exists()) {
`                `transaction.update(itemRef,
`                        `"quantity", FieldValue.*increment*(1),
`                        `"price", FieldValue.*increment*(price));
`            `} else {
`                `double updatedPrice = price \* 1;
`                `CartItemModel cartItem = new CartItemModel(imageUrl, updatedPrice, name, username, 1);
`                `transaction.set(itemRef, cartItem);
`            `}

`            `return null;
`        `}).addOnSuccessListener(aVoid -> {
`            `decrementStockCount(1);
`        `});
`    `}



`    `private void decrementStockCount(long initialQuantity) {
`        `if (initialQuantity > 0) {
`            `int newStockCount = Integer.*parseInt*(itemStockCount.getText().toString()) - 1;
`            `itemStockCount.setText(String.*valueOf*(newStockCount));
`        `}
`    `}
}

##### ItemModel.java

package com.example.gymdolphin;

public class ItemModel {
`    `private String image;
`    `private String name;
`    `private String smallDescription;
`    `private String bigDescription;
`    `private int stockCount;
`    `private double price;



`    `public ItemModel(String image, String name, String smallDescription, String bigDescription, int stockCount, double price) {
`        `this.image = image;
`        `this.name = name;
`        `this.smallDescription = smallDescription;
`        `this.bigDescription = bigDescription;
`        `this.stockCount = stockCount;
`        `this.price = price;
`    `}

`    `public String getImage() {
`        `return image;
`    `}

`    `public String getName() {
`        `return name;
`    `}

`    `public String getSmallDescription() {
`        `return smallDescription;
`    `}

`    `public String getBigDescription() {
`        `return bigDescription;
`    `}

`    `public int getStockCount() {
`        `return stockCount;
`    `}

`    `public double getPrice() {
`        `return price;
`    `}
}


##### User.Java
package com.example.gymdolphin;

import java.util.Calendar;
import java.util.Random;

public class User {
`    `private String firstName;
`    `private String lastName;
`    `private String birthday;
`    `private String email;
`    `private String password;
`    `private String username;


`    `public User(String firstName, String lastName, String birthday, String email, String password) {
`        `this.firstName = firstName;
`        `this.lastName = lastName;
`        `this.birthday = birthday;
`        `this.email = email;
`        `this.password = password;
`        `this.username = generateUsername();
`    `}

`    `public String getUsername() {
`        `return username;
`    `}

`    `private String generateUsername() {

`        `Random random = new Random();
`        `int randomNumber = random.nextInt(99) + 1;
`        `return firstName.toLowerCase() + lastName.toLowerCase() + randomNumber;
`    `}
}


UserProfileActivity.Java
package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {

`    `private TextView usernameTextView, firstNameTextView, lastNameTextView,
`            `birthdayTextView, emailTextView, passwordTextView;
`    `private ImageView firstNameIcon, lastNameIcon, updateBirthdayIcon, updateEmailIcon, updatePasswordIcon;
`    `private LinearLayout fieldsLayout;
`    `private Button signOutButton;
`    `private BottomNavigationView bottomNavigationView;

`    `private EditText firstNameEditText , lastNameEditText, birthdayEditText, emailEditText, passwordEditText;
`    `private FirebaseAuth firebaseAuth;


`    `@Override
`    `protected void onCreate(Bundle savedInstanceState) {
`        `super.onCreate(savedInstanceState);
`        `setContentView(R.layout.*activity\_user\_profile*);

`        `initViews();

`        `Intent intent = getIntent();
`        `String username = intent.getStringExtra("USERNAME\_EXTRA");

`        `usernameTextView.setText(username);

`        `fetchUserData(username);

`        `firebaseAuth = FirebaseAuth.*getInstance*();
`        `setIconClickListeners();

`        `signOutButton.setOnClickListener(v -> signOutUser());
`        `bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

`        `// Set other listeners or perform other operations as needed...
`    `}

`    `private void signOutUser() {
`        `firebaseAuth.signOut();

`        `startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
`        `finish();
`    `}

`    `private void initViews() {
`        `usernameTextView = findViewById(R.id.*usernameTextView*);
`        `firstNameTextView = findViewById(R.id.*firstNameTextView*);
`        `lastNameTextView = findViewById(R.id.*lastNameTextView*);
`        `birthdayTextView = findViewById(R.id.*birthdayTextView*);
`        `emailTextView = findViewById(R.id.*emailTextView*);
`        `passwordTextView = findViewById(R.id.*passwordTextView*);
`        `firstNameIcon = findViewById(R.id.*firstNameIcon*);
`        `lastNameIcon = findViewById(R.id.*lastNameIcon*);
`        `updateBirthdayIcon = findViewById(R.id.*updatebirthday*);
`        `signOutButton = findViewById(R.id.*signOutButton*);
`        `updateEmailIcon = findViewById(R.id.*updateEmail*);
`        `updatePasswordIcon = findViewById(R.id.*updatePassword*);
`        `fieldsLayout = findViewById(R.id.*fieldsLayout*);
`        `bottomNavigationView = findViewById(R.id.*bottomNavigationView*);
`        `firstNameEditText = findViewById(R.id.*firstNameEditText*);
`        `lastNameEditText = findViewById(R.id.*lastNameEditText*);
`        `birthdayEditText = findViewById(R.id.*birthdayEditText*);
`        `emailEditText = findViewById(R.id.*emailEditText*);
`        `passwordEditText = findViewById(R.id.*passwordEditText*);

`    `}

`    `private void fetchUserData(String username) {
`        `FirebaseFirestore db = FirebaseFirestore.*getInstance*();

`        `db.collection("users")
.document(username)
.get()
.addOnCompleteListener(task -> {

`                    `if (task.isSuccessful() && task.getResult() != null) {
`                        `DocumentSnapshot document = task.getResult();

`                        `// Retrieve user data from the document
`                        `String firstName = document.getString("firstName");
`                        `String lastName = document.getString("lastName");
`                        `String birthday = document.getString("birthday");
`                        `String email = document.getString("email");
`                        `String password = document.getString("password");

`                        `// Set the data in the TextViews
`                        `firstNameTextView.setText(firstName);
`                        `lastNameTextView.setText(lastName);
`                        `birthdayTextView.setText(birthday);
`                        `emailTextView.setText(email);
`                        `passwordTextView.setText(password);

`                    `}
`                `});
`    `}

`    `private void setIconClickListeners() {
`        `firstNameIcon.setOnClickListener(v -> {
`            `String firstName = firstNameEditText.getText().toString();
`            `updateFieldInFirebase("firstName", firstName);
`        `});

`        `lastNameIcon.setOnClickListener(v -> {
`            `String lastName = lastNameEditText.getText().toString();
`            `updateFieldInFirebase("lastName", lastName);
`        `});

`        `updateBirthdayIcon.setOnClickListener(v -> {
`            `String birthday = birthdayEditText.getText().toString();
`            `updateFieldInFirebase("birthday", birthday);
`        `});

`        `updateEmailIcon.setOnClickListener(v -> {
`            `String email = emailEditText.getText().toString();
`            `updateFieldInFirebase("email", email);
`        `});

`        `updatePasswordIcon.setOnClickListener(v -> {
`            `String password = passwordEditText.getText().toString();
`            `updateFieldInFirebase("password", password);
`        `});
`    `}


`    `private void updateFieldInFirebase(String field, String value) {
`        `Log.*d*("UserProfileActivity", "Updating field: " + field + " with value: " + value);
`        `FirebaseFirestore db = FirebaseFirestore.*getInstance*();

`        `Intent intent = getIntent();
`        `String username = intent.getStringExtra("USERNAME\_EXTRA");

`        `Map<String, Object> data = new HashMap<>();
`        `data.put(field, value);

`        `db.collection("users")
.document(username)
.update(data)
.addOnSuccessListener(aVoid -> {
`                    `Toast.*makeText*(UserProfileActivity.this, "Field updated successfully", Toast.*LENGTH\_SHORT*).show();
`                `})
.addOnFailureListener(e -> {
`                    `// Handle the error
`                    `Log.*e*("UserProfileActivity", "Error updating field", e);
`                    `Toast.*makeText*(UserProfileActivity.this, "Error updating field", Toast.*LENGTH\_SHORT*).show();
`                `});
`    `}

`    `private BottomNavigationView.OnNavigationItemSelectedListener navListener =
`            `new BottomNavigationView.OnNavigationItemSelectedListener() {
`                `@Override
`                `public boolean onNavigationItemSelected(@NonNull MenuItem item) {
`                    `int itemId = item.getItemId();

`                    `if (itemId == R.id.*nav\_user*) {
`                        `String username = getIntent().getStringExtra("USERNAME\_EXTRA");
`                        `startActivity(new Intent(UserProfileActivity.this, UserProfileActivity.class)
.putExtra("USERNAME\_EXTRA", username));
`                        `finish();
`                        `return true;
`                    `} else if (itemId == R.id.*nav\_cart*) {
`                        `String username = getIntent().getStringExtra("USERNAME\_EXTRA");
`                        `startActivity(new Intent(UserProfileActivity.this, CartActivity.class)
.putExtra("USERNAME\_EXTRA", username));
`                        `finish();
`                        `return true;
`                    `} else if (itemId == R.id.*nav\_catalog*) {
`                        `// Handle home icon click
`                        `String username = getIntent().getStringExtra("USERNAME\_EXTRA");
`                        `startActivity(new Intent(UserProfileActivity.this, CatalogActivity.class)
.putExtra("USERNAME\_EXTRA", username));
`                        `finish();
`                        `return true;
`                    `}

`                    `return false;
`                `}
`            `};
}



