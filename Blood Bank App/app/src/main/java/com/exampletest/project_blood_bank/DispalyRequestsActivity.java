package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DispalyRequestsActivity extends AppCompatActivity {

    Button btnAddRequest, btnViewRequests, btnViewDonor, btnDonateBlood ;
    DBHelperRegistration DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly_requests);


        btnAddRequest = findViewById(R.id.btnAddRequest);
        btnViewRequests = findViewById(R.id.btnViewRequets);
        btnViewDonor = findViewById(R.id.btnViewDonor);
        btnDonateBlood = findViewById(R.id.btnAddDonate);
        DB = new DBHelperRegistration(this);

        btnAddRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MakeRequestActivity.class);
                startActivity(intent);
            }
        });

        btnViewRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata1();
                if(res.getCount()==0){
                    Toast.makeText(DispalyRequestsActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Email :"+res.getString(1)+"\n");
                    buffer.append("Contact :"+res.getString(2)+"\n");
                    buffer.append("Address :"+res.getString(3)+"\n");
                    buffer.append("Pincode :"+res.getString(4)+"\n");
                    buffer.append("Blood Group :"+res.getString(5)+"\n");
                    buffer.append("Message :"+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(DispalyRequestsActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Request Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        btnViewDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata2();
                if(res.getCount()==0){
                    Toast.makeText(DispalyRequestsActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Email :"+res.getString(1)+"\n");
                    buffer.append("Contact :"+res.getString(2)+"\n");
                    buffer.append("Address :"+res.getString(3)+"\n");
                    buffer.append("Pincode :"+res.getString(4)+"\n");
                    buffer.append("Blood Group :"+res.getString(5)+"\n");
//                    buffer.append("Message :"+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(DispalyRequestsActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Request Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


        btnDonateBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonorRequestActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.logout, menu);
            return super.onCreateOptionsMenu(menu);
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId()==R.id.logout)
            {
                Toast.makeText(this,"Logout", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginScreenActivity.class);
                startActivity(intent);
            }
            return super.onOptionsItemSelected(item);
        }

}