package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin, signup;
    DBHelperRegistration DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        username = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passLogin);
        btnlogin = (Button) findViewById(R.id.loginbtn);
        signup = (Button) findViewById(R.id.registerbtn);
        DB = new DBHelperRegistration(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginScreenActivity.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                else{
                    Boolean checkuserpass = DB.checkemailpassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginScreenActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(getApplicationContext(), DispalyRequestsActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginScreenActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterIActivity.class);
                startActivity(intent);
            }
        });

    }
}