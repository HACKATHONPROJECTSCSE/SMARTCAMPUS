package com.saurabhjadhav.smartcampus.Teacher.TeacherFitness;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.saurabhjadhav.smartcampus.R;

public class TeacherFitnessHome extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 4000;

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView textTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_fitness_home);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.topanimation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottomanimation);

        image = findViewById(R.id.ImageViewTop);
        textTop = findViewById(R.id.TextviewBottom);

        textTop.setAnimation(topAnim);
        image.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(TeacherFitnessHome.this, TeacherFitnessExercises.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logoText");
                pairs[1] = new Pair<View, String>(textTop, "logoImage");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TeacherFitnessHome.this, pairs);
                startActivity(intent, options.toBundle());
            }
        }, SPLASH_SCREEN);
    }
}