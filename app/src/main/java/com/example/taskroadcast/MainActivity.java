package com.example.taskroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button api_data, foreground_services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api_data = findViewById(R.id.api_btn);
        foreground_services = findViewById(R.id.task2_btn);

        api_data.setOnClickListener(this);
        foreground_services.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.api_btn:
                Intent intent = new Intent(MainActivity.this,RetrofitScreen.class);
                startActivity(intent);
                // finish();

                break;

            case R.id.task2_btn:
                Intent intent1 = new Intent(MainActivity.this, LocationScreen.class);
                startActivity(intent1);
                // finish();

                break;

        }

    }
}