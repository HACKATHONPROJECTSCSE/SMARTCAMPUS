package com.saurabhjadhav.smartcampus.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    // VARIABLES

    TextInputLayout fullName, username, email, phoneNo, password;
    Button gotoLogin, registerBtn;
    boolean valid = true;

    // FIREBASE

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    CheckBox isTeacher, isStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = findViewById(R.id.registerName);
        username = findViewById(R.id.registerUsername);
        email = findViewById(R.id.registerEmail);
        phoneNo = findViewById(R.id.registerPhoneNo);
        password = findViewById(R.id.registerPassword);
        isTeacher = findViewById(R.id.checkboxTeacher);
        isStudent = findViewById(R.id.checkboxStudent);
        registerBtn = findViewById(R.id.registerBtn);
        gotoLogin = findViewById(R.id.logIn);

        // FIREBASE

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // ONCLICK LISTENERS

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkFieldFullName(fullName);
                checkFieldUsername(username);
                checkFieldEmail(email);
                checkFieldPhoneNo(phoneNo);
                checkFieldPassword(password);

                if (!(isTeacher.isChecked() || isStudent.isChecked())) {
                    Toast.makeText(Register.this, "Select The Account Type", Toast.LENGTH_SHORT).show();
                }

                if (valid) {

                    fAuth.createUserWithEmailAndPassword(email.getEditText().getText().toString().trim(), password.getEditText().getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            FirebaseUser user = fAuth.getCurrentUser();
                            boolean res = (verify_EmailId());
                            if (res == true) {
                                Toast.makeText(Register.this, "Enter Details Correctly", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            }

                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String, Object> userInfo = new HashMap<>();


                            userInfo.put("FullName", fullName.getEditText().getText().toString().trim());
                            userInfo.put("UserName", username.getEditText().getText().toString().trim());
                            userInfo.put("UserEmail", email.getEditText().getText().toString().trim());
                            userInfo.put("PhoneNumber", phoneNo.getEditText().getText().toString().trim());
                            userInfo.put("Password", password.getEditText().getText().toString().trim());

                            // Type Of User ( Teacher or Student )

                            if (isTeacher.isChecked()) {
                                userInfo.put("isTeacher", "1");
                            }

                            if (isStudent.isChecked()) {
                                res = (verify_EmailId());
                                if (res == true)
                                    return;
                                userInfo.put("isStudent", "1");
                            }

                            df.set(userInfo);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, "Failed To Create Account", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


        // Selecting CheckBox Algorithm

        isStudent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    isTeacher.setChecked(false);
                }
            }
        });

        isTeacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    isStudent.setChecked(false);
                }
            }
        });

    }

    // FIELD VALIDATION

    private void sendEmailVerification() {
        FirebaseUser firebaseUser = fAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Verification Email is Sent ", Toast.LENGTH_SHORT).show();
                    fAuth.signOut();
                    finish();
                    startActivity(new Intent(Register.this, Login.class));
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Failed To send Verification email", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkFieldFullName(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Please Enter Your Full Name!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public boolean checkFieldUsername(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Username Required!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public boolean checkFieldEmail(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Email Required!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public boolean checkFieldPhoneNo(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("PhoneNo Required!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public boolean checkFieldPassword(TextInputLayout textField) {
        if (textField.getEditText().getText().toString().isEmpty()) {
            textField.setError("Password Required!");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    private boolean verify_EmailId() {
        String emailId = email.getEditText().getText().toString().trim();
        if (!emailId.endsWith("@git-india.edu.in")) {
            email.setEnabled(true);
            email.setError("Enter Your College Id");
            return true;
        } else {
            email.setErrorEnabled(false);
            return false;
        }
    }
}