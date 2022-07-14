package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MakeRequestActivity extends AppCompatActivity {

    EditText nameInput,emailInput,mobileEditText,address,pincode,msg;
    String bloodGrpDropDown;
    Button btnSubmit;
    DBHelperRegistration DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

        Spinner s = (Spinner) findViewById(R.id.spinner1);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View arg1,
                                         int position, long arg3) {
                  // On selecting a spinner item
                  bloodGrpDropDown = parent.getItemAtPosition(position).toString();
                  // Showing selected spinner item
                  Toast.makeText(parent.getContext(), "You selected: " + bloodGrpDropDown, Toast.LENGTH_LONG).show();

              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
        });

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        mobileEditText = findViewById(R.id.mobileEditText);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        msg = findViewById(R.id.msg);
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
                String bg = bloodGrpDropDown;
                String messg = msg.getText().toString();

                if(name.equals("")||email.equals("")||mobile.equals("")||add.equals("")||
                        pin.equals("") || bg.equals("") || messg.equals(""))
                    Toast.makeText(MakeRequestActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertData2(name, email, mobile, add, pin, bg, messg);
                    if(insert==true){
                        Toast.makeText(MakeRequestActivity.this, "Request Successful", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(getApplicationContext(), DispalyRequestsActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MakeRequestActivity.this, "Something Wrong", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

/*    private void uploadRequest(String message){
        makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MakeRequestActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Email :"+res.getString(2)+"\n");
                    buffer.append("Message :"+res.getString(1)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MakeRequestActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entry");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }

    private void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

*/
}