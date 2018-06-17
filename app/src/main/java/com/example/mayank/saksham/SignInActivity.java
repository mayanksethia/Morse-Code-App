package com.example.mayank.saksham;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    EditText e5,e6;
    Button b2;
    private SQLiteDatabase db1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        e5 = (EditText)findViewById(R.id.email_signin);
        e6 = (EditText)findViewById(R.id.pass_signin);
        b2 = (Button)findViewById(R.id.signin2);

        db1=openOrCreateDatabase("rec", Context.MODE_PRIVATE,null);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em=e5.getText().toString();
                String passw = e6.getText().toString();

                Cursor res = db1.rawQuery("select * from Reg1 where " +
                        "su_email='"+em+"' and su_pass = '"+passw+"'",null);

                if(res.moveToNext())
                {
                    //String Name = res.getString(0).toString();
                    Toast.makeText(SignInActivity.this,"login success", Toast.LENGTH_LONG).show();
                    db1.close();
                    Intent i =new Intent(SignInActivity.this,Main2Activity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(SignInActivity.this,"login unsuccessful", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
