package com.saurabhjadhav.smartcampus.Student.PlacementPrediction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.saurabhjadhav.smartcampus.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainDashboard extends AppCompatActivity {

    EditText age, internships, cgpa;
    RadioGroup radioGroupGender, radioGroupStream, radioGroupHosteler, radioGroupBacklog;
    Button predict;
    TextView result;
    String url = "https://web-production-ff48.up.railway.app/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        radioGroupGender = findViewById(R.id.radioGroup);
        radioGroupStream = findViewById(R.id.radioGroupStream);
        radioGroupHosteler = findViewById(R.id.radioGroupHosteller);
        radioGroupBacklog = findViewById(R.id.radioGroupBacklog);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectGender = radioGroupGender.getCheckedRadioButtonId();
                int selectStream = radioGroupStream.getCheckedRadioButtonId();
                int selectHosteler = radioGroupHosteler.getCheckedRadioButtonId();
                int selectBacklog = radioGroupBacklog.getCheckedRadioButtonId();

                // hit the API -> Volley
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("placement");
                                    if (data.equals("1")) {
                                        result.setText("Placement Hoga");
                                    } else {
                                        result.setText("Placement Nahi Hoga");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainDashboard.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("age", age.getText().toString());
                        params.put("internship", internships.getText().toString());
                        params.put("cgpa", cgpa.getText().toString());

                        params.put("male", cgpa.getText().toString());
                        params.put("female", cgpa.getText().toString());


                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainDashboard.this);
                queue.add(stringRequest);
            }
        });
    }
}