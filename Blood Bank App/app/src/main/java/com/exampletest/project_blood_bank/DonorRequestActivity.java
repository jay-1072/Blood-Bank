package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonorRequestActivity extends AppCompatActivity {
    EditText nameInput,emailInput,mobileEditText,address,pincode,bloodGrpDropDown;
    Button btnSubmit;
    DBHelperRegistration DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_request);


        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        mobileEditText = findViewById(R.id.mobileEditText);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        bloodGrpDropDown = findViewById(R.id.bloodGrpDropDown);
        btnSubmit = findViewById(R.id.btnSubmit);
        DB = new DBHelperRegistration(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();
                String mobile = mobileEditText.getText().toString();
                String add = address.getText().toString();
                String pin = pincode.getText().toString();
                String bg = bloodGrpDropDown.getText().toString();

                if (name.equals("") || email.equals("") || mobile.equals("") || add.equals("") || pin.equals("") || bg.equals(""))
                    Toast.makeText(DonorRequestActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData3(name, email, mobile, add, pin, bg);
                    System.out.println(insert);
                    if (insert == true) {
                        Toast.makeText(DonorRequestActivity.this, "Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), DispalyRequestsActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(DonorRequestActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
                    }
                }

            }

        });
    }
}