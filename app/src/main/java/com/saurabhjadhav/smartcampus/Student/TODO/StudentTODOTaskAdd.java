package com.saurabhjadhav.smartcampus.Student.TODO;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.saurabhjadhav.smartcampus.R;

public class StudentTODOTaskAdd extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private ImageView save;
    ImageView backToSDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_todotask_add);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        save = findViewById(R.id.save_note);
        backToSDash = findViewById(R.id.BackToSDash);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        backToSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentTODOTaskAdd.this, StudentTODO.class));
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        String user = fAuth.getCurrentUser().getUid();

        CollectionReference myTaskRef = FirebaseFirestore.getInstance()
                .collection("STUDENT TASKS").document(user).collection("TASKS");
        myTaskRef.add(new StudentTODOModel(title, description, priority));
        Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
        finish();
    }
}