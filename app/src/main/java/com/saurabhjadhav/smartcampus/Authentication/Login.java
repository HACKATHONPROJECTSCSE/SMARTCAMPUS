package com.saurabhjadhav.smartcampus.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;
import com.saurabhjadhav.smartcampus.Student.StudentDashboard;
import com.saurabhjadhav.smartcampus.Teacher.TeacherDashboard;


public class Login extends AppCompatActivity {

    // VARIABLES

    TextInputLayout email, password;
    Button loginBtn, gotoRegister, forgotPassword, skipSignIn;
    boolean valid = true;
    ProgressDialog progressDialog;

    //FIREBASE

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        gotoRegister = findViewById(R.id.createAccount);
        forgotPassword = findViewById(R.id.ForgotPassword);
        skipSignIn = findViewById(R.id.skipSignIn);

        // FIREBASE

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // ONCLICK LISTENERS

       /* skipSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, LimitedFeaturesDashboard.class));
            }
        });

        */

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d("TAG", "onClick" + email.getEditText().getText().toString().trim());

                checkFieldEmail(email);
                checkFieldPassword(password);

                if (valid) {
                    fAuth.signInWithEmailAndPassword(email.getEditText().getText().toString().trim(), password.getEditText().getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            checkUserAccessLevel(authResult.getUser().getUid());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });


        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }

    // FIELD VALIDATION

    public boolean checkFieldEmail(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Enter Email!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public boolean checkFieldPassword(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Enter Password!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private void checkUserAccessLevel(String uid) {
        DocumentReference df = fStore.collection("Users").document(uid);

        // extract data from the document

        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG", "onSuccess: " + documentSnapshot.getData());

                FirebaseUser firebaseUser = fAuth.getCurrentUser();

                // identify user admin or user

                if (documentSnapshot.getString("isTeacher") != null) {
                    // user is admin

                    if (firebaseUser.isEmailVerified() == true) {
                        startActivity(new Intent(getApplicationContext(), TeacherDashboard.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Verify your email", Toast.LENGTH_LONG).show();
                        fAuth.signOut();
                    }
                }

                if (documentSnapshot.getString("isStudent") != null) {
                    // user is user

                    if (firebaseUser.isEmailVerified() == true) {
                        startActivity(new Intent(getApplicationContext(), StudentDashboard.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Verify your email", Toast.LENGTH_LONG).show();
                        fAuth.signOut();
                    }
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            progressDialog = new ProgressDialog(Login.this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    FirebaseUser firebaseUser = fAuth.getCurrentUser();

                    if (documentSnapshot.getString("isTeacher") != null) {
                        if (firebaseUser.isEmailVerified() == true) {
                            startActivity(new Intent(getApplicationContext(), TeacherDashboard.class));
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Verify your email", Toast.LENGTH_LONG).show();
                            fAuth.signOut();
                        }
                    }

                    if (documentSnapshot.getString("isStudent") != null) {
                        if (fAuth.getCurrentUser().isEmailVerified() == true) {
                            startActivity(new Intent(getApplicationContext(), StudentDashboard.class));
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Verify your email", Toast.LENGTH_LONG).show();
                            fAuth.signOut();
                        }
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
            });
        }


    }
}