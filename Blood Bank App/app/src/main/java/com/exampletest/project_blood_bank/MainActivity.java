package com.exampletest.project_blood_bank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                  startActivity(new Intent(MainActivity.this,LoginScreenActivity.class));
                  MainActivity.this.finish();
            }
            private void getSelf() {
            }
        }.start();
    }
}