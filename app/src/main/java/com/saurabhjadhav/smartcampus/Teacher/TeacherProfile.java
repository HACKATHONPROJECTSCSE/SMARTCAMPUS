package com.saurabhjadhav.smartcampus.Teacher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.saurabhjadhav.smartcampus.MainActivity;
import com.saurabhjadhav.smartcampus.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class TeacherProfile extends AppCompatActivity {

    // VARIABLES

    TextView Name, Username, Email, PhoneNo, changeProfileImage, deleteAccount;
    ImageView backToSDash, profileImage, logout;

    // FIREBASE

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    FirebaseUser firebaseUser;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        Name = findViewById(R.id.ProfileName);
        Username = findViewById(R.id.ProfileUsername);
        Email = findViewById(R.id.ProfileEmail);
        PhoneNo = findViewById(R.id.ProfilePhoneN0);
        backToSDash = findViewById(R.id.BackToSDash);
        profileImage = findViewById(R.id.ProfileImage);
        changeProfileImage = findViewById(R.id.ChangeProfilePic);
        logout = findViewById(R.id.Logout);
        deleteAccount = findViewById(R.id.DeleteAccount);

        // FIREBASE
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = firebaseAuth.getCurrentUser().getUid();
        firebaseUser = firebaseAuth.getCurrentUser();

        // ONCLICK LISTENERS

        // OPEN GALLERY
        changeProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 1000);
            }
        });


        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherProfile.this, TeacherDashboard.class));
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(TeacherProfile.this);
                dialog.setTitle("Are You Sure ?");
                dialog.setMessage("Account Will Be Deleted");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(TeacherProfile.this, "Account Deleted", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(TeacherProfile.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(TeacherProfile.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });


        // RETRIEVE USER DATA

        DocumentReference documentReference = firebaseFirestore.collection("Users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                Name.setText(documentSnapshot.getString("FullName"));
                Username.setText(documentSnapshot.getString("UserName"));
                Email.setText(documentSnapshot.getString("UserEmail"));
                PhoneNo.setText(documentSnapshot.getString("PhoneNumber"));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        // RETRIEVE USER PROFILE

        StorageReference profileRef = storageReference.child("Users/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).networkPolicy(NetworkPolicy.OFFLINE).into(profileImage);
            }
        });
    }

    // PICK IMAGE FROM GALLERY
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                profileImage.setImageURI(imageUri);
                uploadImage(imageUri);
            }
        }
    }

    // UPLOAD IMAGE TO FIREBASE
    private void uploadImage(Uri imageUri) {
        StorageReference fileRef = storageReference.child("Users/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(TeacherProfile.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).networkPolicy(NetworkPolicy.OFFLINE).into(profileImage);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TeacherProfile.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}