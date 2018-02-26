package com.example.marijah.loginregister_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHandler db;
    EditText email;
    EditText pass;
    EditText cpass;
    Button register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new MyDBHandler(this);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        cpass=(EditText)findViewById(R.id.cpass);
        register=(Button)findViewById(R.id.register);
        login=(Button)findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });






        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1=email.getText().toString();
                String s2=pass.getText().toString();
                String s3=cpass.getText().toString();
                if (email.equals("") || pass.equals("") || cpass.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)) {
                        Boolean checkmail = db.checkemail(s1);
                        if (checkmail == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfuly", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    // Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }


            }


        });
    }
}