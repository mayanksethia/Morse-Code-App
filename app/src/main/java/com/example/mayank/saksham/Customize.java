package com.example.mayank.saksham;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Customize extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        t1 = (TextView)findViewById(R.id.textView7);
        t2 = (TextView)findViewById(R.id.textView8);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Customize.this, "Customize Layout Clicked!", Toast.LENGTH_LONG).show();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Customize.this, "Add Gestures Clicked!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
