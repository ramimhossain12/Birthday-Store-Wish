package com.example.birthdaystoreapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import kotlin.reflect.KClass;

public class FirstActivity extends AppCompatActivity {


    private ImageView imageView;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        imageView = findViewById(R.id.imgID);
        textView = findViewById(R.id.textID);


        Animation animation = AnimationUtils.loadAnimation(FirstActivity.this,R.anim.myanimation);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}