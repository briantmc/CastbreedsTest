package com.eiscolombia.testcatbreeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.eiscolombia.testcatbreeds.connection.request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request re = new request(MainActivity.this);

        /*CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                //Intent intent = new Intent(MainActivity.this, LoginMain.class);
                //if(tengoPermisoEscritura()) {
                Intent intent = new Intent(MainActivity.this, Principal.class);
                startActivity(intent);
                finish();
                //}
            }
        }.start();*/
    }
}