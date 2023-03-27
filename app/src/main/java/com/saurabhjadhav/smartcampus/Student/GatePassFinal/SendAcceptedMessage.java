package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.saurabhjadhav.smartcampus.R;

public class SendAcceptedMessage extends AppCompatActivity {

    TextView contact;
    EditText accepted;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    String userId;
    FirebaseUser firebaseUser;

    Button sendAccepted;

    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    String user = fAuth.getCurrentUser().getUid();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference myTaskRef = db.collection("GatepassNew");

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Gatepass");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_accepted_message);

        contact = findViewById(R.id.contactNo);
        accepted = findViewById(R.id.accepted);

        sendAccepted = findViewById(R.id.sendAccepted);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = firebaseAuth.getCurrentUser().getUid();
        firebaseUser = firebaseAuth.getCurrentUser();

        // new code

        // Working

        Bundle extras = getIntent().getExtras();
        String getContact = extras.getString("contactNo");

        contact.setText(getContact);
/*

        DocumentReference documentReference = firebaseFirestore.collection("GatepassNew").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                contact.setText(documentSnapshot.getString("+917410140535"));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SendAcceptedMessage.this, "Failed To Load", Toast.LENGTH_LONG).show();
            }
        });


 */
        sendAccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(SendAcceptedMessage.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    sendMessage();
                } else {
                    ActivityCompat.requestPermissions(SendAcceptedMessage.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });

    }

    private void sendMessage() {
        String sPhone = contact.getText().toString().trim();
        String sMessage = accepted.getText().toString().trim();

        if (!sPhone.equals("") && !sMessage.equals("")) {

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(sPhone, null, sMessage, null, null);

            Toast.makeText(this, "SMS SENT", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Enter Message", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            sendMessage();
        } else {
            Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show();
        }
    }
}