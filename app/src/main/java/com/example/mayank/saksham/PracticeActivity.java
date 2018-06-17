package com.example.mayank.saksham;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PracticeActivity extends AppCompatActivity {
    ImageView i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        i1 = (ImageView)findViewById(R.id.imageView5);
        i2 = (ImageView)findViewById(R.id.imageView6);
        i3 = (ImageView)findViewById(R.id.imageView7);
        i4 = (ImageView)findViewById(R.id.imageView8);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PracticeActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PracticeActivity.this, "Wrong Answer!, Try Again!", Toast.LENGTH_SHORT).show();
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PracticeActivity.this, "Wrong Answer!, Try Again!", Toast.LENGTH_SHORT).show();
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PracticeActivity.this, "Wrong Answer!, Try Again!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
