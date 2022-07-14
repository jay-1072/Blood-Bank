package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterIActivity extends AppCompatActivity{

    EditText fNameInput,lNameInput,emailInput,passInput,stateDropDrown,districtRegister,VillageRegister,
            mobileEditText,bloodGrpDropDown;
    Button btnSubmit;
    DBHelperRegistration DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_i);

        fNameInput = findViewById(R.id.fNameInput);
        lNameInput = findViewById(R.id.lNameInput);
        emailInput = findViewById(R.id.emailInput);
        passInput = findViewById(R.id.passInput);
        mobileEditText = findViewById(R.id.mobileEditText);
        btnSubmit = findViewById(R.id.btnSubmit);
        DB = new DBHelperRegistration(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = fNameInput.getText().toString();
                String lname = lNameInput.getText().toString();
                String user = emailInput.getText().toString();
                String pass = passInput.getText().toString();
                String mobile = mobileEditText.getText().toString();

                if(fname.equals("")||lname.equals("")||user.equals("")||pass.equals("")||
                mobile.equals(""))
                    Toast.makeText(RegisterIActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertData1(fname, lname, user, pass, mobile);
                    if(insert==true){
                        Toast.makeText(RegisterIActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(getApplicationContext(), DispalyRequestsActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterIActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String car = parent.getItemAtPosition(position).toString();
        Toast.makeText(RegisterIActivity.this, "Selected Car is: \t" + car, Toast.LENGTH_LONG).show();
    }*/
}