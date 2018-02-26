package com.example.marijah.loginregister_sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText text1;
    EditText text2;
   // Button button = (Button)findViewById(R.id.button);
    MyDBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new MyDBHandler(this);
        text1=(EditText)findViewById(R.id.text1);
        text2=(EditText)findViewById(R.id.text2);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=text1.getText().toString();
                String password=text2.getText().toString();
                //zatim u database helper checking the mail and password
                //vrati se ovde:
                Boolean checkemailpass=db.emailpassword(email,password);
                if(checkemailpass==true)
                    Toast.makeText(getApplicationContext(),"Successfuly login",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
            }
        });
    }



}
